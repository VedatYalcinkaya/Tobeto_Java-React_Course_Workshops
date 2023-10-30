package org.example.firstTwoAmicablePairs;

public class Main {
    public static void main(String[] args) {
        int limit = 10000; // Chatgpt kodu :)

        for (int num1 = 1; num1 <= limit; num1++) {
            int num2 = findAmicablePair(num1);
            if (num2 > num1) {
                int num2Pair = findAmicablePair(num2);
                if (num2Pair == num1) {
                    System.out.println("Dostça sayı çifti: " + num1 + " ve " + num2);
                }
            }
        }
    }

    public static int findAmicablePair(int number) {
        int sum = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
