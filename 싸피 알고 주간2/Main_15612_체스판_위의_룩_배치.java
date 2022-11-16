import java.io.*;
import java.util.*;

public class Main_15612_체스판_위의_룩_배치 {
    private static final int N = 8;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/15612.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        // 정확히 8개의 룩이 있어야 한다.
        // 모든 룩은 서로 공격할 수 없어야 한다. 즉, 서로 다른 두 룩은 같은 열에 있거나 같은 행에 있으면 안 된다
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append('#').append(t).append(' ');
            String result = "";
            boolean[] isVisited = new boolean[N];
            boolean failCheck = false;

            int count = 0;
            for (int i = 0; i < N; i++) {
                String temp = br.readLine();
                int rowCount = 0;
                for (int j = 0; j < N; j++) {
                    char ch = temp.charAt(j);

                    if (ch == 'O') {
                        rowCount++;

                        if (rowCount >= 2 || isVisited[j]) {
                            failCheck = true;
                            break;
                        }
                        isVisited[j] = true;
                        count++;
                    }
                }
            }

            if(count == 8 && !failCheck) {
                result = "yes";
            } else {
                result = "no";
            }

            sb.append(result).append('\n');
        }

        bw.write(sb.toString());
        bw.close();
    } // End of main

} // End of Main class
