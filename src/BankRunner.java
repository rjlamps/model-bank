import java.util.Scanner;
import java.util.ArrayList;

public class BankRunner 
{
    public static void main(String[] args) throws Exception
    {
        Scanner input = new Scanner(System.in);
        boolean isWorking = true;
        BankSystem bank = new BankSystem();
        System.out.println("Welcome to the Bank Simulator!");
        System.out.print("Please enter your full name: ");
        String nameMain = input.nextLine();
        Account userAccount = bank.findAccount(nameMain);

        ArrayList<String> transactionHistory = new ArrayList<String>(); //make sure to add transactions 
        if (userAccount != null)
        {
            System.out.println("Welcome " + userAccount.getName() + "!");
        }
        else
        {
            System.out.println("Looks like you don't have an account with us.");
            System.out.println("How much money would you like to start with?");
            double startMoney = input.nextDouble();
            input.nextLine();
            userAccount = new Account(nameMain, startMoney);
            bank.addAccount(userAccount);

        }
        while (isWorking == true)
        {
            System.out.println("");
            System.out.println("What would you like to do?");
            System.out.println("1: Check Balance");
            System.out.println("2: See ID Number");
            System.out.println("3: Deposit Money");
            System.out.println("4: Withdraw Money");
            System.out.println("5: Check Transaction History");
            System.out.println("6: End Simulator");
            String function = input.nextLine();

            if (function.equals("1") || function.equals("Check Balance") || function.equals("check balance"))
            {
                System.out.println(userAccount.getBalance());
            }
            else if (function.equals("2") || function.equals("See ID Number") || function.equals("see id number"))
            {
                System.out.println(userAccount.getID());
            }
            else if (function.equals("3") || function.equals("Deposit Money") || function.equals("deposit money"))
            {
                System.out.print("How much would you like to deposit? ");
                double depositAmt = input.nextDouble();
                input.nextLine();
                if (depositAmt <= 0)
                {
                    System.out.println("Deposit amount must be greater than 0.");
                }
                else
                {
                    System.out.println("Successfully deposited " + depositAmt + " into account " + userAccount.getID());    
                    userAccount.depositFunds(depositAmt);
                    System.out.println("New Balance: " + userAccount.getBalance());
                    transactionHistory.add("Successfully deposited " + depositAmt);
                }
            }
            else if (function.equals("4") || function.equals("Withdraw Money") || function.equals("withdraw money"))
            {
                System.out.print("How much would you like to withdraw? ");
                double withdrawAmt = input.nextDouble();
                input.nextLine();
                if (userAccount.getBalance() <= 0 || userAccount.getBalance() < withdrawAmt)
                {
                    System.out.println("Unable to withdraw " + withdrawAmt + " . There is only " + userAccount.getBalance() + " in account " + userAccount.getID());
                }
                else
                {
                    System.out.println("Successfully withdrawn " + withdrawAmt + " from account " + userAccount.getID());
                    userAccount.withdrawFunds(withdrawAmt);
                    System.out.println("New balance: " + userAccount.getBalance());
                    transactionHistory.add("Successfully withdrawn " + withdrawAmt);
                }
            }
            else if(function.equals("5") || function.equals("Check Transaction History") || function.equals("check transaction history"))
            {
                if (transactionHistory.size() > 0)
                {    
                    for (int i = 0; i < transactionHistory.size(); i++)
                    {
                        System.out.print(transactionHistory.get(i) + ", "); 
                    }
                }
                else
                {
                    System.out.println("No transactions yet.");
                }
            }
            else if (function.equals("6") || function.equals("End Simulator") || function.equals("end simulator"))
            {
                isWorking = false;
                System.out.println("Simulator ended. The balance of account " + userAccount.getID() + " is " + userAccount.getBalance() + ".");
            }
            else
            {
                System.out.println("Invalid option. Please try again.");
            }
        }
        
    }
}