package BOJ_16929;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16929_Two_Dots {

    // https://www.acmicpc.net/problem/16929
    // input
    private static BufferedReader br;

    // variables
    private static int N, M;
    private static char[][] map;
    private static boolean[][] isVisited;
    private static int[] dirX = {0, 0, -1, 1};
    private static int[] dirY = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_16929\\res.txt"));
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
                if (isVisited[i][j]) continue;

                if (DFS(i, j, i, j, map[i][j])) {
                    sb.append("Yes");
                    return sb.toString();
                }
            }
        }

        sb.append("No");
        return sb.toString();
    } // End of solve()

    private static boolean DFS(int x, int y, int preX, int preY, char color) {
        System.out.println("============================================");
        for (boolean[] t : isVisited) {
            System.out.println(Arrays.toString(t));
        }

        // 앞으로만 진행하면서 방문했던 곳을 다시 만나게되면 사이클이 있는 것이다.
        if (isVisited[x][y]) return true;
        isVisited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nextX = dirX[i] + x;
            int nextY = dirY[i] + y;

            if (!isAbleCheck(nextX, nextY, color)) continue;

            // 사이클을 찾기 위해서 isVisited에서 true인 곳도 진행을 해야 함.
            // 근데 바로 이전에 왔던 곳은 통과하도록 진행
            if (nextX != preX || nextY != preY) {
                if (DFS(nextX, nextY, x, y, color)) return true;
            }
        }

        return false;
    } // End of DFS

    private static boolean isAbleCheck(int nextX, int nextY, char color) {
        return nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && map[nextX][nextY] == color;
    } // End of isAbleCheck()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        isVisited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
    } // End of input()
} // End of Main class
