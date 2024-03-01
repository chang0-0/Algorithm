package BOJ_2467;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2467 {

    // https://www.acmicpc.net/problem/2467
    // input
    private static BufferedReader br;

    // variables
    private static int N;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_2467\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        int[] ret = twoPointer();

        sb.append(ret[0]).append(' ').append(ret[1]);
        return sb.toString();
    } // End of solve()

    private static int[] twoPointer() {
        int low = 0;
        int high = N - 1;
        int min = Integer.MAX_VALUE;
        int[] ret = new int[2];

        while (low < high) {
            int sum = arr[low] + arr[high];
            int abs = Math.abs(sum);

            if (abs < min) {
                min = abs;
                ret[0] = arr[low];
                ret[1] = arr[high];
            }

            if (sum > 0) {
                high--;
            } else {
                low++;
            }
        }

        return ret;
    } // End of twoPointer()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    } // End of input()
} // End of Main class
