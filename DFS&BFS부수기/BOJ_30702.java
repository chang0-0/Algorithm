package BOJ_30702;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_30702 {

    // https://www.acmicpc.net/problem/30702
    // input
    private static BufferedReader br;

    // variables
    private static int N, M;
    private static boolean[][] isVisited1, isVisited2;
    private static char[][] map1, map2;
    private static final int[] dirX = {-1, 0, 1, 0};
    private static final int[] dirY = {0, 1, 0, -1};

    private static class Coordinate {
        int x;
        int y;
        char ch;

        private Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    } // End of Coordinate class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_30702\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!isVisited1[i][j]) {
                    if (!BFS(i, j)) {
                        sb.append("NO");
                        return sb.toString();
                    }
                }
            }
        }

        sb.append("YES");
        return sb.toString();
    } // End of solve()

    private static boolean BFS(int x, int y) {
        LinkedList<Coordinate> que = new LinkedList<>();

        char map1Color = map1[x][y];
        char map2Color = map2[x][y];
        que.offer(new Coordinate(x, y));


        while (!que.isEmpty()) {
            Coordinate current = que.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = dirX[i] + current.x;
                int nextY = dirY[i] + current.y;

                if (!isAbleCheck(nextX, nextY, map1Color)) continue;

                if (map2Color != map2[nextX][nextY]) {
                    return false;
                }

                que.offer(new Coordinate(nextX, nextY));
                isVisited1[nextX][nextY] = true;
            }
        }

        return true;
    } // End of BFS()

    private static boolean isAbleCheck(int nextX, int nextY, char color) {
        return nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && !isVisited1[nextX][nextY] && map1[nextX][nextY] == color;
    } // End of isAbleCheck()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map1 = new char[N][M];
        isVisited1 = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            map1[i] = br.readLine().toCharArray();
        }

        map2 = new char[N][M];
        for (int i = 0; i < N; i++) {
            map2[i] = br.readLine().toCharArray();
        }
    } // End of input()
} // End of Main class
