package BOJ_25709;

import java.io.*;

public class BOJ_25709 {

    // https://www.acmicpc.net/problem/25709
    // input
    private static BufferedReader br;

    // variables
    private static int N;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_25709\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        String str = Integer.toString(N);
        int ans = 0;
        for (; ; ) {

            int len = str.length();
            int idx = -1;
            if (len >= 2) {
                for (int i = len - 1; i >= 0; i--) {
                    char ch = str.charAt(i);
                    if (ch == '1') {
                        idx = i;
                        break;
                    }
                }
            }

            if (idx == -1) {
                int temp = Integer.parseInt(str) - 1;
                str = Integer.toString(temp);
            } else {
                StringBuilder num = new StringBuilder();
                for (int i = 0; i < len; i++) {
                    if (idx == i) continue;
                    num.append(str.charAt(i));
                }

                int temp = Integer.parseInt(num.toString().trim());
                str = Integer.toString(temp);
            }

            ans++;
            if (Integer.parseInt(str) == 0) break;
        }

        sb.append(ans);
        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
    } // End of input()
} // End of Main class
