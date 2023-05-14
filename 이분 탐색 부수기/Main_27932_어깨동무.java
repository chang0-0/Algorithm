import java.io.*;
import java.util.StringTokenizer;


public class Main_27932_어깨동무 {
    private static int N;
    private static int K;
    private static int[] arr;
    private static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/27932.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 사람의 인원 수
        K = Integer.parseInt(st.nextToken()); // 지친 사람이 K명 이하가 되어야 함
        arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        arr[N] = arr[N - 1];

        binarySearch(0, Integer.MAX_VALUE);
        sb.append(result);

        bw.write(sb.toString());
        bw.close();
    } // End of main

    private static void binarySearch(int low, int high) {
        if (low > high) {
            return;
        }

        int mid = (low + high) / 2;
        int count = check(mid);

        // 지친 사람이 K명 이하 일 경우 더 줄 일 수 있음 -> 높이 (mid)를 낮추기
        if (K < count) {
            binarySearch(mid + 1, high);
        } else {
            // 기존의 인원 수 보다 클 경우
            result = Math.min(result, mid);
            binarySearch(low, mid - 1);
        }
    } // End of binarySearch

    private static int check(int H) {
        // 지친 사람이 몇 명인지 검사
        int count = 0;

        for (int i = 0; i < N; i++) {
            if (i == 0) {
                int me = arr[i];
                int after = arr[i + 1];

                if (Math.abs(me - after) > H) {
                    count++;
                }
            } else {
                int before = arr[i - 1];
                int me = arr[i];
                int after = arr[i + 1];

                if (Math.abs(me - before) > H || Math.abs(me - after) > H) {
                    count++;
                }
            }
        }

        return count;
    } // End of check
} // End of Main class
