package org.example.simpleSquareNumbers;

import java.util.stream.IntStream;

/**
 * https://www.codewars.com/kata/5edc8c53d7cede0032eb6029/train/java
 * In this Kata, you will be given a number n (n > 0) and your task will be to return the smallest square number
 * N (N > 0) such that n + N is also a perfect square. If there is no answer, return -1 (nil in Clojure,
 * Nothing in Haskell, None in Rust).
 * <p>
 * solve 13 = 36
 * ; because 36 is the smallest perfect square that can be added to 13 to form a perfect square => 13 + 36 = 49
 * <p>
 * solve 3 = 1 ; 3 + 1 = 4, a perfect square
 * solve 12 = 4 ; 12 + 4 = 16, a perfect square
 * solve 9 = 16
 * solve 4 = nil
 */
public class SimpleSquareNumbers {
    public static long solve(int n) {

        //int i1 = LongStream.range(1, n).map(i -> i * i).filter(i -> Math.sqrt(i + n) % 1 == 0).findFirst().orElse(-1);
        for (int i = 1; i < n; i++) {
            if (Math.sqrt((i * i) + n) % 1 == 0) {
                return (long) i * i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        long solve = solve(7);
        System.out.println(solve);
    }
}
