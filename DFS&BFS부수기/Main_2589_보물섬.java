import java.util.*;
import java.io.*;

// L 육지
// W 바다
// 최단 거리 BFS
// 보물은 서로 간에 최단 거리로 이동하는데 있어 가장 긴 시간이 걸리는 육지 두 곳에 나뉘어 묻혀있다.
// 육지를 나타내는 두 곳 사이를 최단 거리로 이동하려면 같은 곳을 두 번 이상 지나가거나, 멀리 돌아가서는 안 된다.

public class Main_2589_보물섬 {
    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {1, -1, 0, 0};
    static char[][] arr;
    static int N, M;

    static class Map {
        int x;
        int y;
        int time;

        public Map(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    } // End of Map class


    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/2589.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        // BFS탐색을 통해서 모든 곳을 방문,
        // 출발점에서 가장 멀리 도착한 값, 중에서 또 최대값을 구함.
        // 최단 거리로 이동하는 시간을 구하라고 하는데 BFS 탐색을 하면 그냥 최단시간이 자동으로 구해짐
        int shortestTime = -1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 'L') {
                    shortestTime = Math.max(BFS(i, j), shortestTime);
                }
            }
        }

        System.out.println(shortestTime);
    } // End of main

    private static int BFS(int x, int y) {
        Queue<Map> que = new LinkedList<>();
        boolean[][] visit = new boolean[N][M];
        int maxTime = 0;

        visit[x][y] = true;
        que.offer(new Map(x, y, 0));

        while (!que.isEmpty()) {
            Map m = que.poll();

            for (int i = 0; i < 4; i++) {
                int nowX = m.x + dirX[i];
                int nowY = m.y + dirY[i];
                int currentTime = m.time;

                if (rangeCheck(nowX, nowY) && !visit[nowX][nowY] && arr[nowX][nowY] == 'L') {
                    visit[nowX][nowY] = true;
                    que.offer(new Map(nowX, nowY, currentTime + 1));
                    maxTime = Math.max(currentTime + 1, maxTime);
                }

            }
        }

        return maxTime;
    } // End of BFS

    private static boolean rangeCheck(int nowX, int nowY) {
        return nowX >= 0 && nowX < N && nowY >= 0 && nowY < M;
    } // End of rangeCheck
} // End of Main class