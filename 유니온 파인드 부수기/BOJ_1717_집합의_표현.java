package BOJ_1717;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1717_집합의_표현 {

    // https://www.acmicpc.net/problem/1717
    // input
    private static BufferedReader br;

    // variables
    private static final String NO = "NO";
    private static final String YES = "YES";
    private static int N, M;
    private static int[] parents, ranks;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_1717\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() throws IOException {
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (num == 0) {
                union(a, b);
            } else {
                if (find(a) == find(b)) {
                    sb.append(YES);
                } else {
                    sb.append(NO);
                }
                sb.append('\n');
            }
        }


        return sb.toString();
    } // End of solve()

    private static int find(int x) {
        if (x == parents[x]) return x;

        System.out.println("parent[" + x + "] : " + parents[x]);
        return find(parents[x]);
    } // End of find()

    private static void union(int a, int b) {
        System.out.println("a : " + a + ", b : " + b);
        int aParent = find(a);
        int bParent = find(b);

        System.out.println("aParent : " + aParent + ", bParent : " + bParent);

        if (aParent != bParent) {
            if (ranks[aParent] < ranks[bParent]) {
                parents[aParent] = bParent;
            } else {
                parents[bParent] = aParent;
                if (ranks[aParent] == ranks[bParent]) {
                    ranks[aParent]++;
                }
            }
        }

        System.out.println(Arrays.toString(parents));
        System.out.println(Arrays.toString(ranks));
    } // End of union()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parents = new int[N + 1];
        ranks = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
            ranks[i] = 0;
        }
    } // End of input()
} // End of Main class
