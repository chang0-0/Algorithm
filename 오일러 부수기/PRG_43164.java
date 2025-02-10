import java.util.*;
import java.util.Collections;
import java.util.Objects;

class Solution {
    public List<String> solution(String[][] tickets) {
        String[] answer = {};
        
        
        int N = tickets.length;
        Arrays.sort(tickets, (o1, o2) -> {
            return o1[0].compareTo(o2[0]);
        });
                
        LinkedHashMap<String, LinkedList<String>> adjList = new LinkedHashMap<>();
        for(int i=0; i<N; i++) {
            adjList.put(tickets[i][0], new LinkedList<>());
        }
        
        
        for(int i=0; i<N; i++) {
            adjList.get(tickets[i][0]).offer(tickets[i][1]);
            Collections.sort(adjList.get(tickets[i][0]));
        }
        
        
        ArrayDeque<String> que = new ArrayDeque<>();
        List<String> list = new ArrayList<>();
        que.offer("ICN");
        
        while(!que.isEmpty()) {
            String cur = que.peekLast();
            
            if(adjList.get(cur) != null && !adjList.get(cur).isEmpty()) {
                String next = adjList.get(cur).poll();
                que.offer(next);
            } else {
                list.add(que.pollLast());
            }
        }
        

        Collections.reverse(list);        
        return list;
    } // End of solution()
} // End of Solution class