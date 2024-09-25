package BOJ_28064;

import java.io.*;

public class BOJ_28064 {

    // https://www.acmicpc.net/problem/28064
    // input
    private static BufferedReader br;

    // variables
    private static int N;
    private static String arr[];

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_28064\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() throws IOException {
        StringBuilder sb = new StringBuilder();

        arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            String s = arr[i];
            int n = s.length();

            for (int j = i + 1; j < N; j++) {
                int len = Math.min(n, arr[j].length());

                for (int k = 1; k <= len; k++) {
                    if (arr[i].endsWith(arr[j].substring(0, k)) || arr[j].endsWith(arr[i].substring(0, k))) {
                        ans++;
                        break;
                    }
                }
            }
        }

        sb.append(ans);
        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
    } // End of input()
} // End of Main class
