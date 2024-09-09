package BOJ_1590;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1590 {

    // https://www.acmicpc.net/problem/1590
    // input
    private static BufferedReader br;

    // variables

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_1590\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() throws IOException {
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        long min = Long.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());


            int time = s;
            for (int j = 0; j < c; j++) {
                if(time < T) {
                    time += e;
                    continue;
                }

                if (time - T >= 0 && time - T < min) {
                    min = time - T;
                } else if (time > min) break;

                time += e;
            }
        }

        if(min == Long.MAX_VALUE) {
            min = -1;
        }


        sb.append(min);
        return sb.toString();
    } // End of solve()
} // End of Main class
