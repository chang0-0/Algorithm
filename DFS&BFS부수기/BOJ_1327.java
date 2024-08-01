package BOJ_1327;

import java.io.*;
import java.util.*;

public class BOJ_1327 {

    // https://www.acmicpc.net/problem/1327
    // input
    private static BufferedReader br;

    // variables
    private static int N, K;
    private static char[] arr, clone;
    private static String arrStr, cloneStr;

    private static class Swap {
        String str;
        int cnt;

        private Swap(String str, int cnt) {
            this.str = str;
            this.cnt = cnt;
        }
    } // End of Swap class


    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_1327\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        clone = arr.clone();
        Arrays.sort(arr);

        arrStr = new String(arr);
        cloneStr = new String(clone);

        int ret = BFS();
        sb.append(ret);
        return sb.toString();
    } // End of solve()

    private static int BFS() {
        ArrayDeque<Swap> que = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();
        que.offer(new Swap(cloneStr, 0));
        // BFS를 통한 완탐인데, 가지치기를 포함

        while (!que.isEmpty()) {
            Swap cur = que.poll();

            if (arrStr.equals(cur.str)) return cur.cnt;

            if (set.add(Integer.parseInt(cur.str))) {
                for (int i = 0; i <= N - K; i++) {
                    que.offer(new Swap(makeStr(cur.str, i, i + K), cur.cnt + 1));
                }
            }
        }

        return -1;
    } // End of BFS()

    private static String makeStr(String str, int i, int j) {
        StringBuilder sb = new StringBuilder();

        sb.append(str, 0, i);
        String temp = str.substring(i, j);
        for (int k = K - 1; k >= 0; k--) {
            sb.append(temp.charAt(k));
        }

        sb.append(str, j, str.length());
        return sb.toString();
    } // End of makeStr()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new char[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
    } // End of input()
} // End of Main class
