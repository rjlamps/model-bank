import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
public class AuthSystem 
{
    ArrayList<User> users;

    public AuthSystem()
    {
        users = new ArrayList<User>();
    }

    public void addUser(User u)
    {
        users.add(u);
    }

    public User login(String username, String password)
    {
        for (int i = 0; i < users.size(); i++)
        {
            if (users.get(i).getUsername().equals(username) && users.get(i).getPassword().equals(password))
            {
                return users.get(i);
            }
        }
        return null;
    }

    public void loadUsers()
    {
        try
        {
            Scanner fileReader = new Scanner(new File("users.txt"));
            while (fileReader.hasNext())
            {
                String line = fileReader.nextLine();
                String[] array = line.split(",");

                String username = array[0];
                String password = array[1];
                int id = Integer.parseInt(array[2]);

                User loadedUser = new User(username, password, id);
                addUser(loadedUser);
                
            }
            fileReader.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found: " + e.getMessage());
        }
    }

    public void saveUsers()
    {
        try
        {
            PrintWriter writer = new PrintWriter(new FileWriter("users.txt"));
            for (User u : users)
            {
                writer.println(u.getUsername() + "," + u.getPassword() + "," + u.getAccountID());
            }
            writer.close();
        }
        catch (IOException e)
        {
            System.out.println("Error saving file");
        }
    }
}
