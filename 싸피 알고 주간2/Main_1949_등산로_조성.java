import java.util.*;
import java.io.*;


// 최대 공사 가능 깊이는 K
// 높이가 0이 될 수 도 있다.
// 가장 긴 등산로의 길이를 찾아서 결과로 출력
// 딱 한 곳을 정해서 최대 K 깊이만큼 지형을 깎는 공사를 할 수 있다.
public class Main_1949_등산로_조성 {
    static int N, K, result;
    static int[][] map;
    static boolean[][] isVisited;

    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/1949.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append('#').append(t).append(' ');

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            init();

            int maxHeight = -1;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    maxHeight = Math.max(map[i][j], maxHeight);
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (maxHeight != map[i][j]) continue;

                    isVisited[i][j] = true;
                    DFS(i, j, 1, map[i][j], K);
                    isVisited[i][j] = false;
                }
            }

            sb.append(result).append('\n');
        }

        bw.write(sb.toString());
        bw.close();
    } // End of main

    // 백트래킹을 통해서 등산로를 깎으면서 갈 수 있는 모든 길을 다 가봄.
    private static void DFS(int x, int y, int length, int height, int k) {
        // 최대 길이를 매번 갱신.
        result = Math.max(length, result);

        for (int i = 0; i < 4; i++) {
            int nowX = dirX[i] + x;
            int nowY = dirY[i] + y;

            if (!rangeCheck(nowX, nowY) || isVisited[nowX][nowY]) continue;

            if (k == 0) {
                if (map[nowX][nowY] < height) {
                    isVisited[nowX][nowY] = true;
                    DFS(nowX, nowY, length + 1, map[nowX][nowY], k);
                    isVisited[nowX][nowY] = false;
                }
            } else {
                if (map[nowX][nowY] < height) {
                    isVisited[nowX][nowY] = true;
                    DFS(nowX, nowY, length + 1, map[nowX][nowY], k);
                    isVisited[nowX][nowY] = false;
                } else if ((map[nowX][nowY] - k) < height) {
                    // 앞으로 가려고 하는 곳의 높이가. K만큼 깎았을 때, height 보다 낮을 경우 갈 수 있음
                    // map[nowX][nowY]가 갈 수 있다는 조건에서 높이가 딱 1차이만 나도록 깎아야함
                    isVisited[nowX][nowY] = true;
                    DFS(nowX, nowY, length + 1, height - 1, 0);
                    isVisited[nowX][nowY] = false;
                }
            }

        }

    } // End of DFS

    private static boolean rangeCheck(int nowX, int nowY) {
        return nowX >= 0 && nowX < N && nowY >= 0 && nowY < N;
    } // End of rangeCheck

    private static void init() {
        map = new int[N][N];
        isVisited = new boolean[N][N];
        result = -1;
    } // End of init
} // End of Main class