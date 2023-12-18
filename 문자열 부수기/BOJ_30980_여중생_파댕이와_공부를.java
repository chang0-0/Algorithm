package BOJ_30980;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_30980_여중생_파댕이와_공부를 {

    // https://www.acmicpc.net/problem/30980
    // input
    private static BufferedReader br;

    // variables
    private static int N, M;
    private static char[][] arr;

    private static class Coordinate {
        int x;
        int y;

        private Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_30980\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        StringBuilder ret = new StringBuilder();
        boolean flag = false;

        Coordinate startIdx = new Coordinate(0, 0);
        Coordinate endIdx;

        for (int i = 0; i < 3 * N; i++) {
            for (int j = 0; j < 8 * M; j++) {
                if (arr[i][j] == '/' || arr[i][j] == '*') continue;

                if (!flag && arr[i][j] != '.') {
                    ret.append(arr[i][j]);
                    startIdx = new Coordinate(i, j);
                    flag = true;
                } else if (flag && arr[i][j] != '.') {
                    ret.append(arr[i][j]);
                } else if (flag && arr[i][j] == '.') {
                    String temp = ret.toString();

                    endIdx = new Coordinate(i, j);
                    ret = new StringBuilder();
                    flag = false;

                    check(temp, startIdx, endIdx);
                }
            }
        }


        for (int i = 0; i < 3 * N; i++) {
            for (int j = 0; j < 8 * M; j++) {
                sb.append(arr[i][j]);
            }
            sb.append('\n');
        }

        return sb.toString();
    } // End of solve()

    private static void check(String temp, Coordinate startIdx, Coordinate endIdx) {
        int a = Character.getNumericValue(temp.charAt(0));
        int b = Character.getNumericValue(temp.charAt(2));
        int c = Integer.parseInt(temp.substring(4));

        if (a + b == c) {
            // 맞는 경우
            arr[startIdx.x][startIdx.y - 1] = '*';
            arr[endIdx.x][endIdx.y] = '*';

            int len = temp.length();
            for (int i = 0; i < len; i++) {
                arr[startIdx.x + 1][startIdx.y + i] = '*';
                arr[startIdx.x - 1][startIdx.y + i] = '*';
            }
        } else {
            // 틀린 경우 startIdx = (1, 1)의 경우 0, 3, 1, 2 2, 1
            arr[startIdx.x - 1][startIdx.y + 2] = '/';
            arr[startIdx.x][startIdx.y + 1] = '/';
            arr[startIdx.x + 1][startIdx.y] = '/';
        }
    } // End of check()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[3 * N][8 * M];
        for (int i = 0; i < 3 * N; i++) {
            arr[i] = br.readLine().toCharArray();
        }
    } // End of input()
} // End of Main class
