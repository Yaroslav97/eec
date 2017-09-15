package ua.nure.poliakov.Practice8.managers;
import ua.nure.poliakov.Practice8.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
   private static List<User> users = new ArrayList<>();

    public static void add(String user){
         users.add(new User(user));
    }

    public static List<User> getUsers() {
        return users;
    }

    public static String getLogins() {
        return users.toString();
    }
}