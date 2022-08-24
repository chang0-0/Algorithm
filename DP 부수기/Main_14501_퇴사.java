import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/14501
// 최대 수익을 구하는 프로그램을 작성
public class Main_14501_퇴사 {
    static Integer[] memo;
    static int[][] arr;
    static int N;
    static int max = -1;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/14501.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1][2];
        memo = new Integer[N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        //for(int num[] : arr) System.out.println(Arrays.toString(num));
        DP( 0, 0);
        System.out.println(memo[N]);
    } // End of main

    private static int DP(int depth, int total) {
        System.out.println(Arrays.toString(memo));
        // 재귀 카운트 N과 동일할 때,
        if (depth >= N) {
            return memo[depth];
        }

        // 재귀 카운트
        if(memo[depth] != null) {

        }

        if (memo[depth] == null) {
            memo[depth] = total;
        }

        for (int i = 1; i <= N; i++) {
            DP(depth + arr[i][0], total + arr[depth][1]);
        }

        return memo[depth];
    } // End of DP
} // End of Main class