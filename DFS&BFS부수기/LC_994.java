import java.util.*;
import java.io.*;

class Solution {
    private static int[] dirX = {-1, 0, 1, 0};
    private static int[] dirY = {0, 1, 0, -1};
    private static int N, M;
    private static int[][] board;
    private static Queue<Coordinate> que;

    private static class Coordinate implements Comparable<Coordinate> {
        int x;
        int y;
        int time;

        private Coordinate(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }

        @Override
        public int compareTo(Coordinate o) {
            return Integer.compare(time, o.time);
        }
    } // End of Coordinate class

    public int orangesRotting(int[][] grid) {
        N = grid.length;
        M = grid[0].length;
        board = grid;
        que = new ArrayDeque<>();

        int fresh = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(board[i][j] == 2) {
                    que.offer(new Coordinate(i, j, 0));
                } else if(board[i][j] == 1) {
                    fresh++;
                }
            }
        }

        

        return BFS(fresh);
    } // End of solve()

    private static int BFS(int fresh) {
        int ans = 0;
        

        while(!que.isEmpty()) {
            Coordinate cur = que.poll();
            
            ans = Math.max(ans, cur.time);
            
            
            for(int i=0; i<4; i++) {
                int nX = cur.x + dirX[i];
                int nY = cur.y + dirY[i];

                if(!isAbleCheck(nX, nY)) continue;

                board[nX][nY] = 2;
                fresh--;

                que.offer(new Coordinate(nX, nY, cur.time + 1));           
            }
        }

        if(fresh == 0) return ans;
        else return -1;
    } // End of BFS()

    private static boolean isAbleCheck(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M && board[x][y] == 1;
    } // End of isAbleCheck()
} // End of Solution class