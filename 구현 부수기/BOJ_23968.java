package BOJ_23968;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_23968 {

    // https://www.acmicpc.net/problem/23968
    // input
    private static BufferedReader br;

    // variables
    private static int N, K;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_23968\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        int swapCount = 0;
        for (int last = N - 1; last > 0; last--) {
            for (int i = 0; i < last; i++) {
                if (arr[i] > arr[i + 1]) {
                    swapCount++;
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;

                    if (swapCount == K) {
                        sb.append(arr[i]).append(' ').append(arr[i + 1]);
                        return sb.toString();
                    }
                }
            }
        }

        sb.append(-1);

        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    } // End of input()
} // End of Main class
