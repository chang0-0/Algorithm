import java.io.*;
import java.util.*;

public class Main_치킨댄스를_추는_곰곰이를_본_임스_2 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/a.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int count = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), "D-");
            int num = Integer.parseInt(st.nextToken());


            if (num <= 90) {
                count++;
            }
        }

        System.out.println(count);
    } // End of main
} // End of Main class
