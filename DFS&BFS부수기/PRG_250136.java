import java.util.*;

class Solution {
    public static int[][] land;
    public static boolean[][] isVisited;
    public static int N, M;
    public static final int[] dirX = {-1, 0, 1, 0}; // 상 우 하 좌
    public static final int[] dirY = {0, 1, 0, -1};
    
    public static class Coordinate {
        int x;
        int y;
        
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    } // End of Coordinate class
    
    public int solution(int[][] land) {        
        input(land);
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int idx = 2;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(isVisited[i][j] || land[i][j] == 0) continue;
                
                int count = BFS(i, j, idx);
                map.put(idx++, count);                
            }
        }
        
        int ans = 0;
        for(int i=0; i<M; i++) {
            Set<Integer> set = new HashSet<>();
            
            for(int j=0; j<N; j++) {
                if(land[j][i] > 0) {
                    set.add(land[j][i]);
                }
            }
            
            int sum = 0;
            for(int num : set) {
                sum += map.get(num);
            }
            ans = Math.max(ans, sum);
        }
        
         
        return ans;
    } // End of solution()
    
    public int BFS(int x, int y, int idx) {
        LinkedList<Coordinate> que = new LinkedList<>();
        int count = 1;
        
        que.offer(new Coordinate(x,y));
        land[x][y] = idx;
        isVisited[x][y] = true;
        
        while(!que.isEmpty()) {
            Coordinate current = que.poll();
            
            for(int i=0; i<4; i++) {
                int nextX = dirX[i] + current.x;
                int nextY = dirY[i] + current.y;
                
                if(!isAbleCheck(nextX, nextY)) continue;
                isVisited[nextX][nextY] = true;
                
                land[nextX][nextY] = idx;
                count++;
                que.offer(new Coordinate(nextX, nextY));
            }
        }
        
        return count;
    } // End of BFS()
    
    public boolean isAbleCheck(int nextX, int nextY) {
        return nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && !isVisited[nextX][nextY] && land[nextX][nextY] == 1;
    } // End of isAbleCheck()
    
    public void input(int[][] land) {
        N = land.length;
        M = land[0].length;
        isVisited = new boolean[N][M];
        
        this.land = land;
    } // End of input();
} //End of Solution class