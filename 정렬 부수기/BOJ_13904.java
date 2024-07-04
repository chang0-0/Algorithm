package BOJ_13904;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_13904 {

    // https://www.acmicpc.net/problem/13904
    // input
    private static BufferedReader br;

    // variables
    private static int N;
    private static Task[] tasks;

    private static class Task implements Comparable<Task> {
        int d;
        int w;

        private Task(int d, int w) {
            this.d = d;
            this.w = w;
        }

        @Override
        public int compareTo(Task o) {
            if (d == o.d) {
                return o.w - w;
            }
            return d - o.d;
        }
    } // End of Task class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_13904\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        // 하루에 과제 하나를 끝낼 수 있다.
        // 얻을 수 있는 점수의 최대값

        int max = 0;
        Arrays.sort(tasks);
        PriorityQueue<Integer> pque = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            pque.offer(tasks[i].w);
            max += tasks[i].w;

            if (pque.size() > tasks[i].d) {
                max -= pque.poll();
            }
        }

        sb.append(max);
        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        tasks = new Task[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken()); // 마감일까지 남은 일수
            int w = Integer.parseInt(st.nextToken()); // 과제 점수

            tasks[i] = new Task(d, w);
        }

    } // End of input()
} // End of Main class
