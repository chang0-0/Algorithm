package BOJ_28110;

import java.io.*;
import java.util.Arrays;

public class BOJ_28110 {

    // https://www.acmicpc.net/problem/28110
    // input
    private static BufferedReader br;

    // variables
    private static int N;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_28110\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        Arrays.sort(arr);
        int maxDiff = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < N - 1; i++) {
            int diff = arr[i + 1] - arr[i];

            if (maxDiff < diff) {
                maxDiff = diff;
                left = arr[i];
                right = arr[i + 1];
            }
        }


        int can = left + ((right - left) / 2);
        int min = Math.min(can - left, right - can);
        int ans = -1;
        if (min != 0) {
            ans = can;
        }

        sb.append(ans);
        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    } // End of input()
} // End of Main class
