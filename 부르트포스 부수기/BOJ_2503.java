package BOJ_2503;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_2503 {

    // https://www.acmicpc.net/problem/2503
    // input
    private static BufferedReader br;

    // variables
    private static int N;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_2503\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() throws IOException {
        StringBuilder sb = new StringBuilder();

        HashSet<Integer> set = new HashSet<>();
        int[] ans = new int[1000];

        int n = N;
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            char[] numChar = Integer.toString(num).toCharArray();
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

            for (int i = 123; i <= 987; i++) {
                char[] temp = Integer.toString(i).toCharArray();
                int strikeCount = 0;
                int ballCount = 0;

                // 하나라도 겹치는 숫자가 있으면 pass
                if (temp[0] == temp[1] || temp[1] == temp[2] || temp[0] == temp[2] || temp[0] == '0' || temp[1] == '0' || temp[2] == '0')
                    continue;

                boolean[] isVisited = new boolean[3];
                for (int j = 0; j < 3; j++) {
                    char ch = numChar[j];
                    for (int k = 0; k < 3; k++) {
                        char ch2 = temp[k];

                        if (isVisited[k]) continue;

                        if (j == k && ch == ch2) {
                            isVisited[k] = true;
                            strikeCount++;
                            break;
                        } else if (j != k && ch == ch2) {
                            ballCount++;
                            isVisited[k] = true;
                            break;
                        }
                    }
                }

                if (ballCount == ball && strikeCount == strike) {
                    ans[i]++;
                }


            }
        }

        int answer = 0;
        for (int i = 123; i <= 987; i++) {
            if (ans[i] == N) {
                answer++;
            }
        }

        sb.append(answer);
        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

    } // End of input()
} // End of Main class
