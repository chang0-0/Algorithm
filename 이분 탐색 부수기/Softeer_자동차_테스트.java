package Softeer_자동차_테스트;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Softeer_자동차_테스트 {

    // https://softeer.ai/practice/info.do?idx=1&eid=1717
    // input
    private static BufferedReader br;

    // variables
    private static int N, Q;
    private static int[] fuelEconomies;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\Softeer_자동차_테스트\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() throws IOException {
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());

            int target = Integer.parseInt(st.nextToken());
            int ret = binarySearch(0, N - 1, target);

            if (ret == -1) {
                sb.append(0);
            } else {
                sb.append(ret * (N - (ret + 1)));
            }
            sb.append('\n');
        }

        return sb.toString();
    } // End of solve()

    private static int binarySearch(int low, int high, int target) {
        if (low > high) return -1;

        int mid = (low + high) / 2;
        if (fuelEconomies[mid] == target) {
            return mid;
        } else if (fuelEconomies[mid] < target) {
            return binarySearch(mid + 1, high, target);
        } else {
            return binarySearch(low, mid - 1, target);
        }
    } // End of binarySearhc()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        fuelEconomies = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            fuelEconomies[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(fuelEconomies);
    } // End of input()
} // End of Main class
