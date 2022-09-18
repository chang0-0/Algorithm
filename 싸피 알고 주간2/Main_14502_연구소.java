import java.util.*;
import java.io.*;

public class Main_14502_연구소 {
    static int N, M, result;
    static int[][] map, tempMap;
    static boolean[][] isVisited = new boolean[N][M];
    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1};

    static List<Coordinates> virusCorList; // 바이러스 좌표값
    static List<Coordinates> safetyCorList; // 안전구역 좌표값
    static Coordinates[] comb;

    static class Coordinates {
        int x;
        int y;

        public Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }
    } // End of Coordinates class

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/14502.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        init();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                tempMap[i][j] = map[i][j];

                if (map[i][j] == 2) {
                    virusCorList.add(new Coordinates(i, j));
                } else if (map[i][j] == 0) {
                    safetyCorList.add(new Coordinates(i, j));
                }
            }
        }

        DFS(0, safetyCorList.size(), 0);
        System.out.println(result); // 안전영역의 최댓값
    } // End of main

    private static void DFS(int depth, int safetyZoneSize, int index) { // 벽을 세우는 경우의 수를 만들기.
        if (depth == 3) {
            for (Coordinates cor : comb) { // 만든 조합으로 벽세우기
                tempMap[cor.x][cor.y] = 1;
            }

            isVisited = new boolean[N][M];
            for (Coordinates cor : virusCorList) {
                BFS(cor.x, cor.y);
            }

            int sum = countingAndCopy(); // 복사를 하면서 안전구역 숫자 세기
            result = Math.max(result, sum);
            return;
        }

        for (int i = index; i < safetyZoneSize; i++) {
            comb[depth] = safetyCorList.get(i);
            DFS(depth + 1, safetyZoneSize, i + 1);
        }
    } // End of DFS

    private static void BFS(int x, int y) { // 바이러스 퍼트리기
        Queue<Coordinates> que = new LinkedList<>();
        que.offer(new Coordinates(x, y));

        while (!que.isEmpty()) {
            Coordinates cor = que.poll();

            for (int i = 0; i < 4; i++) {
                int nowX = cor.x + dirX[i];
                int nowY = cor.y + dirY[i];

                if (rangeCheck(nowX, nowY) && !isVisited[nowX][nowY] && tempMap[nowX][nowY] == 0) {
                    isVisited[nowX][nowY] = true;
                    tempMap[nowX][nowY] = 2; // 바이러스 퍼트림.
                    que.offer(new Coordinates(nowX, nowY));
                }
            }
        }
    } // End of BFS

    private static boolean rangeCheck(int nowX, int nowY) {
        return nowX >= 0 && nowX < N && nowY >= 0 && nowY < M;
    } // End of rangeCheck

    private static int countingAndCopy() {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tempMap[i][j] == 0) {
                    sum++;
                }
                tempMap[i][j] = map[i][j];
            }
        }

        return sum;
    } // End of copy

    private static void init() {
        map = new int[N][M];
        tempMap = new int[N][M];
        result = Integer.MIN_VALUE;
        virusCorList = new ArrayList<>();
        safetyCorList = new ArrayList<>();
        comb = new Coordinates[3];
    } // End of init
} // End of Main class