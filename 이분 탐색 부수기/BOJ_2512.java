package BOJ_2512;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2512 {

    // https://www.acmicpc.net/problem/2512
    // input
    private static BufferedReader br;

    // variables
    private static int N, M, max, ans;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_2512\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        sb.append(binarySearch(0, max));
        return sb.toString();
    } // End of solve()

    private static int binarySearch(int low, int high) {
        if (low > high) return high;
        // 정답이 될 수 있는 최대값 구하기
        // low = high + 1

        int mid = (low + high) / 2;
        int ret = calc(mid);

        if (ret > M) {
            return binarySearch(low, mid - 1);
        } else {
            return binarySearch(mid + 1, high);
        }
    } // End of binarySearch()

    private static int calc(int mid) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += Math.min(mid, arr[i]);

            if (sum > M) return sum;
        }
        return sum;
    } // End of calc()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        max = 1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(arr[i], max);
        }
        M = Integer.parseInt(br.readLine());
    } // End of input()
} // End of Main class
