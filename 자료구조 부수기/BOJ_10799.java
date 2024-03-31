package BOJ_10799;

import java.io.*;
import java.util.LinkedList;

public class BOJ_10799 {

    // https://www.acmicpc.net/problem/10799
    // input
    private static BufferedReader br;

    // variables
    private static char[] chArr;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_10799\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        int ans = 0;
        int N = chArr.length;
        LinkedList<Character> list = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            char ch = chArr[i];

            if (ch == '(') {
                list.offerLast(ch);
            } else if(ch == '1') {
                ans += list.size();
            } else {
                list.pollLast();
                ans++;
            }
        }

        sb.append(ans);
        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        chArr = br.readLine().replace("()", "1").toCharArray();
    } // End of input()
} // End of Main class
