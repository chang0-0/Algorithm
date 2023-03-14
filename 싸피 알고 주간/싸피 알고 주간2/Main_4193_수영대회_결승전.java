import java.util.*;
import java.io.*;

public class Main_4193_수영대회_결승전 {
    static int N, result;
    static int[][] map;
    static int[][] time;

    static Coordinates startCoor;
    static Coordinates destiCoor;

    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1};

    static class Coordinates {
        int x;
        int y;
        int time;

        public Coordinates(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }

        public Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }
    } // End of Coordinates class

    // 소용돌이 주기는 2초
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/4193.txt"));
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

            for (int[] num : time) System.out.println(Arrays.toString(num));


            sb.append(result).append('\n');
        }

        bw.write(sb.toString());
        bw.close();
    } // End of main

    // 2초에 소용돌이가 사라지고 실제로는 3초에 건넌다.
    // 홀수의 초 일 때, 소용돌이 자리에 이동할 수 있음.
    private static int BFS(int x, int y) {
        boolean[][] isVisited = new boolean[N][N];
        Queue<Coordinates> que = new LinkedList<>();

        que.offer(new Coordinates(x, y));
        isVisited[x][y] = true;

        while (!que.isEmpty()) {
            Coordinates pollCoor = que.poll();

            for (int i = 0; i < 4; i++) {
                int nowX = dirX[i] + pollCoor.x;
                int nowY = dirY[i] + pollCoor.y;
                int nowTime = pollCoor.time;

                if (!rangeCheck(nowX, nowY) || isVisited[nowX][nowY] || map[nowX][nowY] == 1) continue;

                if (nowX == destiCoor.x && nowY == destiCoor.y) {
                    return pollCoor.time + 1;
                }

                if (map[nowX][nowY] == 2) {
                    // 실제로 소용돌이 자리로 이동하는 것은 3초대.
                    if ((nowTime % 3) == 2) {
                        System.out.println("nowTime : " + nowTime);
                        time[nowX][nowY] = nowTime + 1;
                        que.offer(new Coordinates(nowX, nowY, nowTime + 1));
                        isVisited[nowX][nowY] = true;
                    } else {
                        // 소용돌이를 지나갈 수 없을때는 제자리에서 시간만 증가.
                        time[pollCoor.x][pollCoor.y] = nowTime + 1;
                        que.offer(new Coordinates(pollCoor.x, pollCoor.y, nowTime + 1));
                        //isVisited[pollCoor.x][pollCoor.y] = true;
                    }
                } else if (map[nowX][nowY] == 0) {
                    // 0일 때는 특별한 조건 없이 이동가능
                    time[nowX][nowY] = nowTime + 1;
                    isVisited[nowX][nowY] = true;
                    que.offer(new Coordinates(nowX, nowY, nowTime + 1));
                    //map[nowX][nowY] = nowTime + 1;
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
        time = new int[N][N];
        result = 200;
    } // End of init
} // End of Main class