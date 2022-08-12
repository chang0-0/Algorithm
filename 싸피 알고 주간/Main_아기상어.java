import java.io.*;
import java.util.*;

class Coo {
    int x;
    int y;

    Coo(int x, int y) {
        this.x = x;
        this.y = y;
    }
} // End of Coo class

public class Main_아기상어 {
    static int N, M;
    static int map[][] = new int[50][50];
    static int dx[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
    static int dy[] = { -1, 0, 1, -1, 1, -1, 0, 1 };
    static int safeAreaMax = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 상어만 돌리기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(safeAreaMax);
    } // End of main

    private static void copy() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {

            }
        }
    } // End of copy

    static void bfs(int i, int j) {
        Queue<Coo> q = new LinkedList<>();
        boolean visited[][] = new boolean[N][M];
        q.offer(new Coo(i, j)); // add 대신 offer
        map[i][j] = 0;

        while (!q.isEmpty()) {
            Coo p = q.poll();
            visited[p.x][p.y] = true;

            for (int a = 0; a < 8; a++) {
                int nx = p.x + dx[a];
                int ny = p.y + dy[a];

                if (rangeCheck(nx, ny) && !visited[nx][ny]) {
                    safeAreaMax = Math.min(map[p.x][p.y] + 1, map[nx][ny]);
                    q.offer(new Coo(nx, ny));
                }
            }
        }
    } // End of bfs

    static boolean rangeCheck(int nx, int ny) {
        return nx >= 0 && nx < N && ny >= 0 && ny < M;
    } // End of rangeCheck
} // End of Main class
