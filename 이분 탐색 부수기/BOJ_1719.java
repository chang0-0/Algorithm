package BOJ_17179;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1719 {

    // https://www.acmicpc.net/problem/17179
    // input
    private static BufferedReader br;

    // variables
    private static int N, M, L;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_17179\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() throws IOException {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(br.readLine());
            sb.append(binarySearch(0, L, temp)).append('\n');
        }

        return sb.toString();
    } // End of solve()

    private static int binarySearch(int low, int high, int cutCount) {
        // 가장 작은 조각의 길이의 최댓값을 구하려고 한다 -> return high
        if (low > high) return high;

        int mid = (low + high) / 2;
        int count = check(mid);

        if (cutCount < count) {
            return binarySearch(mid + 1, high, cutCount);
        } else {
            return binarySearch(low, mid - 1, cutCount);
        }
    } // End of binarySearch()

    private static int check(int mid) {
        int count = 0;
        int pre = 0;
        for (int i = 0; i <= M; i++) {
            if (arr[i] - pre >= mid) {
                count++;
                pre = arr[i];
            }
        }

        return count;
    } // End of check()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        arr = new int[M + 1];
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        arr[M] = L;
    } // End of input()
} // End of Main class
