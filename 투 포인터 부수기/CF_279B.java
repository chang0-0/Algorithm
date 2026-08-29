package CF_279B;

import java.io.*;
import java.util.StringTokenizer;

public class CF_279B {

    // https://codeforces.com/problemset/problem/279/B
    // input
    private static BufferedReader br;

    // variables
    private static int N, T;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\CF_279B\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        int ans = 0;
        int low = 0;
        int sum = 0;

        for (int high = 0; high < N; high++) {
            sum += arr[high];

            while (sum > T) {
                // high만 증가시키면서, 증가한 sum값을 low를 증가시키면서 sum 값을 감소시킨다.
                // sum은 한쪽 방향으로만 증가한다.
                sum -= arr[low];
                low++;
            }

            ans = Math.max(ans, high - low + 1);
        }

        sb.append(ans);
        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    } // End of input()
} // End of Main class
