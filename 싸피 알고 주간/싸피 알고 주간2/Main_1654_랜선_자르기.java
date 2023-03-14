import java.util.*;
import java.io.*;

public class Main_1654_랜선_자르기 {
    static int N, K;
    static long result;
    static int[] lineArr;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/1654.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        lineArr = new int[K];
        result = -1;

        for (int i = 0; i < K; i++) {
            lineArr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(lineArr);
        long start = 1;
        long end = lineArr[K - 1];
        long mid = (start + end) / 2;

        binarySearch(start, mid, end);
    } // End of main

    private static void binarySearch(long start, long mid, long end) {
        if (start > end) {
            System.out.println(mid);
            return;
        }

        int lineCount = 0;
        for (int len : lineArr) {
            lineCount += len / mid;
        }

        if (lineCount >= N) {
            start = mid + 1;
        } else {
            end = mid - 1;
        }
        mid = (start + end) / 2;

        binarySearch(start, mid, end);
    } // End of binarySearch
} // End of Main class
