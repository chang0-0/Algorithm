package BOJ_14677;

import java.io.*;
import java.util.ArrayDeque;

public class BOJ_14677 {

    // https://www.acmicpc.net/problem/14677
    // input
    private static BufferedReader br;

    // variables
    private static int N;
    private static char[] arr;
    private static final char[] state = {'B', 'L', 'D'};
    private static final int MOD = 3;

    private static class Madi {
        int leftIdx;
        int rightIdx;
        int stateIdx;

        private Madi(int leftIdx, int rightIdx, int stateIdx) {
            this.leftIdx = leftIdx;
            this.rightIdx = rightIdx;
            this.stateIdx = stateIdx;
        }
    } // End of Madi class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_14677\\res.txt"));
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
        // ArrayDeque<int[]> que = new ArrayDeque<>();
        ArrayDeque<Madi> que = new ArrayDeque<>();
        boolean[][] isVisited = new boolean[N][N];
        int ans = 0;

        if (state[0] == arr[0]) {
            isVisited[1][0] = true;
            que.offer(new Madi(1, 0, 1));
        }

        if (state[0] == arr[N - 1]) {
            isVisited[0][1] = true;
            que.offer(new Madi(0, 1, 1));
        }


        while (!que.isEmpty()) {
            Madi cur = que.poll();

            ans = Math.max(ans, cur.leftIdx + cur.rightIdx);
            if (cur.leftIdx + cur.rightIdx >= N) continue;

            if (arr[cur.leftIdx] == state[cur.stateIdx] && cur.leftIdx + 1 < N && !isVisited[cur.leftIdx + 1][cur.rightIdx]) {
                isVisited[cur.leftIdx + 1][cur.rightIdx] = true;
                que.offer(new Madi(cur.leftIdx + 1, cur.rightIdx, (cur.stateIdx + 1) % MOD));
            }

            if (arr[N - cur.rightIdx - 1] == state[cur.stateIdx] && cur.rightIdx + 1 < N && !isVisited[cur.leftIdx][cur.rightIdx + 1]) {
                isVisited[cur.leftIdx][cur.rightIdx + 1] = true;
                que.offer(new Madi(cur.leftIdx, cur.rightIdx + 1, (cur.stateIdx + 1) % MOD));
            }
        }

        return ans;
    } // End of BFS()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine()) * 3;
        arr = br.readLine().toCharArray();
    } // End of input()
} // End of Main class
