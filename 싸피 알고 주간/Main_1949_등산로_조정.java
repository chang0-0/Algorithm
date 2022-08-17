import java.util.*;
import java.io.*;

public class Main_1949_등산로_조정 {
    static int N, K;
    static int arr[][];
    static int temp[][];
    static boolean visit[][];
    static int dirX[] = {0, 0, -1, 1};
    static int dirY[] = {-1, 1, 0, 0};
    static List<StartPoint> startPointsList;

    static int maxHeight;
    static int maxLength;

    static class StartPoint {
        int x;
        int y;

        StartPoint(int x, int y) {
            this.x = x;
            this.y = y;
        }
    } // End of StartPoint class

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

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    maxHeight = Math.max(maxHeight, arr[i][j]);
                }
            }

            // 최고 높이 봉우리의 위치 List에 저장
            maxHeightAddList();
            int resultLen = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {

                    copy();
                    // 자신이 0이 될 때 까지 깎도록 반복
                    for (int l = 0; l <= K; l++) {

                        temp[i][j] = arr[i][j] - l;
                        if (temp[i][j] < 0) { // 음수가 되면 break
                            break;
                        }

                        // DFS
                        for (StartPoint s : startPointsList) {
                            visit = new boolean[N][N];
                            DFS(s.x, s.y, temp[s.x][s.y], 1);
                            resultLen = Math.max(resultLen, maxLength);
                        }

                    }
                }
            }

            sb.append(resultLen).append('\n');
        } // End of testCase while

        bw.write(sb.toString());
        bw.close();
    } // End of main

    private static void DFS(int x, int y, int height, int length) {
        for (int i = 0; i < 4; i++) {
            int nowX = x + dirX[i];
            int nowY = y + dirY[i];
            // 내가 가려는 곳의 높이를 찾는 것보다.
            // 내가 있는 위치의 값을 1씩 줄여나가면서
            // 내가 갈 수 있는 곳이 있는지 찾는 것이 우선

            if (rangeCheck(nowX, nowY) && !visit[nowX][nowY] && temp[nowX][nowY] < height) {
                visit[nowX][nowY] = true;

                maxLength = Math.max(maxLength, length + 1);
                DFS(nowX, nowY, temp[nowX][nowY], length + 1);
                visit[nowX][nowY] = false; // 재귀 종료 후에도 방향을 바꿀 수 없음
            }
        }
    } // End of DFS

    private static boolean rangeCheck(int nowX, int nowY) {
        return nowX >= 0 && nowX < N && nowY >= 0 && nowY < N;
    } // End of rangeCheck

    private static void copy() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int num = arr[i][j];
                temp[i][j] = num;
            }
        }
    } // End of copy

    private static void init() {
        arr = new int[N][N];
        temp = new int[N][N];
        startPointsList = new ArrayList<>();
        maxLength = -1;
        maxHeight = -1;
    } // End of init

    private static void maxHeightAddList() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (maxHeight == arr[i][j]) {
                    startPointsList.add(new StartPoint(i, j));
                }
            }
        }
    } // End of maxHeightAddList
} // End of Main class