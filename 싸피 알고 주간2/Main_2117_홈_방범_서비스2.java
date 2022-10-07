import java.util.*;
import java.io.*;

public class Main_2117_홈_방범_서비스2 {
    static int N, M, result, maxProfit;
    static int[][] map;
    static List<Coordinates> houseList;

    private static class Coordinates {
        int x;
        int y;

        public Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }
    } // End of Coordinates class

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/2117.txt"));
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
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());

                    if (map[i][j] == 1) {
                        houseList.add(new Coordinates(i, j));
                    }
                }
            }

            solution();

            sb.append(result).append('\n');
        }

        bw.write(sb.toString());
        bw.close();
    } // End of main

    private static void solution() {

        // 바깥 2중 for문은 기준점을 만드는 전체 배열 탐색 for문
        // 각 집간의 거리를 계산해서 포함되는 집만 찾기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 1; k <= N + 1; k++) {
                    int operatingExpenses = operatingExpensesCalc(k);
                    int saveHomeCount = 0;

                    for (Coordinates cor : houseList) {
                        int targetX = cor.x;
                        int targetY = cor.y;

                        int distDiff = distCalc(i, j, targetX, targetY);
                        if (distDiff < k) {
                            saveHomeCount++;
                        }
                    }

                    if (0 <= ProfitAndLossCalc(operatingExpenses, saveHomeCount)) {
                        // 안전구역에 들어가는 집이 하나라도 있으면 손익계산 해서 최댓값 갱신해서 결과 찾기
                        result = Math.max(result, saveHomeCount);
                    }

                }
            }
        }

    } // End of solution

    private static int ProfitAndLossCalc(int operatingExpenses, int saveHomeCount) {
        return (saveHomeCount * M) - operatingExpenses;
    } // End of ProfitAndLossCalc

    private static int distCalc(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    } // End of distCalc

    private static int operatingExpensesCalc(int k) {
        return k * k + (k - 1) * (k - 1);
    } // End of operatingExpensesCalc

    private static void init() {
        map = new int[N][N];
        result = 0;
        houseList = new ArrayList<>();
        maxProfit = -1;
    } // End of init
} // End of Main class