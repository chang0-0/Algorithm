package BOJ_23843;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_23843 {

    // https://www.acmicpc.net/problem/23843
    // input
    private static BufferedReader br;

    // variables
    private static int N, M;
    private static int[] machines;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_23843\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> pque = new PriorityQueue<>();
        int idx = N - 1;
        while (idx >= 0) {

            if (pque.size() < M) {
                pque.offer(machines[idx]);
                idx--;
                continue;
            }

            int temp = pque.poll() + machines[idx];
            pque.offer(temp);
            idx--;
        }

        int ans = 0;
        while (!pque.isEmpty()) {
            ans = pque.poll();
        }

        sb.append(ans);
        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        machines = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            machines[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(machines);
    } // End of input()
} // End of Main class
