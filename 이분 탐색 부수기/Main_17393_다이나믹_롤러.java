import java.io.*;
import java.util.StringTokenizer;

/*
    문제 이해

    통로는 1 * N 길이의 일자 형태를 가지고 있고, 통로의 바닥은 1 * 1 타일로 가득 차있다.
    각 타일은 잉크지수 A와 점도지수 B를 가지고 있다.

    각 타일은 잉크지수 A와 점도지수 B를 가지고 있다. 타일이 제각각 다른 특성을 가지고 있기 때문에 세심하게 롤러를
    휘둘러야만 한다. 멩미가 i번째 타일 위에 서 있을 때, 멩미는 다이나믹 롤러로 현재 위치보다
    오른쪽에 있으면서도 점도 지수가 서 있는 칸의 잉크지수 A이하인 칸을 칠할 수 있다.

    문제의 핵심 -> 99보다 작거나 같은 점도지수를 가진 칸을 찾는다.

    다이나믹 롤러로 칠할 수 있는 최대의 칸 수를 구해보자.
 */

public class Main_17393_다이나믹_롤러 {
    private static long N; // 통로의 길이
    private static final int MAX = 500_000;
    private static long[] arrA = new long[MAX]; // 잉크 지수
    private static long[] arrB = new long[MAX]; // 점도 지수

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/17393.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Long.parseLong(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arrA[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arrB[i] = Long.parseLong(st.nextToken());
        }

        // 내가 있는 칸을 포함하되 index는 0이 된다.
        // index를 이분 탐색을 통해서 찾아야됨
        for (int i = 0; i < N; i++) {
            // 여기 인덱스를 기준으로 i부터 idx까지 몇개를 칠 할 수 있는지 적어야됨
            sb.append(binarySearch(i, N - 1, arrA[i]) - i).append(' ');
        }


        bw.write(sb.toString());
        bw.close();
    } // End of main

    private static long binarySearch(long low, long high, long inkValue) {
        if (low > high) {
            return -1;
        }

        // 같은 값 중에서 가장 뒤의 값을 선택해야 됨.
        long mid = (low + high) / 2;
        // res가 true이면 더 mid를 더 올려도됨
        if (check(mid, inkValue)) {
            long ret = binarySearch(mid + 1, high, inkValue);
            if (ret == -1) {
                return mid;
            } else {
                return ret;
            }
        } else {
            return binarySearch(low, mid - 1, inkValue);
        }
    } // End of binarySearch

    private static boolean check(long mid, long inkValue) {
        // 잉크지수 보다 점도지수가 작거나 같은지 확인해야됨
        if (arrB[(int) mid] <= inkValue) {
            return true;
        }
        return false;
    } // End of check
} // End of Main class
