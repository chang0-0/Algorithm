package BOJ_5081;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class BOJ_5081 {

    // https://www.acmicpc.net/problem/5081
    // input
    private static BufferedReader br;

    // variables
    private static final int MAX = 1001;
    private static int N;
    private static int[] parents, ranks;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_5081\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (; ; ) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            input();

            bw.write(solve());
        }


        bw.close();
    } // End of main()

    private static String solve() throws IOException {
        StringBuilder sb = new StringBuilder();

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);

            set.add(a);
            set.add(b);
        }

        HashSet<Integer> set2 = new HashSet<>();
        for (int node : set) {
            find(node);
            set2.add(parents[node]);
        }

        System.out.println(set2);


        return sb.toString();
    } // End of solve()

    private static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot == bRoot) return;

        if (ranks[aRoot] < ranks[bRoot]) {
            parents[aRoot] = bRoot;
        } else {
            parents[bRoot] = aRoot;
            if (ranks[aRoot] == ranks[bRoot]) {
                ranks[aRoot]++;
            }
        }
    } // End of union()

    private static int find(int node) {
        if (node == parents[node]) return node;

        return parents[node] = find(parents[node]);
    } // End of find()

    private static void input() throws IOException {
        parents = IntStream.rangeClosed(0, MAX).toArray();
        ranks = new int[MAX];


    } // End of input()
} // End of Main class
