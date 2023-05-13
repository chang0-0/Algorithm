import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*

    버섯 포자는 버섯이 자랄 수 있는 칸에만 심을 수 있다.

    각 버섯 포자는 포자가 심어진 칸을 포함해 최대 K개의 연결된 칸에 버섯을 자라게 한다.

    이때 연결된 칸은 상하좌우로 적어도 한 변을 공유하는 칸들의 집합이라고 정의한다.

    버섯이 자랄 수 있는 칸은 0, 버섯이 자랄 수 없는 칸은 1로 주어진다.

    버섯 포자를 하나라도 사용하고 버섯이 자랄 수 있는 모든 칸에 버섯이 전부 자랐을 때 농사가 가능하다고 정의한다.


    농사가 불가능하면 IMPOSSIBLE을 출력
    가능하면 POSSIBLE을 출력하고, 남은 버섯 포자의 개수를 출력한다.
 */

public class Main_27737_버섯_농장 {
    private static int N;
    private static int M;
    private static int K;

    private static int[][] board = new int[101][101];
    private static boolean[][] isVisited = new boolean[101][101];

    // 상 하 좌 우
    private static int dirX[] = {-1, 1, 0, 0};
    private static int dirY[] = {0, 0, -1, 1};

    private static class Coordinates {
        int x;
        int y;

        public Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }
    } // End of Node class

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/27737.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken()); // 버섯 1개당 퍼지는 비율
        int originCount = M;

        // 0의 갯수가 몇개인지 판단.
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 0) {
                    if (!BFS(i, j)) {
                        bw.write("IMPOSSIBLE");
                        bw.close();
                        return;
                    }
                }
            }
        }

        if (originCount == M) {
            sb.append("IMPOSSIBLE");
        } else {
            sb.append("POSSIBLE").append('\n').append(M);
        }

        bw.write(sb.toString());
        bw.close();
    } // End of main

    private static boolean BFS(int x, int y) {
        Queue<Coordinates> que = new LinkedList<>();
        que.offer(new Coordinates(x, y));
        isVisited[x][y] = true;
        int count = 0;

        while (!que.isEmpty()) {
            Coordinates pollCoor = que.poll();
            board[pollCoor.x][pollCoor.y] = -1;
            count++;

            for (int i = 0; i < 4; i++) {
                int nowX = dirX[i] + pollCoor.x;
                int nowY = dirY[i] + pollCoor.y;

                if (!rangeCheck(nowX, nowY)) continue;

                if (board[nowX][nowY] != 1 && !isVisited[nowX][nowY]) {
                    isVisited[nowX][nowY] = true;
                    que.offer(new Coordinates(nowX, nowY));
                }
            }
        }

        return isPossibleCheck(count);
    } // End of BFS

    private static boolean rangeCheck(int nowX, int nowY) {
        return nowX < N && nowX >= 0 && nowY < N && nowY >= 0;
    } // End of rangeCheck

    private static boolean isPossibleCheck(int count) {
        if (count % K == 0) {
            M -= count / K;
        } else {
            M -= (count / K + 1);
        }

        if (M < 0) {
            return false;
        }

        return true;
    } // End of isPossibleCheck
} // End of Main class
