import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2529
// 0 ~ 9까지의 숫자를 사용해서 (중복 제외) 부등호 순서열을 만족시켜라
// 제시된 k개의 부등호 순서를 만족하는 (k+1)자리의 정수 중에서 최댓값과 최솟값을 찾아야 한다

public class Main_2529_부등호 {
    static int K;
    static int[] ans;
    static boolean[] visit;
    static String[] inequalitySignArr;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/2529.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());
        inequalitySignArr = new String[K];
        ans = new int[K+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            inequalitySignArr[i] = st.nextToken();
        }

        System.out.println(Arrays.toString(inequalitySignArr));

    } // End of main

    private static void DFS(int depth) {
        if (depth == K) {
            for (int i = 0; i < K; i++) {
                int num = ans[i];



            }

            return;
        }

        for (int i = 0; i < 10; i++) {
            if (visit[i]) continue;

            visit[i] = true;
            ans[depth] = i;
            DFS(depth + 1);
            visit[i] = false;
        }

    } // End of DFS
} // End of Main class
