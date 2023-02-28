import java.io.*;

/*
    2023년은 검은 토끼의 해로 불린다. 스타는 검은 토끼의 해를 기념해서 흑묘 복권을 만들려고한다.
    복권은 N개의 티켓으로 구성된다. 1 ~ N 이하의 정수인 시리얼 번호가 적혀 있으며 서로 다른 티켓에는 서로 다른 시리얼 번호가 적혀있다.

    티켓 중에서 시리얼 번호가 4자리수 이상이고 서로 다른 자리에서 네 개의 자리수를 골라 자릿수를 골라 고른 자릿수를 제외한 나머지 자릿수를 지울 때 2023을 만들 수 있으면 해당 티켓은 당첨 티켓이다.
    예를 들어 시리얼 번호가

    2023이 순서에 맞게 (위치는 상관없음)
 */

public class Main_27494_2023년은_검은_토끼의_해 {
    static char checkArr[] = {'2', '0', '2', '3'};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/27494.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int result = 0;

        for (int i = 2023; i <= N; i++) {
            String yearToStr = Integer.toString(i);

            if (check(yearToStr)) {
                result++;
            }
        }

        sb.append(result);

        bw.write(sb.toString());
        bw.close();
    } // End of main

    private static boolean check(String str) {
        int length = str.length();
        int index = 0;

        for (int i = 0; i < length; i++) {
            char temp = str.charAt(i);

            if (temp == checkArr[index]) {
                index++;

                if(index == 4) return true;
            }
        }
        return false;
    } // End of check
} // End of Main class
