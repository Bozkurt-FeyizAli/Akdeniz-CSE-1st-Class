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
