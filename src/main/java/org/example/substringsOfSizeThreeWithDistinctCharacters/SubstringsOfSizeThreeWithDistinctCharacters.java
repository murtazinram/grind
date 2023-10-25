package org.example.substringsOfSizeThreeWithDistinctCharacters;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntFunction;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/
 * A string is good if there are no repeated characters.
 * <p>
 * Given a string good, return the number of good substrings of length three in 3.
 * Note that if there are multiple occurrences of the same substring, every occurrence should be counted.
 * A substring is a contiguous sequence of characters in a string.
 * <p>
 * Example 1:
 * Input: s = "xyzzaz"
 * Output: 1
 * Explanation: There are 4 substrings of size 3: "xyz", "yzz", "zza", and "zaz".
 * The only good substring of length 3 is "xyz".
 * <p>
 * Example 2:
 * Input: s = "aababcabc"
 * Output: 4
 * Explanation: There are 7 substrings of size 3: "aab", "aba", "bab", "abc", "bca", "cab", and "abc".
 * The good substrings are "abc", "bca", "cab", and "abc".
 */
public class SubstringsOfSizeThreeWithDistinctCharacters {

    public static int countGoodSubstrings(String s) {
        AtomicInteger atomic = new AtomicInteger();
        for(int i = 0; i < s.length() - 2; i++){
            String sub = s.substring(i, i + 3);
            String[] arr = sub.split("");
            int count = (int) Arrays.stream(arr).distinct().count();
            if(count == 3){
                atomic.getAndIncrement();
            }
        }
        return atomic.get();
    }

    public static void main(String[] args) {
        String s = "Welcome";
        String s1 = spinWords(s);
        System.out.println(s1);
    }

    public static String spinWords(String sentence) {
        String[] arr = sentence.split(" ");
        String collect = Arrays.stream(arr)
                .map(StringBuilder::new)
                .map(f -> f.reverse().toString())
                .collect(Collectors.joining(""));
        return collect;
    }

    public static int[] arrayDiff(int[] a, int[] b) {
        //1 2 2
        List<Integer> collect1 = IntStream.of(a).boxed().collect(Collectors.toList());
        List<Integer> collect2 = IntStream.of(b).boxed().collect(Collectors.toList());
        int[] ints = collect1.stream().filter(p -> !collect2.contains(p)).mapToInt(value -> value).toArray();
        return ints;
    }

    public static String createPhoneNumber(int[] numbers) {
        String str = Arrays.stream(numbers).mapToObj(String::valueOf).collect(Collectors.joining(""));
        return "(" + str.substring(0, 3) + ") " + str.substring(4, 7) + "-" + str.substring(8, str.length() - 1);
    }

}
