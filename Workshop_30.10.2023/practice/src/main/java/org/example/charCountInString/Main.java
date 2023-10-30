package org.example.charCountInString;

public class Main { // Write a Java program gives character counts in a string Ex: Tobeto -> t:2, o:2, b:1, e:1
    public static void main(String[] args) {
        String message = "tobeto";
        System.out.println(message);

        int[] chars = new int[30];

        for (int i = 0; i < message.length(); i++){
            char c = message.charAt(i);

            chars[c - 'a']++;
        }

        for (int i = 0; i<chars.length; i++){
            char harf = (char)('a'+i);
            if (chars[i]>0){
                System.out.println(harf + ": " + chars[i]);
            }
        }
    }
}
