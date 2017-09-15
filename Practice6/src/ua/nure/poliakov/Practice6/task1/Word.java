package ua.nure.poliakov.Practice6.task1;

import java.util.*;

public class Word {

    private Map<String, Integer> map = new HashMap<>();
    private List<String> list = new ArrayList<>();

    public Map<String, Integer> getMap() {
        return map;
    }

    public String input() {
        Scanner scanner = new Scanner("as  a dfv sdfgn asdf asdf s s as s");
        return scanner.nextLine();
    }

    public List<String> add() {
        String[] text = input().split("\\W+");
        for (int i = 0; i < text.length; i++) {
            list.add(text[i]);
        }
        return list;
    }

    public void count() {
        for (String s : list) {
            Integer i = map.get(s);
            if (map.containsValue(i)) {
                map.put(s, i + 1);
            } else {
                map.put(s, 1);
            }
        }
    }

    public List<Map.Entry<String, Integer>> sort() {
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (!o1.equals(o2)) {
                    return o2.getValue() - o1.getValue();
                } else {
                    return o2.getKey().compareTo(o1.getKey());
                }
            }
        });
        return entries;
    }

    public void print() {
        input();
        add();
        count();
        for (Map.Entry<String, Integer> entry : sort()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}