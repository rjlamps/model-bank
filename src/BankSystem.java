import java.util.ArrayList;

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

    public Account findAccount(String name)
    {
        for (Account acc : database)
        {
            if (acc.getName().equals(name))
            {
                return acc;
            }
        }
        return null;
    }



}
