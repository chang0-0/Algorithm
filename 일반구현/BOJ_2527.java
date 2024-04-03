package BOJ_2527;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2527 {

    // https://www.acmicpc.net/problem/2527
    // input
    private static BufferedReader br;

    // variables
    private static int N;
    private static Rectangular R1, R2;

    private static class Rectangular {
        int x;
        int y;
        int p;
        int q;

        public Rectangular(int x, int y, int p, int q) {
            this.x = x;
            this.y = y;
            this.p = p;
            this.q = q;
        }

        @Override
        public String toString() {
            return "Rectangular{" +
                    "x=" + x +
                    ", y=" + y +
                    ", p=" + p +
                    ", q=" + q +
                    '}';
        }
    } // End of Rectagular class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_2527\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 4; i++) {
            input();

            bw.write(solve());
        }

        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        Rectangular com = new Rectangular(
                Math.max(R1.x, R2.x), Math.max(R1.y, R2.y), Math.min(R1.p, R2.p), Math.min(R1.q, R2.q)
        );

        int diffX = com.p - com.x;
        int diffY = com.q - com.y;


        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        R1 = new Rectangular(
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken())
        );

        R2 = new Rectangular(
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken())
        );

    } // End of input()
} // End of Main class
