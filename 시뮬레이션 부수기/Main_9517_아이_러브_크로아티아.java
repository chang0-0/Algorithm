import java.io.*;
import java.util.*;

// 폭탄을 터뜨린 사람의 번호를 출력한다.
public class Main_9517_아이_러브_크로아티아 {
    private static final int BOMB_TIME = 210;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/9517.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        char[] chArr = new char[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
            chArr[i] = st.nextToken().charAt(0);
        }

        int sumTime = 0;
        for (int i = 0; i < N; i++) {
            sumTime += arr[i];

            if (sumTime >= BOMB_TIME) {
                System.out.println(K);
                return;
            }

            // 질문을 패스하거나 틀릴경우, 폭탄은 같은 사람이 계속 들고 있고, 질문만 다음 사람이 받음
            // 질문을 맞힌 사람이 있을 경우에만 폭탄을 왼쪽 사람한테 넘겨줌,
            // 그래서 'T'일 경우에만, K값이 증가함
            if (chArr[i] == 'T') {
                if (K == 8) {
                    K = 1;
                } else {
                    K++;
                }
            }
        }

    } // End of main
} // End of Main class