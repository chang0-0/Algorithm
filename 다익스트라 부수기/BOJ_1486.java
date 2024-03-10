package BOJ_1486;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1486 {

    // https://www.acmicpc.net/problem/1486
    // input
    private static BufferedReader br;

    // variables
    private static final int INF = Integer.MAX_VALUE;
    private static int N, M, T, D;
    private static int[][] map;

    private static final int[] dirX = {-1, 0, 1, 0};
    private static final int[] dirY = {0, -1, 0, 1};

    private static class Coordinate implements Comparable<Coordinate> {
        int x;
        int y;
        int time;

        private Coordinate(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }

        @Override
        public int compareTo(Coordinate o) {
            return time - o.time;
        }
    } // End of Coordinate class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_1486\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        // 호텔 -> 산
        int[][] upDist = dijkstra("up");

        // 산 -> 호텔
        int[][] downDist = dijkstra("down");

        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (downDist[i][j] != INF && upDist[i][j] != INF && downDist[i][j] + upDist[i][j] <= D) {
                    ans = Math.max(ans, map[i][j]);
                }
            }
        }

        sb.append(ans);
        return sb.toString();
    } // End of solve()

    private static int[][] dijkstra(String dir) {
        PriorityQueue<Coordinate> pque = new PriorityQueue<>();
        boolean[][] isVisited = new boolean[N][M];
        int[][] dist = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], INF);
        }

        // D시간안에 갈 수 있는 곳
        pque.offer(new Coordinate(0, 0, 0));
        dist[0][0] = 0;

        while (!pque.isEmpty()) {
            Coordinate current = pque.poll();
            int nowHeight = map[current.x][current.y];

            if (isVisited[current.x][current.y]) continue;
            if (dist[current.x][current.y] < current.time) continue;
            isVisited[current.x][current.y] = true;

            for (int i = 0; i < 4; i++) {
                int nextX = dirX[i] + current.x;
                int nextY = dirY[i] + current.y;

                if (!isAbleCheck(nextX, nextY, isVisited)) continue;

                int diff = 0;
                if (dir.equals("up")) {
                    diff = distCalc(nowHeight, map[nextX][nextY]);
                } else {
                    diff = distCalc(map[nextX][nextY], nowHeight);
                }

                if (diff == 1) {
                    if (dist[nextX][nextY] > dist[current.x][current.y] + 1) {
                        dist[nextX][nextY] = dist[current.x][current.y] + 1;
                        pque.offer(new Coordinate(nextX, nextY, dist[nextX][nextY]));
                    }
                } else if (diff != -1) {
                    if (dist[nextX][nextY] > dist[current.x][current.y] + diff) {
                        dist[nextX][nextY] = dist[current.x][current.y] + diff;
                        pque.offer(new Coordinate(nextX, nextY, dist[nextX][nextY]));
                    }
                }
            }
        }

        return dist;
    } // End of dijkstra()

    private static boolean isAbleCheck(int nextX, int nextY, boolean[][] isVisited) {
        return nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && !isVisited[nextX][nextY];
    } // End of isAbleCheck()

    private static int distCalc(int nowHeight, int nextHeight) {
        int diff = nextHeight - nowHeight;

        if (diff > 0 && diff <= T) {
            return (int) Math.pow(diff, 2);
        } else if (diff <= 0 && diff >= T * -1) {
            return 1;
        }
        return -1;
    } // End of distCalc()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken()); // 제한 높이차
        D = Integer.parseInt(st.nextToken()); // 시간

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                char ch = temp.charAt(j);

                if (ch >= 'A' && ch <= 'Z') {
                    map[i][j] = ch - 'A';
                } else {
                    map[i][j] = (26 + (ch - 'a'));
                }
            }
        }
    } // End of input()
} // End of Main class
