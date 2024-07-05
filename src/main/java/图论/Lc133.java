package 图论;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Lc133 {

    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    HashMap<Integer, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        //异常处理
        if (node == null)
            return null;
        if (node.neighbors == null || node.neighbors.size() == 0)
            return new Node(node.val);

        Node nodeCopy = new Node();
        nodeCopy.val = node.val;
        map.put(nodeCopy.val, nodeCopy);
        List<Node> neighbors = node.neighbors;
        int size = neighbors.size();

        for (int i = 0; i < size; i++) {
            Node nodecur = neighbors.get(i);
            int valcur = nodecur.val;
            nodeCopy.neighbors.add(map.containsKey(valcur) ? map.get(valcur) : cloneGraph(nodecur));
        }

        return nodeCopy;
    }

}
