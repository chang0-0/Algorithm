import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/1904
public class Main_1904_01타일_Top_Down {
    private static final int MOD = 15746;
    static Integer memo[] = new Integer[20];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/1904.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        memo[2] = 2;
        
        // 배열을 Integer형으로 만들어서 0이 아닌 값 null로 초기화
        System.out.print(DP(N));
    } // End of main

    // DP Top-Down (재귀)
    private static int DP(int N) {
        if(N == 1) {
            return 1;
        } else if(N == 0) {
            return 0;
        }

        if(memo[N] == null) {
            memo[N] = (DP(N-1) + DP(N-2)) % MOD;
        }

        return memo[N];
    } // End of DP
} // End of Main class