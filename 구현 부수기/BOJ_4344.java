package BOJ_4344;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_4344 {

    // https://www.acmicpc.net/problem/4344
    // input
    private static BufferedReader br;

    // variables
    private static int N;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_4344\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() throws IOException {
        StringBuilder sb = new StringBuilder();

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int count = Integer.parseInt(st.nextToken());
            int sum = 0;
            int[] arr = new int[count];
            for (int i = 0; i < count; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                sum += arr[i];
            }

            double avg = (double) sum / count;
            int count2 = 0;
            for (int i = 0; i < count; i++) {
                if (arr[i] > avg) {
                    count2++;
                }
            }

            double rate = (double) (count2 * 100) / count;
            String format = String.format("%.3f%%", rate);
            sb.append(format).append('\n');
        }


        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
    } // End of input()
} // End of Main class
