package BOJ_29160;

import java.io.*;
import java.util.*;

public class BOJ_29160 {

    // https://www.acmicpc.net/problem/29160
    // input
    private static BufferedReader br;

    // variables
    private static int N, K;
    private static List<PriorityQueue<Integer>> adjList;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_29160\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        while (K-- > 0) {
            for (int i = 1; i <= 11; i++) {
                PriorityQueue<Integer> pque = adjList.get(i);
                if (!pque.isEmpty()) {
                    int val = pque.poll();

                    if (val-- < 0) {
                        val = 0;
                    }

                    pque.offer(val);
                }
            }
        }

        int sum = 0;
        for (int i = 1; i <= 11; i++) {
            PriorityQueue<Integer> pque = adjList.get(i);
            if (!pque.isEmpty()) {
                sum += pque.poll();
            }
        }

        sb.append(sum);
        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        adjList = new ArrayList<>();
        for (int i = 0; i <= 11; i++) {
            adjList.add(new PriorityQueue<>(Collections.reverseOrder()));
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int positionNum = Integer.parseInt(st.nextToken());
            int playerVal = Integer.parseInt(st.nextToken());
            adjList.get(positionNum).offer(playerVal);
        }
    } // End of input()
} // End of Main class
