package BOJ_2217;

import java.io.*;
import java.util.Arrays;

public class BOJ_2217 {

    // https://www.acmicpc.net/problem/2217
    // input
    private static BufferedReader br;

    // variables
    private static int N;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_2217\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        // 로프의 최대 무게를 기준으로 정렬
        Arrays.sort(arr);

        int max = 0;
        for (int i = 0; i < N; i++) {
            // 가장 낮은 무게를 갖는 친구부터 나오면서,
            // i + 1의 더 높은 최대무게를 갖는 로프는 i 로프의 무게보다 높은 무게를 들 수 있긴해도
            // 낮은 무게를 기준으로 삼기 때문에 i번째 무게에서 개수 추가됨
            int weight = arr[i] * (N - i);
            max = Math.max(max, weight);
        }

        sb.append(max);
        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
    } // End of input()
} // End of Main class
