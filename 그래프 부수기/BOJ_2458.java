package BOJ_2458;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2458 {

    // https://www.acmicpc.net/problem/2458
    // input
    private static BufferedReader br;

    // variables
    private static int N, M;
    private static List<List<Integer>> shortList;
    private static List<List<Integer>> tallList;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_2458\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            boolean[] isVisited = new boolean[N + 1];
            int count = DFS(i, shortList, isVisited) + DFS(i, tallList, isVisited) - 1;
            if (count == N) ans++;
        }


        sb.append(ans);
        return sb.toString();
    } // End of solve()

    private static int DFS(int node, List<List<Integer>> list, boolean[] isVisited) {
        int count = 1;
        isVisited[node] = true;

        for (int next : list.get(node)) {
            if (isVisited[next]) continue;
            count += DFS(next, list, isVisited);
        }

        return count;
    } // End of DFS()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        shortList = new ArrayList<>();
        tallList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            shortList.add(new ArrayList<>());
            tallList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tallList.get(a).add(b);
            shortList.get(b).add(a);
        }

    } // End of input()
} // End of Main class
