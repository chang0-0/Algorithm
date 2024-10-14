package BOJ_1065;

import java.io.*;

public class BOJ_1065 {

    // https://www.acmicpc.net/problem/1065
    // input
    private static BufferedReader br;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_1065\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() throws IOException {
        StringBuilder sb = new StringBuilder();


        int N = Integer.parseInt(br.readLine());
        if (N < 100) {
            sb.append(N);
            return sb.toString();
        }

        int ans = 99;
        for (int i = 100; i <= N; i++) {
            if (check(i)) {
                ans++;
            }
        }

        sb.append(ans);
        return sb.toString();
    } // End of solve()

    private static boolean check(int num) {
        int hundreds = num / 100; // 100의 자리
        int tens = (num / 10) % 10; // 10의 자리
        int units = num % 10; // 1의 자리

        return (hundreds - tens) == (tens - units);
    } // Enf of check()
} // End of Main class
