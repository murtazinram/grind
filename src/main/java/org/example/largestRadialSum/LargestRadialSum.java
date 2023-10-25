package org.example.largestRadialSum;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.codewars.com/kata/64edf7ab2b610b16c2067579/train/java
 * The Codewars Council meets at a circular table with n seats. Depending on the day d of the month,
 * d people will be chosen as leaders of the council. These d leaders are spaced equidistantly from each other on the
 * table, like spokes on a wheel. The leaders are chosen based on which grouping of d equidistant people have the
 * largest summed honor. The honor of the participants for that day in the Council is given in an array arr of length n.
 * Return the combined honor of the d leaders of the Council.
 * <p>
 * Given conditions -
 * n % d == 0, ie. there will be no invalid cases. All groupings go fully around the circle.
 * 1 <= d <= 31, as you can't have 32 days in a month.
 * n > 0 because you can't have a Council of 0 people. (You also can't have a table with 0 open seats, then it's just
 * a nightstand or something)
 * You can have negative honor on Codewars (but it is hard to do) and the solution may be negative.
 * Example -
 * <p>
 * [1, 2, 3, 4], 2 -> 6 because max(1+3, 2+4) == 6
 * [1, 5, 6, 3, 4, 2], 3 -> 11 because max(1+6+4, 5+3+2) == 11
 * [1, 1, 0], 1 -> 1 because max(1, 1, 0) == 1
 * Hint -
 * Something important to note is that you (usually) don't have to evaluate every sum in the array, as after n/d
 * repetitions the sums loop over on themselves.
 */
public class LargestRadialSum {

    public static int largest(int[] arr, int d) {
        List<Integer> list = new ArrayList<>();
        int step = arr.length / d;
        int sum = 0;
        for (int i = 0; i < step; i++) {
            for (int j = i; j < arr.length; j += step) {
                int item = arr[j];
                sum += item;
            }
            list.add(sum);
            sum = 0;
        }
        return list.stream().mapToInt(x -> x).max().getAsInt();
    }

    public static void main(String[] args) {
        int arr[] = new int[]{318, 360, -1028, -584, 1264, 409, -17, -353, -612, 1389, 1485, 541, -1166, 1404, 245, -1392, 1260, -948, -264, 256, -676, 394, -809, -558, -477, 525, 3};
        int d = 3;
        int largest = largest(arr, d);
        System.out.println("largest=" + largest);
    }
}
