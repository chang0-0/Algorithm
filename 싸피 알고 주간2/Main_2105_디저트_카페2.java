import java.util.*;
import java.io.*;

public class Main_2105_디저트_카페2 {
    static int N, result;
    static int[][] map;
    static boolean[][] isVisited;
    static boolean[] desertIsVisited; // 방문한 디저트를 체크

    static int[] dirX = {-1, 1, 1, -1};
    static int[] dirY = {1, 1, -1, -1};

    // 정답은 디저트를 가장 많이 먹을 때의 디저트 수.
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/2105.txt"));
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

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if ((i == 0 && j == 0) || (i == 0 && j == N - 1) || (i == N - 1 && j == 0) || (i == N - 1 && j == N - 1))
                        continue;

                    isVisited[i][j] = true;
                    desertIsVisited[map[i][j]] = true;
                    DFS(i, j, i, j, 1, 0); // i와 j부터 출발
                    desertIsVisited[map[i][j]] = false;
                    isVisited[i][j] = false;
                }
            }

            sb.append(result).append('\n');
        }

        bw.write(sb.toString());
        bw.close();
    } // End of main
    
    // 카페 투어중 같은 숫자의 디저트를 팔고 있는 카페가 있으면 안된다.
    // 대각선 뱡향으로 움직이고 사각형 모양을 그리며 출발한 카페로 돌아와야 한다.
    private static void DFS(int startX, int startY, int x, int y, int desertCount, int index) {

        for (int i = index; i < 4; i++) {
            int nowX = x + dirX[i];
            int nowY = y + dirY[i];

            if (!rangeCheck(nowX, nowY)) {
                continue;
            }

            if (nowX == startX && nowY == startY && desertCount >= 4) {
                result = Math.max(result, desertCount);
                return;
            }


            if (!isVisited[nowX][nowY] && !desertIsVisited[map[nowX][nowY]]) {
                isVisited[nowX][nowY] = true;
                desertIsVisited[map[nowX][nowY]] = true;
                DFS(startX, startY, nowX, nowY, desertCount + 1, i);
                isVisited[nowX][nowY] = false;
                desertIsVisited[map[nowX][nowY]] = false;
            }
        }

    } // End of DFS

    private static boolean rangeCheck(int nowX, int nowY) {
        return nowX >= 0 && nowX < N && nowY >= 0 && nowY < N;
    } // End of rangeCheck

    private static void init() {
        result = -1;
        map = new int[N][N];
        isVisited = new boolean[N][N];
        desertIsVisited = new boolean[101];
    } // End of init
} // End of Main class