package ua.nure.poliakov.Practice6.task6;

import java.util.*;

public class Part1 {

    private Map<String, Integer> map = new HashMap<>();

    public void getWord(String fileName) {
        String[] arr = IO.getInput(fileName).split("\\W+");
        Arrays.sort(arr);
        int[] arrCount = new int[arr.length];
        Arrays.fill(arrCount, 0);
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].equals(arr[i + 1])) {
                count++;
            } else {
                arrCount[i] = count + 1;
                if (!arr[i].equals(arr[i + 1])) {
                    count = 0;
                }
                if (arrCount[i] != 0) {
                    map.put(arr[i], arrCount[i]);
                }
            }
        }
    }

    public Map<String, Integer> sortByCount() {
        List<Map.Entry<String, Integer>> list = new ArrayList(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        map.clear();
        for (Map.Entry<String, Integer> entry : list) {
            if (map.size() != 3) {
                map.put(entry.getKey(), entry.getValue());
            }
        }
        return map;
    }

    public List<Map.Entry<String, Integer>> sort(Map mapName) {
        List<Map.Entry<String, Integer>> list = new ArrayList(mapName.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getKey().compareTo(o1.getKey());
            }
        });
        return list;
    }

    public void facade(String fileName) {
        getWord(fileName);
        for (Map.Entry<String, Integer> entry : sort(sortByCount())) {
            if (map.size() != 2) {
                System.out.println(entry.getKey() + " ==> " + entry.getValue());
            }
        }
    }
}