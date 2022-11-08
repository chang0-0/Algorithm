import java.util.*;
import java.io.*;

public class Main_10815_숫자_카드 {
    static int N, M;
    static int[] card1, card2;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/10815.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        card1 = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            card1[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        card2 = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            card2[i] = Integer.parseInt(st.nextToken());
        }

        // 배열 둘다 정렬
        Arrays.sort(card1);

        // card1의 값이 card2에도 있는가?
        // index를 이분탐색 해야됨.
        int min = 0;
        int max = N - 1;

        for (int i = 0; i < M; i++) {
            sb.append(binarySearch(min, max, card2[i])).append(' ');
        }


        bw.write(sb.toString());
        bw.close();
    } // End of main

    private static int binarySearch(int startIndex, int endIndex, int findNum) {
        if (startIndex > endIndex) {
            // 값을 찾지 못하고, 시작값이 끝 값을 넘어갈 경우, 없다고 판단하고 -1을 return
            return 0;
        }

        int mid = (startIndex + endIndex) / 2;

        // 일치하는 값이있으면 1을 return;
        if (card1[mid] == findNum) {
            return 1;
        } else if (card1[mid] > findNum) {
            // index로 정한값이 찾는 값보다 클 경우, index를 낮춰야됨.
            return binarySearch(startIndex, mid - 1, findNum);
        } else {
            return binarySearch(mid + 1, endIndex, findNum);
        }

    } // End of binarySearch
} // End of Main class

