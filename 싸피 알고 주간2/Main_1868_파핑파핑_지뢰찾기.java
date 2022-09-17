import java.util.*;
import java.io.*;

public class Main_1868_파핑파핑_지뢰찾기 {
    static int N, result;
    static char[][] map;
    static int[] dirX = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dirY = {0, 0, -1, 1, -1, 1, -1, 1};
    static boolean[][] isVisited;

    static class Coordinates {
        int x;
        int y;

        public Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }
    } // End of coordinates class

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/1868.txt"));
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
                String temp = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = temp.charAt(j);
                }
            }

            // 각 위치마다 주변 지뢰 갯수를 미리 파악해서 전체 완성
            isVisited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int mineCount = 0;
                    if (map[i][j] == '*') continue;

                    for (int k = 0; k < 8; k++) {
                        int nowX = i + dirX[k];
                        int nowY = j + dirY[k];

                        if (rangeCheck(nowX, nowY) && map[nowX][nowY] == '*') {
                            mineCount++;
                        }
                    }

                    map[i][j] = (char) (mineCount + '0');
                }
            }


            // 이제 0으로 출발해서 연결될 수 있는 부분을 모두 true처리
            isVisited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!isVisited[i][j] && map[i][j] == '0') {
                        zeroClick(i, j);
                        result++;
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!isVisited[i][j] && Character.getNumericValue(map[i][j]) > 0) {
                        result++;
                    }
                }
            }

            sb.append(result).append('\n');
        }

        bw.write(sb.toString());
        bw.close();
    } // End of main

    private static void zeroClick(int x, int y) {
        Queue<Coordinates> que = new LinkedList<>();
        isVisited[x][y] = true;
        que.offer(new Coordinates(x, y));

        // 8방향으로 0으로만 진행하고 숫자를 만날경우, que에 넣지는 않고 isVisited를 true로만 처리해줌.
        while (!que.isEmpty()) {
            Coordinates cor = que.poll();

            for (int i = 0; i < 8; i++) {
                int nowX = cor.x + dirX[i];
                int nowY = cor.y + dirY[i];

                if (rangeCheck(nowX, nowY) && !isVisited[nowX][nowY]) {
                    if ('0' == map[nowX][nowY]) {
                        que.offer(new Coordinates(nowX, nowY));
                        isVisited[nowX][nowY] = true;
                    } else if (Character.getNumericValue(map[nowX][nowY]) > 0) {
                        isVisited[nowX][nowY] = true;
                    }
                }
            }
        }

    } // End of zeroClick

    private static boolean rangeCheck(int nowX, int nowY) {
        return nowX >= 0 && nowX < N && nowY >= 0 && nowY < N;
    } // End of rangeCheck

    private static void init() {
        map = new char[N][N];
        isVisited = new boolean[N][N];
        result = 0;
    } // End of init
} // End of Main class