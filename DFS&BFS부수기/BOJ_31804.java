package BOJ_31804;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_31804 {

    // https://www.acmicpc.net/problem/31804
    // input
    private static BufferedReader br;

    // variables
    private static int N, M;

    private static class Magic implements Comparable<Magic> {
        int score;
        int count;
        boolean chance;

        private Magic(int score, int count, boolean chance) {
            this.score = score;
            this.count = count;
            this.chance = chance;
        }

        @Override
        public int compareTo(Magic o) {
            return count - o.count;
        }

        @Override
        public String toString() {
            return "Magic{" + score + ", " + count + ", " + chance + "}";
        }

    } // End of Magic class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_31804\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        sb.append(BFS());
        return sb.toString();
    } // End of solve()

    private static int BFS() {
        PriorityQueue<Magic> que = new PriorityQueue<>();
        int[][] memo = new int[M + 1][2];
        for (int i = 0; i < M + 1; i++) {
            Arrays.fill(memo[i], Integer.MAX_VALUE / 4);
        }
        que.offer(new Magic(N, 0, false));
        memo[N][0] = 0;

        while (!que.isEmpty()) {
            Magic cur = que.poll();

            // 목적지에 도달하면 최소 이동 횟수를 반환
            if (cur.score == M) {
                return cur.count;
            }
            if (memo[cur.score][cur.chance ? 1 : 0] < cur.count) continue;


            if (cur.score + 1 <= M && memo[cur.score + 1][cur.chance ? 1 : 0] > memo[cur.score][cur.chance ? 1 : 0] + 1) {
                memo[cur.score + 1][cur.chance ? 1 : 0] = memo[cur.score][cur.chance ? 1 : 0] + 1;
                que.offer(new Magic(cur.score + 1, memo[cur.score + 1][cur.chance ? 1 : 0], cur.chance));
            }

            if (cur.score * 2 <= M && memo[cur.score * 2][cur.chance ? 1 : 0] > memo[cur.score][cur.chance ? 1 : 0] + 1) {
                memo[cur.score * 2][cur.chance ? 1 : 0] = memo[cur.score][cur.chance ? 1 : 0] + 1;
                que.offer(new Magic(cur.score * 2, memo[cur.score * 2][cur.chance ? 1 : 0], cur.chance));
            }

            // *10 연산 (찬스가 사용되지 않은 경우만)
            if (cur.score * 10 <= M && !cur.chance && memo[cur.score * 10][1] > cur.count + 1) {
                memo[cur.score * 10][1] = cur.count + 1;
                que.offer(new Magic(cur.score * 10, memo[cur.score * 10][1], true));
            }
        }

        return -1;
    } // End of BFS()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
    } // End of input()
} // End of Main class
