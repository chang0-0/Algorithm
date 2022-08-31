import java.io.*;
import java.util.*;

public class Main_12014_주식 {
    static int N, K, result;
    static int[] arr;
    static int[] tempArr;
    static boolean[] isVisited;

    // 연속된 날짜가 아니어도 된다.
    // index를 기준으로 증가하는 숫자가 몇개가 있는지 체크한다.
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/12014.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("Case").append(' ').append('#').append(t).append('\n');

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            init();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            // DFS(0);

            // 증가하는 숫자가 몇개가 있는지 체크하기
            boolean check = false;
            for (int i = 0; i < N - K; i++) {
                int num = arr[i];
                int count = 0;
                for (int j = i + 1; j < N; j++) {

                    // 자신 보다 큰 수가 몇개가 있는지 체크하기
                    if (num < arr[j]) {
                        count++;
                    }
                }

                // 증가하는 값을 세아렸는데, K보다 작으면 check를 true로 바꾸고, 유지 하다가
                // 한번이라도 증가하는 값의 숫자가 K와 같거나 커지면 check를 false로 바꾸고 중지
                if (count < K) {
                    check = true;
                } else {
                    check = false;
                    break;
                }
            }

            
            if(check) {
                result = 0;
            } else {
                result = 1;
            }

            sb.append(result).append('\n');
        }

        bw.write(sb.toString());
        bw.close();
    } // End of main

    // 주어진 조건을 만족하여 주식을 사는 것이 가능하면 1을 출력 불가능하면 0을 출력

    // 되는 조건 보다 안되는 조건을 찾는게 더 쉽지 않을까?
    // 1. 0번째 값을 기준으로 증가하는 값이 K개가 되는지 체크하기.
    private static void DFS(int depth) {
        if (depth == K) {
            result = 1;
            return;
        }

        for (int i = 0; i < N; i++) {

        }

    } // End of DFS

    private static void init() { // 변수 초기화 메소드
        result = 1;
        arr = new int[N];
        tempArr = new int[K];
        isVisited = new boolean[N];
    } // End of init
} // End of Main class