import java.util.*;
import java.io.*;

public class Main_5644_무선_충전 {
    static int M, A, result;

    static int[] userA; // 시간 별 유저의 방향 값을 저장할 배열
    static int[] userB;
    static int[] dirX = {0, -1, 0, 1, 0}; // 상 우 하 좌
    static int[] dirY = {0, 0, 1, 0, -1};

    static AP userACoor; // 해당 유저의 현재 위치값
    static AP userBCoor;
    static AP[] apArr; // AP의 데이터가 저장된 배열

    // AP 데이터 객체
    static class AP {
        int num;
        int x;
        int y;
        int chargeRange;
        int performance;

        public AP(int num, int x, int y, int chargeRange, int performance) {
            this.num = num;
            this.x = x;
            this.y = y;
            this.chargeRange = chargeRange;
            this.performance = performance;
        }

        public AP(int x, int y) {
            this.x = x;
            this.y = y;
        }
    } // End of AP class


    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/5644.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append('#').append(t).append(' ');

            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 총 이동 시간
            A = Integer.parseInt(st.nextToken()); // AP의 수
            init(); // 변수 초기화 메소드


            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                userA[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                userB[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < A; i++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                int C = Integer.parseInt(st.nextToken());
                int P = Integer.parseInt(st.nextToken());
                apArr[i] = new AP(i, x, y, C, P);
            }


            // 시간 별 Max값을 구하기.
            for (int i = 0; i <= M; i++) {
                List<AP> AtempList = new ArrayList<>();
                List<AP> BtempList = new ArrayList<>();
                for (AP ap : apArr) {
                    // Auser가 충전범위 안에 들어와있을 경우,
                    if (distCalc(userACoor.x, userACoor.y, ap.x, ap.y) <= ap.chargeRange) {
                        AtempList.add(ap);
                    }

                    // BUser가 충전범위에 들어온 경우,
                    if (distCalc(userBCoor.x, userBCoor.y, ap.x, ap.y) <= ap.chargeRange) {
                        BtempList.add(ap);
                    }
                }

                int AtempListSize = AtempList.size();
                int BtempListSize = BtempList.size();
                int maxValueByHour = 0;
                if (AtempListSize > 0 && BtempListSize == 0) {
                    for (AP ap : AtempList) {
                        maxValueByHour = Math.max(maxValueByHour, ap.performance);
                    }

                } else if (AtempListSize == 0 && BtempListSize > 0) {
                    for (AP ap : BtempList) {
                        maxValueByHour = Math.max(maxValueByHour, ap.performance);
                    }

                } else if (AtempListSize > 0) {
                    // 서로 겹쳤을 경우, (가장 괜찮은 조합을 선택)
                    for (int j = 0; j < AtempListSize; j++) {
                        int aUserAP_Num = AtempList.get(j).num;
                        int aUserAP_Performance = AtempList.get(j).performance;

                        for (int k = 0; k < BtempListSize; k++) {
                            int bUserAP_Num = BtempList.get(k).num;
                            int bUserAP_Performance = BtempList.get(k).performance;

                            // 번호가 같을 경우 충전량이 절반으로 줄어듬
                            if (aUserAP_Num == bUserAP_Num) {
                                maxValueByHour = Math.max(maxValueByHour, (aUserAP_Performance / 2) * 2);
                            } else {
                                maxValueByHour = Math.max(maxValueByHour, aUserAP_Performance + bUserAP_Performance);
                            }
                        }
                    }
                }

                result += maxValueByHour;
                if (i == M) {
                    break;
                }

                // 시간별 user의 좌표값 갱신
                userACoor.x = dirX[userA[i]] + userACoor.x;
                userACoor.y = dirY[userA[i]] + userACoor.y;

                userBCoor.x = dirX[userB[i]] + userBCoor.x;
                userBCoor.y = dirY[userB[i]] + userBCoor.y;
            }

            sb.append(result).append('\n');
        }

        bw.write(sb.toString());
        bw.close();
    } // End of main

    private static int distCalc(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    } // End of distCalc

    private static void init() {
        result = 0;
        userA = new int[M];
        userB = new int[M];
        userACoor = new AP(1, 1); // userA의 시작점
        userBCoor = new AP(10, 10); // userB의 시작점
        apArr = new AP[A];
    } // End of init
} // End of Main class
