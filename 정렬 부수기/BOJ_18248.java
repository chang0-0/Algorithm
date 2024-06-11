package BOJ_18248;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_18248 {

    // https://www.acmicpc.net/problem/18248
    // input
    private static BufferedReader br;

    // variables
    private static int N, M;
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_18248\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() throws IOException {
        StringBuilder sb = new StringBuilder();

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o2[M], o1[M]);
            }
        });

        // 정렬 후에 올바른 값인지 확인하기
        /*
            가장 앞사람을 기준으로 삼아서
            뒷사람은 소리를 들었는데, 앞사람이 소리를 못들은 경우를 찾기
         */

        boolean flag = true;
        loop:
        for (int i = N - 1; i >= 1; i--) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1 && arr[i - 1][j] == 0) {
                    flag = false;
                    break loop;
                }
            }
        }

        if (flag) {
            sb.append("YES");
        } else {
            sb.append("NO");
        }
        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M + 1];
        for (int i = 0; i < N; i++) {
            int sum = 0;
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                sum += arr[i][j];
            }

            arr[i][M] = sum;
        }
    } // End of input()
} // End of Main class
