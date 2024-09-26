package BOJ_28107;

import java.io.*;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_28107 {

    // https://www.acmicpc.net/problem/28107
    // input
    private static BufferedReader br;

    // variables
    private static int N, M;
    private static HashMap<Integer, ArrayDeque<Integer>> sushiMap;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_28107\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() throws IOException {
        StringBuilder sb = new StringBuilder();

        int[] ans = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int j = 0; j < M; j++) {
            int temp = Integer.parseInt(st.nextToken());
            ArrayDeque<Integer> que = sushiMap.get(temp);
            if (que == null || que.isEmpty()) {
                continue;
            }

            int waiter = que.poll();
            ans[waiter]++;
        }

        for (int j = 1; j <= N; j++) {
            sb.append(ans[j]).append(' ');
        }
        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sushiMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());

            ArrayDeque<Integer> que = new ArrayDeque<>();
            for (int j = 0; j < count; j++) {
                int temp = Integer.parseInt(st.nextToken());

                if (sushiMap.get(temp) == null) {
                    sushiMap.put(temp, new ArrayDeque<>());
                }
                sushiMap.get(temp).add(i + 1);
            }
        }
    } // End of input()
} // End of Main class
