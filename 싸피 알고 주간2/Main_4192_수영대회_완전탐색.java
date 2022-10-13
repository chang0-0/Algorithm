import java.util.*;
import java.io.*;

public class Main_4192_수영대회_완전탐색 {
    static int N, result;
    static int[][] map;

    static Coordinates startCoor;
    static Coordinates destiCoor;

    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1};

    static class Coordinates {
        int x;
        int y;
        int dist;

        public Coordinates(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        public Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }
    } // End of Coordinates class

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/4192.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append('#').append(t).append(' ');

            N = Integer.parseInt(br.readLine());
            init();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            st = new StringTokenizer(br.readLine());
            startCoor = new Coordinates(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            st = new StringTokenizer(br.readLine());
            destiCoor = new Coordinates(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));


            result = BFS(startCoor.x, startCoor.y);
            if (result == -1) {
                sb.append(result).append('\n');
            } else {
                sb.append(result).append('\n');
            }
        }

        bw.write(sb.toString());
        bw.close();
    } // End of main

    private static int BFS(int x, int y) {
        boolean[][] isVisited = new boolean[N][N];
        Queue<Coordinates> que = new LinkedList<>();

        que.offer(new Coordinates(x, y, 0));
        isVisited[x][y] = true;

        while (!que.isEmpty()) {
            Coordinates pollCoor = que.poll();

            for (int i = 0; i < 4; i++) {
                int nowX = dirX[i] + pollCoor.x;
                int nowY = dirY[i] + pollCoor.y;

                if (rangeCheck(nowX, nowY) && nowX == destiCoor.x && nowY == destiCoor.y) {
                    return pollCoor.dist + 1;
                } else if (rangeCheck(nowX, nowY) && !isVisited[nowX][nowY] && map[nowX][nowY] == 0) {
                    isVisited[nowX][nowY] = true;
                    que.offer(new Coordinates(nowX, nowY, pollCoor.dist + 1));

                }
            }
        }

        return -1;
    } // End of BFS


    private static boolean rangeCheck(int nowX, int nowY) {
        return nowX >= 0 && nowX < N && nowY >= 0 && nowY < N;
    } // End of rangeCheck

    private static void init() {
        map = new int[N][N];
        result = -1;
    } // End of init
} // End of Main class