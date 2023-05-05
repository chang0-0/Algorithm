import java.util.*;
import java.io.*;

public class Main_1210_Ladder1 {
    static class startArea {
        int x;
        int y;

        public startArea(int x, int y) {
            this.y = y;
            this.x = x;
        }
    } // End of startArea class

    private static final int ARRSIZE = 100;
    static int arr[][] = new int[ARRSIZE][ARRSIZE];
    static List<startArea> startList;
    static int nowX, nowY;
    static int dirX[] = {0, 0, 1}; // 좌, 우, 하
    static int dirY[] = {1, -1, 0};
    static int startX, startY;
    static int result = -1;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/1210.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String str = "";
        while ((str = br.readLine()) != null) {
            int T = Integer.parseInt(str);
            sb.append('#').append(T).append(' ');
            startList = new ArrayList<>();

            for (int i = 0; i < ARRSIZE; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < ARRSIZE; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 출발점만 먼저 찾아서 리스트에 좌표로 담음
            for (int i = 0; i < ARRSIZE; i++) {
                if (arr[0][i] == 1) {
                    startList.add(new startArea(0, i));
                }
            }

            // 출발점 좌표만큼 반복해서 전체 탐색
            for (startArea s : startList) {
                startX = s.x;
                startY = s.y;
                BFS(startX, startY);
            }

            sb.append(result).append('\n');
        }

        bw.write(sb.toString());
        bw.close();
    } // End of main

    private static void BFS(int x, int y) {
        boolean visit[][] = new boolean[ARRSIZE][ARRSIZE];
        Queue<startArea> que = new LinkedList<>();
        // 조건 1일때만 진행

        visit[x][y] = true;
        que.offer(new startArea(x, y));
        while (!que.isEmpty()) {
            startArea start = que.poll();

            for (int i = 0; i < 3; i++) {
                // 좌우를 먼저 탐색하고 하를 탐색
                nowX = start.x + dirX[i];
                nowY = start.y + dirY[i];

                if (rangeCheck() && arr[nowX][nowY] == 2) {
                    result = startY;
                    return;
                }

                // i가 0 또는 1일 때, (좌 우) true일 경우
                if ((i == 0 || i == 1) && rangeCheck() && arr[nowX][nowY] > 0 && !visit[nowX][nowY]) {
                    visit[nowX][nowY] = true;
                    arr[nowX][nowY] = 3;
                    que.offer(new startArea(nowX, nowY));
                    i += 4; // 다시 돌지 못하도록 i+4처리
                } else if (i == 2 && rangeCheck() && arr[nowX][nowY] > 0 && !visit[nowX][nowY]) {
                    visit[nowX][nowY] = true;
                    arr[nowX][nowY] = 3;
                    que.offer(new startArea(nowX, nowY));
                }

            }
        }
    } // End of BFS

    private static boolean rangeCheck() {
        return nowX >= 0 && nowX < ARRSIZE && nowY >= 0 && nowY < ARRSIZE;
    } // End of rangeCheck
} // End of Main class