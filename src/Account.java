public class Account 
{
    private String name;
    private int id;
    private double balance;      
    
    public Account(String name, double balance)
    {
        this.name = name;
        id = (int)(Math.random()*10000 + 1);
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