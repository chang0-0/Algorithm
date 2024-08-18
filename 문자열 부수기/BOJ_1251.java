package BOJ_1251;

import java.io.*;

public class BOJ_1251 {

    // https://www.acmicpc.net/problem/1251
    // input
    private static BufferedReader br;

    // variables
    private static String str;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_1251\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        int len = str.length();
        String ans = "z".repeat(50);

        for (int i = 1; i <= len - 2; i++) {
            String subReverse = new StringBuilder(str.substring(0, i)).reverse().toString();

            for (int j = i + 1; j <= len - 1; j++) {
                StringBuilder temp = new StringBuilder();
                temp.append(subReverse);

                String sub2 = str.substring(i, j);
                String sub2Reverse = new StringBuilder(sub2).reverse().toString();
                String sub3 = str.substring(j, len);
                String sub3Reverse = new StringBuilder(sub3).reverse().toString();
                temp.append(sub2Reverse).append(sub3Reverse);
                ans = comp(ans, temp.toString());
            }
        }

        sb.append(ans);
        return sb.toString();
    } // End of solve()

    private static String comp(String s1, String s2) {
        if (s1.compareTo(s2) >= 0) {
            return s2;
        } else {
            return s1;
        }
    } // End of comp()

    private static void input() throws IOException {
        str = br.readLine();
    } // End of input()
} // End of Main class
