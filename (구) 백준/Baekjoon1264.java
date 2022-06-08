import java.util.Scanner;

public class Baekjoon1264 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //문자열 입력
        for(;;) {
            String str = sc.nextLine();
            int count = 0;
            if(str.equals("#")) {
                break;
            }

            str = str.toLowerCase();

            for(int i=0; i<str.length(); i++) {
               switch(str.charAt(i)) {
                     case 'a':
                     case 'e':
                     case 'i':
                     case 'o':   
                     case 'u':
                        count++;
                    default: 
                        break;
               }
            }
            
            System.out.println(count);
        }

    }
}
