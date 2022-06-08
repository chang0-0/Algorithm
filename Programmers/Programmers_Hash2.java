import java.util.Arrays;

public class Programmers_Hash2 {

    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book);

        for(int i=0; i<phone_book.length - 1; i++) {
            if(phone_book[i+1].startsWith(phone_book[i])) {
                return answer = false;
            }
            
        }

        return answer;
    }

    public static void main(String[] args) {
        Programmers_Hash2 p = new Programmers_Hash2();
        String ph[] = {"119", "97674223", "1195524421"};

        System.out.println(p.solution(ph));
    }
}
