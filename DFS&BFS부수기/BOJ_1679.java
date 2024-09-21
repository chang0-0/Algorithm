package BOJ_1679;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1679 {

    // https://www.acmicpc.net/problem/1679
    // input
    private static BufferedReader br;

    // variables
    private static int N, K, max;
    private static int[] arr;

    private static class Number {
        int num;
        int count;

        private Number(int num, int count) {
            this.num = num;
            this.count = count;
        }
    } // End of Number class

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

        // 누가 몇번째에서 이겼는지 출력하기
        // 만들 수 없는 수 출력하기
        boolean[] ret = BFS();
        int idx = 1;
        for (; ; ) {
            if (!ret[idx]) break;
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
        ArrayDeque<Number> que = new ArrayDeque<>();
        boolean[] isVisited = new boolean[(max * K) + 1];

        for (int i = 0; i < N; i++) {
            que.offer(new Number(arr[i], 1));
            isVisited[arr[i]] = true;
        }

        while (!que.isEmpty()) {
            Number cur = que.poll();
            isVisited[cur.num] = true;

            if (cur.count < K) {
                for (int next : arr) {
                    if (isVisited[next + cur.num]) continue;
                    isVisited[next + cur.num] = true;
                    que.offer(new Number(next + cur.num, cur.count + 1));
                }
            }
        }

        return isVisited;
    } // End of BFS()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        max = arr[N - 1];
        K = Integer.parseInt(br.readLine());
    } // End of input()
} // End of Main class
