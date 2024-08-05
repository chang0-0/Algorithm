package BOJ_13423;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_13423 {

    // https://www.acmicpc.net/problem/13423
    // input
    private static BufferedReader br;

    // variables
    private static int N;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_13423\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            input();

            bw.write(solve());
        }

        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();
        Arrays.sort(arr);

        int ans = 0;
        for (int i = 0; i < N; i++) {
            int num = arr[i];

            for (int j = i + 2; j < N; j++) {
                int temp = arr[j];

                int diff = Math.abs(num - temp);
                if (diff % 2 == 1) continue;
                int target = num + (diff / 2);

                int ret = Arrays.binarySearch(arr, target);
                if (ret > 0) ans++;
            }
        }

        sb.append(ans).append('\n');
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
