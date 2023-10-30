package org.example.firstTwoAmicablePairs;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) { //Uzun sürüyor ama doğru çalışıyor
        int amicablePairsCount = 0;
        int num1 = 1;
        while (amicablePairsCount < 2) {
            int num2 = num1 + 1;
            while (num2 < 10000) {
                if (isAmicablePair(num1, num2)) {
                    System.out.println("Amicable Pair: " + num1 + " and " + num2);
                    amicablePairsCount++;
                }
                num2++;
            }
            num1++;
        }

    }

    public static boolean isAmicablePair(int num1, int num2) {

        int sum1 = findDivisorsSum(num1);
        int sum2 = findDivisorsSum(num2);

        if (num1 == sum2 && num2 == sum1){
            return true;
        }
        return false;
    }

    public static int findDivisorsSum(int num){
        int sum = 0;
        for(int i = 1; i < num; i++) {
            if (num % i == 0){
                sum += i;
            }
        }
        return sum;
    }
}
