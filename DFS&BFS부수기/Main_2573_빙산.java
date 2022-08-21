import java.util.*;
import java.io.*;

public class Main_2573_빙산 {
    static int N, M;
    static int[][] arr;
    static int[][] tempArr;
    static boolean[][] isVisited;

    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {-1, 1, 0, 0};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/2573.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        tempArr = new int[N][M];

        int highestHeightIceberg = -1;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                highestHeightIceberg = Math.max(highestHeightIceberg, arr[i][j]);
            }
        }

        // 몇개의 덩어리로 구분이 되어 있는가?
        // 두 덩어리 이상으로 분리되는 최초의 시간.
        // 두 덩어리가 되지 않을 경우, 0을 출력
        int area = 0;
        int year = 0;
        for (; ; ) {
            if (year > 0) {
                if (!globalWarming()) {
                    // 빙산이 모두 녹아 0이 될 때 까지 덩어리가 2개 이상이 되지 않으면, 0출력 return
                    System.out.println(0);
                    return;
                }

                area = 0;
            }

            isVisited = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] > 0 && !isVisited[i][j]) {
                        area++;
                        DFS(i, j);
                    }

                    if (area >= 2) {
                        System.out.println(year);
                        return;
                    }
                }
            }

            year++;
        }
    } // End of main

    private static void DFS(int x, int y) {
        isVisited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nowX = x + dirX[i];
            int nowY = y + dirY[i];

            if (rangeCheck(nowX, nowY) && !isVisited[nowX][nowY] && arr[nowX][nowY] > 0) {
                DFS(nowX, nowY);
            }
        }

    } // End of DFS

    private static boolean rangeCheck(int nowX, int nowY) {
        return nowX >= 0 && nowX < N && nowY >= 0 && nowY < M;
    } // End of rangeCheck

    private static boolean globalWarming() {
        boolean zeroAnotherNumberCheck = false; // 빙산이 모두 녹아서 0으로만 이루어져 있는지를 체크

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] > 0) {
                    int count = 0;

                    // 4가지 방향을 탐색해서 갈 수 바다와 접한 부분 하나씩 감소
                    for (int k = 0; k < 4; k++) {
                        int nowX = i + dirX[k];
                        int nowY = j + dirY[k];

                        if (rangeCheck(nowX, nowY) && arr[nowX][nowY] == 0) {
                            count++;
                        }
                    }

                    // tempArr을 써야 하는 이유
                    // 기존에 있던 2차원 배열에서 빙산의 크기를 감소하는 작업을 할 경우, 0이된 빙산이 생겼을 때, 이후의 빙산이 영향을 받음
                    // 가령,

                    if (arr[i][j] - count <= 0) {
                        tempArr[i][j] = 0;
                    } else {
                        tempArr[i][j] = arr[i][j] - count;
                        zeroAnotherNumberCheck = true;
                    }
                }
            }
        }

        if (!zeroAnotherNumberCheck) { // 빙산에 숫자가 전부 0일 경우, 모두 녹았을 경우 곧바로 false return
            return false;
        }

        copy(); // 계산 된 빙산을 다시 복사
        return true;
    } // End of globalWarming

    private static void copy() {
        // 계산된 빙산을 다시 복사.
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = tempArr[i][j];
            }
        }
    } // End of copy
} // End of Main class