package BOJ_16946;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_16946 {

    // https://www.acmicpc.net/problem/16946
    // input
    private static BufferedReader br;

    // variables
    private static int N, M;
    private static int[][] board, countBoard;
    private static int[] boardSize;
    private static final int[] dirX = {-1, 0, 1, 0};
    private static final int[] dirY = {0, 1, 0, -1};

    private static class Coordinate {
        int x;
        int y;

        private Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    } // End of Coordinate class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_16946\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        boardSize = new int[(N * M) + 1];
        int num = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                if (countBoard[i][j] == 0 && board[i][j] == 0) {
                    int ret = BFS(i, j, num);
                    boardSize[num++] = ret;
                }
            }
        }

        boolean[] memo;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 1) {
                    int sum = 1;
                    memo = new boolean[num + 1];

                    for (int k = 0; k < 4; k++) {
                        int nX = dirX[k] + i;
                        int nY = dirY[k] + j;

                        if (nX >= 0 && nX < N && nY >= 0 && nY < M && countBoard[nX][nY] >= 1 && !memo[countBoard[nX][nY]]) {
                            memo[countBoard[nX][nY]] = true;
                            sum += boardSize[countBoard[nX][nY]];
                        }
                    }

                    for (int k = 0; k < 4; k++) {
                        int nX = dirX[k] + i;
                        int nY = dirY[k] + j;

                        if (nX >= 0 && nX < N && nY >= 0 && nY < M) {
                            memo[countBoard[nX][nY]] = false;
                        }
                    }

                    sb.append(sum % 10);
                } else {
                    sb.append(0);
                }
            }
            sb.append('\n');
        }


        return sb.toString();
    } // End of solve()

    private static int BFS(int x, int y, int num) {
        ArrayDeque<Coordinate> que = new ArrayDeque<>();
        que.offer(new Coordinate(x, y));
        int ret = 0;

        while (!que.isEmpty()) {
            Coordinate cur = que.poll();

            if (countBoard[cur.x][cur.y] == num) continue;
            countBoard[cur.x][cur.y] = num;
            ret++;

            for (int i = 0; i < 4; i++) {
                int nX = dirX[i] + cur.x;
                int nY = dirY[i] + cur.y;

                if (!isAbleCheck(nX, nY)) continue;
                que.offer(new Coordinate(nX, nY));
            }
        }

        return ret;
    } // End of BFS()

    private static boolean isAbleCheck(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M && board[x][y] == 0;
    } // End of isAbleCheck()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        countBoard = new int[N][M];
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = Character.getNumericValue(temp.charAt(j));
            }
        }
    } // End of input()
} // End of Main class
