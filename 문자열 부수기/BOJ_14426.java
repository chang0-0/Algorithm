package BOJ_14426;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14426 {

    // https://www.acmicpc.net/problem/14426
    // input
    private static BufferedReader br;

    // variables
    private static int N, M;
    private static String[] arr, checkArr;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_14426\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() throws IOException {
        StringBuilder sb = new StringBuilder();

        Arrays.sort(arr);
        int ans = 0;

        for (int i = 0; i < M; i++) {
            String query = br.readLine();
            int idx = Arrays.binarySearch(arr, query); // 단어가 포함되어 있는지 찾기
            // idx가 양수일 경우, 똑같은 단어가 있음, 음수일 경우 똑같은 단어가 없음
            // 존재하지 않을 경우에는 음수를 반환합니다.
            // 이 때 반환되는 음수 값은 단순히 -1이 아니라, 해당 요소가 배열에 삽입될 수 있는 위치를 기준으로 만들어진 특별한 값입니다.

            if (idx < 0) {
                // 음수일 경우, 가장 근접한 위치의 index를 반환했으므로, 이을 양수로 변경한다.
                idx = -(idx + 1);
            }

            if (idx < N) {
                // 양수로 변경된 idx
                if (arr[idx].startsWith(query)) {
                    ans++;
                }
            } else {
                break;
            }
        }

        sb.append(ans);
        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }
    } // End of input()
} // End of Main class
