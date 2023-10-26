package BOJ_3190;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3190_뱀 {

    // https://www.acmicpc.net/problem/3190
    // input
    private static BufferedReader br;

    // variables
    private static int N, K, L;

    private static int[][] map;
    private static int[] dirX = {-1, 1, 0, 0};
    private static int[] dirY = {0, 0, -1, 1};
    private static Coordinate[] apples;
    private static Direction[] directions;

    private static class Coordinate {
        int x;
        int y;

        private Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    } // End of Coordinate class

    private static class Direction {
        int time;
        char dir;

        private Direction(int num, char dir) {
            this.time = num;
            this.dir = dir;
        }
    } // End of Direction

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_3190\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();




        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        map = new int[N][N];

        StringTokenizer st;
        apples = new Coordinate[K];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            apples[i] = new Coordinate(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            );
        }

        L = Integer.parseInt(br.readLine());
        directions = new Direction[L];
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            directions[i] = new Direction(
                    Integer.parseInt(st.nextToken()),
                    st.nextToken().charAt(0)
            );
        }
    } // End of input()
} // End of Main class
