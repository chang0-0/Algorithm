package BOJ_19947;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_19947 {

    // https://www.acmicpc.net/problem/19947
    // input
    private static BufferedReader br;

    // variables
    private static int N, M;

    private static class Finance {
        int money;
        int option;
        int year;

        private Finance(int money, int option, int year) {
            this.money = money;
            this.option = option;
            this.year = year;
        }
    } // End of Finance class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_19947\\res.txt"));
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
        ArrayDeque<Finance> que = new ArrayDeque<>();
        que.offer(new Finance(N, 0, 0));
        int[][] memo = new int[M + 1][4];
        for (int i = 0; i <= M; i++) {
            Arrays.fill(memo[i], -1);
        }
        int ans = N;

        while (!que.isEmpty()) {
            Finance cur = que.poll();

            if (cur.year == M) {
                ans = Math.max(ans, cur.money);
                continue;
            }
            if (memo[cur.year][cur.option] != -1) continue;
            memo[cur.year][cur.option] = cur.money;


            // 1번 투자
            que.offer(new Finance((int) (cur.money * 1.05), 1, cur.year + 1));

            // 2번 투자
            if (cur.year + 3 <= M) {
                que.offer(new Finance((int) (cur.money * 1.2), 2, cur.year + 3));
            }

            if (cur.year + 5 <= M) {
                que.offer(new Finance((int) (cur.money * 1.35), 3, cur.year + 5));
            }
        }


        return ans;
    } // End of BFS()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
    } // End of input()
} // End of Main class
