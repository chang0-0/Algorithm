package BOJ_24509;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_24509 {

    // https://www.acmicpc.net/problem/24509
    // input
    private static BufferedReader br;

    // variables
    private static int N;

    private static class Score implements Comparable<Score> {
        int num;
        int score;

        private Score(int num, int score) {
            this.num = num;
            this.score = score;
        }

        @Override
        public int compareTo(Score o) {
            if (score == o.score) {
                return num - o.num;
            }
            return o.score - score;
        }
    } // End of Score class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_24509\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() throws IOException {
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        boolean[] isVisited = new boolean[N + 1];
        Score[] s1 = new Score[N + 1];
        Score[] s2 = new Score[N + 1];
        Score[] s3 = new Score[N + 1];
        Score[] s4 = new Score[N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            s1[i] = new Score(
                    num, Integer.parseInt(st.nextToken())
            );
            s2[i] = new Score(
                    num, Integer.parseInt(st.nextToken())
            );
            s3[i] = new Score(
                    num, Integer.parseInt(st.nextToken())
            );
            s4[i] = new Score(
                    num, Integer.parseInt(st.nextToken())
            );
        }

        sb.append(check(s1, isVisited)).append(' ');
        sb.append(check(s2, isVisited)).append(' ');
        sb.append(check(s3, isVisited)).append(' ');
        sb.append(check(s4, isVisited));
        return sb.toString();
    } // End of solve()

    private static int check(Score[] score, boolean[] isVisited) {
        Arrays.sort(score, 1, N + 1);

        for (int i = 1; i <= N; i++) {
            if (!isVisited[score[i].num]) {
                isVisited[score[i].num] = true;
                return score[i].num;
            }
        }

        return 0;
    } // End of check()
} // End of Main class
