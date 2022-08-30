package company.bloomberg.q100;

import model.TreeNode;

import java.util.Stack;

public class Q173 {
    class InOrderBSTIterator {
        Stack<TreeNode> stack = new Stack<>();

        public InOrderBSTIterator(TreeNode root) {
            push(stack, root);
        }

        private void push(Stack<TreeNode> stack, TreeNode root) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }

        public int next() {
            if (!hasNext()) return -1;
            TreeNode pop = stack.pop();
            push(stack, pop.right);
            return pop.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }

    class PreOrderIterator {
        Stack<TreeNode> stack = new Stack<>();

        public PreOrderIterator(TreeNode root) {
            if (root != null)
                stack.push(root);
        }

        public int next() {
            if (!hasNext()) return -1;
            TreeNode pop = stack.pop();
            if (pop.right != null) stack.push(pop.right);
            if (pop.left != null) stack.push(pop.left);
            return pop.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }

    class PostOrderIterator {
        Stack<TreeNode> stack = new Stack<>();

        public PostOrderIterator(TreeNode root) {
            push(stack, root);
        }

        private void push(Stack<TreeNode> stack, TreeNode root) {
            while (root != null) {
                stack.push(root);
                if (root.left != null) root = root.left;
                else root = root.right;
            }
        }

        public int next() {
            if (!hasNext()) return -1;
            TreeNode pop = stack.pop();
            if (!stack.isEmpty() && pop.equals(stack.peek())) {
                push(stack, pop.right);
            }
            return pop.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }
}
