public class Account 
{
    private String name;
    private int id;
    private static int nextId = 1;
    private double balance;
    
    public Account(String name, double balance)
    {
        this.name = name;
        id = nextId;
        this.balance = balance;
        nextId++;
    }

    public Account(int id, String name, double balance)
    {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public void setName(String name)
    {
        this.name = name;
    }
    public void setBalance(double balance)
    {
        this.balance = balance;
    }

    public static void setNextId(int id)
    {
        nextId = id;
    }

    public String getName()
    {
        return name;
    }
    public int getID()
    {
        return id;
    }
    public double getBalance()
    {
        return balance;
    }

    public void depositFunds(double amount)
    {
        balance += amount;
    }

    public void withdrawFunds(double amount)
    {
        balance -= amount;
    }

    public String toString()
    {
        return "Account Holder: " + name + "\nID: " + id + "\nBalance: " + balance;
    }
}