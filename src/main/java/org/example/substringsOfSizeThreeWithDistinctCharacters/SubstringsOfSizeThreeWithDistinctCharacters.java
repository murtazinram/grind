package org.example.substringsOfSizeThreeWithDistinctCharacters;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

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

    }
}
