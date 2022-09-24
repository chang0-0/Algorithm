import java.util.*;
import java.io.*;

// 장애물은 O, 학생은 S, 선생님은 T
public class Main_18428_감시피하기 {
    static int N;
    static char[][] map;
    static char[][] tempMap;

    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1};

    static Coordinates[] comb;
    static List<Coordinates> teacherCorList;
    static List<Coordinates> emptyCorList;

    static class Coordinates {
        int x;
        int y;

        public Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }
    } // End of Coordinates class

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/18428.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        init(); // 변수 초기화 메소드

        // 빈칸의 좌표를 저장.
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken().charAt(0);

                if (map[i][j] == 'T') {
                    // 전체 선생님의 수는 5이하의 자연수, 전체 학생의 수는 30이하의 자연수
                    // 이므로, 선생님을 기준으로 반복하는게 더 효율적임
                    teacherCorList.add(new Coordinates(i, j));
                } else if (map[i][j] == 'X') {
                    emptyCorList.add(new Coordinates(i, j));
                }
            }
        }


        DFS(0, 3, 0);

        // DFS가 종료되고 여기 도달했다는 것은 불가능하다는 것을 의미
        System.out.println("NO");
    } // End of main

    private static void DFS(int depth, int depthLimit, int index) {
        if (depth == depthLimit) {
            copy(); // 복사본 가져와서 만들어진 좌표조합에 벽 세우기.
            for (Coordinates wallCor : comb) {
                tempMap[wallCor.x][wallCor.y] = 'O';
            }

            for (Coordinates cor : teacherCorList) {
                for (int i = 0; i < 4; i++) {
                    int nowX = cor.x;
                    int nowY = cor.y;

                    for (; ; ) {
                        nowX += dirX[i];
                        nowY += dirY[i];

                        if (rangeCheck(nowX, nowY)) {
                            if (tempMap[nowX][nowY] == 'S') {
                                // 한명의 학생이라도 선생님을 마주칠 경우 실패이므로 return;
                                return;
                            } else if (tempMap[nowX][nowY] == 'O') {
                                // 벽일 경우, break;
                                break;
                            }
                        } else { //  범위를 벗어난다는 것은 끝까지 도달해서 학생을 만나지 않았다는 것.
                            break;
                        }
                    }

                }
            }

            // 끝까지 도달하면 성공 바로 종료
            System.out.println("YES");
            System.exit(0);
        }

        for (int i = index; i < emptyCorList.size(); i++) {
            comb[depth] = emptyCorList.get(i);
            DFS(depth + 1, depthLimit, i + 1);
        }
    } // End of DFS

    private static boolean rangeCheck(int nowX, int nowY) {
        return nowX >= 0 && nowX < N && nowY >= 0 && nowY < N;
    } // End of rangeCheck

    private static void copy() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tempMap[i][j] = map[i][j];
            }
        }
    } // End of copy

    private static void init() {
        map = new char[N][N];
        tempMap = new char[N][N];
        teacherCorList = new ArrayList<>();
        emptyCorList = new ArrayList<>();
        comb = new Coordinates[3];
    } // End of init
} //End of Main class