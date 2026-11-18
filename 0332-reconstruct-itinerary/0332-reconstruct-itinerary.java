
class Solution {
    Map<String, PriorityQueue<String>> graph = new HashMap<>();
    List<String> result = new ArrayList<>();

    public List<String> findItinerary(List<List<String>> tickets) {

    
        for (List<String> ticket : tickets) {
            graph.computeIfAbsent(
                ticket.get(0),
                k -> new PriorityQueue<>()
            ).offer(ticket.get(1));
        }

        dfs("JFK");

        Collections.reverse(result);

        return result;
    }

    public void dfs(String airport) {

        PriorityQueue<String> neighbors = graph.get(airport);

        while (neighbors != null && !neighbors.isEmpty()) {

            String next = neighbors.poll();

            dfs(next);
        }

        result.add(airport);
    }
}


// class Solution {
//     Map<String,List<String>> graph = new HashMap();
//     List<String> result = new ArrayList();
//     int numTickets = 0;
//     public List<String> findItinerary(List<List<String>> tickets) {
//         numTickets = tickets.size();
//         for(List<String> ticket:tickets){
//             graph.put(ticket.get(0),new ArrayList());
//         }
//         for(List<String> ticket:tickets){
//             graph.get(ticket.get(0)).add(ticket.get(1));
//         }
//         for(Map.Entry<String,List<String>> edges:graph.entrySet()){
//             Collections.sort(edges.getValue());
//         }

//         List<String> path = new ArrayList();
//         DFS("JFK",path);
        
//         return result;
//     }
    
//     public boolean DFS(String fromAirport,List<String> path){
//         path.add(fromAirport);
//         if(path.size() == numTickets+1){
//             result = path;
//             return true;
//         }
        
//         List<String> neighbors = graph.get(fromAirport);
//         for(int i=0;neighbors!=null && i<neighbors.size();i++){
//             String toAirport = neighbors.get(i);
//             neighbors.remove(toAirport);
//             if(DFS(toAirport,path)){
//                 return true;
//             }
//             neighbors.add(i,toAirport);
//         }
//         path.remove(path.size()-1);
//         return false;
//     }
// }