import java.util.HashSet;
import java.util.Iterator;

public class Programmers_prime_number_find {
    HashSet<Integer> numberSet = new HashSet<>();

    public boolean isPrime(int num) {
        if(num == 1 || num == 0) {
            // 1과 0은 소수에서 제외되니 false처리
            return false;
        }

        //⭐⭐ 소수를 찾을때는 아리스토테네스의 체의 limit을 계산한다.
        // 소수인지 확인하려고 하는 값의 제곱근을 구한다. => Math.sqrt(number)
        int limit = (int) Math.sqrt(num);

        // 에라토스테네스의 체에 따라 limit까지만 배수 여부를 확인한다.
        for(int i=2; i<=limit; i++) {
            if(num % i == 0) {
                return false;
            }
        }

        return true;
    }

        // 입력 받은 숫자를 나올 수 있는 최대의 조합을 구해서 HashSet으로 만들어 반환한다.
        public void recursive(String comb, String others) {
            // 1. 현재 조합을 set에 추가한다.
            if(!comb.equals("")) {
                numberSet.add(Integer.parseInt(comb));
            }
    
            // 2. 남은 숫자 중 한개를 더해 새로운 조합을 만든다.
            for(int i=0; i<others.length(); i++) {
                if(!comb.equals("")) {
                    // HashSet의 타입은 Object형 이기때문에 Integer.valueOf로 Integer형으로 만들어준다.
                    numberSet.add(Integer.valueOf(comb));
                }
    
                recursive(comb + others.charAt(i), others.substring(0, i) + others.substring(i+1));
            }
        }

    public int solution(String numbers) {
        int count = 0;
        
        // 1. 만들수 있는 모든 조합의 숫자를 만든다.
        recursive("", numbers);

        // 2. 소수의 개수만 센다.
        // HashSet의 모든 요소를 검사하기위해 Iterator를 사용한다. 
        // loop같은 반복문을 이용해서 사용해도 상관은 없다.
        Iterator<Integer> it = numberSet.iterator();

        while(it.hasNext()) {
            int number = it.next();

            if(isPrime(number)) {
                count ++;
            }
        }

        
        // 3. 소수의 개수를 반환한다.
        return count;
    }
    public static void main(String[] args) {
        Programmers_prime_number_find p = new Programmers_prime_number_find();

        System.out.println(p.solution("17"));
    }
}