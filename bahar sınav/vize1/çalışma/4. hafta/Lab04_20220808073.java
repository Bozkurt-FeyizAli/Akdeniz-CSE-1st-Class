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
