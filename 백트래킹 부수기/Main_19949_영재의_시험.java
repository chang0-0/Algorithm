import java.util.*;
import java.io.*;

public class Main_19949_영재의_시험 {
    private static final int N = 10;
    static int[] ansArr;
    static int[] tempArr;
    static int totalNumberOfCases;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/19949.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ansArr = new int[N]; // 정답 배열
        tempArr = new int[N]; // 경우의 수를 저장할 배열
        totalNumberOfCases = 0; // 한가지 경우의 수 총점

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ansArr[i] = Integer.parseInt(st.nextToken());
        }

        DFS(0);
        System.out.println(totalNumberOfCases);
    } // End of main

    private static void DFS(int depth) {
        if (depth == N) {
            int correctCount = 0;
            for (int i = 0; i < N; i++) {
                if (ansArr[i] == tempArr[i]) {
                    correctCount++;
                }

                if (correctCount == 5) {
                    totalNumberOfCases++;
                    return;
                }
            }
            return;
        }


        for (int i = 1; i <= 5; i++) {
            if (depth > 1) { // depth가 2이상일 때, i로 들어가려는 값이 이전의 -1번째와 -2번째 자리와 같은지 검사해서 i값과 같으면 지나치도록 설정
                // 반복문 단계에서 미리 검사해서 가지치기를 해버림.
                if (tempArr[depth - 1] == i && tempArr[depth - 2] == i) {
                    continue;
                }
            }

            tempArr[depth] = i;
            DFS(depth + 1);
        }

    } // End of DFS
} // End of Main class