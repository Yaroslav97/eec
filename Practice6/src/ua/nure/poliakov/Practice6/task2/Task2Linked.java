package ua.nure.poliakov.Practice6.task2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Task2Linked {

  private   List<String> list = new LinkedList<>();

    public List<String> getList() {
        return list;
    }

    public void fill() {
        for (int i = 0; i < 50000; i++) {
            list.add("name" + i);
        }
    }

    void counter() {
        fill();
        for (int i = 0; i < list.size(); i++) {
            while (list.size() > 1) {
                list.remove(i);
            }
        }
    }

    public void print() {
        counter();
        for (String s : getList()) {
            System.out.println(s);
        }
    }
}
