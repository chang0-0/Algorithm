import java.io.*;
import java.util.*;

public class 등산로_리뷰 {
    static int N;
    static int K;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int ans;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/1949.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();


        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            sb.append('#').append(t).append(' ');

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            init(); // 변수 초기화

            int highest = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (highest < map[i][j]) // 최고 높이 찾기
                        highest = map[i][j];
                }
            }


            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == highest) {
                        visited[i][j] = true;
                        DFS(i, j, highest, 1, false);
                        visited[i][j] = false;
                    }
                }
            }


            sb.append(ans).append('\n');
        } // End of testCase while

        bw.write(sb.toString());
        bw.close();
    } // End of main

    public static void DFS(int x, int y, int h, int pathl, boolean usedk) {
        ans = Math.max(ans, pathl);

        for (int i = 0; i < 4; i++) {
            int newx = x + dx[i];
            int newy = y + dy[i];

            if (!rangeCheck(newx, newy) || visited[newx][newy]) continue; // 가지치기 조건
            visited[newx][newy] = true; // 백트래킹

            if (map[newx][newy] < h) { // 내가 있는 높이가 앞으로 가려는 높이보다 낮을 때 -> 깎을 필요가 없을 때,
                DFS(newx, newy, map[newx][newy], pathl + 1, usedk);
            } else if (!usedk && map[newx][newy] - K < h) { // 내가 앞으로 높이가 -K를 했을 때, 갈 수 있냐 없냐를 판단해서 갈 수 없으면, 가지 않고, 갈 수 있으면 간다.
                // (이것도 가지치기)
                // 앞으로  진행하는 와중에 깎아야하는 경우,  -> 자신의 높이 h에서 1만 딱 깎는다. (1만 깎으면 갈 수 있음)
                DFS(newx, newy, h - 1, pathl + 1, true);
            }

            visited[newx][newy] = false; // 백트래킹
        }
    } // End of DFS

    private static boolean rangeCheck(int newx, int newy) {
        return newx >= 0 && newx < N && newy >= 0 && newy < N;
    } // End of rangeCheck

    private static void init() {
        map = new int[N][N];
        visited = new boolean[N][N];
        ans = 0;
    } // End of init
} // End of Main class
