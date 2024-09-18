package BOJ_30020;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_30020 {

    // https://www.acmicpc.net/problem/30020
    // input
    private static BufferedReader br;

    // variables
    private static int A, B;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_30020\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();


        int count = 0;
        boolean flag = false;
        while (true) {
            if (A <= 0 || B <= 0) {
                flag = true;
                break;
            }

            if (A - B == 1) {
                count++;
                for (int i = 0; i < A - 1; i++) {
                    sb.append('a').append('b');
                }
                sb.append('a').append('\n');
                break;
            } else {
                A -= 2;
                B -= 1;
                sb.append("aba").append('\n');
                count++;
            }
        }

        if (flag) {
            sb = new StringBuilder();
            sb.append("NO");
            return sb.toString();
        }


        sb.insert(0, "YES" + "\n" + count + "\n");
        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
    } // End of input()
} // End of Main class
