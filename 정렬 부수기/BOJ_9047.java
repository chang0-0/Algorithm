package BOJ_9047;

import java.io.*;
import java.util.Arrays;

public class BOJ_9047 {

    // https://www.acmicpc.net/problem/9047
    // input
    private static BufferedReader br;

    // variables
    private static int N;
    private static final int TARGET = 6174;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_9047\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(br.readLine());
        while (k-- > 0) {
            bw.write(solve());
        }
        ;
        bw.close();
    } // End of main()

    private static String solve() throws IOException {
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());
        int ans = 0;
        while (num != TARGET) {
            int[] digits = new int[4];
            for (int i = 0; i < 4; i++) {
                digits[i] = num % 10;
                num /= 10;
            }
            Arrays.sort(digits);

            int min = 0;
            int max = 0;
            for (int i = 0; i < 4; i++) {
                min = min * 10 + digits[i];
                max = max * 10 + digits[3 - i];
            }

            num = max - min;
            ans++;
        }

        sb.append(ans).append('\n');
        return sb.toString();
    } // End of solve()
} // End of Main class
