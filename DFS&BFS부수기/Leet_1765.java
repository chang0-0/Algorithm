import java.util.*;

class Solution {
    private static int N, M;
    private static final int[] dirX = {-1, 0, 1, 0};
    private static final int[] dirY = {0, 1, 0, -1};
    

    private static class Coordinate {
        int x;
        int y;
        int height;

        private Coordinate(int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
        }
    } // End of Coordinate class

    public int[][] highestPeak(int[][] isWater) {
        N = isWater.length;
        M = isWater[0].length;
        
        List<Coordinate> waterList = new ArrayList<>();
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(isWater[i][j] == 1) {
                    waterList.add(new Coordinate(i, j, 0));
                }
            }
        }

        int[][] ret = BFS(waterList, isWater);
        return ret;
    } // End of highestPeak()

    private int[][] BFS(List<Coordinate> waterList, int[][] isWater) {
        ArrayDeque<Coordinate> que = new ArrayDeque<>();
        boolean[][] isVisited = new boolean[N][M];

        for(Coordinate t : waterList) {
            que.offer(t);
            isVisited[t.x][t.y] = true;
            isWater[t.x][t.y] = 0;
        }

        while(!que.isEmpty()) {
            Coordinate cur = que.poll();

            for(int i=0; i<4; i++) {
                int nX = dirX[i] + cur.x;
                int nY = dirY[i] + cur.y;

                if(!isAbleCheck(nX, nY, isVisited)) continue;

                isWater[nX][nY] = cur.height + 1;
                que.offer(new Coordinate(nX, nY, isWater[nX][nY]));
                isVisited[nX][nY] = true;
            }
        }

        return isWater;
    } // End of BFS()

    private boolean isAbleCheck(int x, int y, boolean[][] isVisited) {
        return x >= 0 && x < N && y >= 0 && y < M && !isVisited[x][y];
    } // End of isAbleCheck()
} // End of Solution class