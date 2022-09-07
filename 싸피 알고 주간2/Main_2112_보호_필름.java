import java.util.*;
import java.io.*;

// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5V1SYKAaUDFAWu


// 성능검사를 통과할 수 있는 약품의 최소 투입 횟수이다. 약품을 투입하지 않고도 성능검사를 통과하는 경우에는 0을 출력한다.
// for (int[] arr : tempArr) System.out.println(Arrays.toString(arr));
public class Main_2112_보호_필름 {
    static int D, W, K;
    static int[][] arr;
    static int[][] tempArr;
    static int result;

    static int[] isVisited;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/2112.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append('#').append(t).append(' ');

            st = new StringTokenizer(br.readLine());
            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            init();

            for (int i = 0; i < D; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    tempArr[i][j] = arr[i][j];
                }
            }

            // for (int[] num : arr) System.out.println(Arrays.toString(num));

            if (searching()) { // 먼저 가능한지 한번 체크
                sb.append(0).append('\n');
                continue;
            }

            DFS(0);
            sb.append(result).append('\n');
        }

        bw.write(sb.toString());
        bw.close();
    } // End of main

    private static void DFS(int depth) {

        if(depth == K) {

            return;
        }

        for (int i = 0; i < D; i++) {
            if (isVisited[i] == 2) continue;

            isVisited[i]++;
            change(i, isVisited[i], depth);
            DFS(depth + 1);
            isVisited[i]--;
        }


    } // End of DFS

    private static void change(int index, int num, int depth) {

        if (num == 1) {
            Arrays.fill(tempArr[index], 1);
        } else {
            Arrays.fill(tempArr[index], 0);
        }

        for (int[] arr : tempArr) System.out.println(Arrays.toString(arr));
        System.out.println("========================================");



        if(searching()) {
            System.out.println(depth);
            result = Math.min(result, depth);
        }

        copy();
    } // End of change

    private static boolean searching() {
        for (int i = 0; i < W; i++) {
            boolean check = false;

            int zeroCount = 0;
            int oneCount = 0;
            for (int j = 0; j < D; j++) {
                if (arr[j][i] == 0) {
                    zeroCount++;
                    oneCount = 0;
                } else {
                    oneCount++;
                    zeroCount = 0;
                }

                // 둘 중 하나라도 K를 찍으면 중지.
                if (zeroCount == K || oneCount == K) {
                    check = true;
                    break;
                }
            }

            if (!check) {
                return false;
            }
        }

        return true;
    } // End of searching

    private static void copy() {
        for (int i = 0; i < D; i++) {
            for (int j = 0; j < W; j++) {
                tempArr[i][j] = arr[i][j];
            }
        }
    } // End of copy

    private static void init() {
        arr = new int[D][W];
        tempArr = new int[D][W];
        isVisited = new int[D];
        result = K+2;
    } // End of init
} // End of Main class
