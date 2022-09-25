import java.util.*;

public class Main_1 {
    static int[] expireArr;
    static List<Expire> expireList;

    static class Expire {
        String type;
        int month;

        public Expire(String type, int month) {
            this.type = type;
            this.month = month;
        }
    } // End of Expire

    public static void main(String[] args) throws Exception {
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3" };
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C" };

        Main_1 s = new Main_1();
        System.out.println(Arrays.toString(s.solution(today, terms, privacies)));
    } // End of main

    public int[] solution(String today, String[] terms, String[] privacies) {
        // 모든 달은 28일 까지 있다고 가정
        // 오늘 날짜로 파기해야할 개인정보 번호를 구하려고한다.

        init();
        // 한달은 28일 1년은 336일

        // A의 기한. B의 기한 C의 기한
        // YYYY는 2000이 시작 이므로 2000/1/1 -> 1일
        // 오늘을 일 수로 가져오기
        StringTokenizer st = new StringTokenizer(today, ".");
        int todayInt = calc(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        // 오늘의 일 수를 기준으로 A, B, C의 파기 날짜 계산하기
        expireCalcByToday(todayInt, terms);

        List<Integer> ans = new ArrayList<>();
        int len = privacies.length;
        for (int i = 0; i < len; i++) {
            st = new StringTokenizer(privacies[i]);
            String day = st.nextToken();
            String type = st.nextToken();


            st = new StringTokenizer(day, ".");
            int tempDay = calc(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())); // 일 수로 변경
            // System.out.println(day + ", " + type + ", " + tempDay);

            // 오늘 날짜를 기준으로 계산된 타입별 만기날짜를 계산해서 비교
            for (Expire ex : expireList) {
                if (ex.type.equals(type)) {
                    if (tempDay + ex.month <= todayInt) {
                        ans.add(i + 1);
                    }
                }
            }
        }


        int[] answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }

        return answer;
    } // End of solution

    private static int calc(int y, int m, int d) {
        int sum = (y * (28 * 12)) + (m * 28) + d;
        return sum;
    }

    private static void expireCalcByToday(int todayInt, String[] terms) {
        for (int i = 0; i < terms.length; i++) {
            String temp = terms[i];
            StringTokenizer st = new StringTokenizer(temp);

            String type = st.nextToken();
            int month = Integer.parseInt(st.nextToken());
            expireList.add(new Expire(type, (month * 28)));
        }
    }  // End of expireCalcByToday

    private static void init() {
        expireArr = new int[3];
        expireList = new ArrayList<>();
    } // End of init
} // End of Main class
