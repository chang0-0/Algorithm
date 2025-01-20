import java.util.*;

class Solution {
    static int N;
    
    public List<String> solution(String[][] tickets) {        
        
        // 정렬
        N = tickets.length;
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
                
        
        Stack<String> stack = new Stack<>();
        List<String> list = new ArrayList<>();
        stack.push("ICN");
        
        while(!stack.isEmpty()) {
            String cur = stack.peek();
            
            if(adjList.get(cur) != null && !adjList.get(cur).isEmpty()) {
                String next = adjList.get(cur).removeFirst();
            
                stack.push(next);
            } else {
                list.add(stack.pop());
            }
            
        }
        
        Collections.reverse(list);        
        
        return list;
    } // End of solution()
} // End of Solution class
