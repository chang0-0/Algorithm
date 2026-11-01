
import java.util.*;
import java.io.*;

class Solution {
    private static int N, M;
    private static int[] indegree;
    private static List<List<Integer>> adjList;

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // 모든 과목을 수강할 수 있는지 확인하기.
        N = numCourses;
        M = prerequisites.length;
        adjList = new ArrayList<>();
        for(int i=0; i<N; i++) {
            adjList.add(new ArrayList<>());
        }

        indegree = new int[N];
        int[] order = new int[N];

        for(int i=0; i<M; i++) {
            int from = prerequisites[i][1];
            int to = prerequisites[i][0];

            adjList.get(from).add(to);
            indegree[to]++;
        }

        return BFS(indegree, order);
    } // End of main()

    private static boolean BFS(int[] indegree, int[] order) {
        Queue<Integer> que = new ArrayDeque<>();
        int count = 0;

        for(int i=0; i<N; i++) {
            if(indegree[i] == 0) {
                que.offer(i);
            }
        }

        while(!que.isEmpty()) {
            int cur = que.poll();
            
            order[count++] = cur;

            for(int next : adjList.get(cur)) {
                indegree[next]--;

                if(indegree[next] == 0) {
                    que.offer(next);
                }
            }
        }

        return count == N;
    } // End of BFS()
} // End of Main class