package BOJ_3182;

import java.io.*;

public class BOJ_3182 {

    // https://www.acmicpc.net/problem/3182
    // input
    private static BufferedReader br;

    // variables
    private static int N;
    private static int[] arr;
    private static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_3182\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        int ans = 0;
        int max = 0;
        for (int i = 1; i <= N; i++) {
            isVisited = new boolean[N + 1];
            int count = DFS(i);

            if (max < count) {
                max = count;
                ans = i;
            }
        }

        sb.append(ans);
        return sb.toString();
    } // End of solve()

    private static int DFS(int node) {
        if (isVisited[node]) return 0;
        if (arr[node] == node) return 1;

        isVisited[node] = true;
        return DFS(arr[node]) + 1;
    } // End of DFS()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
    } // End of input()
} // End of Main class
