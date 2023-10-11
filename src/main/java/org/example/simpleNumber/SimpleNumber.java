package org.example.simpleNumber;

import java.math.BigInteger;

public class SimpleNumber {
    public static boolean isSimple1(int value) {
        if (value < 2) {
            throw new ArithmeticException();
        }
        boolean isPrime = true;
        for (int i = 2; i < value; i++) {
            if (value % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }

    public static boolean isSimple(int value) {
        if (value < 2) {
            throw new ArithmeticException();
        }

        for (int i = 2; i <= Math.sqrt(value); i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{8, 7, 2, 22, 11};
        for (int value : nums) {
            boolean simple = isSimple1(value);
            System.out.println("isSimple= " + simple + " ;val=" + value);
        }

        int d = 22;
        BigInteger bigInteger = BigInteger.valueOf(d);
        boolean probablePrime = bigInteger.isProbablePrime(1);
        System.out.println("probablePrime= " + probablePrime);
    }
}
