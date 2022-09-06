import java.util.*;
import java.io.*;

public class Main_1240_단순_2진_암호코드 {
    static final int[][] numberArr = {{3, 2, 1, 1}, {2, 2, 2, 1}, {2, 1, 2, 2}, {1, 4, 1, 1},
            {1, 1, 3, 2}, {1, 2, 3, 1}, {1, 1, 1, 4}, {1, 3, 1, 2}, {1, 2, 1, 3}, {3, 1, 1, 2}};

    static int N, M;
    static int[][] barCode;
    static HashSet<String> codeSet;


    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/1240.txt"));
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
            init();

            boolean check = false;
            for (int i = 0; i < N; i++) {
                String temp = br.readLine();
                for (int j = 0; j < M; j++) {
                    barCode[i][j] = temp.charAt(j);

                    if (!check & barCode[i][j] != '0') {
                        codeSet.add(temp);
                        check = true;
                    }
                }
            }

            String resultCode = "";
            for (String str : codeSet) {
                int codeStartIndex = findStartPoint(str); // 암호가 시작하는 곳 찾아서 인덱스값을 반환
                resultCode = str.substring(codeStartIndex, codeStartIndex + 56);
            }

            // System.out.println("resultCode :" + resultCode);
            // 7개씩 분리해서 계산.

            sb.append(calc(resultCode)).append('\n');
        } // End of for(T)


        bw.write(sb.toString());
        bw.close();
    } // End of main


    // 잘못된 코드일 경우 0을 출력
    private static int calc(String code) {
        int[] ans = new int[8];

        System.out.println("code : " + code);
        System.out.println(code.length());
//
//        String test = "01001101000110110001000110101000110100011000110100010110";
//        System.out.println(test.length());


        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            String temp = code.substring(i * 7, (i * 7) + 7);

            int isZero = 0;
            int isOne = 0;
            for (int j = 0; j < 7; j++) {
                char ch = temp.charAt(j);

                if (ch == '0') {
                    if (isOne > 0) {
                        list.add(isOne);
                    }
                    isZero++;
                    isOne = 0;
                } else {
                    if (isZero > 0) {
                        list.add(isZero);
                    }
                    isOne++;
                    isZero = 0;
                }
            }

            // 마지막 하나 삽입
            if (isZero > 0) {
                list.add(isZero);
            } else {
                list.add(isOne);
            }

            System.out.println(list);

            for (int j = 0; j < 10; j++) {
                int count = 0;
                for (int k = 0; k < 4; k++) {
                    int num = numberArr[j][k];

                    if (num != list.get(k)) {
                        break;
                    } else {
                        count++;
                    }
                }

                if (count == 4) {
                    ans[i] = j;
                    break;
                }
            }

            list.clear();
        }

        System.out.println(Arrays.toString(ans));

        // 마지막 전체 계산.
        int odd = 0;
        int even = 0;
        int result = 0;
        int sum = 0;
        for (int i = 0; i < 8; i++) {
            if (i % 2 == 1) {
                odd += ans[i];
            } else {
                even += ans[i];
            }

            sum += ans[i];
        }
        result = (even * 3) + odd;


        //System.out.println(result);
        if (result % 10 == 0) {
            return sum;
        } else {
            return 0;
        }
    } // End of calc

    private static int findStartPoint(String code) { // 시작점을 찾는 메소드
        int codeStartIndex = -1;
        // System.out.println(code);

        for (int i = 0; i <= code.length() - 7; i++) {
            String temp = code.substring(i, i + 7);
            // System.out.println("temp : " + temp);

            int isZero = 0;
            int isOne = 0;
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < 7; j++) {
                char ch = temp.charAt(j);

                if (ch == '0') {
                    if (isOne > 0) {
                        list.add(isOne);
                    }
                    isZero++;
                    isOne = 0;
                } else {
                    if (isZero > 0) {
                        list.add(isZero);
                    }
                    isOne++;
                    isZero = 0;
                }

                // 리스트 사이즈가 5를 넘으면 할 필요없음
                if (list.size() >= 5) {
                    break;
                }
            }

            // 마지막 하나 삽입
            if (isZero > 0) {
                list.add(isZero);
            } else {
                list.add(isOne);
            }

            if (list.size() == 4) {

                int count = 0;
                for (int j = 0; j < numberArr.length; j++) {
                    // System.out.println("j:  " + j);
                    count = 0;

                    for (int k = 0; k < 4; k++) {
                        int num = numberArr[j][k];

                        if (num != list.get(k)) {
                            // System.out.println("num : " + num + ", list.get : " + list.get(k));
                            break;
                        } else {
                            count++;
                        }
                    }

                    // 비율이 4개 모두 일치할 경우 중지
                    if (count == 4) {
                        codeStartIndex = i; // 시작하는 곳 인덱스
                        break;
                    }
                }
            }

            if (codeStartIndex != -1) {
                break;
            }
        }

        return codeStartIndex;
    } // End of findStartPoint

    private static void init() {
        barCode = new int[N][M];
        codeSet = new HashSet<>();
    } // End of init
} // End of Main class
