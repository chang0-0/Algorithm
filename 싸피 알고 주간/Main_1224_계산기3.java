import java.io.*;
import java.util.*;

public class Main_1224_계산기3 {
    static Deque<Character> deque;
    static Deque<Integer> calcDeq;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/1224.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String str = "";
        int T = 1;
        while ((str = br.readLine()) != null) {
            int N = Integer.parseInt(str);
            sb.append('#').append(T).append(' ');

            char chArr[] = br.readLine().toCharArray();
            deque = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                char ch = chArr[i];

                if (ch == '(') {
                    deque.offerFirst(ch);
                } else if (ch == ')') {
                    while (!deque.isEmpty()) {
                        if (deque.peek() == '(') {
                            deque.pollFirst();
                            break;
                        } else {
                            sb.append(deque.pollLast());
                        }
                    }
                } else if (ch == '*') {
                    deque.offerFirst(ch);
                } else if (ch == '+') {
                    if (deque.isEmpty()) {
                        deque.offerFirst(ch);
                    } else {
                        while (!deque.isEmpty()) {
                            if (deque.peek() == '(') {
                                deque.pollFirst();
                                break;
                            } else {
                                sb.append(deque.pollLast());
                            }
                        }
                    }
                } else {
                    sb.append(ch);
                }
            }



            T++;
        }

        bw.write(sb.toString());
        bw.close();
    } // End of main

} // End of Main class