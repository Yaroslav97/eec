package ua.nure.poliakov.SummaryTask2.sort;

import ua.nure.poliakov.SummaryTask2.text.Word;

import java.util.*;

/**
 * Class display sort words from file which contains some char
 */
public class SortText {

    private List<String> list = new ArrayList<>();

    public List<String> facade(String fileName, String character) {
        getWord(fileName, character);
        sortByCountChar(sortByAlphabet(list), character);
        System.out.printf("Words which contains symbol '%s': ", character);
        return list;
    }

    /**
     * Method add to list word which contain some character
     * @param fileName
     * Name of file
     * @param ch
     * Char
     * @return list with word which contain some character
     */
    private List<String> getWord(String fileName, String ch) {
        String[] text = Word.getWord(fileName).split(" ");
        for (int i = 0; i < text.length; i++) {
            for (int j = 0; j < text[i].length(); j++) {
                if (!list.contains(text[i])&&Character.valueOf(ch.charAt(0)).equals(text[i].charAt(j))) {
                        list.add(text[i]);
                }
            }
        }
        return list;
    }

    /**
     * Method for sort words in the list by alphabet
     * @param list
     * List with words
     * @return sort list by alphabet
     */
    private List<String> sortByAlphabet(List<String> list) {
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        return list;
    }

    /**
     * Method for sort words in the list by count of characters in the word
     * @param list
     * List of words which contains some character
     * @param character
     * Char
     * @return sort list by count of character
     */
    private List<String> sortByCountChar(List<String> list, final String character) {
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return countChar(o2, character) - countChar(o1, character);
            }
        });
        return list;
    }

    /**
     * Method returns count of characters in the string
     * @param word
     * Word
     * @param character
     * Char
     * @return count of entry some char in a word
     */
    private int countChar(String word, String character) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (character.indexOf(word.charAt(i)) >= 0) {
                count++;
            }
        }
        return count;
    }
}