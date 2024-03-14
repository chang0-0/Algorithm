package BOJ_11909;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_11909 {

    // https://www.acmicpc.net/problem/11909
    // input
    private static BufferedReader br;

    // variables
    private static int N;
    private static int[][] arr;
    private static final int INF = Integer.MAX_VALUE / 8;

    private static class Coordinate implements Comparable<Coordinate> {
        int x;
        int y;
        int cost;

        private Coordinate(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Coordinate o) {
            return cost - o.cost;
        }
    } // End of Coordinate class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_11909\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        sb.append(dijkstra());
        return sb.toString();
    } // End of solve()

    private static int dijkstra() {
        PriorityQueue<Coordinate> pque = new PriorityQueue<>();
        boolean[][] isVisited = new boolean[N + 1][N + 1];
        int[][] costs = new int[N + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(costs[i], INF);
        }

        // 자기보다 같거나 높으면 비용 1을 추가해서 갈 수 있다.
        pque.offer(new Coordinate(1, 1, 0));
        costs[1][1] = 0;

        while (!pque.isEmpty()) {
            Coordinate current = pque.poll();
            int nowX = current.x;
            int nowY = current.y;
            int nextX = nowX;
            int nextY = nowY;

            if (costs[nextX][nextY] > costs[nowX][nowY]) continue;

            if (nowX == N && nowY == N) {
                return current.cost;
            }

            if (nowX == N) {
                nextY = nowY + 1;
                if (!isAbleCheck(nextX, nextY, isVisited)) continue;
                if (arr[nowX][nowY] <= arr[nextX][nextY]) {
                    if (costs[nextX][nextY] > costs[nowX][nowY] + (1 + arr[nextX][nextY] - arr[nowX][nowY])) {
                        costs[nextX][nextY] = costs[nowX][nowY] + (1 + arr[nextX][nextY] - arr[nowX][nowY]);
                        pque.offer(new Coordinate(nextX, nextY, costs[nextX][nextY]));
                    }

                } else {
                    if (costs[nextX][nextY] > costs[nowX][nowY]) {
                        costs[nextX][nextY] = costs[nowX][nowY];
                        pque.offer(new Coordinate(nextX, nextY, costs[nextX][nextY]));
                    }
                }

            } else if (nowY == N) {
                nextX = nowX + 1;
                if (!isAbleCheck(nextX, nextY, isVisited)) continue;
                if (arr[nowX][nowY] <= arr[nextX][nextY]) {
                    if (costs[nextX][nextY] > costs[nowX][nowY] + (1 + arr[nextX][nextY] - arr[nowX][nowY])) {
                        costs[nextX][nextY] = costs[nowX][nowY] + (1 + arr[nextX][nextY] - arr[nowX][nowY]);
                        pque.offer(new Coordinate(nextX, nextY, costs[nextX][nextY]));
                    }
                } else {
                    if (costs[nextX][nextY] > costs[nowX][nowY]) {
                        costs[nextX][nextY] = costs[nowX][nowY];
                        pque.offer(new Coordinate(nextX, nextY, costs[nextX][nextY]));
                    }
                }

            } else {
                nextY = nowY + 1;
                if (!isAbleCheck(nextX, nextY, isVisited)) continue;
                if (arr[nowX][nowY] <= arr[nextX][nextY]) {
                    if (costs[nextX][nextY] > costs[nowX][nowY] + (1 + arr[nextX][nextY] - arr[nowX][nowY])) {
                        costs[nextX][nextY] = costs[nowX][nowY] + (1 + arr[nextX][nextY] - arr[nowX][nowY]);
                        pque.offer(new Coordinate(nextX, nextY, costs[nextX][nextY]));
                    }
                } else {
                    if (costs[nextX][nextY] > costs[nowX][nowY]) {
                        costs[nextX][nextY] = costs[nowX][nowY];
                        pque.offer(new Coordinate(nextX, nextY, costs[nextX][nextY]));
                    }
                }

                nextY = nowY;
                nextX = nowX + 1;
                if (!isAbleCheck(nextX, nextY, isVisited)) continue;
                if (arr[nowX][nowY] <= arr[nextX][nextY]) {
                    if (costs[nextX][nextY] > costs[nowX][nowY] + (1 + arr[nextX][nextY] - arr[nowX][nowY])) {
                        costs[nextX][nextY] = costs[nowX][nowY] + (1 + arr[nextX][nextY] - arr[nowX][nowY]);
                        pque.offer(new Coordinate(nextX, nextY, costs[nextX][nextY]));
                    }
                } else {
                    if (costs[nextX][nextY] > costs[nowX][nowY]) {
                        costs[nextX][nextY] = costs[nowX][nowY];
                        pque.offer(new Coordinate(nextX, nextY, costs[nextX][nextY]));
                    }
                }
            }
        }

        return 0;
    } // End of dijkstra()

    private static boolean isAbleCheck(int nextX, int nextY, boolean[][] isVisited) {
        return nextX >= 1 && nextX <= N && nextY >= 1 && nextY <= N && !isVisited[nextX][nextY];
    } // End of isAbleCheck()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    } // End of input()
} // End of Main class
