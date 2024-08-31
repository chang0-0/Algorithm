package BOJ_11581;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_11581 {

    // https://www.acmicpc.net/problem/11581
    // input
    private static BufferedReader br;

    // variables
    private static int N, M;
    private static List<List<Integer>> adjList;
    private static int[] indegree;
    private static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_11581\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        if (DFS(1)) {
            sb.append("CYCLE");
        } else {
            sb.append("NO CYCLE");
        }
        return sb.toString();
    } // End of solve()

    private static boolean DFS(int from) {
        if (isVisited[from] && !adjList.get(from).isEmpty()) {
            return true;
        }

        isVisited[from] = true;

        for (int next : adjList.get(from)) {
            if (DFS(next)) {
                return true;
            }
        }

        isVisited[from] = false;
        return false;
    } // End of DFS()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        adjList = new ArrayList<>();
        indegree = new int[N + 1];
        isVisited = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 1; i <= N - 1; i++) {
            int M = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int temp = Integer.parseInt(st.nextToken());
                adjList.get(i).add(temp);
                indegree[temp]++;
            }
        }
    } // End of input()
} // End of Main class
