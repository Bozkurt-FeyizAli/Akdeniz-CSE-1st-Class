// Exception

import java.util.ArrayList;

public class try2{
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

/*
 * 
Handle UserException in main method:
Uncomment the try-catch block in the main method and implement the catch block to handle the UserException. You need to print the error message when this exception occurs.

Implement the deactivate method:
In the User class, implement the deactivate method. Inside this method, check if the user is active. If the user is active, throw a UserException.

Handle InvalidOperationException in main method:
In the main method, after creating the User object a, call the setUser method with this object. Implement the setUser method to throw an InvalidOperationException if the provided user's ID is not 5. Handle this exception in the main method and print an appropriate error message.

Implement the performOperation method:
In the User class, implement the performOperation method. Inside this method, print "sdfghjk".

Implement the deposit method:
In the User class, implement the deposit method. Check if the provided amount is less than 0. If it is, throw an InvalidAmountException.

Handle RuntimeException in main method:
In the main method, catch a RuntimeException when calling the performOperation method on the acc object. Print the message of the caught exception.

Ensure proper inheritance:
Ensure that classes User, UserUser, and BankAccount are set up correctly with proper inheritance and constructors.

Implement toString method:
In the User class, implement the toString method to provide a string representation of the User object.

Handle exceptions in AccountNotFindException and InvalidAmountException:
Implement necessary handling for exceptions in the AccountNotFindException and InvalidAmountException classes.

Review and test:
Review the code to ensure all methods are implemented correctly. Test the code with different scenarios to ensure proper functionality and exception handling.
 */
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
class User extends UserUser{
    
    
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
// public boolean isActive(int accountId){
//     return
// }

}
class UserUser {
    // ArrayList<Account> accounts= new ArrayList<>();
    String username;
    int accountId;
    boolean active;
    ArrayList<BankAccount> bankAccounts;
    UserUser(String name){
        setUsername(name);
        
        

    }
    public void setUsername(String username) {
        this.username = username;
    }
    public int getId() {
        return accountId;
    }
    public String getUsername() {
        return username;
    }
    


    public void setActive(boolean active) {
