package BOJ_1726;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_1726_로봇 {

    // https://www.acmicpc.net/problem/1726
    // input
    private static BufferedReader br;

    // variables
    private static int M, N;
    private static int[][] map;
    private static Coordinate start, end;
    private static int[] dirX = {0, 0, 1, -1}; // 동 서 남 북
    private static int[] dirY = {1, -1, 0, 0};

    private static class Coordinate {
        int x;
        int y;
        int dir;
        int orderCount;

        private Coordinate(int x, int y, int dir, int moveCount) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.orderCount = moveCount;
        }
    } // End of Coordinate class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_1726\\res.txt"));
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
        LinkedList<Coordinate> que = new LinkedList<>();
        // 방향을 포함한 방문 여부체크, 3차원 배열
        boolean[][][] isVisited = new boolean[M][N][4];
        que.offer(start);

        while (!que.isEmpty()) {
            Coordinate now = que.poll();

            if (now.x == end.x && now.y == end.y && now.dir == end.dir) {
                return now.orderCount;
            }

            // 명령 1 : Go k : k는 1, 2, 또는 3일 수 있다.
            for (int i = 1; i <= 3; i++) {
                int nextX = now.x + dirX[now.dir] * i;
                int nextY = now.y + dirY[now.dir] * i;

                if (!isAbleCheck(nextX, nextY)) break; // 갈 수 없는 곳 일 경우 더 이상 진행하지 않음
                if (isVisited[nextX][nextY][now.dir]) continue;

                isVisited[nextX][nextY][now.dir] = true;
                que.offer(new Coordinate(nextX, nextY, now.dir, now.orderCount + 1));
            }

            // 명령 2 : Turn dir (현재 위치에서 방향만 전환)
            for (int i = 0; i < 4; i++) {
                if (i == now.dir) continue; // 기존의 같은 진행 방향은 skip

                // 반대 방향은 skip
                if ((now.dir == 0 && i == 1) || (now.dir == 1 && i == 0) || (now.dir == 2 && i == 3) || (now.dir == 3 && i == 2))
                    continue;

                if (isVisited[now.x][now.y][i]) continue;
                isVisited[now.x][now.y][i] = true;
                que.offer(new Coordinate(now.x, now.y, i, now.orderCount + 1));
            }
        }

        return 0;
    } // End of BFS()

    private static boolean isAbleCheck(int nextX, int nextY) {
        return nextX >= 0 && nextX < M && nextY >= 0 && nextY < N && map[nextX][nextY] == 0;
    } // End of isAbleCheck()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        // 0과 1인데, 0은 궤도가 깔려있어 로봇이 움직일 수 있는 지점
        // 1은 궤도가 없어 로봇이 이동 할 수 없는 지점
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        start = new Coordinate(
                Integer.parseInt(st.nextToken()) - 1,
                Integer.parseInt(st.nextToken()) - 1,
                Integer.parseInt(st.nextToken()) - 1,
                0
        );

        st = new StringTokenizer(br.readLine());
        end = new Coordinate(
                Integer.parseInt(st.nextToken()) - 1,
                Integer.parseInt(st.nextToken()) - 1,
                Integer.parseInt(st.nextToken()) - 1,
                0
        );
    } // End of input()
} // End of Main class
