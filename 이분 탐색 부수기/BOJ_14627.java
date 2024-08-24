package BOJ_14627;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_14627 {

    // https://www.acmicpc.net/problem/14627
    // input
    private static BufferedReader br;

    // variables
    private static int S, C;
    private static long max;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_14627\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        long ret = binarySearch();
        long sum = 0;
        for (int i = 0; i < S; i++) {
            long div = arr[i] / ret;
            long mod = arr[i] % ret;
            while (C > 0 && div > 0) {
                div--;
                C--;
            }

            sum += mod;
            sum += (ret * div);
        }

        sb.append(sum);
        return sb.toString();
    } // End of solve()

    private static long binarySearch() {
        long low = 1;
        long high = max;
        long ret = Integer.MIN_VALUE;


        while (low <= high) {
            long mid = (low + high) / 2;
            long sum = 0;
            for (int i = 0; i < S; i++) {
                long div = arr[i] / mid;
                sum += div;
            }

            if (sum >= C) {
                // 파닭을 만들 수 있는 파의 양이 나올 때,
                ret = Math.max(ret, mid);
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ret;
    } // End of binarySearch()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new int[S];
        max = Integer.MIN_VALUE;
        for (int i = 0; i < S; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }
    } // End of input()
} // End of Main class
