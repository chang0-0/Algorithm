import com.sun.org.apache.xpath.internal.operations.Neg;

import java.awt.color.ICC_Profile;
import java.util.*;
import java.io.*;

public class Main_연습문제2 {
    static int arr[] = {6, 9, 13, 14, 20, 21, 22, 30, 49, 55};
    static int target = 110;
    static boolean visit[];
    static int answerArr[];
    static int result = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        visit = new boolean[10];

        // 자리수를 정할 answerArr의 크기를 조절하는 배열
        for(int i=1; i<=10; i++) {
            answerArr = new int[i];
            DFS(0, 0);
            // 어짜피 나오면 visit은 다시 다 false가 됨
        }

        bw.write(sb.toString()); bw.close();
    } // End of main

    // 백트래킹
    private static void DFS(int index, int depth) {
        if(depth == answerArr.length) {
            int sum = 0;
            for(int num : answerArr) {
                sum += num;
            }

            if(sum == target) {
                sb.append('[');
                for(int i=0; i<answerArr.length; i++) {
                    sb.append(answerArr[i]).append(' ');
                }
                sb.append(']').append('\n');
                result++;
            }
            return;
        }

        for(int i=index; i<10; i++) {
            if(visit[i]) continue;
            visit[i] = true;
            answerArr[depth] = arr[i];
            DFS(i + 1, depth + 1);
            visit[i] = false;
        }

    } // End of DFS
} // End of Main class