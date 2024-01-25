package BOJ_2668;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_2668 {

    // https://www.acmicpc.net/problem/2668
    // input
    private static BufferedReader br;

    // variables
    private static int N;
    private static int[] arr;
    private static boolean[] visited;
    private static List<Integer> retList;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_2668\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            visited[i] = true;
            DFS(i, i);
            visited[i] = false;
        }

        Collections.sort(retList);
        sb.append(retList.size()).append('\n');
        for (int num : retList) {
            sb.append(num).append('\n');
        }

        return sb.toString();
    } // End of solve()

    private static void DFS(int idx, int target) {

        if (!visited[arr[idx]]) {
            visited[arr[idx]] = true;
            DFS(arr[idx], target);
            visited[arr[idx]] = false;
        }

        if (arr[idx] == target) retList.add(target);
    } // End of DFS()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        retList = new ArrayList<>();
        visited = new boolean[N + 1];
        arr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
    } // End of input()
} // End of Main class
