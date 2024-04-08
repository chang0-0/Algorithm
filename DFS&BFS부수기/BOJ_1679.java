package BOJ_1679;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_1679 {

    // https://www.acmicpc.net/problem/1679
    // input
    private static BufferedReader br;

    // variables
    private static int N, K, max;
    private static int[] arr;

    private static class Game {
        int num;
        int count;

        public Game(int num, int count) {
            this.num = num;
            this.count = count;
        }
    } // End of Game class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_1679\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();


        boolean[] ret = BFS();
        int idx = 1;
        for (; ; ) {
            if (!ret[idx]) {
                break;
            }
            idx++;
        }

        if (idx % 2 == 0) {
            sb.append("holsoon win at ").append(idx);
        } else {
            sb.append("jjaksoon win at ").append(idx);
        }

        return sb.toString();
    } // End of solve()

    private static boolean[] BFS() {
        LinkedList<Game> que = new LinkedList<>();
        boolean[] isVisited = new boolean[(max * K) + 1];

        for (int i = 0; i < N; i++) {
            que.offer(new Game(arr[i], 1));
            isVisited[arr[i]] = true;
        }

        while (!que.isEmpty()) {
            Game current = que.poll();

            if (current.count < K) {
                for (int next : arr) {
                    if (isVisited[next + current.num]) continue;
                    isVisited[next + current.num] = true;
                    que.offer(new Game(next + current.num, current.count + 1));
                }
            }
        }

        return isVisited;
    } // End of BFS()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        max = -1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        K = Integer.parseInt(br.readLine());
    } // End of input()
} // End of Main class