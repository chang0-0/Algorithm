package BOJ_2303;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2303 {

    // https://www.acmicpc.net/problem/2303
    // input
    private static BufferedReader br;

    // variables
    private static int N;
    private static int[][] cards;
    private static int[] scores;
    private static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_2303\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            DFS(i, 0, 0, 0);
        }

        int ans = 0;
        int max = -1;
        for (int i = 0; i < N; i++) {
            if (max <= scores[i]) {
                max = scores[i];
                ans = i + 1;
            }
        }

        sb.append(ans);
        return sb.toString();
    } // End of solve()

    private static void DFS(int num, int idx, int depth, int sum) {
        if (depth == 3) {
            scores[num] = Math.max(scores[num], sum % 10);
            return;
        }

        for (int i = idx; i < 5; i++) {
            if (isVisited[i]) continue;
            isVisited[i] = true;
            DFS(num, i + 1, depth + 1, sum + cards[num][i]);
            isVisited[i] = false;
        }
    } // End of DFS()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        cards = new int[N][5];
        scores = new int[N];
        isVisited = new boolean[5];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                cards[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    } // End of input()
} // End of Main class
