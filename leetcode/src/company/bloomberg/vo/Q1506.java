package company.bloomberg.vo;

import com.sun.source.util.Trees;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q1506 {
    class Node {
        public int val;
        public List<Node> children;


        public Node() {
            children = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public Node findRoot(List<Node> tree) {
        if (tree.size() == 0) return null;
        int total = 0, childrenTotal = 0;
        for (Node node : tree) {
            total += node.val;
            for (Node child : node.children) {
                childrenTotal += child.val;
            }
        }
        for (Node node : tree) {
            if (node.val + childrenTotal == total) return node;
        }
        return null;
    }

    public Node findRoot1(List<Node> tree) {
        if (tree.size() == 0) return null;
        Set<Node> set = new HashSet<>();
        for (Node node : tree) {
            set.addAll(node.children);
        }
        for (Node node : tree) {
            if (!set.contains(node)) return node;
        }
        return null;
    }
}
