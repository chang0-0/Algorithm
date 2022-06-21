import java.util.Scanner;

public class Baekjoon1120 {
    public static void main(String[] args) throws Exception{
      Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();
        int max_same = 0;

        // 띄어쓰기를 기준으로 출력됨
        // 모두 다를 때의 최대값은 문자열 A의 길이 값이기 때문에 여기서 값을 변화시켜주면됨
        //A의 문자열길이와 B의 문자열 길이를 뺀값에 + 1

        for(int i=0; i < B.length() - A.length() + 1; i++) {
            String temp_B = B.substring(i, i+A.length());

            int same = 0;
                 for(int j=0; j<temp_B.length(); j++) {
                    if(A.charAt(j) == temp_B.charAt(j)) {
                        same++;
                    }
                 }

            }
    }
}
