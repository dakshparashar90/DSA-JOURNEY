// /*
// // Definition for a Node.
// class Node {
//     public int val;
//     public List<Node> neighbors;
//     public Node() {
//         val = 0;
//         neighbors = new ArrayList<Node>();
//     }
//     public Node(int _val) {
//         val = _val;
//         neighbors = new ArrayList<Node>();
//     }
//     public Node(int _val, ArrayList<Node> _neighbors) {
//         val = _val;
//         neighbors = _neighbors;
//     }
// }
// */

// class Solution {
//     public Node cloneGraph(Node node) {
//         if(node==null){
//             return null;
//         }

//         HashMap<Node,Node>map=new HashMap<>();
//         Queue<Node>qq=new LinkedList<>();

//         Node clone=new Node(node.val);
//         map.put(node,clone);
//         qq.offer(node);

//         while(!qq.isEmpty()){
//             Node curr=qq.poll();

//             for(Node nn:curr.neighbors){
                
//                 if(!map.containsKey(nn)){
//                     map.put(nn,new Node(nn.val));
//                     qq.offer(nn);
//                 }

//                 map.get(curr).neighbors.add(map.get(nn));

//             }
//         }
//       return  map.get(node);
//     }
// }

class Solution {

    HashMap<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;

        return dfs(node);
    }

    private Node dfs(Node node) {

       
        if (map.containsKey(node)) {
            return map.get(node);
        }

        Node clone = new Node(node.val);
        map.put(node, clone);

      
        for (Node nei : node.neighbors) {
            clone.neighbors.add(dfs(nei));
        }

        return clone;
    }
}