package BOJ_30804;

import java.io.*;

public class BOJ_30804_과일_탕후루 {

    // https://www.acmicpc.net/problem/30804
    // input
    private static BufferedReader br;

    // variables
    private static int N;
    private static int[] arr;
    private static int[] nums = new int[10];

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

        sb.append(twoPointer(0, 0, 0, 0, 0));
        return sb.toString();
    } // End of solve()

    private static int twoPointer(int left, int right, int cnt, int kind, int max) {
        if (right >= N) {
            // right 포인터가 배열의 끝에 도달했음을 의미함
            return max;
        }

        if (nums[arr[right]] == 0) {
            kind++;
        }

        cnt++;
        nums[arr[right]]++;

        // 만약 과일의 종류가 2개를 넘으면, 왼쪽의 포인터를 이동한다.
        if (kind > 2) {
            if (nums[arr[left]] - 1 == 0) {
                kind--;
            }
            cnt--; // 탕후루의 개수를 감소
            left++;
        }

        max = Math.max(max, cnt);

        // left pointer는 그대로 두고, right 포인터만 배열의 끝으로 계속해서 이동
        return twoPointer(left, right + 1, cnt, kind, max);
    } // End of find()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        String s = br.readLine();
        for (int i = 0; i < N; i++) {
            arr[i] = s.charAt(i << 1) - '0';
        }
    } // End of input()
} // End of Main class
