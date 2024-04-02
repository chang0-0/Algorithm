package BOJ_30804;

import java.io.*;

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


        int ret = twoPointer();

        sb.append(ret);
        return sb.toString();
    } // End of solve()

    private static int twoPointer() {
        int left = 0, right = 0;
        int cnt = 0, kind = 0, max = 0; // cnt: 현재 부분 배열의 길이, kind: 과일 종류 수, max: 최대 길이
        int[] nums = new int[10]; // 과일 종류를 카운트할 배열, 데이터에 따라 크기 조정 필요


        // 기본적으로는 right 포인터를 옮기면서 최대값을 찾는다.
        while (right < N) {
            if (nums[arr[right]] == 0) { // 새로운 과일 종류 발견
                kind++;
            }

            cnt++;
            nums[arr[right]]++;

            while (kind > 2) {
                if (--nums[arr[left]] == 0) {
                    kind--;
                }
                // 종류가 2개가 넘어서면 left를 증가시킨다.
                cnt--;
                left++;
            }

            max = Math.max(max, cnt); // 최대 길이 갱신
            right++;
        }

        return max; // 최대 길이 반환
    } // End of twoPointer()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        String temp = br.readLine();

        for (int i = 0; i < N; i++) {
            arr[i] = temp.charAt(i << 1) - '0';
        }
    } // End of input()
} // End of Main class
