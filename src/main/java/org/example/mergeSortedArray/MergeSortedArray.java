package org.example.mergeSortedArray;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        List<Integer> nums1List = Arrays.stream(nums1).boxed().limit(m).collect(Collectors.toList());
        List<Integer> nums2List = Arrays.stream(nums2).boxed().collect(Collectors.toList());

        int[] ints = Stream.of(nums1List, nums2List).flatMap(e->e.stream()).sorted().mapToInt(i -> i).toArray();
        nums1 = ints;

    }

    public static void main(String[] args) {
       int nums1[] = new int[]{1,2,3,0,0,0};
       int nums2[] = new int[]{2,5,6};
       merge(nums1, 3, nums2, 3);

       System.out.println(Arrays.toString(nums1));
    }
}
