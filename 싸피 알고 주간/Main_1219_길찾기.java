import java.util.*;
import java.io.*;

// 0에서 99로 갈 수 있는지 파악
public class Main_1219_길찾기 {
    static List<List<Integer>> nodeList;
    static boolean visit[];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/1219.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String str = "";
        int T = 1;
        while ((str = br.readLine()) != null) {
            sb.append('#').append(T).append(' ');

            visit = new boolean[100];
            nodeList = new ArrayList<>();
            for(int i=0; i<=100; i++) {
                nodeList.add(new ArrayList<>());
            }

            StringTokenizer st = new StringTokenizer(str);
            st.nextToken();
            int loop = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<loop; i++) {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                nodeList.get(x).add(y);
            }

            DFS(0);
            if(visit[99] == true) {
                sb.append(1).append('\n');
            } else {
                sb.append(0).append('\n');
            }

            T++;
        }

        bw.write(sb.toString());
        bw.close();
    } // End of main

    private static void DFS(int y) {
        for(int num : nodeList.get(y)) {
            if(!visit[num]) {
                DFS(num);
            }
        }

        visit[y] = true;
    } // End of DFS;
} // End of Main class