package BOJ_1544;

import java.io.*;
import java.util.HashSet;

public class BOJ_1544 {

    // https://www.acmicpc.net/problem/1544
    // input
    private static BufferedReader br;

    // variables
    private static int N;
    private static HashSet<String> set;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_1544\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() throws IOException {
        StringBuilder sb = new StringBuilder();

        set.add(br.readLine());
        for (int i = 1; i < N; i++) {
            String temp = br.readLine();
            if (!find(temp)) {
                set.add(temp);
            }
        }

        sb.append(set.size());
        return sb.toString();
    } // End of solve()

    private static boolean find(String s) {
        if (set.contains(s)) return true;

        StringBuilder sb = new StringBuilder();
        sb.append(s);
        int len = s.length();
        for (int i = 1; i < len; i++) {

            // 앞에껄 뒤올 붙이고 앞을 지움
            sb.append(sb.charAt(0)).deleteCharAt(0);
            if (set.contains(sb.toString())) {
                return true;
            }
        }

        return false;
    } // End of find()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        set = new HashSet<>();

    } // End of input()
} // End of Main class
