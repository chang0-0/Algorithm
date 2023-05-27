import java.io.*;
import java.util.StringTokenizer;

public class Main_B {

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/b.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            char[] chArr = br.readLine().toCharArray();

            int len = chArr.length;
            int cnt = 0;
            boolean flag = false;
            int slashCount = 0;

            StringBuilder tempString = new StringBuilder();
            for (char ch : chArr) {

                if (ch == '@') {
                    cnt++;
                    tempString.append('a');
                } else if (ch == '[') {
                    cnt++;
                    tempString.append('c');
                } else if (ch == '!') {
                    cnt++;
                    tempString.append('i');
                } else if (ch == ';') {
                    cnt++;
                    tempString.append('j');
                } else if (ch == '^') {
                    cnt++;
                    tempString.append('n');
                } else if (ch == '0') {
                    cnt++;
                    tempString.append('o');
                } else if (ch == '7') {
                    cnt++;
                    tempString.append('t');
                } else if (ch == '\\') {
                    slashCount++;
                } else if (slashCount == 1 && ch == '\'') {
                    slashCount = 0;
                    cnt++;
                    tempString.append('v');
                } else if (slashCount == 1 && ch == '\\') {
                    slashCount++;
                } else if (slashCount == 2 && ch == '\'') {
                    slashCount = 0;
                    cnt++;
                    tempString.append('w');
                } else {
                    tempString.append(ch);
                }


                // 단어를 해석할 수 없는 경우
                if (len / 2 <= cnt) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                sb.append("I don't understand").append('\n');
            } else {
                sb.append(tempString).append('\n');
            }
        }

        bw.write(sb.toString());
        bw.close();
    } // End of main
} // End of Main class
