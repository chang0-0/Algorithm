package BOJ_1406;

import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

public class BOJ_1406 {

    // https://www.acmicpc.net/problem/1406
    // input
    private static BufferedReader br;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_1406\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() throws IOException {
        StringBuilder sb = new StringBuilder();

        char[] chArr = br.readLine().toCharArray();
        LinkedList<Character> list = new LinkedList<>();
        for (char ch : chArr) list.offer(ch);

        ListIterator<Character> iter = list.listIterator();
        while (iter.hasNext()) {
            iter.next();
        }

        int M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            String com = br.readLine();

            switch (com.charAt(0)) {
                case 'L':
                    if (iter.hasPrevious()) iter.previous();
                    break;
                case 'D':
                    if (iter.hasNext()) iter.next();
                    break;
                case 'B':
                    if (iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                    break;
                case 'P':
                    char ch = com.charAt(2);
                    iter.add(ch);
                    break;
            }
        }

        for (char ch : list) sb.append(ch);
        return sb.toString();
    } // End of solve()
} // End of Main class
