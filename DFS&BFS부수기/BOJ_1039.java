package BOJ_1039;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_1039 {

    // https://www.acmicpc.net/problem/1039
    // input
    private static BufferedReader br;

    // variables
    private static int N, K, ans, Nlen;
    private static String Nstr;
    private static final int MAX = 1_000_001;

    private static class Num {
        String num;
        int count;

        private Num(String num, int count) {
            this.num = num;
            this.count = count;
        }
    } // End of Num class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_1039\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        BFS();
        sb.append(ans);
        return sb.toString();
    } // End of solve()

    private static void BFS() {
        ArrayDeque<Num> que = new ArrayDeque<>();
        boolean[][] isVisited = new boolean[MAX][K];
        que.offer(new Num(Nstr, 0));
        isVisited[N][0] = true;

        while (!que.isEmpty()) {
            Num cur = que.poll();

            for (int i = 0; i < Nlen - 1; i++) {
                for (int j = i + 1; j < Nlen; j++) {
                    if (i == 0 && cur.num.charAt(j) == '0') continue;
                    String swapStr = swap(cur.num, i, j);
                    int swapInt = Integer.parseInt(swapStr);

                    if(cur.count + 1 == K) {
                        ans = Math.max(ans, swapInt);
                        continue;
                    }

                    if (isVisited[swapInt][cur.count + 1]) continue;
                    isVisited[swapInt][cur.count + 1] = true;
                    que.offer(new Num(swapStr, cur.count + 1));
                }
            }
        }
    } // End of BFS()

    private static String swap(String str, int i, int j) {
        char[] chArr = str.toCharArray();
        char ch = chArr[i];
        chArr[i] = chArr[j];
        chArr[j] = ch;
        return new String(chArr);
    } // End of swap()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        ans = -1;

        Nstr = Integer.toString(N);
        Nlen = Nstr.length();
    } // End of input()
} // End of Main class
