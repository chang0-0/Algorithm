package BOJ_1245;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_1245 {

    // https://www.acmicpc.net/problem/1245
    // input
    private static BufferedReader br;

    // variables
    private static int N, M;
    private static int[][] board;
    private static boolean[][] isVisited;

    private static final int[] dirX = {-1, 1, 0, 0, -1, 1, -1, 1};
    private static final int[] dirY = {0, 0, -1, 1, -1, -1, 1, 1};

    private static class Coordinate {
        int x;
        int y;

        private Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    } // End of Coordinate class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_1245\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!isVisited[i][j] && board[i][j] > 0) {
                    boolean ret = BFS(i, j);
                    if (ret) {
                        ans++;
                    }
                }
            }
        }

        // 높이가 같은것들만 찾아서 순회, 
        // 인접한 산들 중 자신의 높이가 주변에서 제일 높을 경우
        sb.append(ans);
        return sb.toString();
    } // End of solve()

    private static boolean BFS(int x, int y) {
        boolean ret = true;
        ArrayDeque<Coordinate> que = new ArrayDeque<>();
        que.offer(new Coordinate(x, y));
        isVisited[x][y] = true;
        int height = board[x][y];
        // 높이가 같은 것들만 que에 넣고 순회,

        while (!que.isEmpty()) {
            Coordinate cur = que.poll();

            for (int i = 0; i < 8; i++) {
                int nX = dirX[i] + cur.x;
                int nY = dirY[i] + cur.y;

                if (!isAbleCheck(nX, nY)) continue;
                if (height < board[nX][nY]) {
                    ret = false;
                }

                if (height == board[nX][nY] && !isVisited[nX][nY]) {
                    isVisited[nX][nY] = true;
                    que.offer(new Coordinate(nX, nY));
                }
            }
        }

        return ret;
    } // End of BFS()

    private static boolean isAbleCheck(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    } // End of isAbleCheck()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        isVisited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    } // End of input()
} // End of Main class
