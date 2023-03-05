import java.io.*;
import java.util.StringTokenizer;

public class Main_27648_증가_배열_만들기 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/a.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()); // 1이상 K이하의 수로 채우기.

        if ((N + M) - 2 >= K) {
            System.out.println("NO");
            return;
        }

        sb.append("YES").append('\n');
        int startNum;
        for (int i = 0; i < N; i++) {
            startNum = i + 1;
            for (int j = 0; j < M; j++) {
                sb.append(startNum++).append(' ');
            }
            sb.append('\n');
        }

        bw.write(sb.toString());
        bw.close();
    } // End of main
} // End of Main class
