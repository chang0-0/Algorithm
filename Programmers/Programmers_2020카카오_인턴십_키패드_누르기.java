public class Programmers_2020카카오_인턴십_키패드_누르기 {
    //https://programmers.co.kr/learn/courses/30/lessons/67256?language=java

    public String solution(int[] numbers, String hand) {
        String answer = "";
        // 처음 왼손과 오른손의 위치
        int left = 10; 
        int right = 12;

        // hand 매개변수 -> 왼손잡이 오른손잡이 설정하기
        if(hand == "right") {
            hand = "R";
        }
        else {
            hand = "L";
        }

        for(int i=0; i<numbers.length; i++) {

            // 다음번호가 1 4 6인 경우 왼손선택
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                answer += 'L';
                left = numbers[i];
            }

            // 다음번호가 3 6 9인 경우 오른손 선택
            else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                answer += 'R';
                right = numbers[i];
            }
            // 다음 번호가 2 5 8 0 일 경우 거리에 따라 손의 위치 출력
            else {
                if(numbers[i]==0) {
                    numbers[i] = 11;
                }

                int left_start = Calc(numbers[i], left);
                int right_start = Calc(numbers[i], right);

                System.out.println(left_start);
                System.out.println(right_start);

                
                if(left_start == right_start) {
                    if(hand == "R") {
                        right = numbers[i];
                        answer += "R";
                    }
                    else {
                        left = numbers[i];
                        answer += "L";
                    }
                }
                else if(left_start > right_start) {
                    answer += "R";
                    right = numbers[i];
                }
                else {
                    answer += "L";
                    left = numbers[i];
                }
            }
        }

        return answer;
    }

    private int Calc(int arrive, int hand) {
        int dist = Math.abs(arrive - hand)/3 + Math.abs(arrive - hand)%3;

        return dist;
    }

    public static void main(String[] args) {
        Programmers_2020카카오_인턴십_키패드_누르기 s = new Programmers_2020카카오_인턴십_키패드_누르기();

        int numbers[] = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";

        System.out.println(s.solution(numbers, hand));
    }
}



