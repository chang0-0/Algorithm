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
    private static char[] chArr;

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

        do {
            if (check()) ans++;
        } while (np());

        System.out.println(aaa());
        sb.append(ans);
        return sb.toString();
    } // End of solve()

    private static int[] aaa() {
        return new int[]{-1};
    }

    private static boolean check() {
        for (int i = 0; i < N - 1; i++) {
            if (chArr[i] == chArr[i + 1]) return false;
        }

        return true;
    } // End of check()

    private static boolean np() {
        int i = N - 1;
        while (i > 0 && chArr[i - 1] >= chArr[i]) {
            i--;
        }

        System.out.println("i : " + i);

        if (i == 0) return false;

        int j = N - 1;
        while (chArr[i - 1] >= chArr[j]) {
            j--;
        }
        swap(i - 1, j);
        System.out.println("j : " + j);

        int k = N - 1;
        while (i < k) {
            swap(i++, k--);
        }
        System.out.println("k : " + k);

        return true;
    } // End of np()

    private static void swap(int i, int j) {
        char cur = chArr[i];
        chArr[i] = chArr[j];
        chArr[j] = cur;
    } // End of swap()

    private static void input() throws IOException {
        ans = 0;
        S = br.readLine();
        N = S.length();

        chArr = S.toCharArray();
        Arrays.sort(chArr);
    } // End of input()
} // End of Main class
