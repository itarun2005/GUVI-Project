import java.util.HashMap;
import java.util.Scanner;

class Account {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public Account(String accountNumber, String accountHolderName) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = 0.0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance!");
        }
    }
}

public class BankManagementSystem {
    private static HashMap<String, Account> accounts = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Welcome to the Bank Management System");
            System.out.println("1. Open Account");
            System.out.println("2. Search Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Quit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    openAccount();
                    break;
                case 2:
                    searchAccount();
                    break;
                case 3:
                    deposit();
                    break;
                case 4:
                    withdraw();
                    break;
                case 5:
                    System.out.println("Thank you for using the Bank Management System!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }

    private static void openAccount() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter account holder name: ");
        String accountHolderName = scanner.nextLine();

        if (accounts.containsKey(accountNumber)) {
            System.out.println("Account already exists!");
        } else {
            Account account = new Account(accountNumber, accountHolderName);
            accounts.put(accountNumber, account);
            System.out.println("Account opened successfully!");
        }
    }

    private static void searchAccount() {
        System.out.print("Enter account number to search: ");
        String accountNumber = scanner.nextLine();

        Account account = accounts.get(accountNumber);
        if (account != null) {
            System.out.println("Account Holder: " + account.getAccountHolderName());
            System.out.println("Balance: " + account.getBalance());
        } else {
            System.out.println("Account not found!");
        }
    }

    private static void deposit() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        Account account = accounts.get(accountNumber);

        if (account != null) {
            System.out.print("Enter amount to deposit: ");
            double amount = scanner.nextDouble();
            account.deposit(amount);
            System.out.println("New Balance: " + account.getBalance());
        } else {
            System.out.println("Account not found!");
        }
    }

    private static void withdraw() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        Account account = accounts.get(accountNumber);

        if (account != null) {
            System.out.print("Enter amount to withdraw: ");
            double amount = scanner.nextDouble();
            account.withdraw(amount);
            System.out.println("New Balance: " + account.getBalance());
        } else {
            System.out.println("Account not found!");
        }
    }
}
