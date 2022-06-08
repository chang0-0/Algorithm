import java.io.IOException;
import java.util.Scanner;

public class Baekjoon20540 {
    public static void main(String[] args) throws IOException {
        Scanner stdIn = new Scanner(System.in);
        String MBTI = stdIn.next();
        String arr[] = new String[4];
        arr = MBTI.split("");

        if (arr[0].equals("E")) {
            System.out.print("I");
        } else if (arr[0].equals("I")) {
            System.out.print("E");
        }

        if (arr[1].equals("S")) {
            System.out.print("N");
        } else if (arr[1].equals("N")) {
            System.out.print("S");
        }

        if (arr[2].equals("T")) {
            System.out.print("F");
        } else if (arr[2].equals("F")) {
            System.out.print("T");
        }

        if (arr[3].equals("J")) {
            System.out.print("P");
        } else if (arr[3].equals("P")) {
            System.out.print("J");
        }

    }
}