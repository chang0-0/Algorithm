package BOJ_18405;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_18405 {

    // https://www.acmicpc.net/problem/18405
    // input
    private static BufferedReader br;

    // variables
    private static int N, K, S;
    private static int[][] arr;
    private static Coordinate target;
    private static final int[] dirX = {-1, 1, 0, 0};
    private static final int[] dirY = {0, 0, -1, 1};

    private static class Coordinate implements Comparable<Coordinate> {
        int x;
        int y;
        int num;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Coordinate(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }

        @Override
        public int compareTo(Coordinate o) {
            return num - o.num;
        }

        @Override
        public String toString() {
            return "Coordinate{" +
                    "x=" + x +
                    ", y=" + y +
                    ", num=" + num +
                    '}' + '\n';
        }
    } // End of Coordinate class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_18405\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        sb.append(BFS());
        return sb.toString();
    } // End of solve()

    private static int BFS() {
        PriorityQueue<Coordinate> pQue = new PriorityQueue<>();
        boolean[][] isVisited = new boolean[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (arr[i][j] != 0) {
                    pQue.offer(new Coordinate(i, j, arr[i][j]));
                    isVisited[i][j] = true;
                }
            }
        }

        for (int i = 0; i < S; i++) {
            List<Coordinate> list = new ArrayList<>();
            while (!pQue.isEmpty()) {
                Coordinate current = pQue.poll();

                for (int j = 0; j < 4; j++) {
                    int nextX = dirX[j] + current.x;
                    int nextY = dirY[j] + current.y;

                    if (!isAbleCheck(nextX, nextY, isVisited, current.num)) continue;

                    list.add(new Coordinate(nextX, nextY, current.num));
                    isVisited[nextX][nextY] = true;
                    arr[nextX][nextY] = current.num;
                }
            }

            if (list.isEmpty()) {
                break;
            } else {
                for (Coordinate c : list) {
                    pQue.offer(c);
                }
            }
        }

        return arr[target.x][target.y];
    } // End of BFS()

    private static boolean isAbleCheck(int nextX, int nextY, boolean[][] isVisited, int num) {
        return nextX >= 1 && nextX <= N && nextY >= 1 && nextY <= N && !isVisited[nextX][nextY] && arr[nextX][nextY] == 0;
    } // End of isAbleCheck()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        target = new Coordinate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    } // End of input()
} // End of Main class
