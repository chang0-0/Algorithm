package BOJ_3190;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_3190_뱀 {

    // https://www.acmicpc.net/problem/3190
    // input
    private static BufferedReader br;

    // variables
    private static int N, K, L;

    private static int[][] map;
    private static int[] dirX = {0, 1, 0, -1};
    private static int[] dirY = {1, 0, -1, 0};
    private static Direction[] directions;

    private static class Coordinate {
        int x;
        int y;

        private Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    } // End of Coordinate class

    private static class Direction {
        int time;
        char dir;

        private Direction(int num, char dir) {
            this.time = num;
            this.dir = dir;
        }
    } // End of Direction

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_3190\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        int time = 0;
        int directionIdx = 0;
        int direction = 0;
        int headX = 1, headY = 1; // 처음 시작 머리가 있는 곳
        Deque<Coordinate> snake = new LinkedList<>();
        snake.offer(new Coordinate(headX, headY));
        map[headX][headY] = 2;

        for (; ; ) {
            time++;

            int nextX = headX + dirX[direction];
            int nextY = headY + dirY[direction];

            if (!isAbleCheck(nextX, nextY)) break;

            if (map[nextX][nextY] != 1) {
                Coordinate tail = snake.pollLast();
                map[tail.x][tail.y] = 0;
            }

            snake.offer(new Coordinate(nextX, nextY));
            map[nextX][nextY] = 2;

            headX = nextX;
            headY = nextY;

            if (directionIdx < directions.length && directions[directionIdx].time == time) {
                if (directions[directionIdx].dir == 'L') {
                    direction = (direction + 3) % 4;
                } else {
                    direction = (direction + 1) % 4;
                }
                directionIdx++;
            }
        }

        sb.append(time);
        return sb.toString();
    } // End of solve()

    private static boolean isAbleCheck(int nextX, int nextY) {
        return nextX >= 1 && nextX <= N && nextY >= 1 && nextY <= N && map[nextX][nextY] != 2;
    } // End of isAbleCheck

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];

        StringTokenizer st;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
        }

        L = Integer.parseInt(br.readLine());
        directions = new Direction[L];
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            directions[i] = new Direction(
                    Integer.parseInt(st.nextToken()),
                    st.nextToken().charAt(0)
            );
        }
    } // End of input()
} // End of Main class
