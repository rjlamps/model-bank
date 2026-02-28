import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class BankSystem 
{
    private ArrayList<Account> database;

    public BankSystem()
    {
        database = new ArrayList<Account>();
    }

    public void addAccount(Account account)
    {
        database.add(account);
    }

    public Account findAccountByID(int id)
    {
        for (Account acc : database)
        {
            if (acc.getID()==(id))
            {
                return acc;
            }
        }
        return null;
    }

    public void loadAccounts()
    {
        try
        {
            Scanner fileReader = new Scanner(new File("accounts.txt"));
            int highestId = 0;
            while (fileReader.hasNext())
            {
                String line = fileReader.nextLine();
                String[] array = line.split(",");

                int id = Integer.parseInt(array[0]);
                String name = array[1];
                double balance = Double.parseDouble(array[2]);
                if (id > highestId)
                {
                    highestId = id;
                }
                Account loadedAccount = new Account(id, name, balance);
                addAccount(loadedAccount);
            }
            Account.setNextId(highestId + 1);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found: " + e.getMessage());
        }
    }

    public void saveAccounts()
    {
        try
        {
            PrintWriter writer = new PrintWriter(new FileWriter("accounts.txt"));
            for (Account acc : database)
            {
                writer.println(acc.getID() + "," + acc.getName() + "," + acc.getBalance());
            }
            writer.close();
        }
        catch (IOException e)
        {
            System.out.println("Error saving file");
        }
    }



}
