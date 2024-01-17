package BOJ_3273;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3273 {

    // https://www.acmicpc.net/problem/3273
    // input
    private static BufferedReader br;

    // variables
    private static int N, X;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_3273\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        sb.append(twoPointer());
        return sb.toString();
    } // End of solve()

    private static int twoPointer() {
        int left = 0;
        int right = N - 1;
        int ret = 0;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum < X) {
                left++;
            } else if (sum > X) {
                right--;
            } else {
                ret++;
                right--;
            }
        }

        return ret;
    } // End of twoPointer()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        X = Integer.parseInt(br.readLine());
    } // End of input()
} // End of Main class
