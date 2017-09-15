package ua.nure.poliakov.Practice4;

import java.util.ResourceBundle;

public class Task5 {
    public static String local(String key, String locale) {
        ResourceBundle res = ResourceBundle.getBundle(locale);
        return res.getString(key);
    }
}