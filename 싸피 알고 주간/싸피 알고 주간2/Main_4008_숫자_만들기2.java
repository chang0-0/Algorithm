import java.util.*;
import java.io.*;

public class Main_4008_숫자_만들기2 {
    static int N, minResult, maxResult;
    static int[] oper;
    static int[] number;
    static int[] comb;
    //static boolean[] isVisited;

    // 힌트는 연산자를 조합하는게 아닌 숫자를 조합해서 위치를 움직이는 것.
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/4008.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append('#').append(t).append(' ');

            N = Integer.parseInt(br.readLine());
            init();

            st = new StringTokenizer(br.readLine());
            int index = 0;
            for (int i = 0; i < 4; i++) {
                int operNum = Integer.parseInt(st.nextToken());

                while (operNum-- > 0) {
                    oper[index++] = i;
                }
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                number[i] = Integer.parseInt(st.nextToken());
            }

            boolean[] isVisited = new boolean[N - 1];
            DFS(0, N - 1, N - 1, isVisited);
            sb.append(Math.abs(maxResult - minResult)).append('\n');
        }

        bw.write(sb.toString());
        bw.close();
    } // End of main

    // N개 중에 R개를 선택하는 것이 아닌, 순열을 만드는 것.
    private static void DFS(int depth, int n, int r, boolean[] isVisited) {
        //System.out.println("============= DFS(" + depth + ") =============");

        if (depth == r) {
             System.out.println(Arrays.toString(comb));

            int sum = number[0];
            for (int i = 0; i < N - 1; i++) {

                if (comb[i] == 0) {
                    sum += number[i + 1];
                } else if (comb[i] == 1) {
                    sum -= number[i + 1];
                } else if (comb[i] == 2) {
                    sum *= number[i + 1];
                } else {
                    sum /= number[i + 1];
                }
            }

            minResult = Math.min(minResult, sum);
            maxResult = Math.max(maxResult, sum);
            return;
        }

        for (int i = 0; i < n; i++) {
            // System.out.println("i : " + i);
            if (isVisited[i]) continue;
            isVisited[i] = true;
            comb[depth] = oper[i];
            DFS(depth + 1, n, r, isVisited);
            isVisited[i] = false;
        }

    } // End of DFS

    private static void init() {
        number = new int[N];
        comb = new int[N - 1];
        oper = new int[N - 1];
        //isVisited = new boolean[N - 1];
        maxResult = Integer.MIN_VALUE; // 얻은 결과값 중 최댓값
        minResult = Integer.MAX_VALUE; // 얻은 결과값 중 최솟값

    } // End of init
} // End of Main class