package BOJ_31946;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_31946 {

    // https://www.acmicpc.net/problem/31946
    // input
    private static BufferedReader br;

    // variables
    private static int N, M, X;
    private static int[][] arr;
    private static List<Coordinate> sameColorList;

    private static class Coordinate {
        int x;
        int y;
        int color;

        private Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    } // End of Coordinate class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_31946\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        if (BFS()) {
            sb.append("ALIVE");
        } else {
            sb.append("DEAD");
        }

        return sb.toString();
    } // End of solve()

    private static boolean BFS() {
        ArrayDeque<Coordinate> que = new ArrayDeque<>();
        boolean[][] isVisited = new boolean[N][M];
        que.offer(new Coordinate(0, 0));
        isVisited[0][0] = true;

        while (!que.isEmpty()) {
            Coordinate cur = que.poll();

            if (cur.x == N - 1 && cur.y == M - 1) {
                return true;
            }

            for (Coordinate coor : sameColorList) {
                int dist = distCalc(cur.x, cur.y, coor.x, coor.y);

                if (X >= dist && !isVisited[coor.x][coor.y]) {
                    isVisited[coor.x][coor.y] = true;
                    que.offer(new Coordinate(coor.x, coor.y));
                }
            }
        }

        return false;
    } // End of BFS()

    private static int distCalc(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    } // End of distCalc()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        arr = new int[N][M];
        sameColorList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if (arr[0][0] == arr[i][j]) {
                    sameColorList.add(new Coordinate(i, j));
                }
            }
        }

        X = Integer.parseInt(br.readLine());
    } // End of input()
} // End of Main class
