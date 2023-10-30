package org.example.uniqueCharacterCheck;

public class Main {
    public static void main(String[] args) {
        String msg = "vedav";
        if (isStringCharsUnique(msg)){
            System.out.println("Benzersiz");
        }else {
            System.out.println("Benzersiz değil");
        }

    }
    public static boolean isStringCharsUnique(String msg){
        int[] charCount = new int[256];

        for (int i = 0; i < msg.length(); i++){
            char c = msg.charAt(i);
            if (charCount[c] >0){
                return false;
            }
            charCount[c]=1;
        }
        return true;
    }
}
