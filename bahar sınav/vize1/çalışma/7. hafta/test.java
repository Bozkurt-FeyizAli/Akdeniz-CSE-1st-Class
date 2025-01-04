// import org.junit.Test;

// import static org.junit.Assert.*;

// import org.junit.After;
// import org.junit.AfterClass;
// import org.junit.Before;
// import org.junit.BeforeClass;

// public class test {
    
// private static int testNumber=1;
//     @BeforeClass
//     public static void test001_account(){
//         System.out.println("test is started.");
//     }
//     @Before
//     public void display(){
//         System.out.println("\nRunning test: "+ (++testNumber));
//     }
//     @AfterClass
//     public static void tearDown(){
//         System.out.println("End of tests");
//     }
//     @After
//     public void afterDisplay(){
//         System.out.println("After the test: "+ testNumber);
//     }
//     @Test(timeout = 100)
//     public void shouldCreateAccountObject(){
//         System.out.println("should be able to instantiate and Account Object.");
//         try {
//             new Account("123", 12);
//         } catch (Exception e) {
//             fail("could not create instance of Account class.");
//         }
//     }
//     @Test
//     public void shouldReturnBalance(){
//         String accountNumber="123";
//         int balance=9;
//         Account a= new Account(accountNumber, balance);
//         assert(accountNumber.equals(a.getAccountNumber()));
//         }
// }
