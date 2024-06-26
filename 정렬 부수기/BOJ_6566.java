package BOJ_6566;

import java.io.*;
import java.util.*;

public class BOJ_6566 {

    // https://www.acmicpc.net/problem/6566
    // input
    private static BufferedReader br;

    // variables
    private static final String OUTPUT = "Group of size ";
    private static List<String> wordList;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_6566\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        Map<String, List<String>> anagramGroup = new HashMap<>();
        for (String word : wordList) {
            char[] ch = word.toCharArray();
            Arrays.sort(ch);
            String sorted = new String(ch);

            anagramGroup.computeIfAbsent(sorted, k -> new ArrayList<>()).add(word);
        }


        List<List<String>> result = new ArrayList<>(anagramGroup.values());
        result.sort((g1, g2) -> {
            if (g1.size() != g2.size()) {
                return g2.size() - g1.size();
            } else {
                return g1.get(0).compareTo(g2.get(0));
            }
        });

        int count = 0;
        for (List<String> g : result) {
            Collections.sort(g);
            HashSet<String> set = new HashSet<>();
            sb.append(OUTPUT).append(g.size()).append(": ");
            for (String word : g) {
                if (set.add(word)) {
                    sb.append(word).append(' ');
                }
            }
            sb.append(".\n");
            count++;
            if (count == 5) break;
        }

        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        wordList = new ArrayList<>();

        String temp = "";
        while ((temp = br.readLine()) != null) {
            wordList.add(temp);
        }
    } // End of input()
} // End of Main class
