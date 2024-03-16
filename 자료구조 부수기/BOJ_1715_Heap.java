package BOJ_1715;

import java.io.*;
import java.util.PriorityQueue;

public class BOJ_1715_Heap {

    // https://www.acmicpc.net/problem/1715
    // input
    private static BufferedReader br;

    // variables
    private static int N;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_1715\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> pque = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pque.offer(arr[i]);
        }

        int sum = 0;
        while (pque.size() >= 2) {
            int a = pque.poll();
            int b = pque.poll();
            sum += a + b;
            pque.offer(a + b);
        }


        sb.append(sum);
        return sb.toString();
    } // End of solve()


    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
    } // End of input()
} // End of Main class
