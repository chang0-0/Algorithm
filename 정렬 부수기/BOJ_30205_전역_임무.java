package BOJ_30205;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_30205_전역_임무 {

    // https://www.acmicpc.net/problem/30205
    // input
    private static BufferedReader br;

    // variables
    private static int N, M;
    private static long P;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_30205\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() throws IOException {
        StringBuilder sb = new StringBuilder();

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            PriorityQueue<Integer> pque = new PriorityQueue<>();
            int item = 0;

            for (int i = 0; i < M; i++) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp == -1) {
                    item++;
                } else {
                    pque.offer(temp);
                }
            }

            while (!pque.isEmpty()) {
                while (P < pque.peek() && item > 0) {
                    item--;
                    P *= 2;
                }

                if (P < pque.peek()) {
                    return "0";
                }

                P += pque.peek();
                pque.poll();
            }

            // 남은 아이템 모두 사용
            while (item-- > 0) P *= 2;
        }

        sb.append(1);
        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = Long.parseLong(st.nextToken());
    } // End of input()
} // End of Main class
