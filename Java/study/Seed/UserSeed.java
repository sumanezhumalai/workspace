package Seed;
import Model.User;

public class UserSeed {
    private static final User[] INSTANCE = new User[]{
         new User(1L, "Aarav Sharma", "009", "Developer"),
         new User(2L, "Priya Patel", "010", "Developer"),
         new User(3L, "Rohan Verma", "008", "Support"),
         new User(4L, "Ananya Iyer", "003", "Support"),
         new User(5L, "Vikram Singh", "004", "Manager"),
         new User(6L, "Neha Gupta", "006", "Developer"),
         new User(7L, "Karan Malhotra", "007", "QA Tester"),
         new User(8L, "Sneha Reddy", "005", "DevOps Engineer"),
         new User(9L, "Arjun Nair", "001", "Product Owner"),
         new User(10L, "Kavya Joshi", "002", "Support")
    };

    public static User[] getUsers (){
        return INSTANCE;
    }
}