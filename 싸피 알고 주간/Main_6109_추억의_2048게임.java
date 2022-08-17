import java.io.*;
import java.util.*;

public class Main_6109_추억의_2048게임 {
    static int N;
    static int arr[][];
    static int dirX[] = {0, 0, -1, 1}; // 우 좌 상 하
    static int dirY[] = {1, -1, 0, 0};
    static boolean visit[][];

    // 자신과 같은 값이 있으면 합해줌
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/6109.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        int T = 1;
        while (tc-- > 0) {
            sb.append('#').append(T).append('\n');
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            String func = st.nextToken();

            init(); // 변수들 초기화,

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }


            if (func.equals("down")) {
                for (int i = N - 1; i >= 0; i--) {
                    for (int j = 0; j < N; j++) {

                        if (arr[i][j] != 0) {
                            DFS(i, j, func);
                        }

                    }
                }
            } else if (func.equals("up")) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {

                        if (arr[i][j] != 0) {
                            DFS(i, j, func);
                        }

                    }
                }
            } else if (func.equals("left")) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {

                        if (arr[i][j] != 0) {
                            DFS(i, j, func);
                        }

                    }
                }
            } else { // right
                for (int i = 0; i < N; i++) {
                    for (int j = N - 1; j >= 0; j--) {

                        if (arr[i][j] != 0) {
                            DFS(i, j, func);
                        }

                    }
                }
            }


            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    sb.append(arr[i][j]).append(' ');
                }
                sb.append('\n');
            }

            T++;
        }

        bw.write(sb.toString());
        bw.close();
    } // End of main

    private static void init() {
        arr = new int[N][N];
        visit = new boolean[N][N];
    } // End of init

    private static void DFS(int x, int y, String func) {
        // 한번 합쳐진 곳은 더 이상 합쳐지지 않는다 -> visit으로 true처리
        int idx = 0;
        if (func.equals("up")) {
            idx = 2;
        } else if (func.equals("down")) {
            idx = 3;
        } else if (func.equals("left")) {
            idx = 1;
        }

        int nowX = x + dirX[idx];
        int nowY = y + dirY[idx];
        if (rangeCheck(nowX, nowY) && arr[nowX][nowY] == 0) {
            swap(x, y, nowX, nowY); // 한번은 스왑을 함.

            int nextX = 0;
            int nextY = 0;
            while (arr[nowX][nowY] >= 0) {
                nextX = nowX + dirX[idx];
                nextY = nowY + dirY[idx];

                if (rangeCheck(nextX, nextY) && arr[nextX][nextY] == 0) {
                    swap(nowX, nowY, nextX, nextY);
                    nowX = nextX;
                    nowY = nextY;
                } else {
                    break;
                }
            }

            if (rangeCheck(nextX, nextY) && !visit[nextX][nextY] && arr[nextX][nextY] == arr[nowX][nowY]) {
                arr[nextX][nextY] += arr[nowX][nowY];
                visit[nextX][nextY] = true;
                arr[nowX][nowY] = 0;
            }

        } else if (rangeCheck(nowX, nowY) && !visit[nowX][nowY] && arr[nowX][nowY] == arr[x][y]) {
            arr[nowX][nowY] += arr[x][y];
            visit[nowX][nowY] = true;
            arr[x][y] = 0;
        }

    } // End of DFS

    private static void swap(int x, int y, int newX, int newY) {
        int tmp = arr[x][y];
        arr[x][y] = arr[newX][newY];
        arr[newX][newY] = tmp;
    } // End of swap

    private static boolean rangeCheck(int nowX, int nowY) {
        return nowX >= 0 && nowX < N && nowY >= 0 && nowY < N;
    } // End of rangeCheck
} // End of Main class