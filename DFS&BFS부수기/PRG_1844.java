import java.util.*;

class Solution {
    public static final int[] dirX = {-1, 1, 0, 0};
    public static final int[] dirY = {0, 0, 1, -1};
    public static int N, M;
    
    public static class Coordinate {
        int x;
        int y;
        int count = 0;
        
        public Coordinate(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    } // End of Coordinate class
    
    public int solution(int[][] maps) {
        int answer = 0;
        input(maps);
        
        return BFS(maps);
    } // End of solution()
    
    public int BFS(int[][] maps) {
        LinkedList<Coordinate> que = new LinkedList<>();
        boolean[][] isVisited = new boolean[N][M];
        
        que.offer(new Coordinate(0, 0, 1));
        
        while(!que.isEmpty()) {
            Coordinate current = que.poll();
            
            for(int i=0; i<4; i++) {
                int nextX = current.x + dirX[i];
                int nextY = current.y + dirY[i];
                
                if(nextX == N - 1 && nextY == M - 1) {
                    return current.count + 1;
                }
                
                if(!isAbleCheck(maps, nextX, nextY, isVisited)) continue;
                
                que.offer(new Coordinate(nextX, nextY, current.count + 1));
                isVisited[nextX][nextY] = true;
            }
        }
        
        return -1;
    } // End of BFS()
    
    public boolean isAbleCheck(int[][] maps, int nextX, int nextY, boolean[][] isVisited) {
        return nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && !isVisited[nextX][nextY] && maps[nextX][nextY] == 1;
    } // End of isAbleCheck()
    
    public void input(int[][] maps) {
        N = maps.length;
        M = maps[0].length;
    } // End of input()
} // End of Solution class