import java.util.*;
import java.io.*;

public class Main_1861_정사각형_방 {
    static int N;
    static int arr[][];
    static boolean visit[][];
    static int dirX[] = {0, 0, -1, 1};
    static int dirY[] = {-1, 1, 0, 0};

    static int arrMax = -1;
    static int nowX, nowY;
    static int newMax;
    static int resultMax;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/1861.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            sb.append('#').append(t).append(' ');

            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];

            resultMax = -1;
            int startRoomNum = -1;


            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    arrMax = Math.max(arrMax, arr[i][j]);
                }
            }

            // 탐색한 최댓값과 배열내의 최댓값의 차이가 같을 경우 더 이상 탐색하지 않음
            //for(int num[] : arr) System.out.println(Arrays.toString(num));

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    newMax = 1;
                    visit = new boolean[N][N];
                    DFS(i, j, arr[i][j]);

                    // 이동할 수 있는 방의 개수가 최대인 방이 여럿이라면 그 중에서 적힌 수가 가장 작은 것을 출력한다.
                    if (resultMax < newMax) {
                        resultMax = newMax;
                        startRoomNum = arr[i][j];
                    } else if(resultMax == newMax) {
                        startRoomNum = Math.min(startRoomNum, arr[i][j]);
                    }
                }
            }


            sb.append(startRoomNum).append(' ').append(resultMax).append('\n');
        }

        bw.write(sb.toString());
        bw.close();
    } // End of main

    private static void DFS(int x, int y, int startNum) {
        for(int i=0; i<4; i++) {
            nowX = x + dirX[i];
            nowY = y + dirY[i];

            if(rangeCheck() && !visit[nowX][nowY] && arr[nowX][nowY] == (startNum + 1) ) {
                visit[nowX][nowY] = true;
                newMax++;
                DFS(nowX, nowY, startNum + 1);
            }
        }

    } // End of DFS

    private static boolean rangeCheck() {
        return nowX >= 0 && nowX < N && nowY >= 0 && nowY < N;
    } // End of rangeCheck



} // End of Main clas