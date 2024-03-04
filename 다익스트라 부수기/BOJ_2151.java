package BOJ_2151;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BOJ_2151 {

    // https://www.acmicpc.net/problem/2151
    // input
    private static BufferedReader br;

    // variables
    private static final int INF = 2501;
    private static int[] dirX = {-1, 0, 1, 0}; // 상 우 하 좌
    private static int[] dirY = {0, -1, 0, 1};
    private static int N;
    private static char[][] map;
    private static Coordinate[] doors;

    private static class Coordinate implements Comparable<Coordinate> {
        int x;
        int y;
        int count;
        int dir;

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
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_2151\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        sb.append(dijkstra(doors[0]));
        return sb.toString();
    } // End of solve()

    private static int dijkstra(Coordinate start) {
        int ans = INF;
        PriorityQueue<Coordinate> pque = new PriorityQueue<>();
        boolean[][][] isVisited = new boolean[N][N][4];
        int[][][] dist = new int[N][N][4];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(dist[i][j], INF);
            }
        }

        for (int i = 0; i < 4; i++) {
            pque.offer(new Coordinate(start.x, start.y, i, 0));
            dist[start.x][start.y][i] = 0;
        }

        while (!pque.isEmpty()) {
            Coordinate current = pque.poll();

            if (doors[1].x == current.x && doors[1].y == current.y && map[current.x][current.y] == '#') {
                return current.count;
            }

            if (isVisited[current.x][current.y][current.dir]) continue;
            if (dist[current.x][current.y][current.dir] < current.count) continue;
            isVisited[current.x][current.y][current.dir] = true;

            int nextX = 0;
            int nextY = 0;
            if (map[current.x][current.y] == '!') {
                // 거울 설치 가능 위치

                for (int i = 1; i <= 3; i += 2) {
                    int idx = (current.dir + i) % 4;
                    nextX = dirX[idx] + current.x;
                    nextY = dirY[idx] + current.y;
                    if (!isAbleCheck(nextX, nextY, idx, isVisited)) continue;
                    if (dist[nextX][nextY][idx] <= dist[current.x][current.y][current.dir] + 1) continue;
                    dist[nextX][nextY][idx] = dist[current.x][current.y][current.dir] + 1;
                    pque.offer(new Coordinate(nextX, nextY, idx, dist[nextX][nextY][idx]));
                }
            }

            // 거울 설치가능 위치여도 거울을 설치하지 않고 통과
            nextX = current.x + dirX[current.dir];
            nextY = current.y + dirY[current.dir];
            if (!isAbleCheck(nextX, nextY, current.dir, isVisited)) continue;
            if (dist[nextX][nextY][current.dir] <= dist[current.x][current.y][current.dir]) continue;
            dist[nextX][nextY][current.dir] = dist[current.x][current.y][current.dir];
            pque.offer(new Coordinate(nextX, nextY, current.dir, dist[nextX][nextY][current.dir]));
        }

        return ans;
    } // End of dijkstra()

    private static boolean isAbleCheck(int nextX, int nextY, int dir, boolean[][][] isVisited) {
        return nextX >= 0 && nextX < N && nextY >= 0 && nextY < N && !isVisited[nextX][nextY][dir] && map[nextX][nextY] != '*';
    } // End of isAbleCheck()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        int idx = 0;
        doors = new Coordinate[2];

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();

            for (int j = 0; j < N; j++) {
                map[i][j] = temp.charAt(j);

                if (map[i][j] == '#') {
                    doors[idx++] = new Coordinate(i, j);
                }
            }
        }
    } // End of input()
} // End of Main class
