package BOJ_3448;

import java.io.*;

public class BOJ_3448 {

    // https://www.acmicpc.net/problem/3448
    // input
    private static BufferedReader br;

    private static StringBuilder str;
    private static final String EFF = "Efficiency ratio is ";

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_3448\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            str = new StringBuilder();

            while (true) {
                String temp = br.readLine();
                if (temp == null || temp.isEmpty()) {
                    break;
                }
                str.append(temp);
            }

            bw.write(solve());
        }


        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        String temp = str.toString();
        double N = temp.length();
        double count = 0.0;

        for (int i = 0; i < N; i++) {
            if (temp.charAt(i) == '#') {
                count++;
            }
        }

        double ratio = 100 - ((count * 100) / N);
        String ratioToString = String.format("%.1f", ratio);
        int ratioToInt = (int) Double.parseDouble(ratioToString);

        sb.append(EFF);
        if (ratioToString.equals(ratioToInt + ".0")) {
            sb.append(ratioToInt);
        } else {
            sb.append(ratioToString);
        }

        sb.append("%.\n");
        return sb.toString();
    } // End of solve()
} // End of Main class
