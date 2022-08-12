import java.io.*;

// https://www.acmicpc.net/problem/1904
public class Main_1904_01타일_Bottom_Up {
    private static final int MOD = 15746;
    static int memo[] = new int[1000001];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/1904.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        memo[0] = 0;
        memo[1] = 1;
        memo[2] = 2;
        System.out.print(DP(N));
    } // End of main

    // DP Bottom-Up (
    private static int DP(int N) {
        for(int i=3; i<=N; i++) {
            memo[i] = (memo[i-1] + memo[i-2]) % MOD;
        }

        return memo[N];
    } // End of DP
} // End of Main class