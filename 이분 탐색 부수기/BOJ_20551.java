package BOJ_20551;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_20551 {

    // https://www.acmicpc.net/problem/20551
    // input
    private static BufferedReader br;

    // variables
    private static int N, M;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_20551\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() throws IOException {
        StringBuilder sb = new StringBuilder();

        Arrays.sort(arr);
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(br.readLine());

            int ret = binarySearch(0, N - 1, num);
            sb.append(ret).append('\n');
        }


        return sb.toString();
    } // End of solve()

    private static int binarySearch(int low, int high, int target) {
        if (low > high) return -1;

        int midIdx = (low + high) / 2;

        if (arr[midIdx] == target) {
            // 타겟을 찾았으므로, 더 낮은 인덱스가 있는지 왼쪽을 계속 탐색합니다.
            int idx = binarySearch(low, midIdx - 1, target);
            if (idx != -1) {
                return idx;
            } else {
                return midIdx;
            }
        } else if (arr[midIdx] < target) {
            return binarySearch(midIdx + 1, high, target);
        } else {
            return binarySearch(low, midIdx - 1, target);
        }
    } // End of binarySearch()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
    } // End of input()
} // End of Main class
