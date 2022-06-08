import java.util.Scanner;

public class Baekjoon2845 {

	public static void main(String[] args) {

		Scanner stdIn = new Scanner(System.in);

		int people = stdIn.nextInt();
		int place = stdIn.nextInt();

		int SumPeople = people * place;

		int alticle1 = stdIn.nextInt();
		int alticle2 = stdIn.nextInt();
		int alticle3 = stdIn.nextInt();
		int alticle4 = stdIn.nextInt();
		int alticle5 = stdIn.nextInt();

		System.out.println((alticle1 - SumPeople) + " " + (alticle2 - SumPeople) + " " + (alticle3 - SumPeople) + " "
				+ (alticle4 - SumPeople) + " " + (alticle5 - SumPeople));
	}
}
