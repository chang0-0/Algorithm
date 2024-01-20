package BOJ_3055;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_3055 {

    // https://www.acmicpc.net/problem/3055
    // input
    private static BufferedReader br;

    // variables
    private static final String FAIL = "KAKTUS";
    private static int R, C;
    private static char[][] map;
    private static Coordinate D, S;
    private static List<Coordinate> waterList;
    private static final int[] dirX = {0, 0, -1, 1};
    private static final int[] dirY = {-1, 1, 0, 0};

    private static class Coordinate {
        int x;
        int y;
        int time;
        int type;

        private Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        private Coordinate(int x, int y, int time, int type) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.type = type;
        }
    } // End of Coordinate class

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        int ret = BFS();

        if (ret == -1) {
            sb.append(FAIL);
        } else {
            sb.append(ret);
        }

        return sb.toString();
    } // End of solve()

    private static int BFS() {
        LinkedList<Coordinate> que = new LinkedList<>();
        boolean[][] hedgeVisited = new boolean[R][C];
        boolean[][] waterVisited = new boolean[R][C];

        for (Coordinate c : waterList) {
            que.offer(new Coordinate(c.x, c.y, 0, 1)); // 물
            waterVisited[c.x][c.y] = true;
        }

        que.offer(new Coordinate(S.x, S.y, 0, 0)); // 고슴도치
        hedgeVisited[S.x][S.y] = true;


        while (!que.isEmpty()) {
            // System.out.println("que : " + que);
            Coordinate current = que.poll();

            if (current.x == D.x && current.y == D.y && current.type == 0) {
                return current.time;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = dirX[i] + current.x;
                int nextY = dirY[i] + current.y;

                if (current.type == 0 && ableCheck(nextX, nextY, hedgeVisited) && (map[nextX][nextY] == 'D' || map[nextX][nextY] == '.')) {
                    que.offer(new Coordinate(nextX, nextY, current.time + 1, current.type)); // 고슴도치
                    hedgeVisited[nextX][nextY] = true;
                } else if (current.type == 1 && ableCheck(nextX, nextY, waterVisited) && map[nextX][nextY] == '.') {
                    map[nextX][nextY] = '*';
                    que.offer(new Coordinate(nextX, nextY, current.time, current.type));
                    waterVisited[nextX][nextY] = true;
                }
            }
        }

        return -1;
    } // End of BFS()

    private static boolean ableCheck(int nextX, int nextY, boolean[][] visited) {
        return nextX >= 0 && nextX < R && nextY >= 0 && nextY < C && !visited[nextX][nextY];
    } // End of ableCheck()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        waterList = new ArrayList<>();

        for (int i = 0; i < R; i++) {
            String temp = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = temp.charAt(j);

                if (map[i][j] == 'D') {
                    D = new Coordinate(i, j);
                } else if (map[i][j] == 'S') {
                    S = new Coordinate(i, j);
                    map[i][j] = '.';
                } else if (map[i][j] == '*') {
                    waterList.add(new Coordinate(i, j));
                }
            }
        }
    } // End of input()
} // End of Main class
