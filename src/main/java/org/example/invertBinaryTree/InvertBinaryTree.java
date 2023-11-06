package org.example.invertBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/invert-binary-tree/
 * Given the root of a binary tree, invert the tree, and return its root.
 * <p>
 * Example 1:
 * Input: root = [4,2,7,1,3,6,9]
 * Output: [4,7,2,9,6,3,1]
 * <p>
 * Example 2:
 * Input: root = [2,1,3]
 * Output: [2,3,1]
 * Example 3:
 * <p>
 * Input: root = []
 * Output: []
 * <p>
 * Constraints:
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();

            if (node != null) {
                if (node.right != null && node.left != null) {
                    queue.add(node.right);
                    queue.add(node.left);

                    TreeNode tempNode = node.left;
                    node.left = node.right;
                    node.right = tempNode;
                }
                if (node.right != null && node.left == null) {
                    queue.add(node.right);
                    node.left = node.right;
                    node.right = null;
                } else if (node.left != null && node.right == null) {
                    queue.add(node.left);
                    node.right = node.left;
                    node.left = null;
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}


