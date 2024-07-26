package BOJ_1235;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class BOJ_1235 {

    // https://www.acmicpc.net/problem/1235
    // input
    private static BufferedReader br;

    // variables
    private static int N, M;
    private static String[] arr;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_1235\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        int ans = 1;
        for (int i = 1; i <= M; i++) {
            Set<String> set = new HashSet<>();
            boolean flag = true;

            for (int j = 0; j < N; j++) {
                String temp = arr[j].substring(M - i, M);

                if (!set.add(temp)) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                ans = i;
                break;
            }
        }

        sb.append(ans);
        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        M = arr[0].length();
    } // End of input()
} // End of Main class
