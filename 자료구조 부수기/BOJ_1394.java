package BOJ_1394;

import java.io.*;
import java.util.HashMap;

public class BOJ_1394 {

    // https://www.acmicpc.net/problem/1394
    // input
    private static BufferedReader br;

    // variables
    private static final int MOD = 900528;
    private static String str, password;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_1394\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        int strLen = str.length();
        int passwordLen = password.length();
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < strLen; i++) {
            map.put(str.charAt(i), i + 1);
        }

        int ans = 0;
        for (int i = 0; i < passwordLen; i++) {
            ans *= strLen;

            char num = password.charAt(i);
            ans += map.get(num);
            ans %= MOD;
        }

        sb.append(ans);
        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        str = br.readLine();
        password = br.readLine();
    } // End of input()
} // End of Main class
