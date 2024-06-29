package BOJ_17265;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17256 {

    // https://www.acmicpc.net/problem/17265
    // input
    private static BufferedReader br;

    // variables
    private static int N;
    private static char[][] map;
    private static boolean[][] isVisited;
    private static ArrayDeque<Character> comb;
    private static int max, min;

    private static final int[] dirX = {0, 1};
    private static final int[] dirY = {1, 0};

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_17265\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        isVisited[0][0] = true;
        comb.offer(map[0][0]);
        DFS(0, 0);

        sb.append(max).append(' ').append(min);
        return sb.toString();
    } // End of solve()

    private static void DFS(int x, int y) {
        if (x == N - 1 && y == N - 1) {
            ArrayDeque<Character> copy = new ArrayDeque<>();
            copy.addAll(comb);
            int temp = comb.pollLast() - '0';
            int sum = temp;

            while (!comb.isEmpty()) {
                char op = comb.pollLast();
                int num = comb.pollLast() - '0';

                if (op == '+') {
                    sum += num;
                } else if (op == '-') {
                    sum -= num;
                } else if (op == '*') {
                    sum *= num;
                }
            }

            // 5, *, 4, +, 5, *, 5, +, 2
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            comb = copy;
            return;
        }


        for (int i = 0; i < 2; i++) {
            int nextX = x + dirX[i];
            int nextY = y + dirY[i];

            if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
                if (isVisited[nextX][nextY]) continue;
                isVisited[nextX][nextY] = true;
                comb.offerFirst(map[nextX][nextY]);
                DFS(nextX, nextY);
                comb.pollFirst();
                isVisited[nextX][nextY] = false;
            }
        }
    } // End of DFS()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        map = new char[N][N];
        isVisited = new boolean[N][N];
        comb = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken().charAt(0);
            }
        }
    } // End of input()
} // End of Main class
