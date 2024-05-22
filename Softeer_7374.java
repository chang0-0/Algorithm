import java.io.*;
import java.util.*;

public class Main {

    private static BufferedReader br;
    private static final int N = 3;

    private static int[][] map;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() throws IOException {
        StringBuilder sb = new StringBuilder();

        map = new int[N][N];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 가로 순
        int min = Integer.MAX_VALUE;
        for(int i=0; i<N; i++) {
            int[] t = new int[N];
            int[] t2 = new int[N];
            for(int j=0; j<N; j++) {
                t[j] = map[i][j];
                t2[j] = map[j][i];
            }
            
            min = Math.min(min, calc(t));
            min = Math.min(min, calc(t2));
        }

        sb.append(min);
        return sb.toString();
    } // End of solve()

    private static int calc(int[] t) {

        int min = Integer.MAX_VALUE;
        for(int i=0; i<N; i++) {
            int sum = 0;
            for(int j=0; j<N; j++) {
                sum += Math.abs(t[i] - t[j]);
            }

            min = Math.min(min, sum);
        } 

        return min;
    } // End of calc()
} // End of Main class