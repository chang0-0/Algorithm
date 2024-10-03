package BOJ_11116;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_11116_HashSet {

    // https://www.acmicpc.net/problem/11116
    // input
    private static BufferedReader br;

    // variables
    private static int M;
    private static final int TIME = 1000;
    private static HashSet<Integer> leftSet;
    private static HashSet<Integer> rightSet;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_11116_HashSet\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            input();

            bw.write(solve());
        }

        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        int ans = 0;
        for (int left : leftSet) {
            if (rightSet.contains(left + TIME)) {
                ans++;
            }
        }

        sb.append(ans / 2).append('\n');
        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        M = Integer.parseInt(br.readLine());
        leftSet = new HashSet<>();
        rightSet = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            leftSet.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            rightSet.add(Integer.parseInt(st.nextToken()));
        }
    } // End of input()
} // End of Main class
