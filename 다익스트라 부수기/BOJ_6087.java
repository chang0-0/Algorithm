package BOJ_6087;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_6087 {

    // https://www.acmicpc.net/problem/6087
    // input
    private static BufferedReader br;

    // variables
    private static final int INF = Integer.MAX_VALUE;
    private static final int[] dirX = {-1, 0, 1, 0}; // 상 좌 하 우
    private static final int[] dirY = {0, -1, 0, 1};
    private static int N, M, S, G, H;
    private static Coordinate[] dests;
    private static char[][] map;

    private static class Coordinate implements Comparable<Coordinate> {
        int x;
        int y;
        int dir;
        int count;

        private Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        private Coordinate(int x, int y, int dir, int count) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.count = count;
        }

        @Override
        public int compareTo(Coordinate o) {
            return count - o.count;
        }
    } // End of Coordinate class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_6087\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        sb.append(dijkstra(dests[0]));
        return sb.toString();
    } // End of solve()

    private static int dijkstra(Coordinate start) {
        // .으로 된곳에는 모든 곳에 거울을 설치할 수 있다.
        PriorityQueue<Coordinate> pque = new PriorityQueue<>();
        boolean[][][] isVisited = new boolean[N][M][4];
        int[][][] dist = new int[N][M][4];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Arrays.fill(dist[i][j], INF);
            }
        }

        for (int i = 0; i < 4; i++) {
            pque.offer(new Coordinate(start.x, start.y, i, 0));
            dist[start.x][start.y][i] = 0;
        }

        while (!pque.isEmpty()) {
            Coordinate current = pque.poll();

            if (current.x == dests[1].x && current.y == dests[1].y && map[current.x][current.y] == 'C') {
                return current.count;
            }
            if (dist[current.x][current.y][current.dir] < current.count) continue;
            if (isVisited[current.x][current.y][current.dir]) continue;
            isVisited[current.x][current.y][current.dir] = true;

            int nextX = 0;
            int nextY = 0;
            for (int i = 1; i <= 3; i += 2) {
                int idx = (current.dir + i) % 4;

                nextX = current.x + dirX[idx];
                nextY = current.y + dirY[idx];
                if (!isAbleCheck(nextX, nextY, idx, isVisited)) continue;
                if (dist[nextX][nextY][idx] <= dist[current.x][current.y][current.dir] + 1) continue;

                dist[nextX][nextY][idx] = dist[current.x][current.y][current.dir] + 1;
                pque.offer(new Coordinate(nextX, nextY, idx, dist[nextX][nextY][idx]));
            }

            nextX = current.x + dirX[current.dir];
            nextY = current.y + dirY[current.dir];
            if (!isAbleCheck(nextX, nextY, current.dir, isVisited)) continue;
            if (dist[nextX][nextY][current.dir] <= dist[current.x][current.y][current.dir]) continue;

            dist[nextX][nextY][current.dir] = dist[current.x][current.y][current.dir];
            pque.offer(new Coordinate(nextX, nextY, current.dir, dist[nextX][nextY][current.dir]));
        }

        return INF;
    } // End of dijkstra()

    private static boolean isAbleCheck(int nextX, int nextY, int dir, boolean[][][] isVisited) {
        return nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && !isVisited[nextX][nextY][dir] && map[nextX][nextY] != '*';
    } // End of isAbleCheck()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        dests = new Coordinate[2];
        int idx = 0;

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = temp.charAt(j);

                if (map[i][j] == 'C') {
                    dests[idx++] = new Coordinate(i, j);
                }
            }
        }

    } // End of input()
} // End of Main class