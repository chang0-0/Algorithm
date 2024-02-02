import java.util.*;

class Solution {
    private static int[][] map;
    private static int N, M, count;
    private static boolean[][] isVisited;
    private static List<Integer> dayList;
    private static final int[] dirX = {-1, 1, 0, 0};
    private static final int[] dirY = {0, 0, -1, 1};
    
    public int[] solution(String[] maps) {
        int[] answer = {};
        
        input(maps);
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] != -1) {
                    if(isVisited[i][j]) continue;
                    count = map[i][j];
                    isVisited[i][j] = true;
                    DFS(i, j);

                    dayList.add(count);
                }
            }
        }
        
        if(dayList.isEmpty()) {
            return new int[] {-1};
        }
        
        int[] ans = new int[dayList.size()];
        int idx = 0;
        for(int num : dayList) {
            ans[idx++] = num;
        }

        Arrays.sort(ans);
        
        
        return ans;
    } // End of solution()
    
    public void DFS(int x, int y) {
        
        for(int i=0; i<4; i++) {
            int nextX = x + dirX[i];
            int nextY = y + dirY[i];
            
            if(!isAbleCheck(nextX, nextY)) continue;

            isVisited[nextX][nextY] = true;
            count += map[nextX][nextY];
            DFS(nextX, nextY);
        } 
        
    } // End of DFS()
    
    public boolean isAbleCheck(int nextX, int nextY) {
        return nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && !isVisited[nextX][nextY] && map[nextX][nextY] != -1;
    } // End of isAbleCheck()
    
    public void input(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        
        map = new int[N][M];
        isVisited = new boolean[N][M];
        dayList = new ArrayList<>();
        
        for(int i=0; i<N; i++) {
            String temp = maps[i];
            for(int j=0; j<M; j++) {
                if(temp.charAt(j) == 'X') {
                    map[i][j] = -1;
                } else {
                    map[i][j] = Character.getNumericValue(temp.charAt(j));
                }
            }
        }
        
    } // End of input()
} // End of Solution class