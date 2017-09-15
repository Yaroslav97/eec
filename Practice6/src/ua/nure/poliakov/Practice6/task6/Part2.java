package ua.nure.poliakov.Practice6.task6;

import java.util.*;

public class Part2 {

    private Map<String, Integer> map = new HashMap<>();

    public void part2(String fileName) {
        String[] text = IO.getInput(fileName).split("\\W+");
        int max = text[0].length();
        for (int i = 0; i < text.length; i++) {
            if (max < text[i].length()) {
                max = i;
            }
            if (!map.containsKey(text[max])) {
                map.put(text[max], text[max].length());
            }
        }
    }

    public Map<String, Integer> sortByLenght() {
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());

        Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        map.clear();
        for (Map.Entry<String, Integer> entry : entries) {
            if (map.size() != 3) {
                map.put(entry.getKey(), entry.getValue());
            }
        }
        return map;
    }

    public List<Map.Entry<String, Integer>> sortMap(Map mapName) {
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(mapName.entrySet());
        Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getKey().compareTo(o1.getKey());
            }
        });
        return entryList;
    }

    public void facade(String fileName) {
        part2(fileName);
        for (Map.Entry<String, Integer> entry : sortMap(sortByLenght())) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
    }
}