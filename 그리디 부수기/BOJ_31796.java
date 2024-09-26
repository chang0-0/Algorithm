package BOJ_31796;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_31796 {

    // https://www.acmicpc.net/problem/31796
    // input
    private static BufferedReader br;

    // variables
    private static int N;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_31796\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        Arrays.sort(arr);
        int val = 0;
        int count = 0;

        for (int i = 0; i < N; i++) {
            if (val * 2 <= arr[i]) {
                count++;
                val = arr[i];
            }
        }

        sb.append(count);
        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    } // End of input()
} // End of Main class
