package BOJ_1515;

import java.io.*;

public class BOJ_1515 {

    // https://www.acmicpc.net/problem/1515
    // input
    private static BufferedReader br;

    // variables
    private static char[] chArr;
    private static String str;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_1515\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        int curNum = 1;
        int sequenceIndex = 0;
        int len = str.length();

        while (sequenceIndex < len) {
            String curNumStr = Integer.toString(curNum);
            int curNumStrLen = curNumStr.length();
            for (int i = 0; i < curNumStrLen; i++) {
                if (str.charAt(sequenceIndex) == curNumStr.charAt(i)) {
                    sequenceIndex++;
                    if (sequenceIndex == len) {
                        break;
                    }
                }
            }
            curNum++;
        }

        sb.append(curNum - 1);
        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        chArr = br.readLine().toCharArray();
        str = new String(chArr);
    } // End of input()
} // End of Main class
