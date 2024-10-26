package BOJ_23352;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_23352 {

    // https://www.acmicpc.net/problem/23352
    // input
    private static BufferedReader br;

    // variables
    private static int N, M, wholeMaxCount, maxSum;
    private static int[][] board;
    private static final int[] dirX = {-1, 0, 1, 0};
    private static final int[] dirY = {0, 1, 0, -1};


    private static class Coordinate {
        int x;
        int y;
        int count;

        private Coordinate(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    } // End of Coordinate class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_23352\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] != 0) {
                    BFS(i, j);
                }
            }
        }

        sb.append(maxSum);
        return sb.toString();
    } // End of solve()

    private static void BFS(int x, int y) {
        ArrayDeque<Coordinate> que = new ArrayDeque<>();
        boolean[][] isVisited = new boolean[N][M];
        int start = board[x][y];
        int end = 0;
        int maxCount = 0;
        que.offer(new Coordinate(x, y, 0));
        isVisited[x][y] = true;

        // BFS 회전에서는 최고 이동거리를 파악하고 그에 맞는 end값 중에 가장 큰 값을 찾는다.
        while (!que.isEmpty()) {
            Coordinate cur = que.poll();

            for (int i = 0; i < 4; i++) {
                int nX = cur.x + dirX[i];
                int nY = cur.y + dirY[i];

                if (!isAbleCheck(nX, nY, isVisited)) continue;
                que.offer(new Coordinate(nX, nY, cur.count + 1));
                isVisited[nX][nY] = true;

                if (maxCount <= cur.count + 1) {
                    maxCount = cur.count + 1;
                    end = board[nX][nY];
                }
            }
        }

        if (wholeMaxCount < maxCount) {
            wholeMaxCount = maxCount;
            maxSum = start + end;
        } else if (wholeMaxCount == maxCount) {
            maxSum = Math.max(maxSum, start + end);
        }
    } // End of BFS()

    private static boolean isAbleCheck(int x, int y, boolean[][] isVisited) {
        return x >= 0 && x < N && y >= 0 && y < M && !isVisited[x][y] && board[x][y] != 0;
    } // End of isAbleCheck()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        wholeMaxCount = 0;
        maxSum = 0;
        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    } // End of input()
} // End of Main class
