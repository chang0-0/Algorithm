package BOJ_2304;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2304 {

    // input
    private static BufferedReader br;

    // variables
    private static int N, maxHeight, maxLen, minLen;
    private static Pillar[] pillars;

    private static class Pillar implements Comparable<Pillar> {
        int l;
        int h;

        private Pillar(int l, int h) {
            this.l = l;
            this.h = h;
        }

        @Override
        public int compareTo(Pillar o) {
            return l - o.l;
        }

        @Override
        public String toString() {
            return "Pillar{" +
                    "l=" + l +
                    ", h=" + h +
                    '}' + '\n';
        }
    } // End of Pillar class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_2304\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        Arrays.sort(pillars);
        int max = 0;

        for (int i = 0; i < N; i++) {
            Pillar current = pillars[i];

            if (max < current.h) {
                max = current.h;
            }
        }


        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        pillars = new Pillar[N];
        maxLen = -1;
        minLen = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            pillars[i] = new Pillar(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            if (maxHeight <= pillars[i].h) {
                maxHeight = pillars[i].h;
            }

            maxLen = Math.max(maxLen, pillars[i].l);
            minLen = Math.min(minLen, pillars[i].l);
        }
        maxLen += 1;
    } // End of input()
} // End of Main class
