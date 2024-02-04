import java.io.*;
import java.util.*;

// 누적합, 소수점
public class Main {
    // https://softeer.ai/practice/6294
    // input
    private static BufferedReader br;

    // variables
    private static int N, K;
    private static int[] arr, prefixSum;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        input();
        
        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() throws IOException  {
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start =  Integer.parseInt(st.nextToken());
            int end =  Integer.parseInt(st.nextToken());

            double sum = prefixSum[end] - prefixSum[start - 1];
            double ret = sum / ( end - (start - 1) );
            String formatted = String.format("%.2f", ret);
            sb.append(formatted).append('\n');
        }

        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        prefixSum = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            prefixSum[i] = prefixSum[i - 1] +  Integer.parseInt(st.nextToken());
        }
    } // End of input()
} // End of Main class
