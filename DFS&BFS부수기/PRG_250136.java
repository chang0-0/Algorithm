import java.util.*;

class Solution {
    public static HashMap<Integer, Integer> indexMap;
    public static int N, M;
    public static int[][] map, oilIndexMap;
    public static boolean[][] isVisited;
    
    public static final int[] dirX = {-1, 1, 0, 0}; // 하 상 좌 우
    public static final int[] dirY = {0, 0, -1, 1}; // 하 상 좌 우
    
    
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
        
        int mapIdx = 1;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {                
                if(!isVisited[i][j] && map[i][j] == 1) {
                    int ret = BFS(i, j, mapIdx);
                    
                    indexMap.put(mapIdx++, ret);
                }
            }
        }
        
        int ans = 0;
        // 세로로 진행
        for(int y=0; y<M; y++) {
            HashSet<Integer> set = new HashSet<>();
            for(int x=0; x<N; x++) {
                if(oilIndexMap[x][y] != 0) {
                    set.add(oilIndexMap[x][y]);
                }
            }
            
            int sum = 0;
            for(int idx : set) {
                sum += indexMap.get(idx);
            }
            
            ans = Math.max(ans, sum);
        }
        
        
        return ans;
    } // End of solution()
    
    public int BFS(int x, int y, int mapIdx) {
        ArrayDeque<Coordinate> que = new ArrayDeque<>();
        que.offer(new Coordinate(x, y));
        int count = 0;
        
        while(!que.isEmpty()) {
            Coordinate cur = que.poll();
            
            if(isVisited[cur.x][cur.y]) continue;
            isVisited[cur.x][cur.y] = true;
            oilIndexMap[cur.x][cur.y] = mapIdx;
            count++;
            
            for(int i=0; i<4; i++) {
                int nextX = dirX[i] + cur.x;
                int nextY = dirY[i] + cur.y;
                
                if(!isAbleCheck(nextX, nextY)) continue;
                
                que.offer(new Coordinate(nextX, nextY));
            }
        }
        
        return count;
    } // End of BFS()
    
    public boolean isAbleCheck(int nextX, int nextY) {
        return nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && map[nextX][nextY] == 1;
    } // End of isAbleCheck()
    
    public void input(int[][] land) {
        map = land;
        N = land.length;
        M = land[0].length;
        oilIndexMap = new int[N][M];
        indexMap = new HashMap<>();
        isVisited = new boolean[N][M];
    } // End of input()
} // End of Solution class