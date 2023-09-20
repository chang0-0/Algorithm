package BOJ_30024;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_30024_옥수수밭 {

    // https://www.acmicpc.net/problem/30024
    // input
    private static BufferedReader br;

    // variables
    private static int N, M, K;
    private static boolean[][] isVisited;
    private static int[][] map;
    private static int[] dirX = {-1, 1, 0, 0};
    private static int[] dirY = {0, 0, -1, 1};
    private static PriorityQueue<Corn> cornPque;

    private static class Corn implements Comparable<Corn> {
        int x;
        int y;
        int value;

        private Corn(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        @Override
        public String toString() {
            return "x : " + x + ", y : " + y + ", value : " + value;
        }

        @Override
        public int compareTo(Corn o) {
            return value - o.value;
        }
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_30024\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        return BFS();
    } // End of solve()

    private static String BFS() {
        StringBuilder sb = new StringBuilder();

        // PriorityQueue 이므로 외곽옥수수를 넣어놓으면
        // 옥수수 가치가 높은 순서대로 정렬되어서, 어차피 상하좌우 탐색시 가치가 높은 옥수수가 가장 먼저오게된다.
        // 우선순위큐의 특성을 놓친 내 실수
        while (K-- > 0) {
            Corn nowCorn = cornPque.poll();
            sb.append(nowCorn.x).append(' ').append(nowCorn.y).append('\n');
            isVisited[nowCorn.x][nowCorn.y] = true;

            for (int i = 0; i < 4; i++) {
                int nextX = nowCorn.x + dirX[i];
                int nextY = nowCorn.y + dirY[i];

                if (!isAbleCheck(nextX, nextY, isVisited)) continue;

                isVisited[nextX][nextY] = true;
                cornPque.offer(new Corn(nextX, nextY, map[nextX][nextY]));
            }
        }

        return sb.toString();
    } // End of BFS()

    private static boolean isAbleCheck(int nextX, int nextY, boolean[][] isVisited) {
        return nextX >= 1 && nextX <= N && nextY >= 1 && nextY <= M && !isVisited[nextX][nextY];
    } // End of isAbleCheck()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][M + 1];
        isVisited = new boolean[N + 1][M + 1];
        cornPque = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (i == 1 || i == N || j == 1 || j == M) {
                    // 외곽이 우선순위가 가장 높으므로 먼저 que에 넣음
                    cornPque.offer(new Corn(i, j, map[i][j]));
                    isVisited[i][j] = true;
                }
            }
        }

        K = Integer.parseInt(br.readLine());
    } // End of input()
} // End of Main class
