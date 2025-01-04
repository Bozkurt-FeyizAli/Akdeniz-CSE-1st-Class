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

