package BOJ_1342;

import java.io.*;
import java.util.Arrays;

public class BOJ_1342 {

    // https://www.acmicpc.net/problem/1342
    // input
    private static BufferedReader br;

    // variables
    private static int N, ans;
    private static String S;
    private static int[] chArr;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_1342\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        DFS(-1, 0);
        sb.append(ans);
        return sb.toString();
    } // End of solve()

    private static void DFS(int pre, int depth) {
        if (depth == N) {
            ans++;
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (chArr[i] == 0 || pre == i) continue;
            chArr[i]--;
            DFS(i, depth + 1);
            chArr[i]++;
        }
    } // End of DFS()

    private static void input() throws IOException {
        ans = 0;
        S = br.readLine();
        N = S.length();

        chArr = new int[26];
        for (char c : S.toCharArray()) {
            chArr[c - 'a']++;
        }
    } // End of input()
} // End of Main class
