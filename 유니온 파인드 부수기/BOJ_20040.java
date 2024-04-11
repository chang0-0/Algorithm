package BOJ_20040;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_20040 {

    // https://www.acmicpc.net/problem/20040
    // input
    private static BufferedReader br;

    // variables
    private static int N, M;
    private static int[] parents, ranks;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_20040\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() throws IOException {
        StringBuilder sb = new StringBuilder();
        
        /*
            먼저 사이클을 완성하면 이긴다. -> 부모가 같으면 사이클임
            모두 처리한 이후에도 사이클이 없다면 0을 출력
         */

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (find(a) == find(b)) {
                sb.append(i + 1);
                return sb.toString();
            }

            union(a, b);
        }

        sb.append(0);
        return sb.toString();
    } // End of solve()

    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) return;

        if (ranks[rootA] < ranks[rootB]) {
            // A가 더 부모임
            parents[rootA] = rootB; //  rootA의 부모는 rootB로 변경
        } else {
            // rootA의 높이가 더 높거나 같을 경우
            parents[rootB] = rootA; // rootB의 부모가 rootA가 된다.
            // 이미 A의 높이가 더 높을경우에는 A가 부모가 되고 높이는 증가시키지 않는다.
            if (ranks[rootA] == ranks[rootB]) {
                ranks[rootA]++; // A가 B의 부모가 되어서 rank가 증가한다.
            }
        }
    } // End of union()

    private static int find(int node) {
        if (parents[node] == node) return node;

        return find(parents[node]);
    } // End of find()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parents = new int[N];
        ranks = new int[N];

        for (int i = 1; i < N; i++) {
            parents[i] = i;
        }
    } // End of input()
} // End of Main class
