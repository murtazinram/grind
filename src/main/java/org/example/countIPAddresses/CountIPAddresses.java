package org.example.countIPAddresses;

import java.util.Arrays;
import java.util.Objects;

/**
 * https://www.codewars.com/kata/526989a41034285187000de4/train/java
 * Implement a function that receives two IPv4 addresses, and returns the number of addresses between them
 * (including the first one, excluding the last one).
 *
 * All inputs will be valid IPv4 addresses in the form of strings. The last address will always be greater than the
 * first one.
 *
 * Examples
 * * With input "10.0.0.0", "10.0.0.50"  => return   50
 * * With input "10.0.0.0", "10.0.1.0"   => return  256
 * * With input "20.0.0.10", "20.0.1.0"  => return  246
 */
public class CountIPAddresses {
    public static long ipsBetween(String start, String end) {
        long[] endArr = Arrays.stream(end.split("\\.")).mapToLong(Long::parseLong).toArray();
        long[] startArr = Arrays.stream(start.split("\\.")).mapToLong(Long::parseLong).toArray();

        //1
        long r4 = endArr[3] - startArr[3];
        long r3 = (long) ((endArr[2] - startArr[2]) * Math.pow(256, 1));
        long r2 = (long) ((endArr[1] - startArr[1]) * Math.pow(256, 2));
        long r1= (long) ((endArr[0] - startArr[0]) * Math.pow(256, 3));

        long res= r4 + r3 + r2 + r1;

        return res;
    }

    public static void main(String[] args) {
        long l = CountIPAddresses.ipsBetween("20.0.0.10", "20.0.1.0");
        System.out.println(l);
    }
}
