package company.amazon.q1600;

import java.util.Stack;

public class Q1628 {
    abstract class Node {
        public abstract int evaluate();
        // define your fields here
    }

     class TreeNode extends Node {
        TreeNode left;
        TreeNode right;
        String val;

        public TreeNode(String val) {
            this.val = val;
        }

        @Override
        public int evaluate() {
            return dfs(this);
        }

        private int dfs(TreeNode node) {
            if (node == null) return 0;
            if (node.left == null && node.right == null) return Integer.parseInt(node.val);
            int left = dfs(node.left);
            int right = dfs(node.right);
            switch (node.val) {
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

    class TreeBuilder {
        Node buildTree(String[] postfix) {
            Stack<TreeNode> stack = new Stack<>();
            for (String s : postfix) {
                if (s.equals("+") || s.equals("-") || s.equals("/") || s.equals("*")) {
                    TreeNode root = new TreeNode(s);
                    TreeNode right = stack.pop();
                    TreeNode left = stack.pop();
                    root.left = left;
                    root.right = right;
                    stack.push(root);
                } else {
                    stack.push(new TreeNode(s));
                }
            }
            return stack.pop();
        }
    }
}
