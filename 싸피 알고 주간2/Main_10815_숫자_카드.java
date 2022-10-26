import java.util.*;
import java.io.*;

public class Main_10815_숫자_카드 {
    static int N, M;
    static int[] card1, card2, result;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/10815.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        card1 = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            card1[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        card2 = new int[M];
        result = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            card2[i] = Integer.parseInt(st.nextToken());
        }

        // 배열 둘다 정렬
        Arrays.sort(card1);
        Arrays.sort(card2);


        // card1의 값이 card2에도 있는가?
        // index를 이분탐색 해야됨.
        int min = 0;
        int max = M - 1;

        for (int i = 0; i < N; i++) {
            boolean bol = binarySearch(min, max, card1[i]);

            if (bol) {
                result[i] = 1;
            } else {
                result[i] = 0;
            }
        }


    } // End of main

    private static boolean binarySearch(int startIndex, int endIndex, int findNum) {
        if (startIndex > endIndex) {
            return false;
        }

        int mid = (startIndex + endIndex) / 2;

        // index로 정한값이 찾는 값보다 클 경우, index를 낮춰야됨.
        if (card2[mid] > findNum) {
            endIndex = mid - 1;
        } else {
            startIndex = mid + 1;
        }

        binarySearch(startIndex, endIndex, findNum);

        return false;
    } // End of binarySearch


    private static void findNum(int mid) {

    } // End of findNUm

} // End of Main class
