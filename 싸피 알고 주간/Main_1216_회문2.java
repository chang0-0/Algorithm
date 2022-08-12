import java.util.*;
import java.io.*;

// 가장 긴 회문의 길이를 찾아라
public class Main_1216_회문2 {
    private static final int ARRSIZE = 100;
    static char charArr[][] = new char[ARRSIZE][ARRSIZE];
    static char tempArr[][] = new char[ARRSIZE][ARRSIZE];
    static int maxPalindromLength;

    // 펠린드롬의 규칙 : 알파벳의 개수가 모두 짝수이거나, 홀수인 알파벳의 개수가 2개 이상이면 안된다.
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/1216.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String str = "";
        while ((str = br.readLine()) != null) {
            int T = Integer.parseInt(str);
            maxPalindromLength = -1;
            sb.append('#').append(T).append(' ');

            for (int i = 0; i < ARRSIZE; i++) {
                String temp = br.readLine();
                for (int j = 0; j < ARRSIZE; j++) {
                    charArr[i][j] = temp.charAt(j);
                }
            }
            ratationCopy();

            for (int i = 0; i < ARRSIZE; i++) {
                for (int j = 1; j <= ARRSIZE; j++) {
                    search(charArr[i], j);
                    search(tempArr[i], j);
                }
            }

            sb.append(maxPalindromLength).append('\n');
        }

        bw.write(sb.toString());
        bw.close();
    } // End of main

    private static void ratationCopy() {
        for (int i = 0; i < ARRSIZE; i++) {
            for (int j = 0; j < ARRSIZE; j++) {
                tempArr[j][i] = charArr[i][j];
            }
        }
    } // End of rotationCopy

    private static void search(char ch[], int palindromLength) {
        for (int i = 0; i <= ARRSIZE - palindromLength; i++) {
            StringBuilder rowStrBuilder = new StringBuilder();
            StringBuilder rowReverseStrBuilder = new StringBuilder();

            for (int j = 0; j < palindromLength; j++) {
                rowStrBuilder.append(ch[j + i]);
                rowReverseStrBuilder.append(ch[(palindromLength - 1) + i - j]);
            }
            if (rowStrBuilder.toString().equals(rowReverseStrBuilder.toString())) {
                maxPalindromLength = Math.max(maxPalindromLength, palindromLength);
                return;
            }
        }
    } // End of search
} // End of Main class