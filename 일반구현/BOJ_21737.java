package BOJ_21737;

import java.io.*;
import java.util.ArrayDeque;

public class BOJ_21737 {

    // https://www.acmicpc.net/problem/21737
    // input
    private static BufferedReader br;

    // variables
    private static int N;
    private static String str;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_21737\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        int len = str.length();
        StringBuilder num = new StringBuilder();
        ArrayDeque<String> que = new ArrayDeque<>();

        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);

            if (ch - '0' >= 0 && ch - '0' <= 9) {
                num.append(ch);
            } else {
                if (num.length() != 0) {
                    int temp = Integer.parseInt(num.toString());
                    que.offerLast(Integer.toString(temp));
                    num = new StringBuilder();
                }

                if (que.size() >= 3) {
                    // 계산 먼저
                    int temp = calc(que);
                    que.clear();
                    que.offerLast(Integer.toString(temp));
                }

                if (ch == 'C') {
                    sb.append(que.peek()).append(' ');
                } else {
                    que.offer(Character.toString(ch));
                }

            }
        }

        if (sb.length() == 0) {
            sb.append("NO OUTPUT");
        }

        return sb.toString();
    } // End of solve()

    private static int calc(ArrayDeque<String> que) {
        int num = Integer.parseInt(que.poll());
        String op = que.poll();
        int num2 = Integer.parseInt(que.poll());
        int ret = 0;

        if (op.equals("S")) {
            ret = num - num2;
        } else if (op.equals("P")) {
            ret = num + num2;
        } else if (op.equals("M")) {
            ret = num * num2;
        } else if (op.equals("U")) {
            ret = num / num2;
        }

        return ret;
    } // End of calc()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        str = br.readLine();
    } // End of input()
} // End of Main class
