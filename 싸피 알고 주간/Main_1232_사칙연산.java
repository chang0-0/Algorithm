import java.util.*;
import java.io.*;

public class Main_1232_사칙연산 {
    static Node[] arr; // 트리를 표현할 Node객체 타입 배열
    static int N; // 트리의 노드 갯수
    static int result; // 결과값
    static StringBuilder sb = new StringBuilder();

    // ✔️ 트리의 속성을 파악하는 것이 중요하고, 프로그래밍에서 트리의 구조를 어떻게 표현을 하는지를 아는 것이 중요함
    static class Node { // 트리의 노드 정보를 담을 객체
        int value; // 노드가 가지고 있는 숫자, (연산자를 가지고 있을 경우 null값을 가지게 됨)
        int left; // 왼쪽 자식노드의 번호
        int right; // 오른쪽 자식노드의 번호
        String op; // 노드가 가지고 있는 연산자 정보, 
    } // End of Node class

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/1232.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = "";
        int T = 1;
        while ((str = br.readLine()) != null) {
            sb.append('#').append(T).append(' ');

            N = Integer.parseInt(str);
            init(); // 변수초기화 메소드

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int idx = Integer.parseInt(st.nextToken());
                String op = st.nextToken();

                if (op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/")) { // 연산자가 들어오면, 연산자와 자식 노드들을 저장.
                    arr[idx].op = op;
                    arr[idx].left = Integer.parseInt(st.nextToken());
                    arr[idx].right = Integer.parseInt(st.nextToken());
                } else {
                    arr[idx].value = Integer.parseInt(op); // 연산자가 아닐 경우, 바로 숫자가 넘어오므로 data에 저장
                }
            }

            T++;
            sb.append(postOrder(1)).append('\n');
        }

        bw.write(sb.toString());
        bw.close();
    } // End of main

    private static int postOrder(int num) { // 수식은 전위 순회
        String op = arr[num].op;

        if (op != null && op.equals("+")) {
            result = postOrder(arr[num].left) + postOrder(arr[num].right);
        } else if (op != null && op.equals("-")) {
            result = postOrder(arr[num].left) - postOrder(arr[num].right);
        } else if (op != null && op.equals("/")) {
            result = postOrder(arr[num].left) / postOrder(arr[num].right);
        } else if (op != null && op.equals("*")) {
            result = postOrder(arr[num].left) * postOrder(arr[num].right);
        } else {
            result = arr[num].value;
        }

        return result;
    } // End of postOrder

    private static void init() {
        result = 0;

        // 객체형 배열 생성
        arr = new Node[N + 1]; // 트리의 인덱스를 사용해서 배열의 인덱스와 연결시켜서 탐색
        for (int i = 0; i <= N; i++) {
            arr[i] = new Node();
        }
    } // End of init
} // End of Main class