package org.example.squareDigit;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SquareDigit {
    public int squareDigits(int n) {
        String[] arr = String.valueOf(n).split("");
        String s = Arrays.stream(arr).map(b-> Integer.valueOf(b)).map(v->v*v).map(w-> w.toString()).collect(Collectors.joining());
        return  Integer.valueOf(s);
    }

    public static String highAndLow(String numbers) {
        Integer max = Arrays.stream(numbers.split(" ")).mapToInt(Integer::parseInt).max().getAsInt();
        Integer min = Arrays.stream(numbers.split(" ")).mapToInt(Integer::parseInt).min().getAsInt();
        return max + " " + min;
    }

    public static int sortDesc(final int num) {
        Integer[] objects = Arrays.stream(String.valueOf(num).split(""))
                .map(Integer::parseInt).toArray(Integer[]::new);
        Arrays.sort(objects, Collections.reverseOrder());
        return Integer.parseInt(Arrays.stream(objects).map(String::valueOf).collect(Collectors.joining()));
    }

    public static void main(String[] args) {
        int s = sortDesc(42145 );
        System.out.println("res=" +s);
    }
}
