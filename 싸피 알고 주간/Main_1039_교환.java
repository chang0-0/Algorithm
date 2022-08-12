import java.util.*;
import java.io.*;

public class Main_1039_교환 {
    static int N, K;
    static int result;

    static class NumberData {
        int number;
        int cnt;

        public NumberData(int number, int cnt) {
            this.number = number;
            this.cnt = cnt;
        } // End of NumberData
    } // End of NumberData class

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/1039.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        char ch[] = Integer.toString(N).toCharArray();

        if(ch.length < K) {
            System.out.println(-1);
            return;
        }

        BFS();
    } // End of main

    private static void BFS() {
        PriorityQueue<NumberData> pque = new PriorityQueue<>();
        boolean visit[][] = new boolean[1000001][K+1];

        pque.offer(new NumberData(N, 0));
        visit[N][0] = true;

        while(!pque.isEmpty()) {
            NumberData nd = pque.poll();

            if(nd.cnt == K) {
                result = Math.max(result, nd.number);
                continue;
            }

            int len = Integer.toString(nd.number).length();
            for(int i=0; i<len-1; i++) {
                for(int j=i+1; j<len; j++) {

                }
            }

        }


    } // End of BFS

    private static int swap(int n, int i, int j) {
        char numArr[] = Integer.toString(n).toCharArray();



        return 0;
    } // End of swap

} // End of Main class