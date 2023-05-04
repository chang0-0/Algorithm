import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


/*
    공유기 사이의 최소거리를 이분 탐색을 통해서 구하는 문제이다.
 */

public class Main_2110_공유기_설치 {
    static int N;
    static int C;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/2110.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;


        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        // 최소거리가 가질 수 있는 최솟값
        int low = 1;
        int high = arr[N - 1] - arr[0] + 1;

        sb.append(binarySearch(low, high) - 1);
        bw.write(sb.toString());
        bw.close();
    } // End of main

    private static int binarySearch(int low, int high) {
        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;

        if (check(mid) < C) {
            // 필요한 공유기 설치 개수가 C보다 클 경우,
            // 최소 거리를 더 늘려야 함.
            high = mid - 1;
            int result = mid;

            int temp = binarySearch(low, high);
            if(temp == -1) {
                return result;
            } else {
                return temp;
            }
        } else {
            low = mid + 1;
            return binarySearch(low , high);
        }
    } // End of binarySearch

    private static int check(int dist) {
        int count = 1;
        int lastLocate = arr[0];

        for (int i = 1; i < N; i++) {
            int locate = arr[i];

            // 이전 집과 현재 집의 거리가 최소 거리보다 크거나 같으면 공유기 개수를 증가
            if (locate - lastLocate >= dist) {
                count++;
                lastLocate = locate;
            }
        }

        return count;
    } // End of check
} // End of Main class
