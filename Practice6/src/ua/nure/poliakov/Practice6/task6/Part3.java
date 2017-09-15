package ua.nure.poliakov.Practice6.task6;

import java.util.HashSet;
import java.util.Set;

public class Part3 {

    private Set<String> duplication = new HashSet<String>();

    public Set<String> getSet() {
        return duplication;
    }

    private void part3(String fileName) {
        String[] arr = IO.getInput(fileName).split("\\W+");
        Set<String> set = new HashSet<String>();
        for (int i = 0; i < arr.length; i++) {
            if (!set.add(arr[i]) && duplication.size() < 3) {
                duplication.add(reverse(arr[i].toUpperCase()));
            }
        }
    }

    private String reverse(String word) {
        StringBuilder result = new StringBuilder();
        for (int i = word.length(); i > 0; i--) {
            result.append(word.charAt(i - 1));
        }
        return result.toString();
    }

    public void facade(String fileName) {
        part3(fileName);
        for (String s : getSet()) {
            System.out.println(s);
        }
    }
}