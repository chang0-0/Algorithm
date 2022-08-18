import org.w3c.dom.Node;

import java.util.*;
import java.io.*;

public class Main_1231_중위순회 {
    // 중위순회를 하여 단어를 만들어라
    static int N;
    static char arr[];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/1231.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = "";
        int T = 1;
        while( (str = br.readLine()) != null ) {
            sb.append('#').append(T).append(' ');

            N = Integer.parseInt(str);
            arr = new char[N+1];
            for(int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                int nodeNum = Integer.parseInt(st.nextToken());
                char alphabet = st.nextToken().charAt(0);
                arr[nodeNum] = alphabet;
            }

            inOrder(1); // 중위 순회
            sb.append('\n');
            T++;
        }

        bw.write(sb.toString()); bw.close();
    } // End of main

    private static void inOrder(int node) {
        System.out.printf("inOrder( %d ) \n", node);

        if(node > N) {
            return;
        }

        // x의 왼쪽 자식노드 인덱스 번호 = 2x
        inOrder(node * 2);
        sb.append(arr[node]);

        // x의 오른쪽 자식노드 인덱스 번호 = 2x + 1
        inOrder(node * 2 + 1);
    } // End of inOrder
} // End of Main class