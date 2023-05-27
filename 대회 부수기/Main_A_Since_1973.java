import java.io.*;
import java.util.StringTokenizer;

public class Main_A_Since_1973 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/a.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        if (N < 50) {
            sb.append(N);
        } else if(N >= 50) {
            int temp = N % 50;

            if(temp == 1) {
                sb.append(N + 1);
            } else {
                sb.append(N);
            }
        }

        bw.write(sb.toString());
        bw.close();
    } // End of main
} // End of Main class
