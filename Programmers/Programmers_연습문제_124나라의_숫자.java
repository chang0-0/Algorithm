import java.util.Iterator;
import java.util.Stack;

    //https://programmers.co.kr/learn/courses/30/lessons/12899
public class Programmers_연습문제_124나라의_숫자  {

    public String solution(int n) {
        String answer = "";
        Stack<Integer> stack = new Stack<Integer>();
        int[] arr = {1, 2, 4};
        
        // 3의 배수경우
        // 나머지 없을 경우 그대로 출력 

        int rest = n % 3;
        
        // 3의 배수 일 경우 무조건 마지막자리 4가 오기 때문에 일단 4넣고 시작
        if(rest == 0) {
            stack.push(4);

            int value = n / 3;

            while(value >= 10) {
                int temp1 = (value / 3) - 1;

                if(temp1 >= 3) {
                    stack.push(4);
                }
                
            }

            


            System.out.println("value : " + value);
        }
        else {
            while(n >= 3) {
                rest = n % 3;
                n = n / 3;    
    
                System.out.println("n : " + n);
                System.out.println("rest : " + rest);
                stack.push(rest);
            }
            stack.push(n);
        }

        // 스택 출력
        Iterator iter = stack.iterator();
        while(iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
        
        return answer;
    }

    public static void main(String[] args) {
        Programmers_연습문제_124나라의_숫자 s = new Programmers_연습문제_124나라의_숫자();

        int value = 21;
        System.out.println(s.solution(value));
    }
}
