class Solution {

    public Node dfs(Node node, HashMap<Node, Node> map) {

        if(node == null) return null;

        if(map.containsKey(node)) {
            return map.get(node);
        }

        Node clone = new Node(node.val);
        map.put(node, clone);

        for(Node n : node.neighbors) {
            clone.neighbors.add(dfs(n, map));
        }

        return clone;
    }

    public Node cloneGraph(Node node) {

        HashMap<Node, Node> map = new HashMap<>();

        return dfs(node, map);
    }
}