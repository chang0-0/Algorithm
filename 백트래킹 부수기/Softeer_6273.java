import java.io.*;
import java.util.*;

public class Main {

    // https://softeer.ai/practice/6273
    // input    
    private static BufferedReader br;

    // variables
    private static int N, M, K, ans;
    private static int[] arr, comb;
    private static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        // 백트래킹 
        // 레일의 끝으로 가면 다시 처음으로 돌아감
        DFS(0, 0);

        sb.append(ans);
        return sb.toString();
    } // End of solve()

    private static void DFS(int depth, int idx) {
        if(depth == N) {
            ans = Math.min(ans, calc());
            return;
        }

        for(int i=idx; i<N; i++) {
            if(isVisited[i]) continue;
            comb[depth] = arr[i];
            isVisited[i] = true;
            DFS(depth + 1, idx);
            isVisited[i] = false;
        }
    } // End of DFS()

    private static int calc() {
        int ret = 0;
        int idx = 0;
        int count = 0;
        int sum = 0;
        
        for(;;) {
            sum += comb[idx];
            if(sum > M) {
                count++;
                ret += sum - comb[idx];
                if(count == K) break;
                sum = comb[idx];
            }

            idx++;
            if(idx == N) {
                idx = 0;
            }
        }

        return ret;
    } // End of calc()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 레일의 개수
        M = Integer.parseInt(st.nextToken()); // 바구니의 무게
        K = Integer.parseInt(st.nextToken()); // 일의 시행 횟수

        ans = Integer.MAX_VALUE;
        arr = new int[N];
        comb = new int[N];
        isVisited = new boolean[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    } // End of input()
} // End of Main class
