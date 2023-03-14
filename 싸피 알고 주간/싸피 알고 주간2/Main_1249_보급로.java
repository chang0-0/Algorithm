import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1249_보급로 {
    private static final int INF = Integer.MAX_VALUE;
    static int N, result;
    static int[][] arr;
    static int[][] dist;
    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1};

    static class Coordinates implements Comparable<Coordinates> {
        int x;
        int y;
        int dist;

        public Coordinates(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(Coordinates o) {
            return this.dist - o.dist;
        }
    } // End of Coordinates

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/1249.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append('#').append(t).append(' ');
            N = Integer.parseInt(br.readLine());
            init();

            for (int i = 0; i < N; i++) {
                String temp = br.readLine();
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Character.getNumericValue(temp.charAt(j));
                    dist[i][j] = INF;
                }
            }

            sb.append(BFS(0, 0)).append('\n');
        }

        bw.write(sb.toString());
        bw.close();
    } // End of main

    private static int BFS(int x, int y) {
        PriorityQueue<Coordinates> pque = new PriorityQueue<>();
        pque.offer(new Coordinates(x, y, 0));

        while (!pque.isEmpty()) {
            Coordinates coor = pque.poll();

            for (int i = 0; i < 4; i++) {
                int nowX = coor.x + dirX[i];
                int nowY = coor.y + dirY[i];
                int time = coor.dist;

                if (rangeCheck(nowX, nowY) && dist[nowX][nowY] > time + arr[nowX][nowY]) {
                    dist[nowX][nowY] = time + arr[nowX][nowY];
                    pque.offer(new Coordinates(nowX, nowY, dist[nowX][nowY]));
                }
            }
        }

        return dist[N - 1][N - 1];
    } // End of BFS

    private static boolean rangeCheck(int nowX, int nowY) {
        return nowX >= 0 && nowX < N && nowY >= 0 && nowY < N;
    } // End of rangeCheck

    private static void init() {
        arr = new int[N][N];
        dist = new int[N][N];
        result = 0;
    } // End of init
} // End of Main class