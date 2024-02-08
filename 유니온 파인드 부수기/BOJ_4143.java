package BOJ_4143;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_4143 {

    // https://www.acmicpc.net/problem/4143
    // input
    private static BufferedReader br;

    // variables
    private static int N;
    private static int[] parents, ranks, size;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_4143\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            input();

            bw.write(solve());
        }
        bw.close();
    } // End of main()

    private static String solve() throws IOException {
        StringBuilder sb = new StringBuilder();

        Map<String, Integer> map = new HashMap<>();
        int nodeNum = 1;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String nodeA = st.nextToken();
            String nodeB = st.nextToken();

            if (!map.containsKey(nodeA)) {
                map.put(nodeA, nodeNum);
                parents[nodeNum] = nodeNum;
                size[nodeNum] = 1;
                nodeNum++;
            }

            if (!map.containsKey(nodeB)) {
                map.put(nodeB, nodeNum);
                parents[nodeNum] = nodeNum;
                size[nodeNum] = 1;
                nodeNum++;
            }


            union(map.get(nodeA), map.get(nodeB));

            // union할때 find를 해도 최상위 부모가 갱신되어 있지 않을 수 있기 때문에 꼭 find()를 다시 수행해서 부모가 같은지 확인할 것
            sb.append(size[find(map.get(nodeA))]).append('\n');
        }

        return sb.toString();
    } // End of solve()

    private static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot == bRoot) return;

        if (ranks[aRoot] < ranks[bRoot]) {
            parents[aRoot] = bRoot;
            size[bRoot] += size[aRoot];
        } else {
            parents[bRoot] = aRoot;
            size[aRoot] += size[bRoot];
            if (ranks[aRoot] == ranks[bRoot]) {
                ranks[aRoot]++;
            }
        }
    } // End of union()

    private static int find(int node) {
        if (parents[node] == node) return node;

        return parents[node] = find(parents[node]);
    } // End of find()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        parents = new int[N * 2];
        ranks = new int[N * 2];
        size = new int[N * 2];
    } // End of input()
} // End of Main class
