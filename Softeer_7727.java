import java.io.*;
import java.util.*;

public class Main {
    
    // input
    private static BufferedReader br;

    // variables
    private static int N, M, ans;
    private static int[][] map, copy;
    private static int[] comb;
    private static Coordinate[] starts;
    private static boolean[] combIsVisited;

    private static Set<Coordinate> set;
    
    
    private static final int[] dirX = {-1, 1, 0, 0};
    private static final int[] dirY = {0, 0, -1, 1};

    private static class Coordinate {
        int x;
        int y;
        int time;
        int count;

        private Coordinate(int x,int y) {
            this.x = x;
            this.y = y;
        }

        private Coordinate(int x, int y, int time, int count) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.count = count;
        }
    } // End of Coordinate class

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        DFS(0, 0);

        sb.append(ans);
        return sb.toString();
    } // End of solve()

    private static void DFS(int idx, int depth) {
        if(depth == M) {
            ans = Math.ans(ans, getResult());
            return;
        }

        for(int i=idx; i<M; i++) {
            if(combIsVisited[i]) continue;
            combIsVisited[i] = true;
            comb[depth] = i;
            DFS(idx, depth + 1);
            combIsVisited[i] = false;
        }
    } // End of DFS() 

    private static int getResult(int x, int y) {

        for(int i=0; i<4; i++) {
            int nextX = dirX[i] + x;
            int nextY = dirY[i] + y;
            if(!isAbleCheck(nextX, nextY)) continue;
            if(set.contains())
            
        }
        
    } // End of getResult()

    private static void copy() {
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                map[i][j] = copy[i][j];
            }
        }
    } // End of copy()

    private static void DFS() {
        if(is)
        
    } // End of DFS()

    private static boolean isAbleCheck(int nextX, int nextY) {
        return nextX >= 1 && nextX <= N && nextY >= 1 && nextY <= N;
    } // End of isAbleCheck()
    
    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ans = 0;

        starts = new Coordinate[M];
        comb = new int[M];
        combIsVisited = new boolean[M];
        map = new int[N + 1][N + 1];
        copy = new int[N + 1][N + 1];
        set = new HashSet<>();
        
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                copy[i][j] = map[i][j];
            }
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            starts[i] = new Coordinate(x, y);
        }
    } // End of input()
} // End of Main class