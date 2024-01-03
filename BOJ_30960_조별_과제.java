package BOJ_30960;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_30960_조별_과제 {

    // https://www.acmicpc.net/problem/30960
    // input
    private static BufferedReader br;

    // variables
    private static int N;
    private static int[] arr;
    private static int[] prefix;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_30960\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        System.out.println(Arrays.toString(prefix));


        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        Arrays.sort(arr);
        prefix = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            prefix[i] = arr[i];
            if (i >= 1) {
                prefix[i] = prefix[i] + prefix[i - 1];
            }
        }
    } // End of input()
} // End of Main class

