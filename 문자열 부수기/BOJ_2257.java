package BOJ_2257;

import java.io.*;
import java.util.ArrayDeque;

public class BOJ_2257 {

    // https://www.acmicpc.net/problem/2257
    // input
    private static BufferedReader br;

    // variables
    private static char[] chArr;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_2257\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        int N = chArr.length;
        int i = 0;
        ArrayDeque<Integer> que = new ArrayDeque<>();

        while (i < N) {
            char ch = chArr[i];

            if (ch == '(') {
                que.addLast(-1);
                i++;
            } else if (ch == ')') {
                int value = 0;
                while (!que.isEmpty() && que.getLast() != -1) {
                    value += que.removeLast();
                }

                while (!que.isEmpty() && que.getLast() == -1) {
                    que.removeLast();
                }

                i++;
                if (i < N && Character.isDigit(chArr[i])) {
                    value *= Character.getNumericValue(chArr[i]);
                }

                que.addLast(value);
            } else if (ch == 'C' || ch == 'H' || ch == 'O') {
                int value = calc(ch);

                i++;
                if (i < N && Character.isDigit(chArr[i])) {
                    value *= Character.getNumericValue(chArr[i]);
                }
                que.addLast(value);
            } else {
                // ) 다음에 숫자가 아닐 경우가 있음,
                // 이미 위에서 i++을 했기 때문에 else에서 i를 ++해줘야 한다.
                i++;
            }
        }

        int ans = 0;
        for (int num : que) {
            ans += num;
        }

        sb.append(ans);
        return sb.toString();
    } // End of solve()

    private static int calc(char ch) {
        if (ch == 'C') {
            return 12;
        } else if (ch == 'H') {
            return 1;
        } else {
            return 16;
        }
    } // End of calc()

    private static void input() throws IOException {
        chArr = br.readLine().toCharArray();
    } // End of input()
} // End of Main class
