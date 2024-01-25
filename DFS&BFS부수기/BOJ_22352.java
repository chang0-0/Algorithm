package BOJ_22352;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_22352 {

    // https://www.acmicpc.net/problem/22352
    // input
    private static BufferedReader br;

    // variables
    private static int N, M;
    private static int[][] before, after;
    private static List<Coordinate> difList;
    private static final int[] dirX = {0, 0, -1, 1};
    private static final int[] dirY = {-1, 1, 0, 0};

    private static class Coordinate {
        int x;
        int y;

        private Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    } // End of Coordiante class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_22352\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();
        bw.write(solve());

        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        boolean flag = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!flag && before[i][j] != after[i][j]) {
                    BFS(i, j, before[i][j], after[i][j]);
                    flag = true;
                }
            }
            if(flag) break;
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (before[i][j] != after[i][j]) {
                    sb.append("NO");
                    return sb.toString();
                }
            }
        }


        sb.append("YES");
        return sb.toString();
    } // End of solve()

    private static void BFS(int x, int y, int colorB, int colorA) {
        LinkedList<Coordinate> que = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        before[x][y] = colorA;
        visited[x][y] = true;
        que.offer(new Coordinate(x, y));

        while (!que.isEmpty()) {
            Coordinate current = que.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = current.x + dirX[i];
                int nextY = current.y + dirY[i];

                if (ableCheck(nextX, nextY, visited, colorB)) {
                    que.offer(new Coordinate(nextX, nextY));
                    visited[nextX][nextY] = true;
                    before[nextX][nextY] = colorA;
                }
            }
        }
    } // End of BFS()

    private static boolean ableCheck(int nextX, int nextY, boolean[][] visited, int colorB) {
        return nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && !visited[nextX][nextY] && before[nextX][nextY] == colorB;
    } // End of ableCheck()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        before = new int[N][M];
        after = new int[N][M];
        difList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                before[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                after[i][j] = Integer.parseInt(st.nextToken());

                if (after[i][j] != before[i][j]) {
                    difList.add(new Coordinate(i, j));
                }
            }
        }

    } // End of input()
} // End of Main class
