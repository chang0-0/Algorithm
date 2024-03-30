package BOJ_1113;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_1113 {

    // https://www.acmicpc.net/problem/1113
    // input
    private static BufferedReader br;

    // variables
    private static int N, M, maxHeight;
    private static int[][] map;
    private static boolean[][] isVisited;
    private static final int[] dirX = {-1, 0, 1, 0}; // 상 우 하 좌
    private static final int[] dirY = {0, 1, 0, -1};

    private static class Coordinate {
        int x;
        int y;

        private Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    } // End of Coordinate class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_1113\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();


        int ans = 0;
        for (int i = 2; i <= maxHeight; i++) {
            isVisited = new boolean[N][M];

            for (int j = 1; j < N - 1; j++) {
                for (int k = 1; k < M - 1; k++) {

                    if (map[j][k] < i && !isVisited[j][k]) {
                        int ret = BFS(j, k, i);

                        if (ret != -1) {
                            ans += ret;
                        }
                    }

                }
            }
        }

        sb.append(ans);
        return sb.toString();
    } // End of solve()

    private static int BFS(int x, int y, int height) {
        LinkedList<Coordinate> que = new LinkedList<>();

        int ret = 0;
        que.offer(new Coordinate(x, y));
        isVisited[x][y] = true;
        boolean flag = true;

        while (!que.isEmpty()) {
            Coordinate current = que.poll();

            ret++;
            if (current.x == N - 1 || current.y == M - 1 || current.x == 0 || current.y == 0) {
                // 끝부분에 도달, 현재 높이가 시작한 높이보다 낮을 경우
                if (map[current.x][current.y] < height) {
                    // 물이 수영장 밖으로 빠져나가는 경우가 발생하면 안됨. 물은 높이가 낮은곳으로 이동한다. 같은 곳은 관계 없음

                    // 핵심 : 실패여부를 알아도 멈추지 않기 탐색할 수 있는 부분은 모두 탐색해서 중간에 끊기는 부분이 없도록 해야됨
                    flag = false;
                }
            }


            for (int i = 0; i < 4; i++) {
                int nextX = dirX[i] + current.x;
                int nextY = dirY[i] + current.y;

                if (!isAbleCheck(nextX, nextY)) continue;

                if (map[nextX][nextY] >= height) continue; // 자기보다 높이가 같거나 높은 곳은 통과

                que.offer(new Coordinate(nextX, nextY));
                isVisited[nextX][nextY] = true;
            }
        }

        if (!flag) {
            ret = -1;
        }

        return ret;
    } // End of BFS()

    private static boolean isAbleCheck(int nextX, int nextY) {
        return nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && !isVisited[nextX][nextY];
    } // End of isAbleCheck()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 가장 바깥쪽은 0으로 도배
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = temp.charAt(j) - '0';
                maxHeight = Math.max(maxHeight, map[i][j]);
            }
        }
    } // End of input()
} // End of Main class
