import java.io.*;
import java.util.*;

public class Main_16234_인구이동 {
    static int N, L, R, result;
    static int[][] arr;
    static boolean[][] isVisited;
    static boolean[][] isPossible;
    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1};

    static class Coordinates {
        int x;
        int y;

        public Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }
    } // End of Coordinates

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/16234.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        init();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 가능하면 계속해서 돌음
        for (; ; ) {
            // 연합 하나당 평균값으로 바꿔야함.
            isVisited = new boolean[N][N];
            int sum = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {

                    if (!isVisited[i][j]) {
                        sum += BFS(i, j);
                    }
                }
            }

            if (sum == 0) {
                break;
            }
            result++;
        }

        System.out.println(result);
    } // End of main

    private static int BFS(int x, int y) {
        List<Coordinates> corList = new ArrayList<>();
        Queue<Coordinates> que = new LinkedList<>();
        int sum = arr[x][y];
        int count = 1;
        isVisited[x][y] = true;
        que.offer(new Coordinates(x, y));
        corList.add(new Coordinates(x, y));

        while (!que.isEmpty()) {
            Coordinates cor = que.poll();

            for (int i = 0; i < 4; i++) {
                int nowX = cor.x + dirX[i];
                int nowY = cor.y + dirY[i];

                if (rangeCheck(nowX, nowY) && !isVisited[nowX][nowY] && L <= Math.abs(arr[cor.x][cor.y] - arr[nowX][nowY]) && R >= Math.abs(arr[cor.x][cor.y] - arr[nowX][nowY])) {
                    sum += arr[nowX][nowY];
                    count++;
                    isVisited[nowX][nowY] = true;
                    corList.add(new Coordinates(nowX, nowY));
                    que.offer(new Coordinates(nowX, nowY));
                }
            }
        }

        if (count == 1) {
            return 0;
        }

        int avg = sum / count;
        for (Coordinates cor : corList) {
            arr[cor.x][cor.y] = avg;
        }

        return avg;
    } // End of BFS

    private static boolean rangeCheck(int nowX, int nowY) {
        return nowX >= 0 && nowX < N && nowY >= 0 && nowY < N;
    } //  End of rangeCheck

    private static void init() {
        arr = new int[N][N];
        isVisited = new boolean[N][N];
        isPossible = new boolean[N][N];
        result = 0;
    } // End of init
} // End of Main class