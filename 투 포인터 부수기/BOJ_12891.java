package BOJ_12891;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_12891 {

    // https://shinhandigital.recruiter.co.kr/career/jobs/29611
    // input
    private static BufferedReader br;

    // variables
    private static int S, P;
    private static String str;
    private static int[] minArr = new int[4];

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_12891\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        int ans = 0;
        for (int i = 0; i < S; i++) {
            int idx = countIdx(str.charAt(i));
            if (idx >= 0) {
                minArr[idx]--;
            }

            if (i >= P) {
                idx = countIdx(str.charAt(i - P));
                if (idx >= 0) {
                    minArr[idx]++;
                }
            }

            if (i >= P - 1 && check()) {
                ans++;
            }
        }

        sb.append(ans);
        return sb.toString();
    } // End of solve()

    private static int countIdx(char ch) {
        if (ch == 'A') {
            return 0;
        } else if (ch == 'C') {
            return 1;
        } else if (ch == 'G') {
            return 2;
        } else {
            return 3;
        }
    } // End of countIdx()

    private static boolean check() {
        for (int i = 0; i < 4; i++) {
            if (minArr[i] > 0) {
                return false;
            }
        }
        return true;
    } // End of check()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        str = br.readLine();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            minArr[i] = Integer.parseInt(st.nextToken());
        }
    } // End of input()
} // End of Main class
