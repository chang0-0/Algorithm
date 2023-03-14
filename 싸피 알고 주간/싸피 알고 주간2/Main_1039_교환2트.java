import java.io.*;
import java.util.*;

public class Main_1039_교환2트 {
    static int N, K, len, result;
    static char[] charN;
    static String strN;
    static int[][] memo;


    // 연산을 K번 했을 때, 나올 수 있는 수의 최댓값을 구하라.
    // 바꾼수 가 0으로 시작하면 안된다.
    // K번 연산할 수 없으면 -1을 출력한다.
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/1039.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        strN = st.nextToken();
        K = Integer.parseInt(st.nextToken());
        init();

        if (len == 1 || (len == 2 && strN.charAt(1) == '0')) {
            System.out.print(-1);
            return;
        }

        System.out.println(DFS(0, strN));
    } // End of main

    private static int DFS(int depth, String strN) {
        // System.out.println("DFS(" + depth + ", " + strN + ")");

        int num = Integer.parseInt(strN);
        if (depth == K) {
            return num; // K번의 연산을 마친 값을 return
        }

        int memoVal = memo[depth][num];
        if (memoVal != 0) {
            // 해당 재귀의 깊이에 num의 값 자리를 이미 방문했으므로, 더 이상 진행할 필요 없다.
            return memoVal;
        }

        memoVal = -1; // 처음 교환을 하기 전의 값은 -1
        for (int i = 0; i < len - 1; i++) { // 0번째 부터 마지막 전까지.
            for (int j = i + 1; j < len; j++) { // 1번째 부터 마지막까지 (서로 교환이 하나씩 가능한 범위를 교차로 만듬)

                // 바꾸려는 자리가 첫번째 자리인데 오려고하는 값이 0일 경우, 그냥 지나친다.
                if (i == 0 && strN.charAt(j) == '0') {
                    continue;
                }

                String tempStr = swap(strN, i, j);
                int tempInt = DFS(depth + 1, tempStr);

                // 재귀가 종료되면서 만들어진 값을 기존에 있었던 값과 비교하여 최댓값으로 갱신.
                memoVal = Math.max(memoVal, tempInt);
            }
        }

        memo[depth][num] = memoVal;
        return memoVal;
    } // End of DFS

    // 값을 바꿔주는 swap메소드
    private static String swap(String str, int i, int j) {
        char[] chars = str.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return String.valueOf(chars);
    } // End of swap

    private static void init() {
        len = strN.length();
        N = Integer.parseInt(strN);
        result = Integer.MIN_VALUE;
        charN = strN.toCharArray();
        memo = new int[K + 1][1_000_001];
    } // End of init
} // End of Main class