import java.util.*;
import java.io.*;

public class Main_1215_회문1 {
    private static final int ARRSIZE = 8;
    static char charArr[][] = new char[ARRSIZE][ARRSIZE];
    static char tempArr[][] = new char[ARRSIZE][ARRSIZE];
    static int N;
    static int palindromeCount;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/1215.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String str = "";
        int t = 1;
        while ((str = br.readLine()) != null) {
            sb.append('#').append(t).append(' ');
            N = Integer.parseInt(str);
            palindromeCount = 0;

            for (int i = 0; i < ARRSIZE; i++) {
                String temp = br.readLine();
                for (int j = 0; j < ARRSIZE; j++) {
                    charArr[i][j] = temp.charAt(j);
                }
            }
            ratationCopy();

            for (int i = 0; i < ARRSIZE; i++) {
                search(charArr[i]);
                search(tempArr[i]);
            }

            t++;
            sb.append(palindromeCount).append('\n');
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

    private static void search(char ch[]) {
        for (int i = 0; i <= ARRSIZE - N; i++) {
            StringBuilder rowStrBuilder = new StringBuilder();
            StringBuilder rowReverseStrBuilder = new StringBuilder();

            for (int j = 0; j < N; j++) {
                rowStrBuilder.append(ch[j+i]);
                rowReverseStrBuilder.append(ch[ (N-1)+i-j ]);
            }
            if (rowStrBuilder.toString().equals(rowReverseStrBuilder.toString())) palindromeCount++;
        }
    } // End of search
}// End of Main class