package org.example.fibonacci;

public class Main {                 // 2-Write a Java function to print first 100 numbers in Fibonacci series?
    public static void main(String[] args) {

        long[] fibonacciNumbers = new long[100];

        fibonacciNumbers[0] = 1;
        fibonacciNumbers[1] = 1;

        for(int i = 2; i < 100; i++){
            fibonacciNumbers[i] = fibonacciNumbers[i-1] + fibonacciNumbers[i-2];
        }
        for(long number: fibonacciNumbers){
            System.out.println(number);
        }

    }
}

