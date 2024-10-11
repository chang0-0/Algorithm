package BOJ_25758;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ_25758 {

    // https://www.acmicpc.net/problem/25758
    // input
    private static BufferedReader br;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_25758\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() throws IOException {
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            String str = st.nextToken();

            if (map.get(str) != null && map.get(str) >= 2) continue;
            map.put(str, map.getOrDefault(str, 0) + 1);
            set.add(str);
        }
        TreeSet<Character> geneSet = new TreeSet<>();
        for (String key : map.keySet()) {
            int value = map.get(key);

            if (value == 2) {
                char ch = makeGene(key, key);
                geneSet.add(ch);
            }
        }

        for (String a : set) {
            for (String b : set) {
                if (a.equals(b)) continue;
                char ch = makeGene(a, b);
                geneSet.add(ch);
            }
        }

        sb.append(geneSet.size()).append('\n');
        for (char ch : geneSet) {
            sb.append(ch).append(' ');
        }
        return sb.toString();
    } // End of solve()

    private static char makeGene(String a, String b) {
        char ch1 = a.charAt(0);
        char ch2 = b.charAt(1);

        if (ch1 > ch2) {
            return ch1;
        } else {
            return ch2;
        }
    } // End of makeGene()
} // End of Main class
