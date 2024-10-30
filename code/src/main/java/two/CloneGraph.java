package two;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {

    private static Map<Integer, Node> visited = new HashMap<>();

    public static void main(String[] args) {

    }

    public static Node clone(Node node) {
        return dfs(node);
    }

    public static Node dfs(Node node) {
        if (node == null)
            return null;
        if (visited.containsKey(node.data)) {
            return visited.get(node.data);
        }

        Node root = new Node(node.data);
        visited.put(root.data, root);

        for (Node neighbor : node.neighbors) {
            root.neighbors.add(dfs(neighbor));
        }
        return root;
    }
}

class Node {
    int data;
    List<Node> neighbors;

    Node(int data) {
        this.data = data;
        this.neighbors = new ArrayList();
    }
}
