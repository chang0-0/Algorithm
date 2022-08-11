import java.util.*;
import java.io.*;

public class Main_1217_거듭_제곱 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/1217.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String str = "";
        while ((str = br.readLine()) != null) {
            sb.append('#').append(Integer.parseInt(str)).append(' ');
            StringTokenizer st = new StringTokenizer(br.readLine());
            sb.append((int) Math.pow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))).append('\n');
        }

        bw.write(sb.toString()); bw.close();
    } // End of main
} // End of Main class