package BOJ_1991;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1991_트리_순회_배열구현 {

    // https://www.acmicpc.net/problem/1991
    // input
    private static BufferedReader br;

    // variables
    private static int N;
    private static Node[] tree;
    private static StringBuilder sb;

    private static class Node {
        char cur;
        Node left;
        Node right;

        private Node(char cur) {
            this.cur = cur;
            this.left = null;
            this.right = null;
        }
    } // End of Node class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_1991\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {

        // 전위 순회
        preOrder(tree[0]);
        sb.append('\n');

        // 중위 순회
        inOrder(tree[0]);
        sb.append('\n');

        // 후위 순회
        postOrder(tree[0]);
        sb.append('\n');

        return sb.toString();
    } // End of solve()

    private static void preOrder(Node node) {
        if (node == null) return;
        sb.append(node.cur);
        preOrder(node.left);
        preOrder(node.right);
    } // End of preOrder()

    private static void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        sb.append(node.cur);
        inOrder(node.right);
    } // End of inOrder()

    private static void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        sb.append(node.cur);
    } // End of postOrder()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        tree = new Node[N + 1];
        sb = new StringBuilder();


        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char cur = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            if (tree[cur - 'A'] == null) {
                tree[cur - 'A'] = new Node(cur);
            }

            if (left != '.') {
                tree[left - 'A'] = new Node(left);
                tree[cur - 'A'].left = tree[left - 'A'];
            }

            if (right != '.') {
                tree[right - 'A'] = new Node(right);
                tree[cur - 'A'].right = tree[right - 'A'];
            }
        }
    } // End of input()
} // End of Main class
