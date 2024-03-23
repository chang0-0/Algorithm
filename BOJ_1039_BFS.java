package BOJ_1039;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_1039_BFS {

    // https://www.acmicpc.net/problem/1039
    // input
    private static BufferedReader br;

    // variables
    private static int N, K, M;
    private static String str;
    private static boolean[][] memo;

    private static class Num {
        int num;
        int count;

        private Num(int num, int count) {
            this.num = num;
            this.count = count;
        }
    } // End of Num class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_1039\\res.txt"));
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
        LinkedList<Num> que = new LinkedList<>();
        que.offer(new Num(N, 0));
        int ans = -1;

        while (!que.isEmpty()) {
            Num current = que.poll();

            if (current.count == K) {
                ans = Math.max(ans, current.num);
                continue;
            }

            String s = Integer.toString(current.num);
            for (int i = 0; i < M - 1; i++) {
                for (int j = i + 1; j < M; j++) {
                    if (i == 0 && s.charAt(j) == '0') continue;

                    int swapNum = swap(i, j, Integer.parseInt(s));

                    if (memo[swapNum][current.count + 1]) continue;
                    memo[swapNum][current.count + 1] = true;
                    que.offer(new Num(swapNum, current.count + 1));
                }
            }
        }

        return ans;
    } // End of BFS()

    private static int swap(int i, int j, int num) {
        char[] ch = Integer.toString(num).toCharArray();

        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;

        return Integer.parseInt(String.valueOf(ch));
    } // End of swap()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        str = Integer.toString(N);
        M = str.length();
        memo = new boolean[1_000_001][K + 1];
    } // End of input()
} // End of Main class
