package BOJ_9505;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_9505 {

    // https://www.acmicpc.net/problem/9505
    // input
    private static BufferedReader br;

    // variables
    private static int K, W, H;
    private static Coordinate start;
    private static HashMap<Character, Integer> classTime;
    private static char[][] board = new char[1001][1001];


    private static final int INF = Integer.MAX_VALUE;
    private static final int[] dirX = {-1, 0, 1, 0};
    private static final int[] dirY = {0, 1, 0, -1};

    private static class Coordinate implements Comparable<Coordinate> {
        int x;
        int y;
        int time;

        @Override
        public int compareTo(Coordinate o) {
            return time - o.time;
        }

        private Coordinate(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }

        private Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    } // End of Coordinate class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_9505\\res.txt"));
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

        sb.append(BFS()).append('\n');
        return sb.toString();
    } // End of solve()

    private static int BFS() {
        PriorityQueue<Coordinate> que = new PriorityQueue<>();
        int[][] memo = new int[H + 1][W + 1];
        for (int[] t : memo) Arrays.fill(t, INF);

        classTime.put('E', 0);
        que.offer(new Coordinate(start.x, start.y, 0));
        memo[start.x][start.y] = 0;

        while (!que.isEmpty()) {
            Coordinate cur = que.poll();

            if (cur.time > memo[cur.x][cur.y]) continue;

            for (int i = 0; i < 4; i++) {
                int nX = dirX[i] + cur.x;
                int nY = dirY[i] + cur.y;

                if (!isAbleCheck(nX, nY)) {
                    return cur.time;
                }

                if (classTime.get(board[nX][nY]) == null) continue;
                if (memo[nX][nY] > memo[cur.x][cur.y] + classTime.get(board[nX][nY])) {
                    memo[nX][nY] = memo[cur.x][cur.y] + classTime.get(board[nX][nY]);
                    que.offer(new Coordinate(nX, nY, memo[nX][nY]));
                }
            }
        }

        return 0;
    } // End of BFS()

    private static boolean isAbleCheck(int x, int y) {
        return x >= 0 && x < H && y >= 0 && y < W;
    } // End of isAbleCheck()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        classTime = new HashMap<>();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            classTime.put(st.nextToken().charAt(0), Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < H; i++) {
            String temp = br.readLine();
            for (int j = 0; j < W; j++) {
                board[i][j] = temp.charAt(j);

                if (board[i][j] == 'E') {
                    start = new Coordinate(i, j);
                }
            }
        }
    } // End of input()
} // End of Main class
