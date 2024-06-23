package BOJ_2697;

import java.io.*;

public class BOJ_2697 {

    // https://www.acmicpc.net/problem/2697
    // input
    private static BufferedReader br;

    // variables
    private static final String BIG = "BIGGEST";

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_2697\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            bw.write(solve());
        }

        bw.close();
    } // End of main()

    private static String solve() throws IOException {
        StringBuilder sb = new StringBuilder();

        char[] chArr = br.readLine().toCharArray();
        if (check(chArr)) {
            sb.append(new String(chArr));
        } else {
            sb.append(BIG);
        }
        sb.append('\n');

        return sb.toString();
    } // End of solve()

    private static boolean check(char[] chArr) {
        int i = chArr.length - 1;

        while (i > 0 && chArr[i - 1] >= chArr[i]) {
            i--;
        }

        if (i <= 0) {
            return false;
        }


        int j = chArr.length - 1;
        while (chArr[j] <= chArr[i - 1]) {
            j--;
        }

        // swap
        char temp = chArr[i - 1];
        chArr[i - 1] = chArr[j];
        chArr[j] = temp;

        j = chArr.length - 1;
        while (i < j) {
            temp = chArr[i];
            chArr[i] = chArr[j];
            chArr[j] = temp;
            i++;
            j--;
        }

        return true;
    }
} // End of Main class
