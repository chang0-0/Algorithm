import java.io.*;
import java.util.StringTokenizer;

/*

    L W H인
    N, L, W, H가 주어질 때, 가능한 A의 최댓값을 찾는 프로그램을 작성하시오.

    첫쨰 줄에 가능한 A의 최댓값을 출력한다. 절대/상대 오차는 10^-9까지 허용한다.
 */

public class Main_1166_선물 {
    private static int N, L, W, H;
    private static double result = 0;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/1166.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        sb.append(binarySearch(0.0, Math.max(L, Math.max(W, H))));

        bw.write(sb.toString());
        bw.close();
    } // End of main

    private static double binarySearch(double low, double high) {
        for (int i = 0; i < 10000; i++) {
            double mid = (low + high) / 2.0;

            if ((long) (L / mid) * (long) (W / mid) * (long) (H / mid) >= N) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return low;
    } // End of binarySearch

} // End of Main class
