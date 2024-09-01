package BOJ_31924;

import java.io.*;

public class BOJ_31924 {

    // https://www.acmicpc.net/problem/31924
    // input
    private static BufferedReader br;

    // variables
    private static int N;
    private static char[][] arr;
    private static final int[] dirX = {-1, 0, 1, 0, 1, -1, 1, -1};
    private static final int[] dirY = {0, -1, 0, 1, 1, -1, -1, 1};
    private static final String MOBIS = "MOBIS";

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_31924\\res.txt"));
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
            for (int j = 0; j < N; j++) {
                if (arr[i][j] != 'M') continue;

                for (int k = 0; k < 8; k++) {
                    StringBuilder str = new StringBuilder();
                    int nextX = i;
                    int nextY = j;

                    for (int t = 0; t < 5; t++) {
                        if (!isAbleCheck(nextX, nextY)) break;
                        str.append(arr[nextX][nextY]);
                        nextX += dirX[k];
                        nextY += dirY[k];
                    }

                    if (str.length() == 5 && str.toString().equals(MOBIS)) {
                        ans++;
                    }
                }
            }
        }

        sb.append(ans);
        return sb.toString();
    } // End of solve()

    private static boolean isAbleCheck(int nextX, int nextY) {
        return nextX >= 0 && nextX < N && nextY >= 0 && nextY < N;
    } // End of isAbleCheck()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        arr = new char[N][N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }
    } // End of input()
} // End of Main class
