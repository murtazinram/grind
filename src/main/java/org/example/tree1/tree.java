package org.example.tree1;

import java.util.*;

public class tree {

    public static void main(String[] args) {
        Tree root = new Tree(20,
                            new Tree(7,
                                    new Tree(4, null,
                                            new Tree(6)),
                                    new Tree(9)),
                            new Tree(35,
                                    new Tree(31,
                                            new Tree(28), null),
                                    new Tree(40,
                                            new Tree(38), new Tree(52))));

        System.out.println("sum tree=" + mySum(root));
        System.out.println("sum tree=" + root.sumRecursive());
        System.out.println("max sum tree=" + maxSum(root));
        System.out.println("sum tree without recursive=" + Tree.sumDeep(root));
        System.out.println("sumWide tree =" + Tree.sumWide(root));
        System.out.println("invertTree tree =" + Tree.invertTree(root));

        Thread thread = Thread.currentThread();
        System.out.println("" + thread.getName());

    }

    static int maxSum(Tree tree) {
        if (tree == null) {
            return 0;
        }
        int value = tree.value;
        int maxLeftSum = maxSum(tree.left);
        int maxRightSum = maxSum(tree.right);
        if (tree.left == null || tree.right == null){
            return value + maxLeftSum + maxRightSum;
        } else {
            return value + Math.max(maxSum(tree.left), maxSum(tree.right));
        }
    }

    static int mySum(Tree tree){
        int summ = tree.value;

        if (tree.left != null){
            summ += mySum(tree.left);
        }
        if (tree.right != null){
            summ += mySum(tree.right);
        }
        return summ;
    }

    static class Tree {
        int value;
        Tree left;
        Tree right;

        public Tree(int value, Tree left, Tree right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Tree(int value) {
            this.value = value;
        }

        /**
         * @return get sum all nodes
         * в глубину с рекурсией
         */
        public int sumRecursive() {
            int summ = value;
            if (left != null) {
                summ += left.sumRecursive();
            }
            if (right != null) {
                summ += right.sumRecursive();
            }
            return summ;
        }

        /**
         * в глубину без рекурсии
         */
        public static int sumDeep(Tree root) {
            Stack<Tree> stack = new Stack<>();
            stack.push(root);

            int summ = 0;

            while (!stack.isEmpty()) {
                Tree node = stack.pop();
                summ += node.value;

                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
            }
            return summ;
        }

        /**
         * в ширину
         */
        public static int sumWide(Tree root) {
            //List<Tree> queue = new ArrayList<>();
            Queue<Tree> queue = new LinkedList<>();
            queue.add(root);

            int summ = 0;

            while (!queue.isEmpty()) {
                //Tree node = queue.remove(0);
                Tree node = queue.remove();
                summ += node.value;

                if (node.right != null) {
                    queue.add(node.right);

                }
                if (node.left != null) {
                    queue.add(node.left);
                }
            }
            return summ;
        }

        public static Tree invertTree(Tree root) {
            Queue<Tree> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                Tree node = queue.remove();
                System.out.println(node.value);
                if (node.right != null && node.left != null) {

                    queue.add(node.right);
                    queue.add(node.left);
                    int leftValue = node.left.value;
                    int rightValue = node.right.value;
                    node.left.value = rightValue;
                    node.right.value = leftValue;
                }
            }
            return root;
        }
    }
}
