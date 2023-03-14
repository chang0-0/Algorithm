import java.io.*;
import java.util.*;

public class Main_1251_하나로 {
    static int N;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/1251.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append('#').append(t).append(' ');

            N = Integer.parseInt(br.readLine());



        }

        bw.write(sb.toString());
        bw.close();
    } // End of main
} // End of Main class