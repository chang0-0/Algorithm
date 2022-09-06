import java.util.*;
import java.io.*;

// for(char[] ch : barCode) System.out.println(Arrays.toString(ch));
public class Main_1242_암호코드_스캔 {
    static int N, M;
    static char[][] barCode;
    static HashSet<String> codeSet;
    static int groupNum;
    static int codeStartIndex;

    static final String[] hexArr = {"0000", "0001", "0010", "0011", "0100",
            "0101", "0110", "0111", "1000", "1001",
            "1010", "1011", "1100", "1101", "1110",
            "1111",
    };

    // 각 코드의 기본 두께 비율
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
            findGroup();

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


            // 16진수로 만들어진 코드 2진수로 변환하는 작업
            StringBuilder code;
            for (String str : codeSet) {
                code = new StringBuilder();
                int index;

                for (int i = 0; i < str.length(); i++) {
                    char ch = str.charAt(i);

                    if (ch == 'A') index = 10;
                    else if (ch == 'B') index = 11;
                    else if (ch == 'C') index = 12;
                    else if (ch == 'D') index = 13;
                    else if (ch == 'E') index = 14;
                    else if (ch == 'F') index = 15;

                    index = Character.getNumericValue(ch);
                    code.append(hexArr[index]);
                }
                //System.out.println(code);

                // 암호가 시작되는 부분 찾아야함
                // 비율이 맞는 부분 찾기
                for (int i = 0; i <= code.length() - (7 * groupNum); i++) {
                    String temp = code.substring(i, (7 * groupNum) + i);

                    int isZero = 0;
                    int isOne = 0;
                    List<Integer> list = new ArrayList<>();
                    for (int j = 0; j < 7 * groupNum; j++) {
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
                        //System.out.println(" temp : " + temp);

                        boolean rateCheck = true;
                        int count = 0;
                        for (int j = 0; j < numberArr.length; j++) {
                            //System.out.println("j:  " + j);
                            count = 0;

                            for (int k = 0; k < 4; k++) {
                                int num = numberArr[j][k];

                                if (num != list.get(k)) {
                                    //System.out.println("num : " + num + ", list.get : " + list.get(k));
                                    rateCheck = false;
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

                int[] answer = new int[8];
                String newCode = code.substring(codeStartIndex, codeStartIndex + (56 * groupNum));
                // System.out.println(newCode);

                List<Integer> list = new ArrayList<>();
                StringBuilder calcStr = new StringBuilder();
                for (int j = 0; j < newCode.length(); j++) {
                    if (j % (7 * groupNum) == 0) {
                        calc(calcStr.toString());
                        calcStr = new StringBuilder();
                    }

                    calcStr.append(newCode.charAt(j));
                }


            } // End of for(set)


        }

        bw.write(sb.toString());
        bw.close();
    } // End of main

    private static void calc(String str) {


    } // End of calc

    private static void findGroup() {
        if (N == 100) groupNum = 1;
        else if (N == 200) groupNum = 2;
        else if (N == 500) groupNum = 3;
        else if (N == 1000) groupNum = 4;
        else if (N == 2000) groupNum = 5;
    } // End of findGroup

    private static void init() {
        barCode = new char[N][M];
        codeSet = new HashSet<>();
        codeStartIndex = -1;
    } // End of init
} // End of Main class