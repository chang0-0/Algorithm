package BOJ_19638;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_19638 {

    // https://www.acmicpc.net/problem/19638
    // input
    private static BufferedReader br;

    // variables
    private static int N, H, T;
    private static PriorityQueue<Integer> pque;


    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_19638\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        int ans = 0;
        while (T-- > 0) {
            int cur = pque.poll();
            if (cur < H) {
                pque.offer(cur);
                break;
            }

            int temp = cur / 2;
            if (temp <= 0) {
                pque.offer(1);
            } else {
                pque.offer(temp);
            }
            ans++;
        }

        if (pque.peek() < H) {
            sb.append("YES\n").append(ans);
        } else {
            sb.append("NO\n").append(pque.peek());
        }

        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        pque = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            pque.offer(Integer.parseInt(br.readLine()));
        }
    } // End of input()
} // End of Main class
