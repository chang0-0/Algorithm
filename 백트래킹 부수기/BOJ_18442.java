package BOJ_18442;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_18442 {

    // https://www.acmicpc.net/problem/18442
    // input
    private static BufferedReader br;

    // variables
    private static int V, P;
    private static long L, ans;
    private static long[] arr, comb, ansArr;
    private static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_18442\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        // V개 중에 P개를 선택
        DFS(0, 0);

        sb.append(ans).append('\n');
        for (long t : ansArr) {
            sb.append(t).append(' ');
        }
        return sb.toString();
    } // End of solve()

    private static void DFS(int idx, int depth) {
        if (depth == P) {
            long ret = check();
            if (ans > ret) {
                ans = ret;
                ansArr = comb.clone();
            }
            return;
        }

        for (int i = idx; i < V; i++) {
            if (isVisited[i]) continue;
            isVisited[i] = true;
            comb[depth] = arr[i];
            DFS(i, depth + 1);
            isVisited[i] = false;
        }
    } // End of DFS()

    private static long check() {
        long sum = 0;

        for (int i = 0; i < V; i++) {
            long min = Long.MAX_VALUE;
            for (int j = 0; j < P; j++) {
                long abs = Math.abs(arr[i] - comb[j]);
                long temp = Math.min(abs, L - abs);
                min = Math.min(min, temp);
            }
            sum += min;

            if (ans < sum) {
                return sum;
            }
        }

        return sum;
    } // End of check()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        L = Long.parseLong(st.nextToken());
        ans = Long.MAX_VALUE;

        arr = new long[V];
        comb = new long[P];
        isVisited = new boolean[V];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < V; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
    } // End of input()
} // End of Main class
