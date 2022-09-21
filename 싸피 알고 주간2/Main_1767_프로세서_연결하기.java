import java.io.*;
import java.util.*;

public class Main_1767_프로세서_연결하기 {
    static int N, result;
    static int[][] board;
    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1};
    static int maxCore;
    static int minLine;
    static List<Coordinates> coreList;

    static class Coordinates {
        int x;
        int y;

        public Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }
    } // End of Coordinates

    // 전선 길이의 합이 최소가 되는 값을
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/1767.txt"));
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
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());

                    // 끝에 붙어있는 코어는 제외.
                    if (board[i][j] == 1) {
                        if (i == 0 || i == N - 1 || j == 0 || j == N - 1) continue;
                        coreList.add(new Coordinates(i, j));
                    }
                }
            }

            DFS(0, coreList.size(), 0, 0);
            sb.append(minLine).append('\n');
        }

        bw.write(sb.toString());
        bw.close();
    } // End of main

    // depth는 index가 되고, depthLimit은 coreList의 size값이 된다.
    // 재귀의 마지막 탈출은 coreList의 끝이된다 더 이상 탐색할 필요가 없고,
    // 우리가 알기 위한 값인 전선의 갯수를 알기위해서는 결국 모든 코어를 순회하는것이 핵심이기때문에
    private static void DFS(int depth, int depthLimit, int coreSum, int lineSum) {
        if (depth == depthLimit) {
            if (maxCore < coreSum) {
                maxCore = coreSum;
                minLine = lineSum;
            } else if (maxCore == coreSum) {
                minLine = Math.min(minLine, lineSum);
            }
            return;
        }

        int x = coreList.get(depth).x;
        int y = coreList.get(depth).y;

        // 4가지 방향에 대해서 가지를 뻗어 나가면서 모든 조합을 계산해 봄.
        for (int i = 0; i < 4; i++) {
            int nowX = x;
            int nowY = y;
            int count = 0;

            for (; ; ) {
                nowX += dirX[i];
                nowY += dirY[i];

                if (!rangeCheck(nowX, nowY)) break;

                // 선을 만나거나 코어를 중간에 만나면 선을 연결 할 수 없다고 판단하고 중지,
                // break를 한뒤 count = 0처리.
                if (board[nowX][nowY] == 2 || board[nowX][nowY] == 1) {
                    count = 0;
                    break;
                }

                count++;
            }

            if (count == 0) {
                // count가 0일 때, 해당 방향으로는 전선을 깔 수 없다는 것을 의미.
                DFS(depth + 1, depthLimit, coreSum, lineSum);
            } else {
                int fillX = x;
                int fillY = y;

                for (int j = 0; j < count; j++) {
                    fillX += dirX[i];
                    fillY += dirY[i];
                    board[fillX][fillY] = 2;
                }

                DFS(depth + 1, depthLimit, coreSum + 1, lineSum + count);

                // 종료후에는 깔려 있던 선을 다시 원상 복구
                for (int j = count - 1; j >= 0; j--) {
                    board[fillX][fillY] = 0;
                    fillX -= dirX[i];
                    fillY -= dirY[i];
                }
            }
        }

    } // End of DFS

    private static boolean rangeCheck(int nowX, int nowY) {
        return nowX >= 0 && nowX < N && nowY >= 0 && nowY < N;
    } // End of rangeCheck

    private static void init() {
        board = new int[N][N];
        coreList = new ArrayList<>();
        result = 0;
        maxCore = Integer.MIN_VALUE;
        minLine = Integer.MAX_VALUE;
    } // End of init
} // End of Main class