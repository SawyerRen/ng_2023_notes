package company.amazon.finalround;

import java.util.Stack;

public class Q1628 {
    abstract class Node {
        public abstract int evaluate();
        // define your fields here
    }

    ;

    class PostFixNode extends Node {
        PostFixNode left;
        PostFixNode right;
        String val;

        public PostFixNode(String val) {
            this.val = val;
        }

        @Override
        public int evaluate() {
            return helper(this);
        }

        private int helper(PostFixNode node) {
            if (node == null) return 0;
            if (node.left == null && node.right == null) {
                return Integer.parseInt(node.val);
            }
            int left = helper(node.left);
            int right = helper(node.right);
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

    /**
     * This is the TreeBuilder class.
     * You can treat it as the driver code that takes the postinfix input
     * and returns the expression tree represnting it as a Node.
     */

    class TreeBuilder {
        Node buildTree(String[] postfix) {
            Stack<PostFixNode> stack = new Stack<>();
            for (String s : postfix) {
                if (s.equals("+") || s.equals("-") || s.equals("/") || s.equals("*")) {
                    PostFixNode right = stack.pop();
                    PostFixNode left = stack.pop();
                    PostFixNode node = new PostFixNode(s);
                    node.left = left;
                    node.right = right;
                    stack.push(node);
                } else {
                    stack.push(new PostFixNode(s));
                }
            }
            return stack.pop();
        }
    }
}
