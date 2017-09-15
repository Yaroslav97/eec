package ua.nure.poliakov.Practice3;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Task4 {
    public static String hash(String input, String algorithm) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance(algorithm);
        digest.update(input.getBytes());
        byte[] hash = digest.digest();
        return toHex(hash).toString();
    }

    private static StringBuffer toHex(byte[] input) {
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < input.length; i++) {
            res.append(Integer.toString(input[i], 16));
        }
        return res;
    }
}