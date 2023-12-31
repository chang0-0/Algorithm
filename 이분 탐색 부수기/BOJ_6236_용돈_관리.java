package BOJ_6236;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_6236_용돈_관리 {

    // https://www.acmicpc.net/problem/6236
    // input
    private static BufferedReader br;

    // variables
    private static int N, M, max, min, ans;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_6236\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        sb.append(binarySearch(min, 10_001));
        System.out.println("ans : " + ans);
        return sb.toString();
    } // End of solve()

    private static int binarySearch(int low, int high) {
        if (low > high) {
            return low;
        }

        int mid = (low + high) / 2;
        if (check(mid)) {
            return binarySearch(low, mid - 1);
        } else {
            return binarySearch(mid + 1, high);
        }
    } // End of binarySearch()

    private static boolean check(int referenceAmount) {
        int withdrawCount = 1;
        int haveMoney = referenceAmount;

        for (int i = 0; i < N; i++) {
            int todayUsedMoney = arr[i];

            if (todayUsedMoney > haveMoney) {
                haveMoney = referenceAmount;
                withdrawCount++;
            } else {
                haveMoney -= todayUsedMoney;
            }
        }

        return withdrawCount <= M;
    } // End of check()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        max = -1;
        min = Integer.MAX_VALUE;
        ans = Integer.MAX_VALUE;

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(arr[i], max);
            min = Math.min(arr[i], min);
        }
    } // End of input()
} // End of Main class
