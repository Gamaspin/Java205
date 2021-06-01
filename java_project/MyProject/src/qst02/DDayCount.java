package qst02;
import java.util.Calendar;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class DDayCount {
	//생일을 기준으로 오늘가지 몇 일을 살았는지 출력하는 프로그램 만들기.
	public static void main(String[] args) {

//		Calendar game_start_calendar = Calendar.getInstance();
//		game_start_calendar.set(2021, 1 - 1, 4, 0, 0, 0);
//
//		Calendar now_calendar = Calendar.getInstance();
//
//		System.out.println(game_start_calendar.getTime());
//		System.out.println(now_calendar.getTime());
//
//		System.out.println(now_calendar.getTimeInMillis() - game_start_calendar.getTimeInMillis());
//
//		long remainLong = now_calendar.getTimeInMillis() - game_start_calendar.getTimeInMillis();
//		long days = remainLong / (1000L * 60 * 60 * 24);
//		System.out.println(days + " 일이 지났습니다.");

		Scanner scanner = new Scanner(System.in);
		System.out.println("생일로부터 오늘까지 몇 일이 지났는지 계산합니다.");
		System.out.println("태어난 년도를 입력하세요");
		int year = scanner.nextInt();
		System.out.println("태어난 달을 입력하세요");
		int month = scanner.nextInt();
		System.out.println("태어난 날짜를 입력하세요");
		int date = scanner.nextInt();

		LocalDate birthDay = LocalDate.of(year, month, date);
		LocalDate now = LocalDate.now();
		
		long days = birthDay.until(now, ChronoUnit.DAYS);
		long weeks = birthDay.until(now, ChronoUnit.WEEKS);
		System.out.println("birth day : "+birthDay );
		System.out.println("today : "+now );
		System.out.println("days : "+days );
		System.out.println("weeks : "+weeks);
	}
}
