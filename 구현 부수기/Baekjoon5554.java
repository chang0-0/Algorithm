import java.util.Scanner;

public class Baekjoon5554 {
	public static void main(String[] args) {

		Scanner stdIn = new Scanner(System.in);
		int firstSec = stdIn.nextInt();

		int SecondSec = stdIn.nextInt();

		int ThirdSec = stdIn.nextInt();

		int FourthSec = stdIn.nextInt();

		int sum = (firstSec + SecondSec + ThirdSec + FourthSec);
		int resultMin = sum / 60;
		int resultSec = sum - (resultMin * 60);

		System.out.println(resultMin);
		System.out.println(resultSec);

	}
}
