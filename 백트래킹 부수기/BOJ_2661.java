package BOJ_2661;

import java.io.*;

public class BOJ_2661 {

    // https://www.acmicpc.net/problem/2661
    // input
    private static BufferedReader br;

    // variables
    private static int N;
    private static String ans;
    private static boolean flag;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_2661\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        // 1 2 3으로만 이루어져 있는 길이가 N인 좋은 수열들 중에서
        DFS(0, "");
        sb.append(ans);
        return sb.toString();
    } // End of solve()

    private static void DFS(int depth, String str) {
        StringBuilder sb;
        if (flag) return;

        if (depth == N) {
            if (ans.compareTo(str) > 0) {
                ans = str;
                flag = true;
            }
            return;
        }

        for (int i = 1; i <= 3; i++) {
            sb = new StringBuilder(str);
            sb.append(i);
            if (!isAbleCheck(sb.toString())) continue;
            DFS(depth + 1, sb.toString());
        }
    } // End of DFS()

    private static boolean isAbleCheck(String str) {
        // 문자열에서 서로 인접한 것 중에 동일한 수열이 있는지 확인하기

        int len = str.length();
        for (int i = 1; i <= len / 2; i++) {
            // 마지막 i개의 부분 수열과 그 앞의 i개의 부분 수열이 같은지 확인
            if (str.substring(len - i).equals(str.substring(len - 2 * i, len - i))) {
                return false; // 중복되는 부분 수열이 있으면 false 반환
            }
        }

        return true;
    } // End of isAbleCheck()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        flag = false;

        String max = "3".repeat(81);
        ans = max;
    } // End of input()
} // End of Main class
