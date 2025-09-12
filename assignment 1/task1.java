//Banking Application for Account Management
import java.util.Scanner;

class BankAccount {
    private int accId; //access specifier used
    private String holderName;
    private double accBalance;
    private String emailAddr;
    private String phoneNum;

    public BankAccount(int id, String name, double initialDeposit, String email, String phone) {
        this.accId = id; //constructor to initialize account
        this.holderName = name; //this keyword: refers to current object
        this.accBalance = initialDeposit;
        this.emailAddr = email;
        this.phoneNum = phone;
    }

    public void addFunds(double amount) { //method to add funds
        if (amount > 0) {
            accBalance += amount;
            System.out.println("Funds added successfully.");
        } else {
            System.out.println("Amount must be positive.");
        }
    }

    public void removeFunds(double amount) { //method to withdraw funds
        if (amount <= 0) {
            System.out.println("Amount must be positive.");
        } else if (amount > accBalance) {
            System.out.println("Insufficient balance.");
        } else {
            accBalance -= amount;
            System.out.println("Withdrawal successful.");
        }
    }

    public void showAccountInfo() {       //method to display account info
        System.out.println("Account ID: " + accId);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: " + accBalance);
        System.out.println("Email: " + emailAddr);
        System.out.println("Phone: " + phoneNum);
    }

    public void modifyContact(String newEmail, String newPhone) { //method to update contact info
        emailAddr = newEmail;
        phoneNum = newPhone;
        System.out.println("Contact details updated.");
    }

    public int getAccountId() {
        return accId;
    }
}

public class task1 { //main class
    private BankAccount[] accounts = new BankAccount[100];
    private int accCount = 0;
    private Scanner scanner = new Scanner(System.in);

    public void initiate() {
        while (true) {
            System.out.println("\nWelcome to Simple Bank");
            System.out.println("1 Open account");
            System.out.println("2 Add funds");
            System.out.println("3 Withdraw funds");
            System.out.println("4 View account");
            System.out.println("5 Edit contact info");
            System.out.println("6 Exit");
            System.out.print("Select option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) { //multiple case statements (session 9 ppt)
                case 1:
                    openAccount();
                    break;
                case 2:
                    addFunds();
                    break;
                case 3:
                    withdrawFunds();
                    break;
                case 4:
                    viewAccount();
                    break;
                case 5:
                    editContact();
                    break;
                case 6:
                    System.out.println("Thank you for using Simple Bank.");
                    return;
                default:
                    System.out.println("Invalid option please try again.");
            }
        }
    }

    private void openAccount() {  //method to open new account
        System.out.print("Enter name: ");
        String name = scanner.nextLine(); // Read full line for name
        System.out.print("Enter initial deposit: ");
        double deposit = scanner.nextDouble(); // Read initial deposit
        scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine();

        accounts[accCount] = new BankAccount(1000 + accCount, name, deposit, email, phone);
        System.out.println("Account created with ID: " + accounts[accCount].getAccountId());
        accCount++;
    }

    private void addFunds() {  //method to add funds
        BankAccount acc = findAccount();
        if (acc != null) {
            System.out.print("Enter amount to deposit: ");
            double amt = scanner.nextDouble();
            acc.addFunds(amt);
        }
    }

    private void withdrawFunds() {
        BankAccount acc = findAccount();
        if (acc != null) {
            System.out.print("Enter amount to withdraw: ");
            double amt = scanner.nextDouble();
            acc.removeFunds(amt);
        }
    }

    private void viewAccount() {
        BankAccount acc = findAccount();
        if (acc != null) {
            acc.showAccountInfo();
        }
    }

    private void editContact() {
        BankAccount acc = findAccount(); //method to edit contact info
        if (acc != null) {
            scanner.nextLine();
            System.out.print("Enter new email: ");
            String newEmail = scanner.nextLine();
            System.out.print("Enter new phone: ");
            String newPhone = scanner.nextLine();
            acc.modifyContact(newEmail, newPhone);
        }
    }

    private BankAccount findAccount() {
        System.out.print("Enter account ID: ");
        int id = scanner.nextInt();
        for (int i = 0; i < accCount; i++) {
            if (accounts[i].getAccountId() == id) {
                return accounts[i];
            }
        }
        System.out.println("Account not found.");
        return null;
    }

    public static void main(String[] args) {
        task1 system = new task1(); //object creation
        system.initiate(); //method call
    }
}