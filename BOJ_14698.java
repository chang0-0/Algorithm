package BOJ_14698;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_14698 {

    // https://www.acmicpc.net/problem/14698
    // input
    private static BufferedReader br;

    // variables
    private static int N;
    private static int[] arr;
    private static final int MOD = (int) Math.pow(10, 9) + 7;
    private static PriorityQueue<Integer> pque;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_14698\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            input();

            bw.write(solve());
        }

        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();
        
        /*  
            한마리의 슬라임으로 만드는데 필요한 최소의 에너지 양을 구하라
         */


        while (pque.size() > 1) {
            int num1 = pque.poll();
            int num2 = pque.poll();

            int temp = (num1 * num2) % MOD;
            pque.offer(temp);
        }

        System.out.println("pque : " + pque);


        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        pque = new PriorityQueue<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            pque.offer(arr[i]);
        }
    } // End of input()
} // End of Main class

/*
    14 * 2 = 28

    28  * 3 = 84

    84, 8, 10


 */