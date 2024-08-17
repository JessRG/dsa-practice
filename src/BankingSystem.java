import java.util.ArrayList;
import java.util.List;

class Transaction {
    private String type;
    private double amount;
    private double balanceAfterTransaction;

    public Transaction(String type, double amount, double balanceAfterTransaction) {
        this.type = type;
        this.amount = amount;
        this.balanceAfterTransaction = balanceAfterTransaction;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "type='" + type + '\'' +
                ", amount=" + amount +
                ", balanceAfterTransaction=" + balanceAfterTransaction +
                '}';
    }
}

class BankAccount {
    private String accountNumber;
    private double balance;
    private List<Transaction> transactionHistory;

    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add(new Transaction("Deposit", amount, balance));
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add(new Transaction("Withdrawal", amount, balance));
            System.out.println("Withdrew: " + amount);
        } else {
            throw new InsufficientFundsException("Invalid withdrawal amount or insufficient funds");
        }
    }

    public void transfer(BankAccount toAccount, double amount) throws InsufficientFundsException {
        if (amount > 0 && amount <= balance) {
            this.withdraw(amount);
            toAccount.deposit(amount);
            transactionHistory.add(new Transaction("Transfer to " + toAccount.getAccountNumber(), amount, balance));
            toAccount.getTransactionHistory().add(new Transaction("Transfer from " + this.getAccountNumber(), amount, toAccount.getBalance()));
            System.out.println("Transferred: " + amount + " to account " + toAccount.getAccountNumber());
        } else {
            throw new InsufficientFundsException("Invalid transfer amount or insufficient funds");
        }
    }

    public void printTransactionHistory() {
        for (Transaction transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
}

public class BankingSystem {
    public static void main(String[] args) throws InsufficientFundsException {
        BankAccount account1 = new BankAccount("123456");
        BankAccount account2 = new BankAccount("654321");

        account1.deposit(300);
        account1.withdraw(200);
        account1.transfer(account2, 300);

        System.out.println("Account 1 Transaction History:");
        account1.printTransactionHistory();

        System.out.println("Account 2 Transaction History:");
        account2.printTransactionHistory();
    }
}

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}
