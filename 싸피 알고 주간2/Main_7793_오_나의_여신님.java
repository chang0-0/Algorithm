import java.util.*;
import java.io.*;

public class Main_7793_오_나의_여신님 {
    static int N, M, result;
    static char[][] map;
    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1};
    static Coordinates engelCor;
    static Coordinates manCor;
    static List<Coordinates> devilCorList;

    static class Coordinates {
        int x;
        int y;
        int time;

        public Coordinates(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }

        public Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }
    } // End of Coordinates class

    // 안전 지역에 도착하는 최소 시간을 출력, 불가능 할 경우 GAME OVER를 출력한다.
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/7793.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append('#').append(t).append(' ');

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            init();

            for (int i = 0; i < N; i++) {
                String temp = br.readLine();
                for (int j = 0; j < M; j++) {
                    map[i][j] = temp.charAt(j);

                    // 악마의 손아귀는 여러개 일 수 있다.
                    if (map[i][j] == '*') devilCorList.add(new Coordinates(i, j));
                    else if (map[i][j] == 'D') engelCor = new Coordinates(i, j);
                    else if (map[i][j] == 'S') manCor = new Coordinates(i, j);
                }
            }

            // 수연이의 위치부터 BFS를 시작.
            BFS(manCor.x, manCor.y);

            if (result == Integer.MAX_VALUE) sb.append("GAME OVER").append('\n');
            else sb.append(result).append('\n');
        }

        bw.write(sb.toString());
        bw.close();
    } // End of main

    // 1초씩 이동. 수연이와 악마의 손아귀가 같이 퍼지는데, 악마의 손아귀인 위치에 수연이가 갈 경우, que에 집어 넣지 않음
    private static void BFS(int x, int y) {
        Queue<Coordinates> manQue = new LinkedList<>();
        Queue<Coordinates> devilQue = new LinkedList<>();
        for (Coordinates c : devilCorList) {
            devilQue.offer(new Coordinates(c.x, c.y));
        }

        manQue.offer(new Coordinates(manCor.x, manCor.y, 0));


        for (; ; ) {
            int manQueSize = manQue.size();
            for (int i = 0; i < manQueSize; i++) {
                Coordinates manCor = manQue.poll();

                for (int j = 0; j < 4; j++) {
                    if (map[manCor.x][manCor.y] == '*') break; // 현재 수연이의 위치에 악마의 손아귀가 퍼졌으면 진행할 필요 없음

                    int nowX = manCor.x + dirX[j];
                    int nowY = manCor.y + dirY[j];
                    int time = manCor.time;

                    if (time >= result) {
                        break;
                    }

                    if (rangeCheck(nowX, nowY) && map[nowX][nowY] == 'D') { // D에 도달 했을 때, 최단 시간을 갱신.
                        result = Math.min(result, time + 1);
                    } else if (rangeCheck(nowX, nowY) && map[nowX][nowY] == '.') {
                        manQue.offer(new Coordinates(nowX, nowY, time + 1));
                        map[nowX][nowY] = 'S';
                    }
                }
            }

            int devilQueSize = devilQue.size();
            for (int i = 0; i < devilQueSize; i++) {
                Coordinates devilCor = devilQue.poll();

                for (int j = 0; j < 4; j++) {
                    int nowX = devilCor.x + dirX[j];
                    int nowY = devilCor.y + dirY[j];

                    if (rangeCheck(nowX, nowY) && (map[nowX][nowY] == '.' || map[nowX][nowY] == 'S')) {
                        map[nowX][nowY] = '*';
                        devilQue.offer(new Coordinates(nowX, nowY));
                    }
                }
            }

            if (manQue.isEmpty()) break;
        }

    } // End of BFS

    private static boolean rangeCheck(int nowX, int nowY) {
        return nowX >= 0 && nowX < N && nowY >= 0 && nowY < M;
    } // End of rangeCheck

    private static void init() {
        map = new char[N][M];
        devilCorList = new ArrayList<>();
        result = Integer.MAX_VALUE;
    } // End of init
} // End of Main class
