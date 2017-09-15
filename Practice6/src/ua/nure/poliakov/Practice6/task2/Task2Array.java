package ua.nure.poliakov.Practice6.task2;

import java.util.ArrayList;
import java.util.List;

public class Task2Array {
   private List<String> list = new ArrayList<>();

    public List<String> getList() {
        return list;
    }

    public void fillArrayList() {
        for (int i = 0; i < 50000; i++) {
            list.add("name" + i);
        }
    }

    void counter(){
        fillArrayList();
        for (int i = 0; i < list.size(); i++) {
            while (list.size() > 1) {
                list.remove(i);
            }
        }
    }

   public void print(){
       counter();
       for (String s : getList()){
           System.out.println(s);
       }
    }
}