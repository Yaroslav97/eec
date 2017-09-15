package ua.nure.poliakov.Practice9.task2.entity;

import java.util.ArrayList;
import java.util.List;

public class Football {

    private static List list = new ArrayList();

    public static boolean isExist(String name) {
        if (getList().contains(name)) {
            return true;
        }
        return false;
    }

    public static void add(String name) {
        if (!isExist(name))
        list.add(name);
    }

    public static List getList() {
        return list;
    }
}
