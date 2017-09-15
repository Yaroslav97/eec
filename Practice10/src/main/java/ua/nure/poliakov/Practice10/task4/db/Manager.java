package ua.nure.poliakov.Practice10.task4.db;

import ua.nure.poliakov.Practice10.task4.entity.User;

import java.util.ArrayList;
import java.util.List;

public class Manager {
    private static List<User> users = new ArrayList<User>();

    public static void add(String login, String pass, String role, String name) {
        users.add(new User(login, pass, role, name));
    }

    public static List<User> getUsers() {
        return users;
    }

    public static List<User> getAll() {
        return users;
    }

    public String getLogin(String login) {
        int index = 0;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getLogin().equals(login)) {
                index = i;
            }
        }
        return users.get(index).getLogin();
    }

    public String getGroup(String login) {
        int index = 0;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getLogin().equals(login)) {
                index = i;
            }
        }
        return users.get(index).getRole_id();
    }

    public String getPassword(String login) {
        int index = 0;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getLogin().equals(login)) {
                index = i;
            }
        }
        return users.get(index).getPass();
    }

    public String getName(String login) {
        int index = 0;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getLogin().equals(login)) {
                index = i;
            }
        }
        return users.get(index).getName();
    }

    public String getLoginByName(String name) {
        int index = 0;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getName().equals(name)) {
                index = i;
            }
        }
        return users.get(index).getLogin();
    }

    public boolean isExist(String login) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getLogin().contains(login)) {
                return true;
            }
        }
        return false;
    }
}
