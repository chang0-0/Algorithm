import java.util.*;
import java.io.*;

public class Main_1242_암호코드_스캔 {
    static int N, M, result;
    static char[][] barCode;
    static HashSet<String> codeSet;
    static HashSet<List<Integer>> finalCodeSet;

    static final String[] hexArr = {"0000", "0001", "0010", "0011", "0100",
            "0101", "0110", "0111", "1000", "1001",
            "1010", "1011", "1100", "1101", "1110",
            "1111",
    };

    // 각 코드의 비율
    static final int[][] numberArr = {{3, 2, 1, 1}, {2, 2, 2, 1}, {2, 1, 2, 2}, {1, 4, 1, 1},
            {1, 1, 3, 2}, {1, 2, 3, 1}, {1, 1, 1, 4}, {1, 3, 1, 2}, {1, 2, 1, 3}, {3, 1, 1, 2}};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/1242.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append('#').append(t).append(' ');

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            init(); // 변수 초기화 메소드

            String preTemp = "";
            for (int i = 0; i < N; i++) {
                String temp = br.readLine();
                if (temp.equals(preTemp)) continue;

                for (int j = 0; j < M; j++) {
                    char ch = temp.charAt(j);
                    if (ch != '0') {
                        // binary코드로 변환하여 set에 저장.
                        codeSet.add(changeBinary(temp));
                        break;
                    }
                }
                preTemp = temp;
            }

            for (String str : codeSet) {
                search(str);
            }

            // 중복제거를 위해서 list를 사용했음, 일반 배열을 set에 넣으면 Hashcode가 달라서, 중복값이 들어가게됨
            for (List<Integer> list : finalCodeSet) {
                int num = calc(list);
                result += num;
            }

            sb.append(result).append('\n');
        }

        bw.write(sb.toString());
        bw.close();
    } // End of main

    private static void search(String str) {
        int zeroCount = 0;
        int oneCount = 0;
        boolean start = false;
        int ratio = 11;

        int[] resultCode = new int[8];
        int resultCodeIndex = 7;

        int[] oneCode = new int[4];
        int oneCodeIndex = 3;

        int len = str.length();
        for (int i = len - 1; i >= 0; i--) {
            char ch = str.charAt(i);

            // 처음 1이 나오면 시작.
            if (!start && ch == '1') {
                start = true;
            }

            if (start && ch == '1') {
                oneCount++;
                if (zeroCount != 0) {
                    oneCode[oneCodeIndex] = zeroCount;
                    oneCodeIndex--;
                }
                zeroCount = 0;
            } else if (start && ch == '0') {
                zeroCount++;
                if (oneCount != 0) {
                    oneCode[oneCodeIndex] = oneCount;
                    oneCodeIndex--;
                }
                oneCount = 0;
            }

            if (resultCodeIndex == 0 && oneCodeIndex == 0) {
                resultCode[resultCodeIndex] = findNum(oneCode, ratio);

                int lastNum = resultCode[resultCodeIndex];
                int number = numberArr[lastNum][0];
                // 하나의 비율을 알게되면, 여기서 비율 * 56으로 끊어서 i값을 증가시켜 바로 지나치도록 했음.
                i -= (number * ratio);

                // 중복제거를 위해서 list를 사용했음, 일반 배열을 set에 넣으면 Hashcode가 달라서, 중복값이 들어가게됨
                List<Integer> tempList = new ArrayList<>();
                for (int j = 0; j < 8; j++) {
                    tempList.add(resultCode[j]);
                }

                finalCodeSet.add(tempList);

                // 전체 코드하나가 완성되면 변수 초기화 진행해서 앞에 새로운 암호가 있는지 탐색.
                zeroCount = 0;
                oneCount = 0;
                ratio = 11;

                oneCodeIndex = 3;
                resultCodeIndex = 7;
                start = false;
                continue;
            }

            if (oneCodeIndex == -1) {
                if (ratio == 11) {
                    for (int j = 0; j < 4; j++) {
                        // 비율에는 항상 1이 들어가 있기 때문에 가장 작은 값이 1이됨.
                        // 가장 작은 값이 비율이 됨.
                        ratio = Math.min(ratio, oneCode[j]);
                    }
                }

                // 코드 한칸 완성시 초기화.
                resultCode[resultCodeIndex] = findNum(oneCode, ratio);
                oneCodeIndex = 3;
                resultCodeIndex--;
            }
        }


    } // End of search

    private static int findNum(int[] oneCode, int ratio) {
        for (int i = 0; i < 10; i++) {
            int count = 0;
            for (int j = 3; j >= 0; j--) {
                int num = numberArr[i][j] * ratio;

                if (num == oneCode[j]) {
                    count++;
                    if (count == 3) {
                        return i;
                    }
                } else {
                    break;
                }
            }

        }

        return -1;
    } // End of findNum

    private static int calc(List<Integer> resultCode) {
        int sum = 0;
        int even = 0;
        int odd = 0;
        for (int i = 0; i < 8; i++) {
            int num = resultCode.get(i);
            sum += num;

            if (i % 2 == 0) {
                even += num;
            } else {
                odd += num;
            }
        }

        if (((even * 3) + odd) % 10 == 0) {
            return sum;
        }

        return 0;
    } // End of calc

    private static String changeBinary(String hex) {
        StringBuilder binary = new StringBuilder();
        for (int i = 0; i < M; i++) {
            char ch = hex.charAt(i);
            binary.append(hexArr[Character.getNumericValue(ch)]);
        }

        return binary.toString();
    } // End of changeBinary

    private static void init() {
        barCode = new char[N][M];
        codeSet = new HashSet<>();
        finalCodeSet = new HashSet<>();
        result = 0;
    } // End of init
} // End of Main class