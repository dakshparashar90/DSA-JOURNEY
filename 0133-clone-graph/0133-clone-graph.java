/*
// Definition for a Node.
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
*/

class Solution {
    HashMap<Node,Node>mp;
    public Node cloneGraph(Node node) {
        if(node==null){
            return null;
        }
        mp=new HashMap<>();
        return solve(node);
    }
    public Node solve(Node node){
        if(mp.containsKey(node)){
            return mp.get(node);
        }
        Node clone=new Node(node.val);
        mp.put(node,clone);
        for(Node nn:node.neighbors){
            mp.get(node).neighbors.add(solve(nn));
        }

        return mp.get(node);
    }
}