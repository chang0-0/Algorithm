import java.util.*;
import java.io.*;

public class Main_연습문제1 {
    private static final int ARRSIZE = 5;
    static int dirX[] = {0, 0, -1, 1};
    static int dirY[] = {1, -1, 0, 0};
    static int nowX, nowY;
    static int arr[][];
    static int resultArr[][];

    public static void main(String[] args) {
        arr = new int[ARRSIZE][ARRSIZE];
        resultArr = new int[ARRSIZE][ARRSIZE];

        for(int i=0; i<ARRSIZE; i++) {
            for(int j=0; j<ARRSIZE; j++) {
                arr[i][j] = (int) (Math.random() * (25 - 1)) + 1;
            }
        }
        System.out.println("원본 배열");
        for(int num[] : arr) {
            System.out.println(Arrays.toString(num));
        }

        System.out.println("=======================================================================");

        for(int i=0; i<ARRSIZE; i++) {
            for(int j=0; j<ARRSIZE; j++) {
                DFS(i, j);
            }
        }

        System.out.println("절대값 배열");
        for(int num[] : resultArr) {
            System.out.println(Arrays.toString(num));
        }
    } // End of main

    private static void DFS(int x, int y) {
        int center = arr[x][y];
        int sum = 0;

        for(int i=0; i<4; i++) {
            nowX = x + dirX[i];
            nowY = y + dirY[i];

            if(rangeCheck()) {
                int ohterValue = arr[nowX][nowY];
                sum += Math.abs(center - ohterValue);
            }
        }
        resultArr[x][y] = sum;
    } // End of DFS

    private static boolean rangeCheck() {
        return nowX >= 0 && nowX < ARRSIZE && nowY >= 0 && nowY < ARRSIZE;
    } // End of rangeCheck
} // End of Main class