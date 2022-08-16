import java.util.*;
import java.io.*;

public class Main_1226_미로1 {
    private static final int ARR_SIZE = 16;
    static int dirX[] = {0, 0, -1, 1};
    static int dirY[] = {1, -1, 0, 0};
    static int arr[][] = new int[ARR_SIZE][ARR_SIZE];
    static int nowX, nowY;

    static class Maze {
        int x;
        int y;

        Maze(int x, int y) {
            this.x = x;
            this.y = y;
        }
    } // End of Maze class

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/1226.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String str = "";
        while ((str = br.readLine()) != null) {
            sb.append('#').append(Integer.parseInt(str)).append(' ');

            for (int i = 0; i < ARR_SIZE; i++) {
                String temp = br.readLine();
                for (int j = 0; j < ARR_SIZE; j++) {
                    arr[i][j] = Character.getNumericValue(temp.charAt(j));
                }
            }

            sb.append(BFS(1, 1)).append('\n');
        }

        bw.write(sb.toString());
        bw.close();
    } // End of main

    private static int BFS(int x, int y) {
        Queue<Maze> que = new LinkedList<>();
        boolean visit[][] = new boolean[ARR_SIZE][ARR_SIZE];
        visit[x][y] = true;
        que.offer(new Maze(x, y));

        while(!que.isEmpty()) {
            Maze m = que.poll();

            for(int i=0; i<4; i++) {
                nowX = dirX[i] + m.x;
                nowY = dirY[i] + m.y;

                if(rangeCheck() && !visit[nowX][nowY] && (arr[nowX][nowY] == 0 || arr[nowX][nowY] == 3)) {
                    if(arr[nowX][nowY] == 3) {
                        return 1;
                    }

                    visit[nowX][nowY] = true;
                    que.offer(new Maze(nowX, nowY));
                }
            }
        }

        return 0;
    } // End of BFS

    private static boolean rangeCheck() {
        return nowX >= 0 && nowX < ARR_SIZE && nowY >= 0 && nowY < ARR_SIZE;
    } // End of rangeCheck
} // End of Main class