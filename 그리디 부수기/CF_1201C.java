package CF_1201C;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF_1201C {

    // https://codeforces.com/problemset/problem/1201/C
    // input
    private static BufferedReader br;

    // variables
    private static int N, K;
    private static long[] arr;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\CF_1201C\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        Arrays.sort(arr);
        int mid = N / 2;
        long cur = arr[mid];
        long count = 1;
        long k = K;

        for (int i = mid + 1; i < N; i++) {
            long next = arr[i];
            long cost = (next - cur) * count;

            if (cost <= K) {
                k -= cost;
                count++;
                cur = next;
            } else {
                cur += k / count;
                k = 0;
                break;
            }
        }

        if (k > 0) {
            cur += k / count;
        }

        sb.append(cur);
        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    } // End of input()
} // End of Main class
