package org.example.mergeTwoSortedLists;

import java.util.*;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 * You are given the heads of two sorted linked lists list1 and list2.
 *
 * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
 *
 * Return the head of the merged linked list.
 *
 * Example 1:
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 *
 * Example 2:
 * Input: list1 = [], list2 = []
 * Output: []
 *
 * Example 3:
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 *
 * Constraints:
 *
 * The number of nodes in both lists is in the range [0, 50].
 * -100 <= Node.val <= 100
 * Both list1 and list2 are sorted in non-decreasing order.
 */
public class MergeTwoSortedLists {
    public static void main(String[] args) {

    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        List<Integer> vals1 = new LinkedList<>();
        recursion(list1,vals1);

        List<Integer> vals2 = new LinkedList<>();
        recursion(list2,vals2);

        List<Integer> result = new ArrayList<>();
        result.addAll(vals2);
        result.addAll(vals1);
        Collections.sort(result);
        //System.out.println(result.toString());

        ListNode firstNode = null;
        ListNode node = null;
        for (Integer val : result) {
            ListNode listNode = new ListNode(val);
            if (node != null){
                node.next = listNode;
                node = listNode;
            } else {
                node = listNode;
                firstNode = node;
            }
        }
        return firstNode;
    }

    public ListNode recursion(ListNode item, List<Integer> values) {
        if (item == null){
            return new ListNode(-1);
        }
        int val = item.val;
        values.add(val);
        ListNode next = item.next;
        return recursion(next, values);
    }

      public class ListNode {
      int val;
      ListNode next;
      ListNode() {

      }
      ListNode(int val) {
          this.val = val;
      }
      ListNode(int val, ListNode next) {
          this.val = val; this.next = next;
      }
  }
}
