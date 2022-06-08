import java.util.ArrayList;
import java.util.Arrays;

public class Programmers_mock_exam {
    public int[] solution(int[] answers) {
        ArrayList<Integer> score = new ArrayList<>();

        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int person1 = 0, person2 = 0, person3 = 0;

        // 1. 찍은 번호 생성
        for(int i=0; i<answers.length; i++) {
            if(one[i%one.length] == answers[i]) {
                person1 ++;
            }
            if(two[i%two.length] == answers[i]) {
                person2 ++;
            }
            if(three[i%three.length] == answers[i]) {
                person3 ++;
            }
        }

        int max = (int) Math.max(Math.max(person1, person2), person3);

        if(max == person1) {
            score.add(1);
        }

        if(max == person3) {
            score.add(3);
        }

        if(max == person2) {
            score.add(2);
        }


        int result[] = new int[score.size()];

        score.sort(null);

        for(int i=0; i<result.length; i++) {
            result[i] = score.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        Programmers_mock_exam p = new Programmers_mock_exam();

        int value[] = {1,3,2,4,2};
        System.out.println(Arrays.toString(p.solution(value)));
    }
}
