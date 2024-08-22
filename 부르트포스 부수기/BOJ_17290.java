package BOJ_17290;

import java.io.*;
import java.util.*;

public class BOJ_17290 {

    // https://www.acmicpc.net/problem/17290
    // input
    private static BufferedReader br;

    // variables
    private static int r, c;
    private static char[][] arr;
    private static List<Coordinate> waterBombCoors;

    private static final int N = 10;
    private static final int[] dirX = {0, -1, 0, 1};
    private static final int[] dirY = {-1, 0, 1, 0};

    private static class Coordinate {
        int x;
        int y;
        int count;

        private Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        private Coordinate(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Coordinate{" +
                    "x=" + x +
                    ", y=" + y +
                    ", count=" + count +
                    '}';
        }
    } // End of Coordinate class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_17290\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        makeWaterBomb();

        if (arr[r][c] == 'x') {
            sb.append(0);
            return sb.toString();
        }

        sb.append(BFS());
        return sb.toString();
    } // End of solve()

    private static int BFS() {
        ArrayDeque<Coordinate> que = new ArrayDeque<>();
        boolean[][] isVisited = new boolean[N + 1][N + 1];
        que.offer(new Coordinate(r, c, 0));
        isVisited[r][c] = true;

        while (!que.isEmpty()) {
            Coordinate cur = que.poll();

            if (arr[cur.x][cur.y] == 'x') {
                return cur.count;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = cur.x + dirX[i];
                int nextY = cur.y + dirY[i];

                if (!isAbleCheck(nextX, nextY, isVisited)) continue;

                que.offer(new Coordinate(nextX, nextY, cur.count + 1));
                isVisited[nextX][nextY] = true;
            }
        }

        return 0;
    } // End of BFS();

    private static boolean isAbleCheck(int nextX, int nextY, boolean[][] isVisited) {
        return nextX >= 1 && nextX <= N && nextY >= 1 && nextY <= N && !isVisited[nextX][nextY];
    } // End of isAbleCheck()

    private static void makeWaterBomb() {
        for (Coordinate cur : waterBombCoors) {
            int x = cur.x;
            int y = cur.y;

            for (int i = 1; i <= N; i++) {
                arr[x][i] = 'o';
                arr[i][y] = 'o';
            }
        }
    } // End of makeWaterBomb()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        waterBombCoors = new ArrayList<>();
        arr = new char[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            String temp = br.readLine();

            for (int j = 1; j <= N; j++) {
                arr[i][j] = temp.charAt(j - 1);

                if (arr[i][j] == 'o') {
                    waterBombCoors.add(new Coordinate(i, j));
                }
            }
        }
    } // End of input()
} // End of Main class
