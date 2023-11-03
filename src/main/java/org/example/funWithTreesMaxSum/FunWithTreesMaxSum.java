package org.example.funWithTreesMaxSum;

import org.example.invertBinaryTree.InvertBinaryTree;

/**
 * https://www.codewars.com/kata/57e5279b7cf1aea5cf000359/train/java
 * You are given a binary tree. Implement the method maxSum which returns the maximal sum of a route from root to leaf.
 * For example, given the following tree:
 * <p>
 * 17
 * /  \
 * 3   -10
 * /    /  \
 * 2    16   1
 * /
 * 13
 * The method should return 23, since [17,-10,16] is the route from root to leaf with the maximal sum.
 * <p>
 * Return 0 if the tree is empty.
 * <p>
 * Please note that you are not to find the best possible route in the tree, but the best possible route from root to
 * leaf, e.g. for the following tree, you cannot skip the leaves and return 15: the expected answer is 5 + 4 + -60 = -51
 * <p>
 * 5
 * /   \
 * 4       10
 * /   \     /
 * -80  -60  -90
 * The class TreeNode is available for you:
 * <p>
 * class TreeNode {
 * TreeNode left;
 * TreeNode right;
 * int value;
 * ...
 * }
 * This kata is part of fun with trees series:
 * <p>
 * Fun with trees: max sum
 * Fun with trees: array to tree
 * Fun with trees: is perfect
 */
public class FunWithTreesMaxSum {
    static int maxSum(TreeNode root) {
        if (root == null){
            return 0;
        }
        int value = root.value;
        int maxSumLeft = maxSum(root.left);
        int maxSumRight = maxSum(root.right);

        if (root.left == null) {
            return value + maxSumLeft + maxSumRight;
        } else if (root.right == null) {
            return value + maxSumLeft + maxSumRight;
        } else {
            return value + Math.max(maxSum(root.left), maxSum(root.right));
        }
    }

    public static void main(String[] args) {

    }

    public class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int value) {
            this.value = value;
        }

        TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
