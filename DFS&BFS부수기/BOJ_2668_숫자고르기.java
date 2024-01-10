package BOJ_2668;

import java.io.*;

public class BOJ_2668_숫자고르기 {

    // https://www.acmicpc.net/problem/2668
    // input
    private static BufferedReader br;

    // variables
    private static int N;
    private static int nums[];

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_2668\\res.txt"));
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

    private static void DFS(int depth) {
        if (depth == N) {


            return;
        }


    } // End of DFS()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        nums = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
    } // End of input()
} // End of Main class
