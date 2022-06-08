import java.util.ArrayList;

class Programmers_프린터2 {
    // Class 사용X
    public int solution(int[] priorities, int location) {
        // 1. Queue 만들기
        ArrayList<Integer> printer = new ArrayList<>();
        for(int p : priorities) {
            printer.add(p);
        }

        int turn = 0;
        // 2. 0번을 꺼내서 max priority가 아니면 다시 끝에 넣는다.
        while(!printer.isEmpty()) {
            Integer priority = printer.remove(0);

            // printer에서 [anyMatch의 의미=> 다른 하나라도] priority보다 큰 값이 있다면 
            // priority를 printer에 추가해라. 
            if(printer.stream().anyMatch(otherPriority -> priority < otherPriority)) {
                printer.add(priority);
            }
            else {
                // if조건 false의 경우 즉, printer에서 priority보다 큰 값이 없을 경우
                // ( 현재 선택된 priority가 가장 큰 값임을 의미)
                // 3. max priority이면 내가 찾는 job이 맞는지 확인한다.
                turn++;
                if(location == 0) {
                    break;
                }
            }
            
            // 반복해서 확인할 때 마다 위치(location)를 하나씩 줄임
            location--;
            if(location < 0) {
                location = printer.size() - 1;
            }
        }
        return turn;
    }

    public static void main(String[] args) {
        Programmers_프린터2 s = new Programmers_프린터2();
        int p[] = {1, 1, 9, 1, 1, 1};
        int lo = 0;


        System.out.println(s.solution(p, lo));
    }
}