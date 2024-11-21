package BOJ_31925;

import java.io.*;
import java.util.*;

public class BOJ_31925 {

    // https://www.acmicpc.net/problem/31925
    // input
    private static BufferedReader br;

    // variables
    private static int N;

    private static class Score implements Comparable<Score> {
        String name;
        int rank;

        private Score(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Score o) {
            return rank - o.rank;
        }

        @Override
        public String toString() {
            return "Score{" + name + ", " + rank + "}\n";
        }
    } // End of Score class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_31925\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() throws IOException {
        StringBuilder sb = new StringBuilder();

        List<Score> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            String status = st.nextToken();
            String isWinner = st.nextToken();
            int topRank = Integer.parseInt(st.nextToken());
            int apcRank = Integer.parseInt(st.nextToken());

            if (status.equals("jaehak") && isWinner.equals("notyet") && (topRank == -1 || topRank > 3)) {
                list.add(new Score(name, apcRank));
            }
        }

        Collections.sort(list);

        int size = Math.min(list.size(), 10);
        String[] names = new String[size];
        for (int i = 0; i < size; i++) {
            names[i] = list.get(i).name;
        }

        Arrays.sort(names);
        sb.append(size).append('\n');
        for (String name : names) {
            sb.append(name).append('\n');
        }

        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
    } // End of input()
} // End of Main class
