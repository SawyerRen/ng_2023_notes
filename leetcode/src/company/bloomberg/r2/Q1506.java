package company.bloomberg.r2;

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
