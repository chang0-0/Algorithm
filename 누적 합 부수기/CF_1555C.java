package CF_1555C;

import java.io.*;
import java.util.StringTokenizer;

public class CF_1555C {

    // https://chatgpt.com/c/6adb34fd-1520-83ee-b7bb-cca1e17431bd
    // input
    private static BufferedReader br;

    // variables
    private static int N;
    private static int[] topPrefix;
    private static int[] bottomPrefix;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\CF_1555C\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            input();

            bw.write(solve());
        }

        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        int bobMinestScore = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            int bobTopSum = topPrefix[N] - topPrefix[i];
            int bobBottomSum = bottomPrefix[i - 1];

            int bobMaxScore = Math.max(bobTopSum, bobBottomSum);
            bobMinestScore = Math.min(bobMinestScore, bobMaxScore);
        }

        sb.append(bobMinestScore).append('\n');
        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        topPrefix = new int[N + 1];
        bottomPrefix = new int[N + 1];

        for (int i = 0; i < 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int temp = Integer.parseInt(st.nextToken());

                if (i == 0) {
                    topPrefix[j] = topPrefix[j - 1] + temp;
                } else {
                    bottomPrefix[j] = bottomPrefix[j - 1] + temp;
                }
            }
        }
    } // End of input()
} // End of Main class
