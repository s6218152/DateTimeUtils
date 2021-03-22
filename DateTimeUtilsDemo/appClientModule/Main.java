import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws ParseException {
		DateTimeUtils DateTimeUtils = new DateTimeUtils();
		Scanner scanner = new Scanner(System.in);
		String ouputString;
		Integer ouputInteger;
		Date ouputDate;
		Calendar ouputCalendar;
		Timestamp ouputTimestamp;
		Boolean ouputboolean;
		while (true) {
			System.out.println("\n請輸入方法：");
			switch (scanner.next()) {
			case "yyyMMddToDate":// 1
				System.out.println("請輸入日期：(ex:1100208)");
				ouputDate = DateTimeUtils.yyyMMddToDate(scanner.next());
				System.out.println("yyyMMdd轉Date：" + ouputDate + "\t類別：" + ouputDate.getClass());
				break;
			case "yyyyMMddToDate":// 2
				System.out.println("請輸入日期：(ex:20210208)");
				ouputDate = DateTimeUtils.yyyyMMddToDate(scanner.next());
				System.out.println("yyyyMMdd轉Date：" + ouputDate + "\t類別：" + ouputDate.getClass());
				break;
			case "yyySlashMMSlashddToDate":// 3
				System.out.println("請輸入日期：(ex:110/02/08)");
				ouputDate = DateTimeUtils.yyySlashMMSlashddToDate(scanner.next());
				System.out.println("yyy/MM/dd轉Date：" + ouputDate + "\t類別：" + ouputDate.getClass());
				break;
			case "yyyySlashMMSlashddToDate":// 4
				System.out.println("請輸入日期：(ex:2021/02/08)");
				ouputDate = DateTimeUtils.yyyySlashMMSlashddToDate(scanner.next());
				System.out.println("yyyy/MM/dd轉Date：" + ouputDate + "\t類別：" + ouputDate.getClass());
				break;
			case "yyyyDashMMDashddToDate":// 5
				System.out.println("請輸入日期：(ex:2021-02-08)");
				ouputDate = DateTimeUtils.yyyyDashMMDashddToDate(scanner.next());
				System.out.println("yyyy-MM-dd轉Date：" + ouputDate + "\t類別：" + ouputDate.getClass());
				break;
			case "ddMMyyyyToDate":// 6
				System.out.println("請輸入日期：(ex:08022021)");
				ouputDate = DateTimeUtils.ddMMyyyyToDate(scanner.next());
				System.out.println("ddMMyyyy轉Date：" + ouputDate + "\t類別：" + ouputDate.getClass());
				break;
			case "yyyMMddtoyyyyMMdd":// 7
				System.out.println("請輸入日期：(ex:1100208)");
				ouputString = DateTimeUtils.yyyMMddtoyyyyMMdd(scanner.next());
				System.out.println("yyyMMdd轉yyyyMMdd：" + ouputString + "\t類別：" + ouputString.getClass());
				break;
			case "yyyMMddToddMMyyyy":// 8
				System.out.println("請輸入日期：(ex:1100208)");
				ouputString = DateTimeUtils.yyyMMddToddMMyyyy(scanner.next());
				System.out.println("yyyMMdd轉ddMMyyyy：" + ouputString + "\t類別：" + ouputString.getClass());
				break;
			case "yyyMMddSlashToddMMyyyy":// 9
				System.out.println("請輸入日期：(ex:110/02/08)");
				ouputString = DateTimeUtils.yyyMMddSlashToddMMyyyy(scanner.next());
				System.out.println("yyy/MM/dd轉ddMMyyyy：" + ouputString + "\t類別：" + ouputString.getClass());
				break;
			case "yyyyMMddtoyyyMMdd":// 10
				System.out.println("請輸入日期：(ex:2021/02/08)");
				ouputString = DateTimeUtils.yyyyMMddtoyyyMMdd(scanner.next());
				System.out.println("yyyy/MM/dd轉yyy/MM/dd：" + ouputString + "\t\t類別：" + ouputString.getClass());
				break;
			case "yyyyMMddtoyyyMMdd1":// 11
				System.out.println("請輸入日期：(ex:20210208)");
				ouputString = DateTimeUtils.yyyyMMddtoyyyMMdd1(scanner.next());
				System.out.println("yyyy/MM/dd轉yyy/MM/dd：" + ouputString + "\t\t類別：" + ouputString.getClass());
				break;
			case "ddMMyyyyToyyyMMdd":// 12
				System.out.println("請輸入日期：(ex:08022021)");
				ouputString = DateTimeUtils.ddMMyyyyToyyyMMdd(scanner.next());
				System.out.println("ddMMyyyy轉yyyMMdd：" + ouputString + "\t類別：" + ouputString.getClass());
				break;
			case "ddMMyyyyToyyyMMddSlash":// 13
				System.out.println("請輸入日期：(ex:08022021)");
				ouputString = DateTimeUtils.ddMMyyyyToyyyMMddSlash(scanner.next());
				System.out.println("ddMMyyyy轉yyy/MM/dd：" + ouputString + "\t類別：" + ouputString.getClass());
				break;
			case "DateToyyyMMdd":// 14
				System.out.println("請輸入日期：(ex:2021/02/08)");
				ouputDate = DateTimeUtils.yyyySlashMMSlashddToDate(scanner.next());
				System.out.println("Stinrg轉Date：" + ouputDate + "\t類別：" + ouputDate.getClass());
				ouputString = DateTimeUtils.DateToyyyMMdd(ouputDate);
				System.out.println("Date轉yyyMMdd：" + ouputString + "\t類別：" + ouputString.getClass());
				break;
			case "DateToyyyyMMdd":// 15
				System.out.println("請輸入日期：(ex:2021/02/08)");
				ouputDate = DateTimeUtils.yyyySlashMMSlashddToDate(scanner.next());
				System.out.println("Stinrg轉Date：" + ouputDate + "\t類別：" + ouputDate.getClass());
				ouputString = DateTimeUtils.DateToyyyyMMdd(ouputDate);
				System.out.println("Date轉yyyyMMdd：" + ouputString + "\t\t類別：" + ouputString.getClass());
				break;
			case "DateToyyySlashMMSlashdd":// 16
				System.out.println("請輸入日期：(ex:2021/02/08)");
				ouputDate = DateTimeUtils.yyyySlashMMSlashddToDate(scanner.next());
				System.out.println("Stinrg轉Date：" + ouputDate + "\t類別：" + ouputDate.getClass());
				ouputString = DateTimeUtils.DateToyyySlashMMSlashdd(ouputDate);
				System.out.println("Date轉yyy/MM/dd：" + ouputString + "\t類別：" + ouputString.getClass());
				break;
			case "DateToyyyySlashMMSlashdd":// 17
				System.out.println("請輸入日期：(ex:2021/02/08)");
				ouputDate = DateTimeUtils.yyyySlashMMSlashddToDate(scanner.next());
				System.out.println("Stinrg轉Date：" + ouputDate + "\t類別：" + ouputDate.getClass());
				ouputString = DateTimeUtils.DateToyyyySlashMMSlashdd(ouputDate);
				System.out.println("Date轉yyyy/MM/dd：" + ouputString + "\t類別：" + ouputString.getClass());
				break;
			case "DateToyyyyDashMMDashdd":// 18
				System.out.println("請輸入日期：(ex:2021/02/08)");
				ouputDate = DateTimeUtils.yyyySlashMMSlashddToDate(scanner.next());
				System.out.println("Stinrg轉Date：" + ouputDate + "\t類別：" + ouputDate.getClass());
				ouputString = DateTimeUtils.DateToyyyyDashMMDashdd(ouputDate);
				System.out.println("Date轉yyyy-MM-dd：" + ouputString + "\t類別：" + ouputString.getClass());
				break;
			case "DateToYYYMMDDHHMMSS":// 19
				System.out.println("請輸入日期：(ex:2021/02/08)");
				ouputDate = DateTimeUtils.yyyySlashMMSlashddToDate(scanner.next());
				System.out.println("Stinrg轉Date：" + ouputDate + "\t類別：" + ouputDate.getClass());
				ouputString = DateTimeUtils.DateToYYYMMDDHHMMSS(ouputDate);
				System.out.println("Date轉YYY/MM/DD HH:MM:SS：" + ouputString + "\t類別：" + ouputString.getClass());
				break;
			case "dateToddMMyyyy":// 20
				System.out.println("請輸入日期：(ex:2021/02/08)");
				ouputDate = DateTimeUtils.yyyySlashMMSlashddToDate(scanner.next());
				System.out.println("Stinrg轉Date：" + ouputDate + "\t類別：" + ouputDate.getClass());
				ouputString = DateTimeUtils.dateToddMMyyyy(ouputDate);
				System.out.println("Date轉ddMMyyyy：" + ouputString + "\t\t類別：" + ouputString.getClass());
				break;
			case "getDefaultYYYYMMDDHHMMSS":// 21
				ouputString = DateTimeUtils.getDefaultYYYYMMDDHHMMSS();
				System.out.println("當前時間轉YYYYMMDDHHMMSS：" + ouputString + "\t\t類別：" + ouputString.getClass());
				break;
			case "yyyMMToyyyyMM":// 22
				System.out.println("請輸入日期：(ex:110/02)");
				ouputString = DateTimeUtils.yyyMMToyyyyMM(scanner.next());
				System.out.println("民國月yyyMM轉西元月yyyyMM：" + ouputString + "\t類別：" + ouputString.getClass());
				break;
			case "getLastDayOfMonth":// 23
				System.out.println("請輸入日期：(ex:202102)");
				ouputString = DateTimeUtils.getLastDayOfMonth(scanner.next(), "yyyyMMdd");
				System.out.println("指定年月, 回傳該月的最後一天：" + ouputString + "\t類別：" + ouputString.getClass());
				break;
			case "getFirstDayOfMonth":// 24
				System.out.println("請輸入日期：(ex:202102)");
				ouputString = DateTimeUtils.getFirstDayOfMonth(scanner.next(), "yyyyMMdd");
				System.out.println("指定年月, 回傳該月的第一天：" + ouputString + "\t類別：" + ouputString.getClass());
				break;
			case "getLastDayOfMonthByYYYMM":// 25
				System.out.println("請輸入日期：(ex:110/02)");
				ouputString = DateTimeUtils.getLastDayOfMonthByYYYMM(scanner.next(), "yyyyMMdd");
				System.out.println("指定民國年月, 回傳該月的最後一天：" + ouputString + "\t\t類別：" + ouputString.getClass());
				break;
			case "getFirstDayOfMonthByYYYMM":// 26
				System.out.println("請輸入日期：(ex:110/02)");
				ouputString = DateTimeUtils.getFirstDayOfMonthByYYYMM(scanner.next(), "yyyMMdd");
				System.out.println("指定年月, 回傳該月的第一天：" + ouputString + "\t\t類別：" + ouputString.getClass());
				break;
			case "getCurrentDate":// 27
				System.out.println("請輸入格式：(ex:yyyyMMdd or yyyy/MM/dd)");
				ouputString = DateTimeUtils.getCurrentDate(scanner.next());
				System.out.println("按指定的格式返回當前時間：" + ouputString + "\t\t類別：" + ouputString.getClass());
				break;
			case "getChineseDateFormat":// 28
				System.out.println("請輸入日期：(ex:2021/02/08)");
				ouputDate = DateTimeUtils.yyyySlashMMSlashddToDate(scanner.next());
				System.out.println("Stinrg轉Date：" + ouputDate + "\t類別：" + ouputDate.getClass());
				ouputString = DateTimeUtils.getChineseDateFormat(ouputDate);
				System.out.println("Date轉年月日：" + ouputString + "\t\t類別：" + ouputString.getClass());
				break;
			case "getFirstDayOfCurrentMonth":
				ouputDate = DateTimeUtils.getFirstDayOfCurrentMonth();
				System.out.println("本月的第一天：" + ouputDate + "\t\t類別：" + ouputDate.getClass());
				break;
			case "addDate":
				System.out.println("請輸入天數：(ex:1, 2, 3, 10, 100)");
				ouputDate = DateTimeUtils.addDate(new Date(), Integer.parseInt(scanner.next()));
				System.out.println("新增天數日期：" + ouputDate + "\t\t類別：" + ouputDate.getClass());
				break;
			case "addMonth":
				System.out.println("請輸入開始日：(ex:20210225)");
				String temp1 = scanner.next();
				System.out.println("請輸入格式：(ex:yyyyMMdd)");
				String temp2 = scanner.next();
				ouputString = DateTimeUtils.addMonth(temp1, temp2);
				System.out.println("指定日期的下個月：" + ouputString + "\t\t類別：" + ouputString.getClass());
				break;
			case "today":
				ouputCalendar = DateTimeUtils.today();
				System.out.println("GregorianCalendar：" + ouputCalendar + "\t\t類別：" + ouputCalendar.getClass());
				break;
			case "getCurrentTimestamp":
				ouputTimestamp = DateTimeUtils.getCurrentTimestamp();
				System.out.println("CurrentTimestamp：" + ouputTimestamp + "\t\t類別：" + ouputTimestamp.getClass());
				break;
			case "dispersionMonth":
				System.out.println("請輸入開始日：(ex:20210201)");
				temp1 = scanner.next();
				System.out.println("請輸入結束日：(ex:20210501)");
				temp2 = scanner.next();
				System.out.println("請輸入格式：(ex:yyyyMMdd)");
				String temp3 = scanner.next();
				ouputInteger = DateTimeUtils.dispersionMonth(temp1, temp2, temp3);
				System.out.println("相差月數：" + ouputInteger + "\t\t類別：" + ouputInteger.getClass());
				break;
			case "isValidDate":// 29
				System.out.println("請輸入日期：(ex:2021/02/08 or 20210208)");
				ouputboolean = DateTimeUtils.isValidDate(scanner.next());
				System.out.println("檢查日期是否合法：" + ouputboolean + "\t\t類別：" + ouputboolean.getClass());
				break;
			}
		}
	}

	public Main() {
		super();
	}

}