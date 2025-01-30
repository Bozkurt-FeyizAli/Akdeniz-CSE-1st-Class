import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
public class HW08_20220808073 {

    public static void main(String[] args) {
        User user1 = SocialNetwork.register("Alice", "alice@example.com");
        User user2 = SocialNetwork.register("Bob", "bob@example.com");

        user1.follow(user2);
        Post post = SocialNetwork.post(user2, "Hello World!");

        user1.like(post);
        user1.comment(post, "Nice post!");

        user1.message(user2, "Hi Bob!");

        System.out.println("User1's feed: " + SocialNetwork.getFeed(user1));
        System.out.println("User2's feed: " + SocialNetwork.getFeed(user2));
    }
}

class User{
    private int id;
    private String username;
    private String email;
    private Set<User> followers;
    private Set<User> following;
    private Set<Post> likedPosts;
    private Map<User, Queue<Message>> messages;
    public User(String username, String email) {
        this.username = username;
        this.email = email;
        this.followers=new HashSet<>();
        this.following= new HashSet<>();
        this.likedPosts= new HashSet<>();
        this.messages= new HashMap<>();
        this.id=this.hashCode();
    }
    public String getEmail() {
        return email;
    }
    public String getUsername() {
        return username;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public Set<User> getFollowers() {
        return followers;
    }
    public Set<User> getFollowing() {
        return following;
    }
    public Set<Post> getLikedPosts() {
        return likedPosts;
    }
    public void message(User recipient, String content){
        if(!messages.containsKey(recipient)){
            messages.put(recipient, new ConcurrentLinkedQueue<>());
        }
        if(!recipient.messages.containsKey(this)){
            recipient.messages.put(this, new ConcurrentLinkedQueue<>());
        }
        Message message = new Message(this, content);
        recipient.messages.get(this).add(message);
        messages.get(recipient).add(message);
        read(recipient);
    }
    public void read(User user){
        if(messages.containsKey(user))
            for (Message message : messages.get(user))
                System.out.println(message.read(this));
    }
    public void follow(User user){
        if(this.following.contains(user)){
            this.following.remove(user);
            user.followers.remove(this);
        }
        else {
            this.following.add(user);
            user.followers.add(this);
        }    
    }
    public void like(Post post){
        if(this.likedPosts.contains(post))
            this.likedPosts.remove(post);
        else
            this.likedPosts.add(post);
        post.likedBy(this);
    }
    public Post post(String content){
        return new Post(content);
    }
    public Comment comment(Post post, String content){
        Comment newComment= new Comment(content);
        post.commentBy(this, newComment);
        return newComment;
    }
    @Override
    public boolean equals(Object obj) {
        if(obj==null)
            return false;
        User user= (User) obj;
        return this.id==user.id;
    }
    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}

class Post {
    java.util.Date datePosted;
    String content; 
    Set<User> likes; 
    Map<User, List<Comment>> comments;
    public Post(String content) {
        this.content = content;
        this.datePosted=new Date(System.currentTimeMillis());
        this.comments= new HashMap<>();
        this.likes= new HashSet<>();
    }
    public boolean likedBy(User user){
        if(likes.contains(user)){
            likes.remove(user);
            return false; 
        }
        else{
            likes.add(user);
            return true;
        }
    } 
    public boolean commentBy(User user, Comment comment){
       comments.putIfAbsent(user, new ArrayList<>());
       return comments.get(user).add(comment);
    }
    public String getContent(){
        System.out.println("Posted at: " + datePosted);
        return content;
    }
    public Comment getComment(User user, int index){
        if(!comments.containsKey(user))
            return null;
        if(comments.get(user).size()-1<index)
            return null;
        return comments.get(user).get(index);
    }
    public int getCommentCount(){
        int getCommentCount=0;
        for (var userComments : comments.entrySet()) {
            getCommentCount+=userComments.getValue().size();
        }
        return getCommentCount;
    }
    public int getCommentCountByUser(User user){
        if(user==null||!comments.containsKey(user))
            return 0;
        else return comments.get(user).size();
    }
}

class Message{
    private boolean seen;
    private java.util.Date dateSent;
    private String content; 
    private User sender;
    public Message(User sender, String content) {
        this.content = content;
        this.sender = sender;
        this.dateSent=new Date(System.currentTimeMillis());
        this.seen=false;
    }
    public String read(User reader){
        if(!sender.equals(reader))
            seen=true; 
        System.out.println("Sent at: " + dateSent);
        return content;
    }
    public boolean hasRead(){
        return seen;
    }
    // @Override
    // public String toString() {
    //     return content;
    // }
}
class Comment extends Post{
    public Comment(String content) {
        super(content);
    }
}

class SocialNetwork{
    private static Map<User, List<Post>> postsByUsers= new HashMap<>();

    public static User register(String username, String email){
        User user= new User(username, email);
        if(getUser(email)==null){
            postsByUsers.put(user, new ArrayList<Post>());
            return user;
        }
        return null;
    }
    public static Post post(User user, String content){
        Post newPost=new Post(content);
        if (postsByUsers.containsKey(user)) {
            postsByUsers.get(user).add(newPost);
            return newPost;
        }
        return null;
    }
    public static User getUser(String email){
        for (User user : postsByUsers.keySet()) {
            if(user.hashCode()==Objects.hash(email))
                return user;
        }
        return null;
    }
    public static Set<Post> getFeed(User user){
        Set<Post> getFeed = new HashSet<>();
        for (var following: user.getFollowing()) {
            if(postsByUsers.containsKey(following))
                getFeed.addAll(postsByUsers.get(following));
        }
        return getFeed;
    }
    public static Map<User, String> search(String keyword){
        Map<User, String> search= new HashMap<>();
        for (var user : postsByUsers.keySet()) {
            if(user.getUsername().contains(keyword))
                search.put(user, user.getUsername());
        }
        return  search;
    }
    public static <V,K> Map<V, Set<K>> reverseMap(Map<K, V> map){
        Map<V, Set<K>> reverseMap= new HashMap<>();
        for (var kV : map.entrySet()) {
            K k=kV.getKey();
            V v=kV.getValue();
            Set<K> setK= new HashSet<K>();
            reverseMap.putIfAbsent(v, setK);
            if(reverseMap.containsKey(v))
                reverseMap.get(v).add(k);
        }
        return reverseMap;
    }
    
}