import java.util.*;
import java.io.*;

class Solution {
    private static int[] dirX = {-1, -1, 0, 1, 1, 1, 0, -1}; // 상 상우 우 하우 하 하좌 좌 상좌 상
    private static int[] dirY = {0, 1, 1, 1, 0, -1, -1, -1};
    private static int[][] board;
    private static int N;
    private static boolean[][] isVisited;

    private static class Coordinate {
        int x;
        int y;
        int cnt;

        private Coordinate(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    } // End of Coordinate class

    public int shortestPathBinaryMatrix(int[][] grid) {
        board = grid;
        N = grid.length;

        if(grid[0][0] == 1) return -1;

        int ans = BFS();
        return ans;
    } // End of main()


    private static int BFS() {
        Queue<Coordinate> que = new ArrayDeque<>();
        isVisited = new boolean[N][N];
        que.offer(new Coordinate(0, 0, 1));
        isVisited[0][0] = true;

        while(!que.isEmpty()) {
            Coordinate cur = que.poll();

            if(cur.x == N - 1 && cur.y == N - 1) return cur.cnt;

            for(int i=0; i<8 ;i++) {
                int nextX = dirX[i] + cur.x;
                int nextY = dirY[i] + cur.y;

                if(!isAbleCheck(nextX, nextY)) continue;

                que.offer(new Coordinate(nextX, nextY, cur.cnt + 1));
                isVisited[nextX][nextY] = true;
            }
        }

        return -1;
    } // End of BFS()

    private static boolean isAbleCheck(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N && !isVisited[x][y] && board[x][y] == 0;
    } // End of isAbleCheck()
} // End of Main class