package ua.nure.poliakov.Practice8.managers;

import ua.nure.poliakov.Practice8.entity.Group;

import java.util.ArrayList;
import java.util.List;

public class GroupManager {
  private static List<Group> groups = new ArrayList<>();

    public static void add(String group){
        groups.add(new Group(group));
    }

    public static List<Group> getGroups() {
        return groups;
    }

    public static String getNames() {
        return groups.toString();
    }
}