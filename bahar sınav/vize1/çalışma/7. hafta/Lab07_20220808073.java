import java.util.ArrayList;
public class Lab07_20220808073 {
    public static void main(String[] args) {
        
    }
}

class Account{
    private String accountNumber;
    private double balance;
    Account(String accountNumber, double balance)throws InsufficientFundsException{
        this.accountNumber=accountNumber;
        if(balance<0)
            throw new InsufficientFundsException(balance);
        this.balance=balance;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public double getBalance() {
        return balance;
    }
    public void deposit(double amount)throws InsufficientFundsException{
        if(amount<0)
        try {
            throw new InvalidTransactionException(amount);
        } catch (InvalidTransactionException e) {
            e.printStackTrace();
        }
        balance+=amount;    
    }
    public void withdraw(double amount)throws InsufficientFundsException, InvalidTransactionException{
        if(amount>balance)
            throw new InsufficientFundsException(amount);
        else if(amount<0)
            try {
                throw new InvalidTransactionException(amount);
            } catch (InvalidTransactionException e) {
                e.printStackTrace();
            }
        
            balance-=amount;
    }

    @Override 
    public String toString(){
        return String.format("Ccount: %s. Balance: %f ", accountNumber, balance);
    }
}

class Customer{
    private String name;
    private ArrayList<Account> accounts;
    Customer(String name){
        this.name=name;
        accounts= new ArrayList<>();
    }
    public Account getAccount(String accountNumber) throws AccountNotFoundException{
        for (Account account : accounts) {
            if(account.getAccountNumber().equals(accountNumber))
                return account;
        }
        throw new AccountNotFoundException(this, accountNumber);
    }
    public String getName() {
        return name;
    }
    public void addAccount(Account account)throws AccountAlreadyExistException{
        try {
            getAccount(account.getAccountNumber());
            throw new AccountAlreadyExistException(this, account);
        } catch (AccountNotFoundException e) {
            accounts.add(account);
        }
        finally{
            System.out.println(this);
        }

        System.out.println("Added account: "+account);
    }

    public void removeAccount(Account account) throws AccountNotFoundException{
            getAccount(account.getAccountNumber());
            accounts.remove(account);
    }
    public void transfer(String fromAccount, Account toAccount, double amount)throws InvalidTransactionException{
       try {
            Account from=getAccount(toAccount.getAccountNumber());
            from.withdraw(amount);
            toAccount.deposit(amount);
       } catch (AccountNotFoundException e) {
            System.out.println(e.getMessage());
       }catch(InsufficientFundsException e){
            System.out.println(e.getMessage());
       }catch(InvalidTransactionException e){
            throw new InvalidTransactionException(e, "Can not transfer funds from "+fromAccount+"to account "+toAccount.getAccountNumber());
       }
       
    }

    @Override
    public String toString() {
        String message= this.getName()+":\n\t";
        for (Account account : accounts) {
            message+=account+"\n\t";
        }
        return message;
    }
    
}

class InsufficientFundsException extends RuntimeException{
    double balance;
    double amount;
    InsufficientFundsException(double balance){
        super("InsufficientFundsException: invallid balance: "+balance);
        this.balance=balance;
    }

    InsufficientFundsException(double balance, double amount){
        super("InsufficientFundsException: Required amount is "+amount+", but anly "+balance+" remaining");
        this.balance=balance;
        this.amount=amount;
    }
}

class InvalidTransactionException extends Exception{
    double amount;
    InvalidTransactionException(double amount){
        super(Double.toString(amount)+" is invalid");
        this.amount=amount;
    } 

    InvalidTransactionException(InvalidTransactionException e, String message){
        super(e.getMessage()+ ":\n\t "+message);
    }

    

}
class AccountNotFoundException extends RuntimeException{
    String AccountNumber;
    Customer Customer;
    AccountNotFoundException(Customer customer, String AccountNumber){
        super(customer.getName()+" does not have any account with number "+AccountNumber);
        this.Customer=customer;
        this.AccountNumber=AccountNumber;
    }
}

class AccountAlreadyExistException extends RuntimeException{
    Customer customer;
    Account account;
    AccountAlreadyExistException(Customer customer, Account account){
        super("Account with number "+ account.getAccountNumber()+" already exist in the clollection of "+customer.getName());
        this.customer=customer;
        this.account=account;
    }
}
