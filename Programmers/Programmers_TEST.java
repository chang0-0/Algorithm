import java.util.HashMap;

public class Programmers_TEST {
    public boolean solution(String[] phone_book) {
        HashMap<String, Integer> map = new HashMap<>();

        for(int i=0; i<phone_book.length; i++) {
            map.put(phone_book[i], 1);
        }


        for(int i=0; i<phone_book.length; i++) {
            for(int j=0; j<phone_book[i].length(); j++) {
                if(map.containsKey(phone_book[i].substring(0, j))) {
                    return false;
                }
            }
        }

        return true;
    }
    
    public static void main(String[] args) {
        Programmers_TEST p = new Programmers_TEST();

        String[] phone_book = {"119", "97674223", "1195524421"};

        System.out.println(p.solution(phone_book));
        
    }
}
