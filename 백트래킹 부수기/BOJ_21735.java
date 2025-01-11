package BOJ_21735;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_21735 {

    // https://www.acmicpc.net/problem/21735
    // input
    private static BufferedReader br;

    // variables
    private static int N, M, ans;
    private static int[] arr;
    private static ArrayDeque<Integer> que;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_21735\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        DFS(0, 0, 1);

        sb.append(ans);
        return sb.toString();
    } // End of solve()

    private static void DFS(int depth, int idx, int snowScale) {
        System.out.println("DFS(" + depth + ", " + idx + ", " + snowScale + ")");
        if (depth <= M) {
            ans = Math.max(ans, snowScale);
            System.out.println("que : " + que);
            System.out.println("ans : " + ans);
        }

        if (depth == M || idx > N) {
            return;
        }

        if (idx + 1 <= N) {
            que.offer(arr[idx + 1]);
            DFS(depth + 1, idx + 1, snowScale + arr[idx + 1]);
            que.poll();
        }

        if (idx + 2 <= N) {
            que.offer(arr[idx + 2]);
            DFS(depth + 1, idx + 2, (snowScale / 2) + arr[idx + 2]);
            que.poll();
        }
    } // End of DFS()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ans = 0;
        que = new ArrayDeque<>();

        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    } // End of input()
} // End of Main class
