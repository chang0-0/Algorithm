package BOJ_25379;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_25379 {

    // https://www.acmicpc.net/problem/25379
    // input
    private static BufferedReader br;

    // variables
    private static int N;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_25379\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        int count = 0;
        int oddSum = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] % 2 == 1) {
                // 앞에서 나온 짝수의 개수만큼 스왑을 해야한다.
                oddSum += count;
            } else {
                // 0부터 시작해서 만나는 짝수의 개수
                count++;
            }
        }

        count = 0;
        int evenSum = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] % 2 == 0) {
                evenSum += count;
            } else {
                count++;
            }

            if (evenSum >= oddSum) {
                sb.append(oddSum);
                return sb.toString();
            }
        }

        System.out.println("count : " + count + ", evenSum : " + evenSum);

        sb.append(Math.min(oddSum, evenSum));
        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    } // End of input()
} // End of Main class
