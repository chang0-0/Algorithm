package BOJ_1039;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_1039 {

    // https://www.acmicpc.net/problem/1039
    // input
    private static BufferedReader br;

    // variables
    private static int N, K, len;
    private static char[] chArr;
    private static boolean[][] memo;
    private static final int MAX = 1_000_001;

    private static class Swap {
        String str;
        int swapCount;

        private Swap(String str, int swapCount) {
            this.swapCount = swapCount;
            this.str = str;
        }
    } // End of Swap class

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
        ArrayDeque<Swap> que = new ArrayDeque<>();
        que.offer(new Swap(new String(chArr), 0));
        int ans = -1;

        while (!que.isEmpty()) {
            Swap cur = que.poll();

            if (cur.swapCount == K) {
                ans = Math.max(ans, Integer.parseInt(cur.str));
                continue;
            }

            for (int i = 0; i < len - 1; i++) {
                for (int j = i + 1; j < len; j++) {
                    if (cur.str.charAt(j) == '0' && i == 0) {
                        continue;
                    }

                    String temp = swap(cur.str.toCharArray(), i, j);
                    if (memo[Integer.parseInt(temp)][cur.swapCount + 1]) continue;
                    que.offer(new Swap(temp, cur.swapCount + 1));
                    memo[Integer.parseInt(temp)][cur.swapCount + 1] = true;
                }
            }
        }

        return ans;
    } // End of BFS()

    private static String swap(char[] ch, int i, int j) {
        char temp = ch[j];
        ch[j] = ch[i];
        ch[i] = temp;
        return new String(ch);
    } // End of swap

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        chArr = st.nextToken().toCharArray();
        N = Integer.parseInt(new String(chArr));
        K = Integer.parseInt(st.nextToken());
        len = chArr.length;
        memo = new boolean[MAX][K + 1];
    } // End of input()
} // End of Main class
