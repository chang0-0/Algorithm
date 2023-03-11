import java.io.*;
import java.util.StringTokenizer;

/*
    기권한 사람이 재학생의 절반 이상이라면 찬성과 반대의 수 상관없이 투표는 무효처리 돤다.
 */

public class Main_a_찬반투표 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/a.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int agg = 0; // 찬성
        int opp = 0; // 반대
        int giv = 0; // 기권

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int vote = Integer.parseInt(st.nextToken());

            if (vote == -1) {
                // 반대
                opp++;
            } else if (vote == 1) {
                // 찬성
                agg++;
            } else if(vote == 0) {
                // 기권
                giv++;
            }
        }

        int half = 0;
        if(N % 2 == 0) {
            half = (N / 2);
        } else {
            half = (N / 2) + 1;
        }

        if(half <= giv) {
            System.out.println("INVALID");
            return;
        } else if(agg > opp) {
            System.out.println("APPROVED");
            return;
        }

        System.out.println("REJECTED");
    } // End of main
} // End of Main class
