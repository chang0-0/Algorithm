import java.util.*;
import java.io.*;

public class Main_1218_괄호_짝짓기 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/1218.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String str = "";
        int T = 1;
        while ( (str = br.readLine()) != null) {
            sb.append('#').append(T).append(' ');
            int N = Integer.parseInt(str);
            char quaArr[] = new char[N];
            Stack<Character> stack = new Stack<>();
            boolean check = true;

            String chTemp = br.readLine();
            for(int i=0; i<N; i++) {
                quaArr[i] = chTemp.charAt(i);
            }

            for(int i=0; i<N; i++) {
                char ch = quaArr[i];

                if(ch == '(' || ch == '{' || ch == '[' || ch == '<') {
                    stack.push(ch);
                } else {
                    if(stack.isEmpty()) {
                        check = false;
                        break;
                    } else {
                        char temp = stack.pop();

                        if(temp == '(' && ch != ')') {
                            check = false;
                            break;
                        } else if(temp == '{' && ch != '}') {
                            check = false;
                            break;
                        } else if(temp == '[' && ch != ']') {
                            check = false;
                            break;
                        } else if(temp == '<' && ch != '>') {
                            check = false;
                            break;
                        }

                    }
                }
            }

            if(check) {
                sb.append(1).append('\n');
            } else {
                sb.append(0).append('\n');
            }

            T++;
        }

        bw.write(sb.toString()); bw.close();
    } // End of main
} // End of Main class