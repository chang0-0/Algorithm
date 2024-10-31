package BOJ_31264;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_31264 {

    // https://www.acmicpc.net/problem/31264
    // input
    private static BufferedReader br;

    // variables
    private static int N, M, A, max;
    private static int[] arr;

    private static class Shot {
        int count;
        long nowPower;
        long nowScore;
        int startIdx;

        private Shot(int count, long nowScore, long nowPower, int startIdx) {
            this.count = count;
            this.nowScore = nowScore;
            this.startIdx = startIdx;
            this.nowPower = nowPower;
        }
    } // End of Shot class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_31264\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        // 진급할 수 있는 사격 실력의 최솟값
        Arrays.sort(arr);
        // 사격의 실력을 구하기
        sb.append(binarySearch());
        return sb.toString();
    } // End of solve()

    private static long binarySearch() {
        int low = 1;
        int high = arr[N - 1];
        long ans = Long.MAX_VALUE;

        if (arr[0] >= A) {
            return A;
        }

        // 표적의 점수만큼 사격 점수를 획득.
        // 가장 낮은 초기 사격 점수를 구하자.
        while (low <= high) {
            int mid = (low + high) / 2; // arr의 Index기준
            boolean ret = check(mid);
            // 사격을 통과할 수 있으면 점수를 더 낮춰보자.

            if (ret) {
                // 현재 사격 점수가 승진 점수보다 높거나 같을 경우 초기 사격 실력을 더` 낮춰도 됨
                ans = Math.min(ans, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    } // End of binarySearch()

    private static boolean check(int firstPower) {
        if (arr[0] > firstPower) return false;

        // 가장 큰 값을 찾아서 해당 값 위주로 쏘기
        int count = 0;
        long scoreSum = 0;
        long nowPower = firstPower;
        int nowIdx = 0;
        while (count < M) {

            boolean flag = true;
            for (int i = nowIdx; i < N; i++) {
                if (nowPower < arr[i]) {
                    nowIdx = i - 1;
                    flag = false;
                    break;
                }
            }

            if (flag) {
                if (arr[N - 1] <= nowPower) {
                    nowIdx = N - 1;
                }
            }

            nowPower += arr[nowIdx];
            scoreSum += arr[nowIdx];
            count++;
            if (scoreSum >= A) {
                return true;
            }
        }

        return false;
    } // End of check()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());

        arr = new int[N];
        max = -1;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }
    } // End of input()
} // End of Main class
