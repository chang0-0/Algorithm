package BOJ_28069;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_28069 {

    // https://www.acmicpc.net/problem/28069
    // input
    private static BufferedReader br;

    // variables
    private static int N, K;

    private static class GimBab {
        int n;
        int k;

        private GimBab(int n, int k) {
            this.n = n;
            this.k = k;
        }

        @Override
        public String toString() {
            return "Gimbab{" + n + ", " + k + "}";
        }
    } // End of GimBab class;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_28069\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        boolean ret = BFS();
        sb.append(ret ? "minigimbob" : "water");
        return sb.toString();
    } // End of solve()

    private static boolean BFS() {
        ArrayDeque<GimBab> que = new ArrayDeque<>();
        que.offer(new GimBab(0, 0));
        boolean[] isVisited = new boolean[N];

        while (!que.isEmpty()) {
            GimBab cur = que.poll();

            if (cur.n == N) {
                return true;
            } else if (cur.n > N) {
                continue;
            } else if (cur.k == K) {
                continue;
            }

            if (isVisited[cur.n]) continue;
            isVisited[cur.n] = true;

            que.offer(new GimBab(cur.n + 1, cur.k + 1));

            if (cur.n > 0) {
                que.offer(new GimBab(cur.n + (cur.n / 2), cur.k + 1));
            }
        }

        return false;
    } // End of BFS()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

    } // End of input()
} // End of Main class
