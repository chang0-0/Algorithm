package BOJ_5639;

import java.io.*;

public class BOJ_5639_이진_검색_트리 {

    // https://www.acmicpc.net/problem/5639
    // input
    private static BufferedReader br;

    // variables

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_5639\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {

        String temp = "";
        while ((temp = br.readLine()) != null) {
            System.out.println("temp : " + temp);
        }


    } // End of input()
} // End of Main class
