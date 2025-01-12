package BOJ_6443;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class BOJ_6443 {

    // https://www.acmicpc.net/problem/6443
    // input
    private static BufferedReader br;

    // variables
    private static int N, M;
    private static char[] chArr;
    private static HashSet<String> set;
    private static boolean[] isVisited;
    private static StringBuilder ans;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_6443\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() throws IOException {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            chArr = br.readLine().toCharArray();
            M = chArr.length;
            Arrays.sort(chArr);

            StringBuilder sb2 = new StringBuilder();
            for (int j = 0; j < M; j++) {
                sb2.append(chArr[j]);
            }

            set.add(sb2.toString());
        }

        for (String str : set) {
            M = str.length();
            isVisited = new boolean[M];
            chArr = str.toCharArray();
            DFS(0, new StringBuilder());
        }

        sb.append(ans.toString());
        return sb.toString();
    } // End of solve()

    private static void DFS(int depth, StringBuilder sb) {
        if (depth == M) {
            ans.append(sb).append('\n');
            return;
        }

        for (int i = 0; i < M; i++) {
            if (isVisited[i]) continue;
            if (i > 0 && chArr[i] == chArr[i - 1] && !isVisited[i - 1]) continue;

            isVisited[i] = true;
            sb.append(chArr[i]);
            DFS(depth + 1, sb);
            // 마지막 문자 다시 제거,
            sb.deleteCharAt(sb.length() - 1);
            isVisited[i] = false;
        }
    } // End of DFS()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        set = new LinkedHashSet<>();
        ans = new StringBuilder();
    } // End of input()
} // End of Main class
