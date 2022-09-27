import java.util.*;
import java.io.*;

public class Main_15683_감시 {
    static int N, M;
    static int[][] map;
    static int[][] tempMap;
    static int[] dirX = {-1, 1, 0, 0}; // 상 하 좌 우
    static int[] dirY = {0, 0, -1, 1};

    static List<Coordinates> cctvList;

    static class Coordinates {
        int x;
        int y;
        int num;

        public Coordinates(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    } // End of Coordinates class


    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/15683.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        cctvList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] > 0 && map[i][j] < 6) {
                    cctvList.add(new Coordinates(i, j, map[i][j]));
                }
            }
        }

        // 지도에서 0은 빈칸, 6은 벽, 1 ~ 5는 CCTV
        // 사각 지대의 최소크기를 구하여라. -> 0이 가장 작은 곳 구하기.


    } // End of main

    private static void DFS(int depth, int depthLimit) {


    } // End of DFS

    private static void copy() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tempMap[i][j] = map[i][j];
            }
        }

    } // End of copy
} // End of Main class