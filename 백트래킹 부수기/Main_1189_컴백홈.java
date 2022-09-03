import java.util.*;
import java.io.*;

public class Main_1189_컴백홈 {
    static int R, C, K;
    static char[][] map;
    static boolean[][] isVisited;
    static int numberOfCases;

    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {-1, 1, 0, 0};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/1183.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        isVisited = new boolean[R][C];
        numberOfCases = 0;

        for (int i = 0; i < R; i++) {
            String temp = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = temp.charAt(j);
            }
        }

        // (R-1, 0)에서 출발해서, T는 갈 수 없는 곳,
        // (0, C-1)로 도착하는 방법중 길이가 K인 경우의 수 구하기.
        DFS(R - 1, 0, 1);
        System.out.println(numberOfCases);
    } // End of main

    private static void DFS(int x, int y, int depth) {
        isVisited[x][y] = true;

        if (depth == K && x == 0 && y == C - 1) {
            numberOfCases++;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nowX = x + dirX[i];
            int nowY = y + dirY[i];

            if (rangeCheck(nowX, nowY) && !isVisited[nowX][nowY] && map[nowX][nowY] == '.') {
                DFS(nowX, nowY, depth + 1);
                isVisited[nowX][nowY] = false;
            }
        }

    } // End of DFS

    private static boolean rangeCheck(int nowX, int nowY) {
        return nowX >= 0 && nowX < R && nowY >= 0 && nowY < C;
    } // End of rangeCheck
} //  End of Main class