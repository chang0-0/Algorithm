package BOJ_2810;

import java.io.*;

public class BOJ_2810 {

    // https://www.acmicpc.net/problem/2810
    // input
    private static BufferedReader br;

    // variables
    private static int N;
    private static char[] chArr;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_2810\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        // 사용할 수 있는 컵 홀더의 개수를 파악하자
        int holder = 1;
        for (int i = 0; i < N; i++) {
            if (chArr[i] == 'L') {
                i++;
            }
            holder++;
        }

        sb.append(Math.min(holder, N));
        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        chArr = br.readLine().toCharArray();
    } // End of input()
} // End of Main class
