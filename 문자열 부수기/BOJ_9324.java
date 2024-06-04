package BOJ_9324;

import java.io.*;

public class BOJ_9324 {

    // https://www.acmicpc.net/problem/9324
    // input
    private static BufferedReader br;

    // variables
    private static int[] alp;


    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_9324\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            alp = new int[26];
            bw.write(solve());
        }

        bw.close();
    } // End of main()

    private static String solve() throws IOException {
        StringBuilder sb = new StringBuilder();

        String temp = br.readLine();
        int len = temp.length();
        char[] chArr = new char[len + 1];
        for (int i = 0; i < len; i++) {
            chArr[i] = temp.charAt(i);
        }

        boolean flag = true;
        for (int i = 0; i < len; i++) {
            char ch = chArr[i];

            alp[ch - 'A']++;
            if (alp[ch - 'A'] % 3 == 0) {
                if (ch != chArr[i + 1]) {
                    flag = false;
                    break;
                }
                i++; // 맞으면 다음 index로 넘어간다. 4번째 문자는 count하지 않기 위해
            }
        }

        if (!flag) {
            sb.append("FAKE");
        } else {
            sb.append("OK");
        }
        sb.append('\n');

        return sb.toString();
    } // End of solve()
} // End of Main class
