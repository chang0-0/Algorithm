package BOJ_15723;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15723 {

    // https://www.acmicpc.net/problem/15723
    // input
    private static BufferedReader br;

    // variables
    private static int N, M;
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_15723\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() throws IOException {
        StringBuilder sb = new StringBuilder();

        floyd();
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = st.nextToken().charAt(0) - 'a';
            st.nextToken();
            int b = st.nextToken().charAt(0) - 'a';

            if (arr[a][b] == 1) sb.append('T');
            else sb.append('F');
            sb.append('\n');
        }

        return sb.toString();
    } // End of solve()

    private static void floyd() {

        for (int k = 0; k < 27; k++) {
            for (int i = 0; i < 27; i++) {
                for (int j = 0; j < 27; j++) {
                    if (arr[i][k] == 1 && arr[k][j] == 1) {
                        arr[i][j] = 1;
                    }
                }
            }
        }

    } // End of floyd()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        arr = new int[27][27];
        for (int i = 0; i < 27; i++) {
            Arrays.fill(arr[i], 100);
            arr[i][i] = 0;
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int ch = st.nextToken().charAt(0) - 'a';
            st.nextToken();
            int ch2 = st.nextToken().charAt(0) - 'a';

            arr[ch][ch2] = 1;
        }

        M = Integer.parseInt(br.readLine());
    } // End of input()
} // End of Main class
