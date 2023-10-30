package org.example.anagram;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String message1 = "vedat";
        String message2 = "datve";

        if (isAnagram(message1, message2)){
            System.out.println(message1 + " ve " + message2 + " anagramdır.");
        }else {
            System.out.println(message1 + " ve " + message2 + " anagram değildir.");
        }

    }
    public static boolean isAnagram(String message1, String message2) {
        if (message1.length() != message2.length()){
            return false;
        }

        char[] charArray1 = message1.toCharArray();
        char[] charArray2 = message2.toCharArray();

        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        if (Arrays.equals(charArray1, charArray2)){
            return true;
        }
        return false;
    }
}
