import java.util.*;
import java.io.*;

public class Main_2105_디저트_카페 {
    static int N;
    static int[][] map;
    static int[] dirX = {-1, 1, 1, -1}; // 대각선 방향으로 시계방향. (상우 -> 하우 -> 하좌 -> 상좌)
    static int[] dirY = {1, 1, -1, -1};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/2105.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append('#').append(t).append(' ');

            N = Integer.parseInt(br.readLine());
            map = new int[N][N];

        }


        bw.write(sb.toString());
        bw.close();
    } // End of main
} // End of Main class