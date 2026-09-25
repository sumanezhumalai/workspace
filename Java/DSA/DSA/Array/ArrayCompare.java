package Array;
import java.util.Arrays;
import java.util.Comparator;

import Model.User;
import Seed.UserSeed;

public class ArrayCompare {
    private User[] users = UserSeed.getUsers();


    public static void main(String[] args) {

        ArrayCompare obj = new ArrayCompare();

        // Arrays.sort(obj.users,(u1,u2) -> u1.getPhone().compareTo(u2.getPhone()));
        Arrays.sort(obj.users,Comparator.comparing(User::getRole));
        System.out.println(Arrays.toString(obj.users));
    }
}