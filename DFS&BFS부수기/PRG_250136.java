import java.util.*;

class Solution {
    private static int N, M;
    private static int[][] map;
    private static boolean[][] isVisited;
    private static int[] dirX = {-1, 0, 1, 0}; // 상 우 하 좌
    private static int[] dirY = {0, 1, 0, -1}; 
    private static HashMap<Integer, Integer> hashMap;
    
    private static class Coordinate {
        int x;
        int y;
        
        private Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    } // End of Coordinate class
    
    public int solution(int[][] land) {        
        map = land;
        N = map.length;
        M = map[0].length;
        isVisited = new boolean[N][M];
        
        hashMap = new HashMap<>();
        int num = 1;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] == 1 && !isVisited[i][j]) {
                    int count = BFS(i, j, ++num);
                    hashMap.put(num, count);
                }
            }
        }
        
        int ans = 0;
        for(int i=0; i<M; i++) {
            HashSet<Integer> hashSet = new HashSet<>();
            int sum = 0;
            
            for(int j=0; j<N; j++) {
                if(map[j][i] != 0) {
                    
                    if(hashSet.add(map[j][i])) {
                        sum += hashMap.get(map[j][i]);                        
                    }
                }
            }
            
            ans = Math.max(ans, sum);
        }
        
        return ans;
    } // End of solution()
    
    private int BFS(int x, int y, int num) {        
        ArrayDeque<Coordinate> que = new ArrayDeque<>();
        int count = 1;
        que.offer(new Coordinate(x, y));
        map[x][y] = num;
        
        while(!que.isEmpty()) {
            Coordinate cur = que.poll();
            
            for(int i=0; i<4; i++) {
                int nX = dirX[i] + cur.x;
                int nY = dirY[i] + cur.y;   
                
                if(!check(nX, nY)) continue;
                
                que.offer(new Coordinate(nX, nY));
                isVisited[nX][nY] = true;
                map[nX][nY] = num;
                count++;
            }            
        }
        
        return count;
    } // End of BFS()
    
    private boolean check(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M && !isVisited[x][y] && map[x][y] == 1;
    } // End of check()
} // End of Solution class