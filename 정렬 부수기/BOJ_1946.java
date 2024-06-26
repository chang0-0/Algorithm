package BOJ_1946;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1946 {

    // https://www.acmicpc.net/problem/1946
    // input
    private static BufferedReader br;

    // variables
    private static int N;
    private static int[] scores;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_1946\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            input();

            bw.write(solve());
        }

        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        int ans = 1; // 1등은 무조건 합격이므로 1명으로 시작
        int standard = scores[1]; // 서류 1등을 기준으로

        for (int i = 2; i <= N; i++) {
            if (scores[i] < standard) {
                // 서류 점수 i등 인원이 기준의 면접 점수 보다 작을 경우
                // 선발할 수 있는 인원
                // 서류 등수가 낮은 순으로 나오는데, 그 기준에서 면접 등수는 높을 경우 해당 인원은 합격
                standard = scores[i];
                ans++;
            }
        }

        sb.append(ans).append('\n');
        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        scores = new int[N + 1];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 두 성적순위가 1 ~ N까지 표시된다고 했으므로 서류 성적 순위를 배열 index로 설정
            scores[a] = b;
        }
    } // End of input()
} // End of Main class
