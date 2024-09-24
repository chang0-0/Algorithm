package BOJ_13417;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_13417 {

    // https://www.acmicpc.net/problem/1039
    // input
    private static BufferedReader br;

    // variables

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_13417\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            bw.write(solve());
        }

        bw.close();
    } // End of main()

    private static String solve() throws IOException {
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        ArrayDeque<Character> que = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        char ch = st.nextToken().charAt(0);
        que.offer(ch);

        for (int i = 0; i < N - 1; i++) {
            ch = st.nextToken().charAt(0);

            char first = que.peekFirst();
            if (first >= ch) {
                que.offerFirst(ch);
            } else {
                que.offer(ch);
            }
        }

        for (char temp : que) {
            sb.append(temp);
        }

        sb.append('\n');
        return sb.toString();
    } // End of solve()
} // End of Main class
