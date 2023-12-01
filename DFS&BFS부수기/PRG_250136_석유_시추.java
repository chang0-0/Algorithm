package PRG_250136;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class PRG_250136_석유_시추 {
    // https://school.programmers.co.kr/learn/courses/30/lessons/250136
    private static int N, M, oilIdx;
    private static int[][] oils;
    private static boolean[][] isVisited;
    private static HashMap<Integer, Integer> map;
    private static int[] dirX = {0, 0, -1, 1};
    private static int[] dirY = {-1, 1, 0, 0};

    private static class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        } // End of Coordinate()
    } // End of Coordinate class

    public static void main(String[] args) {
        int[][] land = {{0, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 0, 0, 0, 1, 1, 0}, {1, 1, 1, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 1, 1}};

        System.out.println(solution(land));
    } // End of main()

    private static int solution(int[][] land) {
        int ans = 0;
        input(land);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (isVisited[i][j] || land[i][j] == 0) continue;

                BFS(land, i, j);
            }
        }


        for (int i = 0; i < M; i++) {
            int temp = 0;
            Set<Integer> set = new HashSet<>();

            for (int j = 0; j < N; j++) {
                if (oils[j][i] > 0) {
                    set.add(oils[j][i]);
                }
            }

            for (int t : set) {
                temp += map.get(t);
            }

            ans = Math.max(ans, temp);
        }

        return ans;
    } // End of solution()

    private static void BFS(int[][] land, int x, int y) {
        LinkedList<Coordinate> que = new LinkedList<>();
        isVisited[x][y] = true;
        que.offer(new Coordinate(x, y));
        oils[x][y] = oilIdx;
        int size = 0;

        while (!que.isEmpty()) {
            Coordinate now = que.poll();
            size++;

            for (int i = 0; i < 4; i++) {
                int nextX = dirX[i] + now.x;
                int nextY = dirY[i] + now.y;

                if (!isAbleCheck(land, isVisited, nextX, nextY)) continue;

                que.offer(new Coordinate(nextX, nextY));
                isVisited[nextX][nextY] = true;
                oils[nextX][nextY] = oilIdx;
            }
        }

        map.put(oilIdx++, size);
    } // End of BFS()

    private static boolean isAbleCheck(int[][] land, boolean[][] isVisited, int nextX, int nextY) {
        return nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && land[nextX][nextY] == 1 && !isVisited[nextX][nextY];
    } // End of isAbleCheck()

    private static void input(int[][] land) {
        N = land.length;
        M = land[0].length;
        oilIdx = 1;

        map = new HashMap<>();
        oils = land;
        isVisited = new boolean[N][M];
    } // Eno df input()
} // End of Main class
