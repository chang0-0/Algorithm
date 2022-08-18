import java.util.*;
import java.io.*;

public class Main_4008_숫자_만들기 {
    static int numArr[];
    static int operArr[] = new int[4];
    static int ans[];
    static int N;
    static int min;
    static int max;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/4008.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append('#').append(t).append(' ');
            max = -100000001;
            min = 100000001;

            N = Integer.parseInt(br.readLine());
            numArr = new int[N];
            ans = new int[N - 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                operArr[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                numArr[i] = Integer.parseInt(st.nextToken());
            }

            DFS(0);
            sb.append(Math.abs(max - min)).append('\n');
        }

        bw.write(sb.toString());
        bw.close();
    } // End of main

    private static void DFS(int depth) { // 백트래킹
        if (depth == N - 1) {
            int total = numArr[0];
            for (int i = 1; i < N; i++) {
                int oper = ans[i - 1];
                if (oper == 0) {
                    total += numArr[i];
                } else if (oper == 1) {
                    total -= numArr[i];
                } else if (oper == 2) {
                    total *= numArr[i];
                } else if (oper == 3) {
                    total /= numArr[i];
                }
            }

            max = Math.max(total, max);
            min = Math.min(total, min);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operArr[i] == 0) continue;
            operArr[i]--;
            ans[depth] = i;
            DFS(depth + 1);
            operArr[i]++;
        }
    } // End of DFS
} // End of Main class