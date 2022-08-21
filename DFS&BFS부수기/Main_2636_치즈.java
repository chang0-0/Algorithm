import java.util.*;
import java.io.*;

public class Main_2636_치즈 {
    static int N, M;
    static int[][] arr;
    static boolean[][] isVisited;
    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {1, -1, 0, 0};
    static int area;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/2636.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 치즈에서 녹을 부분이 어떤 부분인지 파악해야 한다.
        // 0,0은 항상 0일 거임
        // 0을 기준으로 탐색해서 상하좌우 1인 부분을 다 지운다.
        // 전체가 0이되는 시간 구하기.
        int time = 1;
        for (; ; ) {
            isVisited = new boolean[N][M];
            area = 0;
            DFS(0, 0);
            boolean onlyZero = true;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] == 1) {
                        onlyZero = false;
                        break;
                    }
                }
                if (!onlyZero) {
                    break;
                }
            }

            if (onlyZero) {
                System.out.println(time); // 치즈가 모두 녹아서 없어지는데 걸리는 시간
                System.out.println(area); // 치즈가 모두 녹기 한 시간 전에 남아있는 치즈조각이 놓여 있는 칸의 개수
                return;
            }

            time++;
        }

    } // End of main

    private static void DFS(int x, int y) {
        isVisited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nowX = dirX[i] + x;
            int nowY = dirY[i] + y;

            // 1이면 0으로 만들어버림 대신 방문 처리
            if (rangeCheck(nowX, nowY) && !isVisited[nowX][nowY] && arr[nowX][nowY] == 1) {
                area++;
                arr[nowX][nowY]--;
                isVisited[nowX][nowY] = true;
            }

            if (rangeCheck(nowX, nowY) && !isVisited[nowX][nowY] && arr[nowX][nowY] == 0) {
                isVisited[nowX][nowY] = true;
                DFS(nowX, nowY);
            }
        }
    } // End of DFS

    private static boolean rangeCheck(int nowX, int nowY) {
        return nowX >= 0 && nowX < N && nowY >= 0 && nowY < M;
    } // End of rangeCheck
} // End of Main class