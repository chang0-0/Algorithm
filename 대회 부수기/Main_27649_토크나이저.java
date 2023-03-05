import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_27649_토크나이저 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/b.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        List<Character> tokenList = new ArrayList<>();
        tokenList.add('<');
        tokenList.add('>');
        tokenList.add('&');
        tokenList.add('|');
        tokenList.add('(');
        tokenList.add(')');
        tokenList.add(' ');

        List<String> resultList = new ArrayList<>();
        String str = br.readLine();
        int len = str.length();
        String temp2 = "";

        for (int i = 0; i < len; i++) {
            char temp = str.charAt(i);

            if (tokenList.contains(temp)) {
                if (!(temp2.length() == 0)) {
                    resultList.add(temp2);
                    temp2 = "";
                }

                if (temp == '|') {
                    resultList.add("||");
                    i++;
                } else if (temp == '&') {
                    resultList.add("&&");
                    i++;
                } else {
                    resultList.add(String.valueOf(temp));
                }
            } else {
                temp2 += temp;
            }
        }

        if (!(temp2.length() == 0)) {
            resultList.add(temp2);
        }

        for (String temp : resultList) {
            sb.append(temp).append(' ');
        }

        sb.replace(sb.toString().length() - 1, sb.toString().length(), "");

        bw.write(sb.toString());
        bw.close();
    } // End of main
} // End of Main class
