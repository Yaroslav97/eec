package ua.nure.poliakov.Practice8;

import ua.nure.poliakov.Practice8.DBManagers.GroupDBManager;
import ua.nure.poliakov.Practice8.DBManagers.UserDBManager;
import ua.nure.poliakov.Practice8.entity.Group;
import ua.nure.poliakov.Practice8.entity.User;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        UserDBManager userDBManager = new UserDBManager();
        userDBManager.insertUser(new User("obama"));
        userDBManager.insertUser(new User("smith"));
        userDBManager.insertUser(new User("yaroslav"));

        System.out.println(userDBManager.findAllUser());

        System.out.println("===========================================");

        GroupDBManager groupDBManager = new GroupDBManager();
        groupDBManager.insertGroup(new Group("teamD"));

        System.out.println(groupDBManager.findAllGroup());

        System.out.println("===========================================");

        User user1 = userDBManager.getUser("obama");
        System.out.println(user1);
        User user2 = userDBManager.getUser("smith");
        System.out.println(user2);
        User user3 = userDBManager.getUser("yaroslav");
        System.out.println(user3);

        System.out.println();

        Group group1 = groupDBManager.getGroup("teamB");
        System.out.println(group1);
        Group group2 = groupDBManager.getGroup("teamC");
        System.out.println(group2);
        Group group3 = groupDBManager.getGroup("teamD");
        System.out.println(group3);

        System.out.println("===========================================");

        groupDBManager.setGroupsForUser(user1, group1);
        groupDBManager.setGroupsForUser(user2, group1, group2);
        groupDBManager.setGroupsForUser(user3, group1, group3);

        System.out.println();

        for (User user : userDBManager.findAllUser()) {
            System.out.println(groupDBManager.getUserGroups(user));
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
        System.out.println("===========================================");

        //groupDBManager.deleteGroup(group2);

        group1.setName("teamX");
        groupDBManager.updateGroup(group1, 2);

        System.out.println(groupDBManager.findAllGroup());
    }
}