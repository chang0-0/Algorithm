package BOJ_30804;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_30804 {

    // https://www.acmicpc.net/problem/30804
    // input
    private static BufferedReader br;

    // variables
    private static int N;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_30804\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        int left = 0;
        int right = 0;
        int[] nums = new int[10];
        int count = 0;
        int ans = 0;
        int kind = 0;

        while (right < N) {
            int num = arr[right];
            nums[num]++;
            count++;

            if (nums[num] == 1) {
                kind++;
            }

            while (kind > 2) {
                int temp = arr[left];
                nums[temp]--;

                if (nums[temp] == 0) {
                    kind--;
                }
                left++;
                count--;
            }

            right++;
            ans = Math.max(ans, count);
        }

        sb.append(ans);
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
