package BOJ_31823;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_31823 {

    // https://www.acmicpc.net/problem/31823
    // input
    private static BufferedReader br;

    // variables

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_31823\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() throws IOException {
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            int max = 0;
            st = new StringTokenizer(br.readLine());
            int count = 0;

            for (int j = 0; j < M; j++) {
                char ch = st.nextToken().charAt(0);

                if (ch == '.') {
                    count++;
                } else {
                    max = Math.max(max, count);
                    count = 0;
                }
            }

            if (count > 0) {
                max = Math.max(max, count);
            }

            set.add(max);
            sb.append(max).append(' ').append(st.nextToken()).append('\n');
        }

        sb.insert(0, set.size() + "\n");
        return sb.toString();
    } // End of solve()
} // End of Main class
