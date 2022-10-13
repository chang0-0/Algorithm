import java.util.*;
import java.io.*;

public class Main_4485_녹색_옷_입은_애가_젤다지 {
    private static final int MAX_VAL = Integer.MAX_VALUE;
    private static final int ARR_SIZE = 126;
    static int N, result;
    static int[][] map = new int[ARR_SIZE][ARR_SIZE];
    static int[][] dist = new int[ARR_SIZE][ARR_SIZE];

    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1};

    private static class Coordinates implements Comparable<Coordinates> {
        int x;
        int y;
        int money;

        public Coordinates(int x, int y, int money) {
            this.x = x;
            this.y = y;
            this.money = money;
        }

        @Override
        public int compareTo(Coordinates o) {
            return money - o.money;
        }
    } // End of Coordinates class

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/4485.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = 1;
        String temp = "";
        while (!(temp = br.readLine()).isEmpty()) {
            N = Integer.parseInt(temp);
            if (N == 0) break;
            sb.append("Problem ").append(t).append(": ");

            init();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    dist[i][j] = MAX_VAL;
                }
            }

            // 0, 0에서 출발해서 N-1, N-1로 도착할 때 가장 적은 비용으로 도착(다익스트라)
            dijkstra();

            result = dist[N - 1][N - 1];
            t++;
            sb.append(result).append('\n');
        }

        bw.write(sb.toString());
        bw.close();
    } // End of main

    private static void dijkstra() {
        PriorityQueue<Coordinates> pque = new PriorityQueue<>();
        boolean[][] isVisited = new boolean[ARR_SIZE][ARR_SIZE];

        pque.offer(new Coordinates(0, 0, 0));
        isVisited[0][0] = true;
        dist[0][0] = map[0][0];

        while (!pque.isEmpty()) {
            Coordinates pollCoor = pque.poll();

            for (int i = 0; i < 4; i++) {
                int nowX = dirX[i] + pollCoor.x;
                int nowY = dirY[i] + pollCoor.y;
                int nowMoney = pollCoor.money;

                if (rangeCheck(nowX, nowY) && !isVisited[nowX][nowY] && dist[nowX][nowY] > dist[pollCoor.x][pollCoor.y] + map[nowX][nowY]) {
                    dist[nowX][nowY] = dist[pollCoor.x][pollCoor.y] + map[nowX][nowY];
                    isVisited[nowX][nowY] = true;
                    pque.offer(new Coordinates(nowX, nowY, dist[nowX][nowY]));
                }
            }

        }


    } // End of dijkstra

    private static boolean rangeCheck(int nowX, int nowY) {
        return nowX >= 0 && nowX < N && nowY >= 0 && nowY < N;
    } // End of rangeCheck

    private static void init() {
        result = Integer.MAX_VALUE;
    } // End of init
} // End of Main class