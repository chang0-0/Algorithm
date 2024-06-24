package BOJ_2697;

import java.io.*;
import java.util.Arrays;

public class BOJ_2697 {

    // https://www.acmicpc.net/problem/2697
    // input
    private static BufferedReader br;

    // variables
    private static final String BIG = "BIGGEST";

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_2697\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            bw.write(solve());
        }

        bw.close();
    } // End of main()

    private static String solve() throws IOException {
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        char[] chArr = str.toCharArray();
        int N = str.length();

        for (int i = N - 1; i >= 1; i--) {
            int point = chArr[i] - '0';

            // point보다 작은 값을 만나면 중단
            if (chArr[i - 1] - '0' < point) {
                int target = chArr[i - 1] - '0';

                StringBuilder build = new StringBuilder();
                for (int j = i; j < N; j++) {
                    build.append(chArr[j]);
                }

                char[] tempChArr = build.toString().toCharArray();
                Arrays.sort(tempChArr);
                int len = tempChArr.length;

                // chArr[i - 1]보다 큰 값 나오면 바로 교환
                for (int j = 0; j < len; j++) {
                    if (tempChArr[j] - '0' > target) {
                        char temp = chArr[i - 1];
                        chArr[i - 1] = tempChArr[j];
                        tempChArr[j] = temp;
                        break;
                    }
                }

                for (int j = 0; j <= i - 1; j++) {
                    sb.append(chArr[j]);
                }

                for (int j = 0; j < len; j++) {
                    sb.append(tempChArr[j]);
                }
                break;
            }
        }

        if (sb.length() == 0) {
            sb.append(BIG);
        }
        sb.append('\n');

        return sb.toString();
    } // End of solve()
} // End of Main class
