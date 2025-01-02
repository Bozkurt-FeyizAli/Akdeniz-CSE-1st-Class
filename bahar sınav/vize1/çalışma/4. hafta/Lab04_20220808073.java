// Exception

import java.util.ArrayList;

public class Lab04_20220808073{
    public static void main(String[] args) {
        // try {
        //     // getUser(5);
        //     System.out.println("Recevied User.");
        // } catch (UserException e) {
        //     // TODO: handle exception  
        //     // narrow exception
        //     System.out.println(e.getMessage());
        //     // System.out.println("something");
        // }
        // finally{
        //     System.out.println("Finally block");
        // }


        User acc = new User(null);
        System.out.println(acc);
        acc.setActive(false);
        acc.setId(2);
        try {
            acc.deactivate();
        } catch (Exception e) {
            // TODO: handle exception
        }
        // acc.deactivate();
        acc.performOperation();
        System.out.println("Anything");
        User a= new User(null);
        a.id=7;
        try {
            setUser(a);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Exception is caught.");
        }
        try {
            acc.performOperation();
        } catch (RuntimeException e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        
        
    }
    // public static void getUser(int id) throws UserException{
    //     if(id<0){
    //         throw new UserException("no such User exception id<0");
    //     }
    //     else{
    //        //...
    //     }
    // }
    public static void setUser(User User){
        if(User.id !=5){
            throw new InvalidOperationException("Invalid operation");
        }

    }
}
class UserException extends Exception{
    User user;

    UserException(UserUser userUser){
        this.user=(User) userUser;


    }
    // public String getMessage() {
    //     return message;
    // }
    @Override
    public String getMessage(){
        return "An exception has occured."+super.getMessage();
    }

}
class InvalidOperationException extends RuntimeException{
    InvalidOperationException(String message){

    }
    InvalidOperationException(User User){
          super("invalid Operation with: "+User);
    }
    @Override
    public String getMessage(){
        return "Runtime Exception has occured."+super.getMessage();
    }   

}

class Account{
    
}
class User extends UserUser{
    ArrayList<Account> accounts;
    void deposit(double amount) throws InvalidAmountException
{
    if(amount<0)
    System.out.println();
    // throw new InvalidAmountExceptionamount();
    // setBalance(getBalance()+amount);

}    
User(String name) {
        super(name);
        // public boolean isActive(int accountId){

        // }
        //TODO Auto-generated constructor stub
    }
    String username;
    // User(){
    //     super(String username);
    // }
public double id=5;

}
class UserUser {
    String username;
    int id;
    boolean active;
    UserUser(String name){
        setUsername(name);
        

    }
    public void setUsername(String username) {
        this.username = username;
    }
    public int getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }
    public void setActive(boolean active) {
        // for (BankAccount bankAccount : account) {
        //     int accountId;
        //     if(bankAccount.getId()==accountId)
        //     bankAccount.setActive(true);
        // }
        this.active = active;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void deactivate() throws UserException{
        if(active)
            throw new UserException(this);
    } 
    public void performOperation() throws InvalidOperationException{
        System.out.println("sdfghjk");
        
    }

    @Override
    public String toString(){
        return String.format("User: \n\t id: %d \n\t Username: %s \n\t: %b", id, username, active);
    }
}

class BankAccount extends UserUser{
    void withDraw(){

    }
    BankAccount(String name) {
        super(name);
        //TODO Auto-generated constructor stub
    }
    String accountNumber;
    void BankUserExcpetion(){
        // super(String username);
    }

}
