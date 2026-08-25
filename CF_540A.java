package CF_540A;

import java.io.*;

public class CF_540A {

    // https://codeforces.com/problemset/problem/540/A
    // input
    private static BufferedReader br;

    // variables
    private static int N;
    private static char[] cur, pw;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\CF_540A\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();


        int ans = 0;
        for (int i = 0; i < N; i++) {
            int current = Character.getNumericValue(cur[i]);
            int target = Character.getNumericValue(pw[i]);

            int forward = calc(target, current);
            int reverse = calc(current, target);

            int min = Math.min(forward, reverse);
            ans += min;
        }

        sb.append(ans);
        return sb.toString();
    } // End of solve()

    private static int calc(int num1, int num2) {
        return (num1 - num2 + 10) % 10;
    } // End of calc()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        cur = br.readLine().toCharArray();
        pw = br.readLine().toCharArray();
    } // End of input()
} // End of Main class

