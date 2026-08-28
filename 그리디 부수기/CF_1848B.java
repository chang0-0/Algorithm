package CF_1848B;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF_1848B {

    // https://codeforces.com/problemset/problem/1848/B?utm_source=chatgpt.com
    // input
    private static BufferedReader br;

    // variables
    private static int N, K;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\CF_1848B\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            input();
            bw.write(solve());
        }

        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        int[] preIdx = new int[K + 1];
        Arrays.fill(preIdx, -1);

        // 각 색깔의 가장 큰 간격과 두 번째로 큰 간격을 저장.
        int[] maxGap = new int[K + 1];
        int[] secondMaxGap = new int[K + 1];

        for (int i = 0; i < N; i++) {
            int color = arr[i];

            int gap = i - preIdx[color] - 1;
            // 사이에 있는 널빤지 개수, 거리 값
            updateGap(color, gap, maxGap, secondMaxGap);
            preIdx[color] = i;
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= K; i++) {
            // i색상의 마지막 위치부터 다리 끝까지의 간격
            int lastGap = (N - 1) - preIdx[i];
            updateGap(i, lastGap, maxGap, secondMaxGap);

            int ret = Math.max(maxGap[i] / 2, secondMaxGap[i]);
            ans = Math.min(ans, ret);
        }


        sb.append(ans).append('\n');
        return sb.toString();
    } // End of solve()

    private static void updateGap(int color, int gap, int[] maxGap, int[] secondMaxGap) {
        if (gap >= maxGap[color]) {
            secondMaxGap[color] = maxGap[color];
            maxGap[color] = gap;
        } else if (gap > secondMaxGap[color]) {
            secondMaxGap[color] = gap;
        }
    } // End of updateGap()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    } // End of input()
} // End of Main class
