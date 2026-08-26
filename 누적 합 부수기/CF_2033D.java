package CF_2033D;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class CF_2033D {

    // https://codeforces.com/problemset/problem/2033/D
    // input
    private static BufferedReader br;

    // variables
    private static int T, N;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\CF_2033D\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() throws IOException {
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            HashSet<Long> set = new HashSet<>();
            set.add(0L);
            StringTokenizer st = new StringTokenizer(br.readLine());
            long sum = 0;
            int ans = 0;

            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(st.nextToken());
                sum += num;

                if (!set.add(sum)) {
                    set = new HashSet<>();
                    set.add(0L);
                    sum = 0;
                    ans++;
                }
            }

            sb.append(ans).append('\n');
        }


        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        T = Integer.parseInt(br.readLine());
    } // End of input()
} // End of Main class
