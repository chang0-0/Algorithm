package BOJ_1253;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1253 {

    // https://www.acmicpc.net/problem/1253
    // input
    private static BufferedReader br;

    // variables
    private static int N;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_1253\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < N; i++) { // 배열 전체를 순환하면서 찾는다.
            int target = arr[i];

            // index값을 줄여가면서 target을 찾는다.
            int start = 0;
            int end = N - 1;

            while (start < end) { // 이분 탐색 실행
                if (start == i) start++; // start가 i
                else if (end == i) end--; // end가 i랑 같을 경우
                else {
                    int sum = arr[start] + arr[end];

                    if (sum == target) {
                        count++;
                        break;
                    }

                    if (sum < target) start++;
                    else end--;
                }
            }
        }

        sb.append(count);
        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    } // End of input()
} // End of Main class
