package BOJ_1039;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BOJ_1039_교환_BFS {

    // https://www.acmicpc.net/problem/1039
    // input
    private static BufferedReader br;

    // variables
    private static int N, K;
    private static boolean[][] memo;

    private static class Pair {
        int num;
        int swapCount;

        private Pair(int num, int swapCount) {
            this.num = num;
            this.swapCount = swapCount;
        }
    } // End of Pair class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_1039\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        sb.append(BFS());
        return sb.toString();
    } // End of solve()

    private static int BFS() {
        Queue<Pair> que = new LinkedList<>();
        que.offer(new Pair(N, 0));
        memo[N][0] = true;
        int ans = -1;

        String strN = Integer.toString(N);
        int strNLen = strN.length();

        while (!que.isEmpty()) {
            Pair nowPair = que.poll();

            if (nowPair.swapCount == K) {
                ans = Math.max(ans, nowPair.num);
                continue;
            }

            String numStr = Integer.toString(nowPair.num);
            for (int i = 0; i < strNLen - 1; i++) {
                for (int j = i + 1; j < strNLen; j++) {
                    // 가장 앞자리에 0이 오는경우를 제거
                    if (i == 0 && numStr.charAt(j) == '0') continue;

                    // 바꾼 숫자가 이미 방문한 경우 통과.
                    int swapNum = swap(nowPair.num, i, j);

                    if (memo[swapNum][nowPair.swapCount + 1]) continue;
                    memo[swapNum][nowPair.swapCount + 1] = true;
                    que.offer(new Pair(swapNum, nowPair.swapCount + 1));
                }
            }
        }

        return ans;
    } // End of BFS()

    private static int swap(int num, int i, int j) {
        char[] arr = Integer.toString(num).toCharArray();
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return Integer.parseInt(new String(arr));
    } // End of swap()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        memo = new boolean[1_000_001][K + 1];
    } // End of input()
} // End of Main class
