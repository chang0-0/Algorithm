import java.util.*;

class Solution {
    public static final int INF = Integer.MAX_VALUE;
    public static char[][] map;
    public static int N, M;
    public static Coordinate S, E, L;
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
        
        int[][] dist = BFS(S);
        if(dist[E.x][E.y] == INF || dist[L.x][L.y] == INF) {
            return -1;
        }
        
        int leverDist = dist[L.x][L.y];
        dist = BFS(L);
        
        return leverDist + dist[E.x][E.y];
    } // End of solution()
    
    public int[][] BFS(Coordinate start) {
        boolean[][] visited = new boolean[N][M];
        LinkedList<Coordinate> que = new LinkedList<>();
        int[][] dist = new int[N][M];
        for(int i=0; i<N; i++) {
         Arrays.fill(dist[i], INF);
        }
        
        que.offer(new Coordinate(start.x, start.y, 0));
        visited[start.x][start.y] = true;
        dist[start.x][start.y] = 0;
        
        while(!que.isEmpty()) {
            Coordinate current = que.poll();
            
            for(int i=0; i<4; i++) {
                int nextX = dirX[i] + current.x;
                int nextY = dirY[i] + current.y;
                
                if(!isAble(nextX, nextY, visited)) continue;
                if(dist[nextX][nextY] > dist[current.x][current.y] + 1) {
                    dist[nextX][nextY] = dist[current.x][current.y] + 1;
                    que.offer(new Coordinate(nextX, nextY, dist[nextX][nextY]));
                    visited[nextX][nextY] = true;
                }
            }
        }
    
        return dist;
    } // End of BFS()
    
    public boolean isAble(int nextX, int nextY, boolean[][] visited) {
        return nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && !visited[nextX][nextY] && map[nextX][nextY] != 'X';
    } // End of isAble
    
    public void input(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        
        map = new char[N][M];
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                map[i][j] = maps[i].charAt(j);
                
                if(map[i][j] == 'S') {
                    S = new Coordinate(i, j);
                } else if(map[i][j] == 'L') {
                    L = new Coordinate(i, j);
                } else if(map[i][j] == 'E') {       
                    E = new Coordinate(i, j);            
                }
            }
        }
        
    } // End of input()
} // End of Solution class