package org.example.twoSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 * <p>
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 * <p>
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int x = target - nums[i];
                if (x == nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    public static int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            int x = target - cur;
            if (map.containsKey(x)) {
                return new int[]{map.get(x), i};
            }
            map.put(cur, i);
        }
        return new int[]{};
    }

    public static int[] twoSum2(int[] nums, int target) {
        //Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            int curSum = nums[left] + nums[right];
            if (curSum == target){
                return new int[]{left, right};
            } else if (curSum > target) {
                right--;
            } else {
                left++;
                right = nums.length - 1;
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,-2,-3,-4,-5};
        int target = -8;
        long before = System.nanoTime();
        int[] ints = twoSum2(nums, target);
        System.err.println("TIME: " + (System.nanoTime() - before) / 100);
        System.out.println(Arrays.toString(ints));
    }
}

