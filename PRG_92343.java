import java.util.*;

class Solution {
    public static List<List<Integer>> adjList;
    public static int N;
    
    public static class Node implements Comparable<Node> {
        int num;
        int wolfCount;
        int sheepCount;
        
        public Node(int num, int wolfCount, int sheepCount) {
            this.num = num;
            this.wolfCount = wolfCount;
            this.sheepCount = sheepCount;
        }
        
        @Override
        public String toString() {
            return "Node{" + num + ", " + wolfCount + ", " + sheepCount + "}\n";
        }
        
        @Override
        public int compareTo(Node o) {
            if(sheepCount == o.sheepCount) {
                return wolfCount - o.wolfCount;
            }
            
            return sheepCount - o.sheepCount;
        }
        
    } // End of Animal class
    
    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        
        input(info, edges);
        System.out.println(adjList);
        
        DFS(0, 1, 0);
        
        return answer;
    } // End of solution()
    
    public void DFS(int depth, int sheepCount, int wolfCount) {
        
        
        
        
    } // End of DFS()
    
    
    
    public void input(int[] info, int[][] edges ) {
        adjList = new ArrayList<>();
        N = info.length;
        for(int i=0; i<=N; i++) {
            adjList.add(new ArrayList<>());
        }
        
        int len = edges.length;
        for(int i=0; i<len; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }
        
    } // End of input()
} // End of Solution class