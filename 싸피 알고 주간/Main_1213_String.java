import java.io.*;
import java.util.*;

public class Main_1213_String {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/1213.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String str = "";
        while ((str = br.readLine()) != null) {
            int T = Integer.parseInt(str);
            sb.append('#').append(T).append(' ');
            int count = 0;

            String findStr = br.readLine();
            String inputStr = br.readLine();
            int findStrLength = findStr.length();
            int inputStrLength = inputStr.length();

            int vocaCount = 0;
            for(int i=0; i<=inputStrLength-findStrLength; i++) {
                    String temp = inputStr.substring(i, findStrLength+i);
                    if(temp.equals(findStr)) vocaCount++;
            }

            sb.append(vocaCount).append('\n');
        }

        bw.write(sb.toString());
        bw.close();
    } // End of main
} // End of Main class