package BOJ_2493;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.StringTokenizer;

public class BOJ_2493 {

    // https://www.acmicpc.net/problem/2493
    // input
    private static BufferedReader br;

    // variables
    private static int N;
    private static int[] arr;

    private static class Top {
        int num;
        int idx;

        private Top(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }
    } // End of Top class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_2493\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        ArrayDeque<Top> que = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            while (!que.isEmpty() && que.peekLast().num <= arr[i]) {
                que.removeLast();
            }

            if (que.isEmpty()) {
                sb.append(0);
            } else {

                Iterator<Top> iter = que.descendingIterator();
                while (iter.hasNext()) {
                    Top next = iter.next();
                    if (next.num >= arr[i]) {
                        sb.append(next.idx);
                        break;
                    }
                }
            }

            sb.append(' ');
            que.offerLast(new Top(arr[i], i + 1));
        }

        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    } // End of input()
} // End of Main class
