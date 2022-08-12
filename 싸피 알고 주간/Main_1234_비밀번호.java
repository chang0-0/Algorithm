import java.util.*;
import java.io.*;

public class Main_1234_비밀번호 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/1234.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Deque<Character> deque;

        String str = "";
        int T = 1;
        while ((str = br.readLine()) != null) {
            sb.append('#').append(T).append(' ');
            StringTokenizer st = new StringTokenizer(str);
            deque = new LinkedList<>();

            int N = Integer.parseInt(st.nextToken());
            char chArr[] = st.nextToken().toCharArray();

            for (int i = 0; i < N; i++) {
                char ch = chArr[i];

                if (deque.isEmpty()) {
                    deque.push(ch);
                } else if (!deque.isEmpty()) {
                    char peekChar = deque.peekFirst();
                    if (peekChar == ch) {
                        deque.pollFirst();
                    } else {
                        deque.push(ch);
                    }
                }
            }

            int len = deque.size();
            for(int i=0; i<len; i++) {
                sb.append(deque.pollLast());
            }
            T++;
            sb.append('\n');
        }
        bw.write(sb.toString());
        bw.close();
    } // End of main
} // End of Main class