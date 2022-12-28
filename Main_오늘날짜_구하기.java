
import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;

// 현재달의 날 수를 구한다.
public class Main_오늘날짜_구하기 {

	public static void main(String[] args) {

		// 포멧
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		Date now = new Date();

		String nowTime = sdf1.format(now);
		int[] monthArr = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		int year = now.getYear() + 1900;
		int month = now.getMonth() + 1;

		int lastDay = 31;
		if (month == 2) {
			if (year % 4 == 0 && year % 100 != 0 || year % 4 == 0 && year % 400 == 0) {
				lastDay = 29;
			} else {
				lastDay = 28;
			}
		} else if (month == 4 || month == 6 || month == 9 || month == 11) {
			lastDay = 30;
		}

		System.out.println(year + "-" + month + "-" + lastDay);
	} // End of main
}
