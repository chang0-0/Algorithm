package BOJ_24431;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_24431 {

    // https://www.acmicpc.net/problem/24431
    // input
    private static BufferedReader br;

    // variables
    private static int N, L, F;
    private static String[] arr = new String[501];

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_24431\\res.txt"));
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

        int count = 0;
        boolean[] isVisited = new boolean[N];
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (!isVisited[i] && !isVisited[j] && arr[i].endsWith(arr[j].substring(L - F))) {
                    isVisited[i] = true;
                    isVisited[j] = true;
                    count++;
                }
            }
        }

        sb.append(count).append('\n');
        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        F = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = st.nextToken();
        }
    } // End of input()
} // End of Main class
