import java.util.*;

class Solution {
    public static int N, M;
    public static int[][] land;
    public static boolean[][] isVisited;
    public static HashMap<Integer, Integer> map;
    
    public static int[] dirX = {-1, 1, 0, 0};
    public static int[] dirY = {0, 0, -1, 1};
    
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
        
        int num = 2;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(!isVisited[i][j] && land[i][j] == 1) {
                    int ret = BFS(i, j, num); 
                    map.put(num++, ret);
                }
            }
        }
        
        int ans = 0;
        for(int i=0; i<M; i++) {
            HashSet<Integer> set = new HashSet<>();
            for(int j=0; j<N; j++) {
                if(land[j][i] != 0) {
                    set.add(land[j][i]);
                }
            }
            
            int sum = 0;
            for(int setNum : set) {
                sum += map.get(setNum);
            }    
            ans = Math.max(ans, sum);
        }
        
        return ans;
    } // End of solution()
    
    public int BFS(int x, int y, int num) {
        ArrayDeque<Coordinate> que = new ArrayDeque<>();
        que.offer(new Coordinate(x, y));
        int count = 1;
        isVisited[x][y] = true;
        land[x][y] = num;
        
        while(!que.isEmpty()) {
            Coordinate cur = que.poll();
            
            for(int i=0; i<4; i++) {
                int nextX = cur.x + dirX[i];
                int nextY = cur.y + dirY[i];
                
                if(!isAbleCheck(nextX, nextY)) continue;
                
                isVisited[nextX][nextY] = true;
                count++;
                que.offer(new Coordinate(nextX, nextY));
                land[nextX][nextY] = num;
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
        this.land = land;
        
        map = new HashMap<>();
        isVisited = new boolean[N][M];
    } // End of input()
} // End of Solution class