package BOJ_27497;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_27497 {

    // https://www.acmicpc.net/problem/27497
    // input
    private static BufferedReader br;

    // variables
    private static int N;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_27497\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() throws IOException {
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        ArrayDeque<Character> que = new ArrayDeque<>();
        ArrayDeque<Boolean> offerQue = new ArrayDeque<>();

        boolean flag = false;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            char ch = ' ';
            if (a != 3) {
                ch = st.nextToken().charAt(0);
            }

            if (a == 1) {
                que.offerLast(ch);
                offerQue.offer(false);
            } else if (a == 2) {
                que.offerFirst(ch);
                offerQue.offer(true);
            } else {

                if (!offerQue.isEmpty() && offerQue.pollLast() == true) {
                    que.pollFirst();
                } else {
                    que.pollLast();
                }
            }
        }

        if (que.isEmpty()) {
            sb.append(0);
        } else {
            while (!que.isEmpty()) {
                sb.append(que.poll());
            }
        }


        return sb.toString();
    } // End of solve()
} // End of Main class
