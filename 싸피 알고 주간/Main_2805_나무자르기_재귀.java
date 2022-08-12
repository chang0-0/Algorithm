import java.util.*;
import java.io.*;

public class Main_2805_나무자르기_재귀 {
    static int treeArr[];
    static int N;
    static int M;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/2805.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); // 가져가려고 하는 나무의 높이
        treeArr = new int[N];

        st = new StringTokenizer(br.readLine());
        int treeMaxHeight = 0;
        for (int i = 0; i < N; i++) {
            treeArr[i] = Integer.parseInt(st.nextToken());
            treeMaxHeight = Math.max(treeArr[i], treeMaxHeight);
        }

        binarySearch(1, treeMaxHeight);
    } // End of main

    // 재귀 구현
    private static void binarySearch(int low, int high) {
        int middle = (low + high) / 2; // 절단기의 높이 절반으로 조절
        if (low > high) { // 재귀 탈출 조건
            System.out.println(middle);
            return;
        }

        long cuttingTreeLength = 0;
        for (int i = 0; i < N; i++) {
            if(treeArr[i] > middle) {
            cuttingTreeLength += treeArr[i] - middle;
            }

        }

            // 나무를 절단한 총 합의 길이가 target보다 더 길 경우
            // 절단기의 높이를 높여야 한다.
        if (cuttingTreeLength >= M) {
            binarySearch(middle + 1, high);
        } else {
            binarySearch(low, middle - 1);
        }
    } // End of binarySearch
} // End of Main class