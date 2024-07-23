package BOJ_1158;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_1158 {

    // https://www.acmicpc.net/problem/1158
    // input
    private static BufferedReader br;

    // variables
    private static int N, K;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_1158\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        LinkedList<Integer> que = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            que.offer(i);
        }

        int curIdx = 0;
        sb.append('<');
        while (que.size() > 1) {

            int idx = (curIdx + (K - 1)) % que.size();
            int temp = que.remove(idx);
            curIdx = idx;
            sb.append(temp).append(", ");
        }

        sb.append(que.poll());
        sb.append('>');
        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
    } // End of input()
} // End of Main class
