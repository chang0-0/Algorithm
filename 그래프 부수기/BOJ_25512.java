package BOJ_25512;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_25512 {

    // https://www.acmicpc.net/problem/25512
    // input
    private static BufferedReader br;

    // variables
    private static int N;
    private static long whiteSum, blackSum;
    private static List<List<Integer>> adjList;
    private static int[][] colorCosts;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_25512\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        DFS(0, 0);
        sb.append(Math.min(whiteSum, blackSum));
        return sb.toString();
    } // End of solve()

    private static void DFS(int num, int color) {
        whiteSum += colorCosts[num][color];
        blackSum += colorCosts[num][color ^ 1];

        for (int next : adjList.get(num)) {
            DFS(next, color ^ 1);
        }
    } // End of DFS()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        adjList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adjList.add(new ArrayList<>());
        }
        whiteSum = 0;
        blackSum = 0;

        StringTokenizer st;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adjList.get(a).add(b);
        }

        colorCosts = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            colorCosts[i][0] = w;
            colorCosts[i][1] = b;
        }
    } // End of input()
} // End of Main class
