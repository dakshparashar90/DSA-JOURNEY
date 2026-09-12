/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution{
    public Node copyRandomList(Node head){
        if (head == null) return null;

        HashMap<Node,Node>map=new HashMap<>();

        Queue<Node> qq=new LinkedList<>();

        Node newNode=new Node(head.val);
        map.put(head,newNode);
        qq.offer(head);

        while(!qq.isEmpty()){
            Node curr=qq.poll();

            if(curr.next!=null){

                if(!map.containsKey(curr.next)){
                    map.put(curr.next,new Node(curr.next.val));
                    qq.offer(curr.next);
                }

                map.get(curr).next = map.get(curr.next);
            }
             if (curr.random != null) {

                if (!map.containsKey(curr.random)) {
                    map.put(curr.random, new Node(curr.random.val));
                    qq.offer(curr.random);
                }

                map.get(curr).random = map.get(curr.random);
            }
        }

        return newNode;
        

    }
}








// class Solution {
//     HashMap<Node, Node> map = new HashMap<>();

//     public Node copyRandomList(Node head) {
//         if (head == null) return null;

//         if (map.containsKey(head)) {
//             return map.get(head);
//         }

//         Node newNode = new Node(head.val);

//         map.put(head, newNode);

//         newNode.next = copyRandomList(head.next);
//         newNode.random = copyRandomList(head.random);

//         return newNode;
//     }
// }