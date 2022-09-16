import java.util.*;
import java.io.*;

public class Main_15686_치킨_배달 {
    static int N, M, result;
    static int[][] arr;
    static List<Coordinates> homeList = new ArrayList<>();
    static List<Coordinates> chickList = new ArrayList<>();
    static boolean[] isVisited;
    static int[][] distArr;

    static int[] comb;

    //  치킨집을 최대 M개를 골랐을 때, 도시의 치킨 거리의 최솟값을 출력한다.
    static class Coordinates {
        int x;
        int y;

        public Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }
    } // End of Coordinates class

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/15686.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        result = Integer.MAX_VALUE;
        comb = new int[M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if (arr[i][j] == 2) {
                    chickList.add(new Coordinates(i, j));
                } else if (arr[i][j] == 1) {
                    homeList.add(new Coordinates(i, j));
                }
            }
        }

        // 치킨집과 집간의 거리 배열 생성
        // 행자리에 치킨 집 번호, // 열자리에 각 집간의 거리
        distArr = new int[chickList.size()][homeList.size()];
        for (int i = 0; i < chickList.size(); i++) {
            int x = chickList.get(i).x;
            int y = chickList.get(i).y;

            for (int j = 0; j < homeList.size(); j++) {
                int x2 = homeList.get(j).x;
                int y2 = homeList.get(j).y;

                distArr[i][j] = distCalc(x, x2, y, y2);
            }
        }

        isVisited = new boolean[chickList.size()];
        DFS(0, 0);

        System.out.println(result);
    } // End of main

    private static void DFS(int depth, int index) {
        if (depth == M) {
            int sum = 0;
            // 집을 기준으로 치킨집과의 거리중에서 작은 거리값을 선택
            int size = homeList.size();
            for (int i = 0; i < size; i++) {
                int dist = Integer.MAX_VALUE;
                for (int j = 0; j < M; j++) {
                    dist = Math.min(distArr[comb[j]][i], dist);
                }
                sum += dist;
            }

            result = Math.min(sum, result);
            return;
        }

        for (int i = index; i < chickList.size(); i++) {
            comb[depth] = i;
            DFS(depth + 1, i + 1);
        }
    } // End of DFS

    private static int distCalc(int r1, int r2, int c1, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    } // End of distCalc
} // End of Main class