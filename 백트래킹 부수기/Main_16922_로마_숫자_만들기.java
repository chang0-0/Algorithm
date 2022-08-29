import java.io.*;

// 만들 수 있는 서로 다른 수의 개수를 출력한다
public class Main_16922_로마_숫자_만들기 {
    private static final int[] LOMEARR = {1, 5, 10, 50};
    static boolean[] isVisited;
    static int result = 0;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/16922.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 사용 할 수 있는 문자 개수
        isVisited = new boolean[4845];

        DFS(0, N, 0, 0);
        System.out.print(result);
    } // End of main

    private static void DFS(int depth, int depthLimit, int indexStart, int sum) {
        if (depth == depthLimit) {
            if(!isVisited[sum]) { // 계산 된 값이 이미 방문된 값인지 체크.
                isVisited[sum] = true;
                result++;
            }
            return;
        }

        for (int i = indexStart; i < 4; i++) {
            // 중복된 숫자가 들어갈 수 있어야하므로, indexStart의 매개변수 자리에 그대로 현재 실행된 값 i를 넣어서
            // 이전의 실행된 값과 똑같은 인덱스 자리의 값이 들어갈 수 있도록 해준다.
            // 중복을 제외하려면 i + 1을 넣어주어야 한다.
            DFS(depth + 1, depthLimit, i, sum + LOMEARR[i]);
        }
    } // End of DFS
} // End of Main class