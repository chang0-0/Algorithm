import java.util.*;

class Solution {
    private static int N, M;
    private static int[][] land;
    private static boolean[][] isVisited;
    private static final int[] dirX = {-1, 0, 1, 0}; // 상 우 하 좌
    private static final int[] dirY = {0, 1, 0, -1}; // 상 우 하 좌
    
    
    private static class Coordinate {
        int x;
        int y;
        
        private Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    } // End of Coordinate class
    
    public int solution(int[][] land) {
        int answer = 0;
        
        this.land = land;
        N = land.length;
        M = land[0].length;
        isVisited = new boolean[N][M];
        HashMap<Integer, Integer> landMap = new HashMap<>();
        int num = 2;
    
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                
                if(land[i][j] == 1 && !isVisited[i][j]) {
                    int ret = BFS(i, j, num);
                    landMap.put(num++, ret);
                }
            }
        }
        
        
        int ans = 0;
        for(int i=0; i<M; i++) {
            HashSet<Integer> set = new HashSet<>();
            for(int j=0; j<N; j++) {
                if(land[j][i] >= 2) {
                    set.add(land[j][i]);
                }
            }
            
            int sum = 0;
            for(int temp : set) {
                sum += landMap.get(temp);
            }
            ans = Math.max(sum, ans);
        }
        
        
        return ans;
    } // End of solution()
    
    public int BFS(int x, int y, int num) {
        ArrayDeque<Coordinate> que = new ArrayDeque<>();
        que.offer(new Coordinate(x, y));
        int count = 1;
        land[x][y] = num;
        isVisited[x][y] = true;
        
        while(!que.isEmpty()) {
            Coordinate cur = que.poll();
            
            for(int i=0; i<4; i++) {
                int nX = cur.x + dirX[i];
                int nY = cur.y + dirY[i];
                
                if(!isAbleCheck(nX, nY)) continue;
                que.offer(new Coordinate(nX, nY));
                isVisited[nX][nY] = true;
                land[nX][nY] = num;
                count++;
            }
        }
        
        return count;
    } // End of BFS()
    
    public boolean isAbleCheck(int nX, int nY) {
        return nX >= 0 && nX < N && nY >= 0 && nY < M && !isVisited[nX][nY] && land[nX][nY] == 1;
    } // End of isAbleCheck()
} // End of Solution class