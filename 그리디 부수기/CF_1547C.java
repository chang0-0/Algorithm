import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    // input
    private static BufferedReader br;

    // variables
    private static int K, N, M;
    private static int[] arr1, arr2;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            br.readLine();
            input();
            bw.write(solve());
        }

        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();
        List<Integer> ans = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < N || j < M) {
            int num;

            if (i < N && arr1[i] <= K) {
                num = arr1[i];
                i++;
            } else if (j < M && arr2[j] <= K) {
                num = arr2[j];
                j++;
            } else {
                sb.append(-1).append('\n');
                return sb.toString();
            }

            if (num == 0) {
                K++;
            }
            
            ans.add(num);
        }

        for (int num : ans) {
            sb.append(num).append(' ');
        }

        sb.append('\n');
        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        String temp = br.readLine();

        StringTokenizer st = new StringTokenizer(temp);
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr1 = new int[N];
        arr2 = new int[M];

        temp = br.readLine();
        st = new StringTokenizer(temp);
        for (int i = 0; i < N; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        temp = br.readLine();
        st = new StringTokenizer(temp);
        for (int i = 0; i < M; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }
    } // End of input()
} // End of Main class
