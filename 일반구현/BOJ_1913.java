package BOJ_1913;

import java.io.*;

public class BOJ_1913 {

    // https://www.acmicpc.net/problem/1913
    // input
    private static BufferedReader br;

    // variables
    private static int N, M;
    private static int[][] arr;

    private static final int[] dirX = {1, 0, -1, 0}; // 하 우 상 좌
    private static final int[] dirY = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_1913\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        int num = N * N;
        int x = 0;
        int y = 0;
        int dir = 0;
        int ansX = 0;
        int ansY = 0;

        while (num > 0) {
            arr[x][y] = num;

            if (num == M) {
                ansX = x + 1;
                ansY = y + 1;
            }

            int nextX = dirX[dir] + x;
            int nextY = dirY[dir] + y;
            if (!isAbleCheck(nextX, nextY)) {
                dir = (dir + 1) % 4;
                nextX = dirX[dir] + x;
                nextY = dirY[dir] + y;
            }

            x = nextX;
            y = nextY;
            num--;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(arr[i][j]).append(' ');
            }
            sb.append('\n');
        }
        sb.append(ansX).append(' ').append(ansY);

        return sb.toString();
    } // End of solve()

    private static boolean isAbleCheck(int nextX, int nextY) {
        return nextX >= 0 && nextX < N && nextY >= 0 && nextY < N && arr[nextX][nextY] == 0;
    } // End of isAbleCheck()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = new int[N][N];
    } // End of input()
} // End of Main class
