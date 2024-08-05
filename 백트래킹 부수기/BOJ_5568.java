package BOJ_5568;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class BOJ_5568 {

    // https://www.acmicpc.net/problem/5568
    // input
    private static BufferedReader br;

    // variables
    private static int N, K;
    private static String[] arr, comb;
    private static boolean[] isVisited;
    private static Set<String> set;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_5568\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        DFS(0);
        sb.append(set.size());
        return sb.toString();
    } // End of solve()

    private static void DFS(int depth) {
        if (depth == K) {
            StringBuilder sb = new StringBuilder();
            for (String str : comb) {
                sb.append(str);
            }

            set.add(sb.toString());
            return;
        }

        for (int i = 0; i < N; i++) {
            if (isVisited[i]) continue;
            isVisited[i] = true;
            comb[depth] = arr[i];
            DFS(depth + 1);
            isVisited[i] = false;
        }
    } // End of DFS()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        comb = new String[K];
        arr = new String[N];
        isVisited = new boolean[N];
        set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            arr[i] = temp;
        }
    } // End of input()
} // End of Main class
