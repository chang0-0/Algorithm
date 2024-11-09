package BOJ_25214;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_25214 {

    // https://www.acmicpc.net/problem/25214
    // input
    private static BufferedReader br;

    // variables
    private static int N;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_25214\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() throws IOException {
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int min = Integer.parseInt(st.nextToken());
        int[] ans = new int[N];

        // 큰 값을 만들기 위해서는 작은 값이 필요하다.

        for (int i = 1; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (min > num) {
                min = num;
            }

            ans[i] = Math.max(ans[i - 1], num - min);
        }

        for (int t : ans) {
            sb.append(t).append(' ');
        }


        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
    } // End of input()
} // End of Main class
