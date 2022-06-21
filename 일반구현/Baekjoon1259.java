import java.util.Scanner;

public class Baekjoon1259 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        for(;;) {
            String num = sc.next();
            if(num.equals("0")) {
                System.exit(0);
            }

            String[] arr1 = new String[num.length()];
            String[] arr2 = new String[num.length()];

            for(int i=0; i<num.length(); i++) {
                arr1[i] = num.substring(i, i+1);
            }

            for(int i=0; i<num.length(); i++) {
                arr2[i] = arr1[num.length()-1-i];
            }

            int count=0;

            for(int i=0; i<num.length(); i++) {
               if(arr1[i].equals(arr2[i])) {
                   count++;
               }
            }

            if(count == num.length()) {
                System.out.println("yes");
            } 
            else {
                System.out.println("no");
            }
        }
    }
}
