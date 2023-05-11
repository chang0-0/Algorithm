import java.io.*;
import java.util.StringTokenizer;

public class Main_A1_스네이크 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/a.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int temp = N * M;

        if (temp % 2 == 1) {
            System.out.println((temp - 1));
        } else {
            System.out.println(temp);
        }
    } // End of main
} // End of Main class
