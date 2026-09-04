import java.util.*;
import java.io.*;

class Solution {
    private static List<List<Integer>> adjList;
    private static int N, M;
    private static boolean[] isVisited, isCompleted;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        N = numCourses;
        M = prerequisites.length;
        
        adjList = new ArrayList<>();
        for(int i=0; i<N; i++) {
            adjList.add(new ArrayList<>());
        }
        
        for(int i=0; i<M; i++) {
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            adjList.get(a).add(b);
        }

        System.out.println(adjList);

        isVisited = new boolean[N]; // 이미 방문한 노드인가.
        isCompleted = new boolean[N]; // 선행 조건이 모두 완성되었는가

        for(int i=0; i<N; i++) {
            if(isCompleted[i]) continue; // 이미 선행 조건이 완성됨 -> 선행 조건이 없는 노드
            System.out.println(i);
            if(!DFS(i)) return false;
        }


        return true;
    } // End of main()

    private static boolean DFS(int start) {
        if(isVisited[start]) return false;
        if(isCompleted[start]) return true; // start 모든 수강 완료.
        isVisited[start] = true;

        for(int next : adjList.get(start)) {
            if(!DFS(next)) return false;
        }

        isVisited[start] = false;
        isCompleted[start] = true;
        return true;
    } // End of DFS()
} // End of Main class
