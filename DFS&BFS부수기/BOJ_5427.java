package BOJ_5427;

import java.io.*;
import java.util.*;

public class BOJ_5427 {

    // https://www.acmicpc.net/problem/5427
    // input
    private static BufferedReader br;

    // variables
    private static int N, M;
    private static char[][] board = new char[1001][1001];
    private static final int[] dirX = {-1, 0, 1, 0};
    private static final int[] dirY = {0, 1, 0, -1};
    private static final String IM = "IMPOSSIBLE";
    private static List<Coor> fireList;

    private static Coor start;

    private static class Coor {
        int x;
        int y;
        int time;

        private Coor(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }

        @Override
        public String toString() {
            return "Coor{" + x + ", " + y + ", " + time + "}";
        }
    } // End of Coor class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_5427\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            input();

            bw.write(solve());
        }

        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        int ret = BFS();
        sb.append(ret == -1 ? IM : ret).append('\n');
        return sb.toString();
    } // End of solve()

    private static int BFS() {
        ArrayDeque<Coor> que = new ArrayDeque<>();
        boolean[][] isVisited = new boolean[N][M];
        int ans = -1;

        for (Coor t : fireList) {
            que.offer(t);
            isVisited[t.x][t.y] = true;
        }
        que.offer(start);
        isVisited[start.x][start.y] = true;

        while (!que.isEmpty()) {
            Coor cur = que.poll();

            for (int i = 0; i < 4; i++) {
                int nX = dirX[i] + cur.x;
                int nY = dirY[i] + cur.y;

                if (!isAbleCheck(nX, nY)) {
                    if (cur.time != -1) {
                        return cur.time + 1;
                    }
                    continue;
                }

                if (board[nX][nY] == '#' || isVisited[nX][nY]) continue;


                if (cur.time == -1) {
                    // 불
                    board[nX][nY] = '*';
                    que.offer(new Coor(nX, nY, -1));
                    isVisited[nX][nY] = true;
                } else {
                    // 상근이
                    if (board[nX][nY] == '*') continue;
                    que.offer(new Coor(nX, nY, cur.time + 1));
                    isVisited[nX][nY] = true;
                }
            }
        }

        return ans;
    } // End of BFS()

    private static boolean isAbleCheck(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    } // End of isAbleCheck()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        fireList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = temp.charAt(j);

                if (board[i][j] == '@') {
                    start = new Coor(i, j, 0);
                    board[i][j] = '.';
                } else if (board[i][j] == '*') {
                    fireList.add(new Coor(i, j, -1));
                }
            }
        }
    } // End of input()
} // End of Main class
