package BOJ_9024;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class BOJ_9024 {
    // input
    private static BufferedReader br;
    private static StringBuilder sb;

    // variables
    private static int N = 0;
    private static int K = 0;
    private static int ans;

    private static int[] arr;


    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\Java Algorithm\\JavaAlgorithm\\src\\BOJ_9024\\res\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            input();

//            int minIndex = 0;
//            int maxIndex = N - 1;
//            solve2(minIndex, maxIndex, 0, Integer.MAX_VALUE);
//            sb.append(ans).append('\n');

            solve();
        }

        bw.write(sb.toString());
        bw.close();
    } // End of main

    private static void solve() {
        int count = 0;
        int minIndex = 0;
        int maxIndex = N - 1;
        int ret = Integer.MAX_VALUE;

        while (minIndex < maxIndex) {

            int sum = arr[minIndex] + arr[maxIndex];
            int temp = Math.abs(K - sum);  // 합의 차 구하기

            // K에 가장 가까운 값을 구하는 것.
            if (temp < ret) {
                ret = temp;
                count = 1;
            } else if (temp == ret) {
                count++;
            }


            if (sum > K) {
                // 합을 구했는데, 그 합이 K보다 클 경우, 큰 값을 낮춰야 하므로, maxIndex를 줄인다.
                maxIndex--;
            } else {
                // 합을 구했는데, 그 합이 K보다 작을 경우, 작은 값을 올려하므로, minIndex를 높인다.
                minIndex++;
            }
        }

        sb.append(count).append('\n');
    } // End of solve

    private static void solve2(int lower, int upper, int sum, int ret) {
        if (lower >= upper) {
            return;
        }

        sum = arr[lower] + arr[upper];
        int temp = Math.abs(K - sum);

        if (temp < ret) {
            ret = temp;
            ans = 1;
        } else if (temp == ret) {
            ans++;
        }

        if (sum > K) {
            solve2(lower, upper - 1, sum, ret);
        } else {
            solve2(lower + 1, upper, sum, ret);
        }
    } // End of solve2

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        ans = 0;

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
    } // End of input
} // End of BOJ_9024 class
