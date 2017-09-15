package ua.nure.poliakov.Practice10.task3;

import java.util.ArrayList;
import java.util.List;

public class Login {
    private static List<String> names = new ArrayList<String>();

    public static void add(String name){
        names.add(name);
    }

    public static List<String> getList(){
        return names;
    }

    public static void removeAll(){
        names.clear();
    }
}