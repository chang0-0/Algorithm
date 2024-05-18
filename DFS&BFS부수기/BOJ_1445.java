package BOJ_1445;

import java.io.*;
import java.util.*;

public class BOJ_1445 {

    // https://www.acmicpc.net/problem/1445
    // input
    private static BufferedReader br;

    // variables
    private static int N, M;
    private static char[][] arr;
    private static Coordinate start;
    private static final int[] dirX = {-1, 1, 0, 0};
    private static final int[] dirY = {0, 0, -1, 1};
    private static List<Coordinate> trash;

    private static class Coordinate implements Comparable<Coordinate> {
        int x;
        int y;
        int trashCount;
        int sideCount;

        private Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        private Coordinate(int x, int y, int trashCount, int sideCount) {
            this.x = x;
            this.y = y;
            this.trashCount = trashCount;
            this.sideCount = sideCount;
        }

        @Override
        public int compareTo(Coordinate o) {
            if (trashCount == o.trashCount) {
                return sideCount - o.sideCount;
            }

            return trashCount - o.trashCount;
        }
    } // End of Coordinate class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_1445\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        for (Coordinate t : trash) {
            for (int i = 0; i < 4; i++) {
                int nextX = dirX[i] + t.x;
                int nextY = dirY[i] + t.y;

                if (!isAbleCheck(nextX, nextY)) continue;

                if (arr[nextX][nextY] == '.') {
                    // 주변을 변경
                    arr[nextX][nextY] = 'x';
                }
            }
        }

        int[] ret = dijkstra();

        sb.append(ret[0]).append(' ').append(ret[1]);
        return sb.toString();
    } // End of solve()

    private static int[] dijkstra() {
        PriorityQueue<Coordinate> pque = new PriorityQueue<>();
        boolean[][] isVisited = new boolean[N][M];

        pque.offer(new Coordinate(start.x, start.y, 0, 0));

        while (!pque.isEmpty()) {
            Coordinate cur = pque.poll();

            if (isVisited[cur.x][cur.y]) continue;
            isVisited[cur.x][cur.y] = true;

            for (int i = 0; i < 4; i++) {
                int nextX = dirX[i] + cur.x;
                int nextY = dirY[i] + cur.y;

                if (!isAbleCheck(nextX, nextY)) continue;
                if (isVisited[nextX][nextY]) continue;
                // 먼저 주변에 쓰레기가 있는지 파악하자

                char temp = arr[nextX][nextY];
                if (temp == 'F') {
                    return new int[]{cur.trashCount, cur.sideCount};
                }

                if (temp == '.') {
                    pque.offer(new Coordinate(nextX, nextY, cur.trashCount, cur.sideCount));
                } else if (temp == 'g') {
                    pque.offer(new Coordinate(nextX, nextY, cur.trashCount + 1, cur.sideCount));
                } else if (temp == 'x') {
                    pque.offer(new Coordinate(nextX, nextY, cur.trashCount, cur.sideCount + 1));
                }
            }
        }

        return new int[]{0, 0};
    } // End of dijkstra()

    private static boolean isAbleCheck(int nextX, int nextY) {
        return nextX >= 0 && nextX < N && nextY >= 0 && nextY < M;
    } // End of isAbleCheck()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        trash = new ArrayList<>();

        arr = new char[N][M];
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = temp.charAt(j);

                if (arr[i][j] == 'S') {
                    start = new Coordinate(i, j);
                } else if (arr[i][j] == 'g') {
                    trash.add(new Coordinate(i, j));
                }
            }
        }
    } // End of input()
} // End of Main class
