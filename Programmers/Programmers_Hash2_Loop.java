import java.util.Arrays;

public class Programmers_Hash2_Loop {
    public boolean solution(String[] phone_book) {
        // 1. phone_book을 정렬한다.
        Arrays.sort(phone_book);

        // 2. 1중 loop를 돌면서 앞번호가 뒷번호의 접두사 인지 확인한다.
        for(int i=0; i<phone_book.length - 1; i++) {
            if(phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        Programmers_Hash2 p = new Programmers_Hash2();
        String ph[] = {"119", "97674223", "1195524421"};

        System.out.println(p.solution(ph));
    }
}
