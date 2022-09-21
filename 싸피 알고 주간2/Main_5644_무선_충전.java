import java.io.*;
import java.util.*;

public class Main_5644_무선_충전 {
    private static final int N = 10;
    static int result, M, A;
    static Charge[][] map;

    static int[] dirX = {0, -1, 0, 1, 0}; // 상 우 하 좌
    static int[] dirY = {0, 0, 1, 0, -1};
    static int[][] moveArr;

    static class Coordinates {
        int x;
        int y;
        int dist;

        public Coordinates(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        public Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }
    } // End of Coordinates class

    static class Charge {
        int x;
        int y;
        List<ChargeData> chargeDataList;

        public Charge(int x, int y, List<ChargeData> chargeDataList) {
            this.x = x;
            this.y = y;
            this.chargeDataList = chargeDataList;
        }

        public void add(ChargeData data) {
            chargeDataList.add(data);
        }
    } // End of Charge class

    static class ChargeData {
        int num;
        int power;

        public ChargeData(int num, int power) {
            this.num = num;
            this.power = power;
        }
    } // End of ChargeData

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/5644.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append('#').append(t).append(' ');

            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());
            init();

            st = new StringTokenizer(br.readLine());
            Coordinates[] personA = new Coordinates[M + 1];
            personA[0] = new Coordinates(0, 0);
            for (int i = 1; i <= M; i++) {
                int num = Integer.parseInt(st.nextToken());
                int nowX = dirX[num] + personA[i - 1].x;
                int nowY = dirY[num] + personA[i - 1].y;

                personA[i] = new Coordinates(nowX, nowY);
            }

            Coordinates[] personB = new Coordinates[M + 1];
            personB[0] = new Coordinates(N - 1, N - 1);
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= M; i++) {
                int num = Integer.parseInt(st.nextToken());
                int nowX = dirX[num] + personB[i - 1].x;
                int nowY = dirY[num] + personB[i - 1].y;

                personB[i] = new Coordinates(nowX, nowY);
            }

            for (int i = 0; i < A; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()) - 1;
                int y = Integer.parseInt(st.nextToken()) - 1;
                int range = Integer.parseInt(st.nextToken());
                int power = Integer.parseInt(st.nextToken());

                BFS(y, x, range, power, i);
            }

            for (int i = 0; i <= M; i++) {
                int aX = personA[i].x;
                int aY = personA[i].y;
                int bX = personB[i].x;
                int bY = personB[i].y;

                // 둘다 충전 범위에 들어가지 않을 때,
                boolean aCheck = chargeRangeCheck(aX, aY);
                boolean bCheck = chargeRangeCheck(bX, bY);
                int maxSum = 0;

                if (!aCheck && !bCheck) continue; // 둘다 충전범위에 들어와있지 않다면 continue;

                // 둘 중에 하나만 충전범위가 들어가면 그냥 최댓값 더하기.
                if (aCheck && !bCheck) {
                    maxSum = Integer.MIN_VALUE;
                    for (ChargeData aCh : map[aX][aY].chargeDataList) {
                        maxSum = Math.max(maxSum, aCh.power);
                    }
                } else if (!aCheck && bCheck) {
                    maxSum = Integer.MIN_VALUE;
                    for (ChargeData bCh : map[bX][bY].chargeDataList) {
                        maxSum = Math.max(maxSum, bCh.power);
                    }
                } else if (aCheck && bCheck) {
                    // 둘다 충전 범위에 들어갈 때, 최댓값 조합 찾기
                    maxSum = Integer.MIN_VALUE;
                    for (ChargeData aCh : map[aX][aY].chargeDataList) {
                        int aChargeNum = aCh.num;
                        int aChargePower = aCh.power;

                        // System.out.println("map[" + aX + "][" + aY + "] : " + aCh.num + ", " + aCh.power);

                        for (ChargeData bCh : map[bX][bY].chargeDataList) {
                            int sum = 0;
                            int bChargeNum = bCh.num;
                            int bChargePower = bCh.power;

                            if (aChargeNum == bChargeNum) {
                                sum = (bChargePower / 2) * 2;
                            } else {
                                sum = aChargePower + bChargePower;
                            }

                            maxSum = Math.max(maxSum, sum);
                        }
                    }
                }

                result += maxSum;
            }

            sb.append(result).append('\n');
        }

        bw.write(sb.toString());
        bw.close();
    } // End of main

    // A, B가 현재 충전되는 범위에 들어와있는지를 확인하는 메소드
    private static boolean chargeRangeCheck(int x, int y) {
        if (!map[x][y].chargeDataList.isEmpty()) return true;
        return false;
    } // End of sameChargerCheck

    // 지도에 충전 범위 표시하기.
    private static void BFS(int x, int y, int range, int power, int chargeNum) {
        Queue<Coordinates> que = new LinkedList<>();
        boolean[][] isVisited = new boolean[N][N];

        ChargeData cd = new ChargeData(chargeNum, power);
        map[x][y].add(cd);
        que.offer(new Coordinates(x, y, 0));
        isVisited[x][y] = true;

        while (!que.isEmpty()) {
            Coordinates cor = que.poll();

            for (int i = 0; i < 5; i++) {
                int nowX = cor.x + dirX[i];
                int nowY = cor.y + dirY[i];
                int dist = cor.dist;

                if (rangeCheck(nowX, nowY) && !isVisited[nowX][nowY]) {
                    if (range >= dist + 1) {
                        map[nowX][nowY].add(cd);
                        isVisited[nowX][nowY] = true;
                        que.offer(new Coordinates(nowX, nowY, dist + 1));
                    }
                }
            }
        }

    } // End of BFS

    private static boolean rangeCheck(int nowX, int nowY) {
        return nowX >= 0 && nowX < N && nowY >= 0 && nowY < N;
    } // End of rangeCheck

    private static void init() {
        map = new Charge[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = new Charge(i, j, new ArrayList<>());
            }
        }

        moveArr = new int[M][2];
        result = 0;
    } // End of init
} // End of Main class