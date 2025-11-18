import java.util.*;

class Solution {
    public List<String> solution(String[][] tickets) {
        String[] answer = {};
        
        int N = tickets.length;
        int M = 2;
        
        Arrays.sort(tickets, (o1, o2) -> {
           return o1[0].compareTo(o2[0]); 
        });
        
        HashMap<String, LinkedList<String>> adjList = new HashMap<>();
        for(int i=0; i<N; i++) {
            String st = tickets[i][0];
            String ed = tickets[i][1];
            adjList.computeIfAbsent(st, k -> new LinkedList<>()).offer(ed);
        }
        
        for(List<String> list : adjList.values()) {
            Collections.sort(list);
        }
        
        // System.out.println(adjList);
        
        ArrayDeque<String> que = new ArrayDeque<>();
        List<String> ansList = new ArrayList<>();
        // 잊지말자, que는 ArrayDeque를 그냥, stack처럼 활용하기 위해 사용할 뿐임.
        // 이 문제는 오일러 회로 문제이다.
        // BFS 문제와 전혀 상관없기 때문에 BFS의 구현 방식을 떠올리면 안된다.
        
        que.offer("ICN");
        
        while(!que.isEmpty()) {
            String cur = que.peekLast();
            
            if(adjList.get(cur) == null || adjList.get(cur).isEmpty()) {
                ansList.add(que.pollLast());
            } else {
                que.offer(adjList.get(cur).pollFirst());
            }
        }
        
        
        Collections.reverse(ansList);
        // System.out.println(ansList);
        
        return ansList;
    } // End of main()
} // End of Main class