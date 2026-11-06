import java.io.*;
import java.util.StringTokenizer;

public class Main {

    // input
    private static BufferedReader br;

    // variables
    private static int A, B;
    private static String str;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            input();
            bw.write(solve());
        }

        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();


        int N = str.length();
        char[] chArr = str.toCharArray();

        for (int left = 0, right = N - 1; left < right; left++, right--) {
            if (chArr[left] == '?' && chArr[right] != '?') {
                chArr[left] = chArr[right];
            } else if (chArr[right] == '?' && chArr[left] != '?') {
                chArr[right] = chArr[left];
            } else if (chArr[left] != chArr[right]) {
                sb.append(-1).append('\n');
                return sb.toString();
            }
        }

        for (char ch : chArr) {
            if (ch == '0') A--;
            else if (ch == '1') B--;
        }

        if (A < 0 || B < 0) {
            sb.append(-1).append('\n');
            return sb.toString();
        }

        for (int left = 0, right = N - 1; left <= right; left++, right--) {
            if (chArr[left] != '?') {
                continue;
            }

            int need = 1;
            if (left != right) need = 2;

            if (A >= need) {
                chArr[left] = chArr[right] = '0';
                A -= need;
            } else if (B >= need) {
                chArr[left] = chArr[right] = '1';
                B -= need;
            } else {
                sb.append(-1).append('\n');
                return sb.toString();
            }
        }

        if (A != 0 || B != 0) {
            sb.append(-1).append('\n');
            return sb.toString();
        }

        for (char ch : chArr) {
            sb.append(ch);
        }

        sb.append('\n');
        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken()); // 0의 개수
        B = Integer.parseInt(st.nextToken()); // 1의 개수

        String temp = br.readLine();
        str = temp;
    } // End of input()
} // End of Main class
