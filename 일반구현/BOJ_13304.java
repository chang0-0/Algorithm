package BOJ_13304;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_13304 {

    // https://www.acmicpc.net/problem/13304
    // input
    private static BufferedReader br;

    // variables
    private static int N, K, ans;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_13304\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        sb.append(ans);
        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[][] rooms = new int[7][2];
        ans = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken());

            if (grade == 1 || grade == 2) {
                grade = 1;

                rooms[grade][0]++;
                if (rooms[grade][0] == 1) {
                    ans++;
                } else if (rooms[grade][0] == K) {
                    rooms[grade][0] = 0;
                }
            } else if (grade == 3 || grade == 4) {
                grade = 3;

                rooms[grade][gender]++;
                if (rooms[grade][gender] == 1) {
                    ans++;
                } else if (rooms[grade][gender] == K) {
                    rooms[grade][gender] = 0;
                }
            } else if (grade == 5 || grade == 6) {
                grade = 5;

                rooms[grade][gender]++;
                if (rooms[grade][gender] == 1) {
                    ans++;
                } else if (rooms[grade][gender] == K) {
                    rooms[grade][gender] = 0;
                }
            }
        }
    } // End of input()
} // End of Main class
