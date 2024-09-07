package BOJ_15720;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_15720 {

    // https://www.acmicpc.net/problem/15720
    // input
    private static BufferedReader br;

    // variables
    private static int B, C, D;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_15720\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() throws IOException {
        StringBuilder sb = new StringBuilder();

        int B, C, D;
        StringTokenizer st = new StringTokenizer(br.readLine());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        int sum = 0;
        int min = Math.min(B, Math.min(C, D));

        Integer[] burgers = new Integer[B];
        Integer[] sides = new Integer[C];
        Integer[] drinks = new Integer[D];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i++) {
            burgers[i] = Integer.parseInt(st.nextToken());
            sum += burgers[i];
        }
        Arrays.sort(burgers, Collections.reverseOrder());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            sides[i] = Integer.parseInt(st.nextToken());
            sum += sides[i];
        }
        Arrays.sort(sides, Collections.reverseOrder());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < D; i++) {
            drinks[i] = Integer.parseInt(st.nextToken());
            sum += drinks[i];
        }
        Arrays.sort(drinks, Collections.reverseOrder());
        sb.append(sum).append('\n');

        int temp = 0;
        for (int i = 0; i < min; i++) {
            temp += (int) ((burgers[i] + sides[i] + drinks[i]) * 0.9);
        }

        for (int i = min; i < B; i++) {
            temp += burgers[i];
        }

        for (int i = min; i < C; i++) {
            temp += sides[i];
        }

        for (int i = min; i < D; i++) {
            temp += drinks[i];
        }

        sb.append(temp);
        return sb.toString();
    } // End of solve()
} // End of Main class
