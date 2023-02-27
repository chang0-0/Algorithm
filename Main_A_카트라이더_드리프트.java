import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_A_카트라이더_드리프트 {
    private static int redScore = 0;
    private static int blueScore = 0;

    private static int[] scoreArr = {10, 8, 6, 5, 4, 3, 2, 1, 0};
    private static PriorityQueue<Time> pque = new PriorityQueue<>();

    private static class Time implements Comparable<Time> {
        int M;
        int SS;
        int sss;
        String team;

        public Time(int m, int SS, int sss, String team) {
            M = m;
            this.SS = SS;
            this.sss = sss;
            this.team = team;
        }

        @Override
        public String toString() {
            return "Time{" +
                    "M=" + M +
                    ", SS=" + SS +
                    ", sss=" + sss +
                    ", team='" + team + '\'' +
                    '}';
        }

        @Override
        public int compareTo(Time o) {
            if (M == o.M) {
                if (SS == o.SS) {
                    return sss - o.sss;
                }
                return SS - o.SS;
            }

            return M - o.M;
        }
    } // End of Time class

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/a.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int i = 0; i < 8; i++) {
            st = new StringTokenizer(br.readLine(), ":");

            int m = Integer.parseInt(st.nextToken());
            int ss = Integer.parseInt(st.nextToken());

            String temp = st.nextToken();
            int sss = Integer.parseInt(temp.substring(0, 3));
            String team = temp.substring(temp.length() - 1);

            pque.offer(new Time(m, ss, sss, team));
        }

        int size = pque.size();
        for (int i = 0; i < size; i++) {
            Time temp = pque.poll();

            if(temp.team.equals("R")) {
                redScore += scoreArr[i];
            } else {
                blueScore += scoreArr[i];
            }
        }

        if (redScore > blueScore) {
            sb.append("Red");
        } else {
            sb.append("Blue");
        }

        bw.write(sb.toString());
        bw.close();
    } // End of main
} // End of Main class
