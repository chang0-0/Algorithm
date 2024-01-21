import java.util.*;

class Solution {
    public static final int INF = Integer.MAX_VALUE;
    public static char[][] map;
    public static int N, M;
    public static Coordinate S, E;
    public static List<Coordinate> leverList;
    public static final int[] dirX = {0, 0, -1, 1};
    public static final int[] dirY = {-1, 1, 0, 0};
     
    public static class Coordinate {
        int x;
        int y;
        int move;
        
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        public Coordinate(int x, int y, int move) {
            this.x = x;
            this.y = y;
            this.move = move;
        }
    } // End of Coordinate class
    
    
    public int solution(String[] maps) {
        int answer = 0;
        
        input(maps);
        
        // for(char[] t : map) {
        //     System.out.println(Arrays.toString(t));
        // }
        
        return BFS();
    } // End of solution()
    
    public int BFS() {
        boolean[][] visited = new boolean[N][M];
        LinkedList<Coordinate> que = new LinkedList<>();
        int[][] dist = new int[N][M];
        Arrays.fill(dist, INF);
        
        que.offer(new Coordinate(S.x, S.y, 0));
        visited[S.x][S.y] = true;
        dist[S.x][S.y] = 0;
        
        while(!que.isEmpty()) {
            Coordinate current = que.poll();
            
            if(map[current.x][current.y] == 'E') {
                return current.move;
            }
            
            for(int i=0; i<4; i++) {
                int nextX = dirX[i] + current.x;
                int nextY = dirY[i] + current.y;
                
                if(!isAble(nextX, nextY, visited)) continue;
                
                que.offer(new Coordinate(nextX, nextY, current.move + 1));
                visited[nextX][nextY] = true;
            }
        }
        
        return -1;
    } // End of BFS()
    
    public boolean isAble(int nextX, int nextY, boolean[][] visited) {
        return nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && !visited[nextX][nextY] && map[nextX][nextY] != 'X';
    } // End of isAble
    
    public void input(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        leverList = new ArrayList<>();
        
        map = new char[N][M];
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                map[i][j] = maps[i].charAt(j);
                
                if(map[i][j] == 'S') {
                    S = new Coordinate(i, j);
                } else if(map[i][j] == 'L') {
                    leverList.add(new Coordinate(i, j));
                    map[i][j] = 'O';
                } else if(map[i][j] == 'E') {       
                    E = new Coordinate(i, j);            
                    map[i][j] = 'O';
                }
            }
        }
        
    } // End of input()
} // End of Solution class