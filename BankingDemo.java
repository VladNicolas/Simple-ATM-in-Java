import java.util.Scanner;
import java.util.Random;

class Account
{
    private int balance;
    private int pinCode;
    private String name;

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class ATM
{   
    Scanner scanner = new Scanner(System.in);

    Account account;

    public ATM(Account account) {
        this.account = account;
    }

        void accessATM()
        {
            int choice;
            boolean exit = false;

            do {
                System.out.println("\nMenu:");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("0. Exit");
                System.out.print("\nEnter your choice: ");

                choice = scanner.nextInt();

                switch (choice) {

                    case 1:
                        // BALANCE
                        System.out.println("\nYour balance is: " + account.getBalance());
                        break;

                    case 2:
                        // DEPOSIT
                        System.out.println("\nHow much are you depositing?");
                        int deposit = scanner.nextInt();
                        account.setBalance(account.getBalance() + deposit);
                        break;

                    case 3:
                        // WITHDRAW
                        System.out.println("\nHow much are you withdrawing?");
                        int withdraw = scanner.nextInt();
                        account.setBalance(account.getBalance() - withdraw);
                        System.out.println("\nReleasing " + withdraw + "...");
                        break;

                    case 0:
                        System.out.println("Exiting the menu.");
                        exit = true;
                        break;
                        
                    default:
                        System.out.println("Invalid choice. Please select a valid option.");
                }

                    if (!exit) {
                        System.out.println("\nPerform more operatins?");
                        System.out.println("1. Yes");
                        System.out.println("2. No");
                        System.out.print("Enter your choice: ");
                        int subMenuChoice = scanner.nextInt();

                        if (subMenuChoice != 1) {
                            exit = true;
                        }
                    }

            } while (!exit);

        scanner.close();
        }

        
}

public class BankingDemo{


    public static void main (String args[])
    {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        Account myAccount = new Account();

        myAccount.setPinCode(1112);
        myAccount.setBalance(rand.nextInt(1000));

        ATM atm = new ATM(myAccount);

        int insertedPin;

        do
        {
            System.out.println("Enter your PIN:");
            insertedPin = scanner.nextInt();
            if (insertedPin == myAccount.getPinCode())
                    atm.accessATM();
                else
                    System.out.println("Wrong PIN!");

        }
        while (insertedPin != myAccount.getPinCode());        
        
        scanner.close();
    }
}