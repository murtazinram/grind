package org.example.snail;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * https://www.codewars.com/kata/521c2db8ddc89b9b7a0000c1/train/java
 * Snail Sort
 * Given an n x n array, return the array elements arranged from outermost elements to the middle element,
 * traveling clockwise.
 * <p>
 * array = [[1,2,3],
 * [4,5,6],
 * [7,8,9]]
 * snail(array) #=> [1,2,3,6,9,8,7,4,5]
 * For better understanding, please follow the numbers of the next array consecutively:
 * <p>
 * array =
 * [[1,2,3],
 * [8,9,4],
 * [7,6,5]]
 * snail(array) #=> [1,2,3,4,5,6,7,8,9]
 * This image will illustrate things more clearly:
 * <p>
 * <p>
 * NOTE: The idea is not sort the elements from the lowest value to the highest; the idea is to traverse the 2-d array
 * in a clockwise snailshell pattern.
 * <p>
 * NOTE 2: The 0x0 (empty matrix) is represented as en empty array inside an array [[]].
 */
public class Snail {
    public static int[][] snail(int[][] array) {
        int number = 1;
        int n = array.length;
        int res[] = new int[n * n];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {//строка
            for (int j = i; j < n - i; j++) {//столбец
                //array[i][j] = number++;
                map.put(array[i][j], number++);
            }
            for (int k = i + 1; k < n - i; k++) {
                //array[k][n - 1 - i] = number++;
                map.put(array[k][n - 1 - i], number++);
            }
            for (int j = n - i - 2; j >= i; j--) {
                //array[n - 1 - i][j] = number++;
                map.put(array[n - 1 - i][j], number++);
            }
            for (int k = n - 2 - i; k > i; k--) {
                //array[k][i] = number++;
                map.put(array[k][i], number++);
            }
        }
        // enjoy

        return array;
    }

    public static int[][] snail1(int[][] array) {
        int size = array.length;
        int res[] = new int [size * size];

        res = array[0];

        size--;

        List<Integer> nums1List = Arrays.stream(res).boxed().filter(i -> i != 0).collect(Collectors.toList());
        List<Integer> nums2List = Arrays.stream(res).boxed().collect(Collectors.toList());
        nums1List.addAll(nums2List);
        res = nums1List.stream().sorted().mapToInt(i -> i).toArray();

        return array;
    }

    public static void main(String[] args) {

        int[][] array
                = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        int[][] snail = snail1(array);
       // System.out.println(Arrays.toString(snail));

        for (int i = 0; i < snail.length; i++) {//строка
            for (int j = 0; j < snail.length; j++) {//столбец
                System.out.print(array[i][j]);
            }
            System.out.println("\n--");
        }

        List<String> strings = List.of("1", "2");
        Stream<List<String>> strings1 = Stream.of(strings, strings);
        List<String> collect = strings1.flatMap(Collection::stream).collect(Collectors.toList());


    }
}
