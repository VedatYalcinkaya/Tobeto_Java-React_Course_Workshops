package org.example.perfectNumbers;

import java.util.ArrayList;
import java.util.List;

public class ChatGptOptimize {
    public static void main(String[] args) {
        List<Long> perfectNumbers = new ArrayList<>();
        long candidate = 2;

        while (perfectNumbers.size() < 10) {
            if (isPerfect(candidate)) {
                perfectNumbers.add(candidate);
            }
            candidate++;
        }

        for (long perfect : perfectNumbers) {
            System.out.println(perfect);
        }
    }

    public static boolean isPerfect(long num) {
        long sum = 1;
        for (long i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                sum += i;
                if (i != num / i) {
                    sum += num / i;
                }
            }
        }
        return sum == num && num != 1;
    }
}
