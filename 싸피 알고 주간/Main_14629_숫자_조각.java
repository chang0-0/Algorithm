import java.io.*;

public class Main_14629_숫자_조각 {
    private static final long MAXLIMIT = 9876543210L;
    static boolean visit[];
    static long N;
    static String ans[];
    static int len;
    static long min = Long.MAX_VALUE;
    static String result;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/14629.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String strN = br.readLine();
        N = Long.parseLong(strN);
        len = strN.length();
        if (N >= MAXLIMIT) { // 숫자의 길이가 10이상일 경우, 숫자로 만들 수 있는 최대값이 됨
            System.out.println("9876543210");
            return;
        }

        ans = new String[len];
        visit = new boolean[10];

        DFS(0, len);
        if (len > 1) {
            ans = new String[len - 1];
            DFS(0, len - 1);

            ans = new String[len + 1];
            DFS(0, len + 1);
        }

        System.out.println(Long.parseLong(result));
    } // End of main

    private static void DFS(int depth, int depthLimit) { // 백트래킹
        if (depth == depthLimit) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < depthLimit; i++) {
                sb.append(ans[i]);
            }

            String temp = sb.toString();
            long diff = Math.abs(N - Long.parseLong(temp));
            if (min > diff) {
                min = diff;
                result = temp;
            }

            return;
        }

        for (int i = 0; i < 10; i++) {
            if (visit[i])
                continue;
            visit[i] = true;
            ans[depth] = Integer.toString(i);
            DFS(depth + 1, depthLimit);
            visit[i] = false;
        }

    } // End of DFS
} // End of Main class