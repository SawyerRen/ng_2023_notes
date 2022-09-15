package company.amazon.finalround;

import java.util.Stack;

public class Q1628 {
    abstract class Node {
        public abstract int evaluate();
        // define your fields here
    }

    class TreeNode extends Node {
        String val;
        TreeNode left;
        TreeNode right;

        public TreeNode(String val) {
            this.val = val;
        }

        @Override
        public int evaluate() {
            return helper(this);
        }

        private int helper(TreeNode root) {
            if (root == null) return 0;
            if (root.left == null && root.right == null) {
                return Integer.parseInt(root.val);
            }
            int left = helper(root.left);
            int right = helper(root.right);
            switch (root.val) {
                case "+":
                    return left + right;
                case "-":
                    return left - right;
                case "*":
                    return left * right;
                default:
                    return left / right;
            }
        }
    }

    /**
     * This is the TreeBuilder class.
     * You can treat it as the driver code that takes the postinfix input
     * and returns the expression tree represnting it as a Node.
     */

    class TreeBuilder {
        Node buildTree(String[] postfix) {
            Stack<TreeNode> stack = new Stack<>();
            for (String s : postfix) {
                if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                    TreeNode node = new TreeNode(s);
                    TreeNode right = stack.pop();
                    TreeNode left = stack.pop();
                    node.left = left;
                    node.right = right;
                    stack.push(node);
                } else {
                    stack.push(new TreeNode(s));
                }
            }
            return stack.pop();
        }
    }
}
