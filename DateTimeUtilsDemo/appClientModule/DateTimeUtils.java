import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateTimeUtils {
	/**
	 * 方法匯總
	 * 1.yyyMMdd轉Date   				method:yyyMMddToDate
	 * 2.yyyyMMdd轉Date  				method:yyyyMMddToDate
	 * 3.yyy/MM/dd轉Date			    	method:yyySlashMMSlashddToDate
	 * 4.yyyy/MM/dd轉Date				method:yyyySlashMMSlashddToDate
	 * 5.yyyy-MM-dd轉Date				method:yyyyDashMMDashddToDate
	 * 6.ddMMyyyy轉Date					method:ddMMyyyyToDate
	 * 7.yyyMMdd轉yyyyMMdd				method:yyyMMddtoyyyyMMdd
	 * 8.yyyMMdd轉ddMMyyyy				method:yyyMMddToddMMyyyy
	 * 9.yyy/MM/dd轉ddMMyyyy				method:yyyMMddSlashToddMMyyyy
	 * 10.yyyy/MM/dd轉yyy/MM/dd			method:yyyyMMddtoyyyMMdd
	 * 11.yyyyMMdd轉yyy/MM/dd			method:yyyyMMddtoyyyMMdd1
	 * 12.ddMMyyyy轉yyyMMdd				method:ddMMyyyyToyyyMMdd
	 * 13.ddMMyyyy轉yyy/MM/dd			method:ddMMyyyyToyyyMMddSlash
	 * 14.Date轉yyyMMdd					method:DateToyyyMMdd
	 * 15.Date轉yyyyMMdd					method:DateToyyyyMMdd
	 * 16.Date轉yyy/MM/dd				method:DateToyyySlashMMSlashdd
	 * 17.Date轉yyyy/MM/dd				method:DateToyyyySlashMMSlashdd
	 * 18.Date轉yyyy-MM-dd				method:DateToyyyyDashMMDashdd
	 * 19.Date轉YYY/MM/DD HH:MM:SS		method:DateToYYYMMDDHHMMSS
	 * 20.Date轉ddMMyyyy					method:dateToddMMyyyy
	 * 21.當前時間轉YYYYMMDDHHMMSS		method:getDefaultYYYYMMDDHHMMSS
	 * 22.民國月yyyMM轉西元月yyyyMM		method:yyyMMToyyyyMM
	 * 23.指定年月, 回傳該月的最後一天	method:getLastDayOfMonth
	 * 24.指定年月, 回傳該月的第一天		method:getFirstDayOfMonth
	 * 25.指定民國年月, 回傳該月的最後一天method:getLastDayOfMonthByYYYMM
	 * 26.指定年月, 回傳該月的第一天		method:getFirstDayOfMonthByYYYMM
	 * 27.按指定的格式返回當前時間		method:getCurrentDate
	 * 28.Date轉年月日					method:getChineseDateFormat
	 * 29.檢查日期是否合法				method:isValidDate
	 */
	public static final String PATTERN_YYYY_MM = "yyyy/MM";
	public static final String PATTERN_YYYYMMDD = "yyyyMMdd";
	public static final String PAATERN_DD_MM_YYYY = "ddMMyyyy";
	public static final String PATTERN_YYYY_MM_DD = "yyyy/MM/dd";
	public static final String PATTERN_YYYY_MM_DD_DASH = "yyyy-MM-dd";
	public static final String PATTERN_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
	public static final String PATTERN_YYYY_MM_DD_HH_MM_SLASH = "yyyy/MM/dd HH:mm";
	public static final String PATTERN_YYYY_MM_DD_HH_MM_SS_DASH = "yyyy-MM-dd HH:mm:ss";
	public static final String PATTERN_YYYY_MM_DD_HH_MM_SS_SLASH = "yyyy/MM/dd HH:mm:ss";

	/**
	 * 民國日期yyyMMdd轉Date
	 * 
	 * @param yyyMMdd
	 * @return
	 */
	public static Date yyyMMddToDate(String yyyMMdd) throws ParseException {
		if (yyyMMdd == null || yyyMMdd.length() != 7) {
			throw new ParseException(yyyMMdd + " format is not valid date format , valid format should be yyyMMdd", 0);
		}
		String year = yyyMMdd.substring(0, 3);
		String month = yyyMMdd.substring(3, 5);
		String date = yyyMMdd.substring(5);
		Integer _year = 0;
		Integer _month = 0;
		Integer _date = 0;
		try {
			_year = Integer.valueOf(year) + 1911;
			_month = Integer.valueOf(month) - 1;
			_date = Integer.valueOf(date);

			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.YEAR, _year);
			cal.set(Calendar.MONTH, _month);
			cal.set(Calendar.DATE, _date);
			if (cal.get(Calendar.MONTH) != _month) {
				throw new NumberFormatException(yyyMMdd + " is not valid date");
			}
			return cal.getTime();
		} catch (NumberFormatException e) {
			throw new ParseException(e.getMessage(), 0);
		}
	}

	/**
	 * yyyyMMdd轉Date
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date yyyyMMddToDate(String date) throws ParseException {
		return strToDate(PATTERN_YYYYMMDD, date);
	}

	/**
	 * 民國日期yyy/MM/dd轉Date
	 * 
	 * @param yyyMMdd
	 * @return
	 */
	public static Date yyySlashMMSlashddToDate(String yyyMMdd) throws ParseException {
		if (yyyMMdd == null || yyyMMdd.length() != 9) {
			throw new ParseException(yyyMMdd + " format is not valid date format , valid format should be yyyMMdd", 0);
		}
		String year = yyyMMdd.substring(0, 3);
		String month = yyyMMdd.substring(4, 6);
		String date = yyyMMdd.substring(7);
		Integer _year = 0;
		Integer _month = 0;
		Integer _date = 0;
		try {
			_year = Integer.valueOf(year) + 1911;
			_month = Integer.valueOf(month) - 1;
			_date = Integer.valueOf(date);

			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.YEAR, _year);
			cal.set(Calendar.MONTH, _month);
			cal.set(Calendar.DATE, _date);
			if (cal.get(Calendar.MONTH) != _month) {
				throw new NumberFormatException(yyyMMdd + " is not valid date");
			}
			return cal.getTime();
		} catch (NumberFormatException e) {
			throw new ParseException(e.getMessage(), 0);
		}
	}

	/**
	 * yyyy/MM/dd轉Date
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date yyyySlashMMSlashddToDate(String date) throws ParseException {
		return strToDate(PATTERN_YYYY_MM_DD, date);
	}

	/**
	 * yyyy-MM-dd轉Date
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date yyyyDashMMDashddToDate(String date) throws ParseException {
		return strToDate(PATTERN_YYYY_MM_DD_DASH, date);
	}

	/**
	 * ddMMyyyy轉Date
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date ddMMyyyyToDate(String date) throws ParseException {
		return strToDate(PAATERN_DD_MM_YYYY, date);
	}

	/**
	 * yyyMMdd轉yyyyMMdd
	 * 
	 * @param yyyMMdd
	 * @return
	 */
	public static String yyyMMddtoyyyyMMdd(String yyyMMdd) {
		if (yyyMMdd == null || yyyMMdd.length() != 7) {
			return yyyMMdd;
		}
		int year = Integer.parseInt(yyyMMdd.substring(0, 3)) + 1911;
		return year + yyyMMdd.substring(3);
	}

	/**
	 * yyyMMdd轉ddMMyyyy
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static String yyyMMddToddMMyyyy(String date) throws ParseException {
		Date dateTemp = yyyMMddToDate(date);
		return dateToddMMyyyy(dateTemp);
	}

	/**
	 * yyy/MM/dd轉ddMMyyyy
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static String yyyMMddSlashToddMMyyyy(String date) throws ParseException {
		Date dateTemp = yyySlashMMSlashddToDate(date);
		return dateToddMMyyyy(dateTemp);
	}

	/**
	 * yyyy/MM/dd轉yyy/MM/dd
	 * 
	 * @param yyyyMMdd
	 * @return
	 */
	public static String yyyyMMddtoyyyMMdd(String yyyyMMdd) {
		if (yyyyMMdd == null || yyyyMMdd.length() != 10) {
			return yyyyMMdd;
		}
		int year = Integer.parseInt(yyyyMMdd.substring(0, 4)) - 1911;
		return year + yyyyMMdd.substring(4);
	}

	/**
	 * yyyyMMdd轉yyy/MM/dd
	 * 
	 * @param yyyyMMdd
	 * @return
	 * @throws ParseException
	 */
	public static String yyyyMMddtoyyyMMdd1(String yyyyMMdd) throws ParseException {
		Date date = yyyyMMddToDate(yyyyMMdd);
		return DateToyyySlashMMSlashdd(date);
	}

	/**
	 * ddMMyyyy轉yyyMMdd
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static String ddMMyyyyToyyyMMdd(String date) throws ParseException {
		Date dateTemp = ddMMyyyyToDate(date);
		return DateToyyyMMdd(dateTemp);
	}

	/**
	 * ddMMyyyy轉yyy/MM/dd
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static String ddMMyyyyToyyyMMddSlash(String date) throws ParseException {
		Date dateTemp = ddMMyyyyToDate(date);
		return DateToyyySlashMMSlashdd(dateTemp);
	}

	/**
	 * 日期轉民國日期yyyMMdd
	 * 
	 * @param date
	 * @return
	 */
	public static String DateToyyyMMdd(Date date) {
		StringBuffer sb = new StringBuffer();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int date1 = cal.get(Calendar.DATE);
		sb.append("" + (year - 1911)).append(month < 10 ? "0" + month : "" + month)
				.append(date1 < 10 ? "0" + date1 : "" + date1);
		return sb.toString();
	}

	/**
	 * Date轉yyyyMMdd
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static String DateToyyyyMMdd(Date date) throws ParseException {
		return DateToStr(PATTERN_YYYYMMDD, date);
	}

	/**
	 * 日期轉民國日期yyy/MM/dd
	 * 
	 * @param date
	 * @return
	 */
	public static String DateToyyySlashMMSlashdd(Date date) {
		StringBuffer sb = new StringBuffer();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int date1 = cal.get(Calendar.DATE);
		sb.append("" + (year - 1911)).append("/").append(month < 10 ? "0" + month : "" + month).append("/")
				.append(date1 < 10 ? "0" + date1 : "" + date1);
		return sb.toString();
	}

	/**
	 * Date轉yyyy/MM/dd
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static String DateToyyyySlashMMSlashdd(Date date) throws ParseException {
		return DateToStr(PATTERN_YYYY_MM_DD, date);
	}

	/**
	 * Date轉yyyy-MM-dd
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static String DateToyyyyDashMMDashdd(Date date) throws ParseException {
		return DateToStr(PATTERN_YYYY_MM_DD_DASH, date);
	}

	/**
	 * Date 轉 YYY/MM/DD HH:MM:SS
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static String DateToYYYMMDDHHMMSS(Date date) throws ParseException {
		return getDateToYYYMMDDHHMMSS(date, PATTERN_YYYY_MM_DD_HH_MM_SS_SLASH);
	}

	/**
	 * Date轉ddMMyyyy
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static String dateToddMMyyyy(Date date) throws ParseException {
		return DateToStr(PAATERN_DD_MM_YYYY, date);
	}

	/**
	 * 當前時間轉YYYYMMDDHHMMSS
	 * 
	 * @return
	 * @throws ParseException
	 */
	public static String getDefaultYYYYMMDDHHMMSS() {
		String strDate = null;
		try {
			strDate = DateToStr(PATTERN_YYYYMMDDHHMMSS, new Date());
		} catch (ParseException e) {
		}
		return strDate;
	}

	public static Date strToDate(String pattern, String date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.parse(date);
	}

	public static String DateToStr(String pattern, Date date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}

	public static String getDateToYYYMMDDHHMMSS(Date date, String str) throws ParseException {
		String yyymmmdddhhmmss = DateToStr(str, date);
		int yearYYY = Integer.parseInt(yyymmmdddhhmmss.substring(0, 4)) - 1911;

		return yearYYY + yyymmmdddhhmmss.substring(4);
	}

	public static String yyyslashddslashmmToyyyyMMdd(String yyyslashmmslashdd) {
		String _date = yyyslashmmslashdd.replace("/", "");
		return yyyMMddtoyyyyMMdd(_date);
	}

	public static String yyyyMMdd() throws ParseException {
		Date _date = new Date();
		return DateToyyyyMMdd(_date);
	}

	public static String DateToyyySlashMMSlashddyyyyMMdd() {
		Date _date = new Date();
		return DateToyyySlashMMSlashdd(_date);
	}

	/**
	 * 民國月yyyMM轉西元月yyyyMM
	 * 
	 * @param yyyMMdd
	 * @return
	 */
	public static String yyyMMToyyyyMM(String yyyMM) throws ParseException {
		if (yyyMM == null || yyyMM.length() != 6) {
			throw new ParseException(yyyMM + " format is not valid date format , valid format should be yyyMM", 0);
		}
		String year = yyyMM.substring(0, 3);
		String month = yyyMM.substring(4, 6);
		Integer _year = Integer.valueOf(year) + 1911;
		return String.valueOf(_year) + month;
	}

	/**
	 * 指定年月, 回傳該月的最後一天
	 * 
	 * @param format
	 * @return
	 */
	public static String getLastDayOfMonth(String yyyyMM, String format) {

		if (yyyyMM == null || yyyyMM.length() != 6) {
			return yyyyMM;
		}

		String str = "";

		SimpleDateFormat sdf = new SimpleDateFormat(format);

		Calendar lastDate = Calendar.getInstance();
		lastDate.set(Calendar.YEAR, Integer.parseInt(yyyyMM.substring(0, 4)));
		lastDate.set(Calendar.MONTH, Integer.parseInt(yyyyMM.substring(4, 6)));
		lastDate.set(Calendar.DATE, 1);// 設為當前月的1號
		lastDate.add(Calendar.DATE, -1);// 減去一天，變為當月最後一天
		str = sdf.format(lastDate.getTime());

		return str;
	}

	// 指定年月, 回傳該月的第一天
	public static String getFirstDayOfMonth(String yyyyMM, String format) {

		if (yyyyMM == null || yyyyMM.length() != 6) {
			return yyyyMM;
		}

		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat(format);

		Calendar lastDate = Calendar.getInstance();
		lastDate.set(Calendar.YEAR, Integer.parseInt(yyyyMM.substring(0, 4)));
		lastDate.set(Calendar.MONTH, Integer.parseInt(yyyyMM.substring(4, 6)) - 1);
		lastDate.set(Calendar.DATE, 1);// 設為當前月的1號
		str = sdf.format(lastDate.getTime());
		return str;
	}

	/**
	 * 指定民國年月, 回傳該月的最後一天
	 * 
	 * @param format
	 * @return
	 */
	public static String getLastDayOfMonthByYYYMM(String yyyMM, String format) {

		if (yyyMM == null || yyyMM.length() != 6) {
			return yyyMM;
		}

		String str = "";

		SimpleDateFormat sdf = new SimpleDateFormat(format);

		Calendar lastDate = Calendar.getInstance();
		lastDate.set(Calendar.YEAR, Integer.parseInt(yyyMM.substring(0, 3)) + 1911);
		lastDate.set(Calendar.MONTH, Integer.parseInt(yyyMM.substring(4, 6)));
		lastDate.set(Calendar.DATE, 1);// 設為當前月的1號
		lastDate.add(Calendar.DATE, -1);// 減去一天，變為當月最後一天
		str = sdf.format(lastDate.getTime());

		str = (Integer.parseInt(str.substring(0, 4)) - 1911) + str.substring(4);
		return str;
	}

	// 指定年月, 回傳該月的第一天
	public static String getFirstDayOfMonthByYYYMM(String yyyMM, String format) {

		if (yyyMM == null || yyyMM.length() != 6) {
			return yyyMM;
		}

		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat(format);

		Calendar lastDate = Calendar.getInstance();
		lastDate.set(Calendar.YEAR, Integer.parseInt(yyyMM.substring(0, 3)));
		lastDate.set(Calendar.MONTH, Integer.parseInt(yyyMM.substring(4, 6)) - 1);
		lastDate.set(Calendar.DATE, 1);// 設為當前月的1號
		str = sdf.format(lastDate.getTime());
		return str;
	}

	/**
	 * 日期轉民國日期yyy/MM
	 * 
	 * @param date
	 * @return
	 */
	public static String DateToyyySlashMM(Date date) {
		StringBuffer sb = new StringBuffer();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		sb.append("" + (year - 1911)).append("/").append(month < 10 ? "0" + month : "" + month);
		return sb.toString();
	}

	/**
	 * 按指定的格式返回當前時間
	 * 
	 * @param format
	 * @return
	 */
	public static String getCurrentDate(String format) {
		String rtnDate;
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		rtnDate = sdf.format(Calendar.getInstance().getTime());
		return rtnDate;
	}

	public static class Quarter {
		public static final Quarter FIRST = new Quarter(getDate(1970, 1, 1), getDate(1970, 3, 31), 1);
		public static final Quarter SECOND = new Quarter(getDate(1970, 4, 1), getDate(1970, 6, 30), 2);
		public static final Quarter THIRD = new Quarter(getDate(1970, 7, 1), getDate(1970, 9, 30), 3);
		public static final Quarter FOURTH = new Quarter(getDate(1970, 10, 1), getDate(1970, 12, 31), 4);
		private Calendar startDate;
		private Calendar endDate;
		private int quarter;

		private Quarter(Calendar startDate, Calendar endDate, int quarter) {
			int year = now().get(1);
			this.startDate = startDate;
			this.startDate.set(1, year);
			this.endDate = endDate;
			this.endDate.set(1, year);
			this.quarter = quarter;
		}

		public void setYear(int year) {
			getStartDate().set(1, year);
			getEndDate().set(1, year);
		}

		public int getQuarter() {
			return this.quarter;
		}

		public Calendar getStartDate() {
			return this.startDate;
		}

		public Calendar getEndDate() {
			return this.endDate;
		}
	}

	public static Quarter transferFromQuarter(int year, int quarter) {
		Quarter q = null;
		if (quarter == 1) {
			q = Quarter.FIRST;
		} else if (quarter == 2) {
			q = Quarter.SECOND;
		} else if (quarter == 3) {
			q = Quarter.THIRD;
		} else if (quarter == 4) {
			q = Quarter.FOURTH;
		} else {
			throw new RuntimeException("Quarter translation failed.");
		}
		q.setYear(year);
		return q;
	}

	public static int transferToQuarter(Date date) {
		Calendar c = GregorianCalendar.getInstance();
		c.setTime(date);
		int month = c.get(2) + 1;
		if ((month >= 1) && (month <= 3)) {
			return 1;
		}
		if ((month >= 4) && (month <= 6)) {
			return 2;
		}
		if ((month >= 7) && (month <= 9)) {
			return 3;
		}
		if ((month >= 10) && (month <= 12)) {
			return 4;
		}
		throw new RuntimeException("Can not transfer date to quarter");
	}

	public static String getChineseDateFormat(Date date) {
		Calendar c = GregorianCalendar.getInstance();
		c.setTime(date);
		int year = c.get(1);
		int month = c.get(2) + 1;
		int day = c.get(5);

		StringBuffer formated = new StringBuffer();
		formated.append(" ").append(year).append("年").append(month).append("月").append(day).append("日");
		return formated.toString();
	}

	public static Date getFirstDayOfCurrentMonth() {
		Calendar now = now();
		now.set(5, 1);
		return now.getTime();
	}

	public static String dateFormater(Date date, String pattern) {
		return dateFormater(date, pattern, null);
	}

	public static String dateFormater(Date date, String pattern, Locale locale) {
		String formattedDate = "";
		if (date != null) {
			Calendar calendar = GregorianCalendar.getInstance();
			calendar.setTime(date);
			formattedDate = calendarFormater(calendar, pattern, locale);
		}
		return formattedDate;
	}

	public static String calendarFormater(Calendar date, String pattern) {
		return calendarFormater(date, pattern, null);
	}

	public static String calendarFormater(Calendar date, String pattern, Locale locale) {
		String formattedDate = "";
		if (locale == null) {
			locale = Locale.US;
		}
		if (date != null) {
			SimpleDateFormat formatter = new SimpleDateFormat(pattern, locale);
			formattedDate = formatter.format(date.getTime());
		}
		return formattedDate;
	}

	public static Calendar today() {
		Calendar now = now();
		now.set(10, 0);
		now.set(12, 0);
		now.set(13, 0);
		now.set(14, 0);
		now.set(9, 0);
		return now;
	}

	public static Calendar now() {
		return GregorianCalendar.getInstance();
	}

	public static Calendar getDate(int year, int month, int day) {
		month--;
		Calendar date = new GregorianCalendar(year, month, day);
		date.set(10, 0);
		date.set(12, 0);
		date.set(13, 0);
		date.set(14, 0);
		date.set(9, 0);

		return date;
	}

	public static String getChineseDate() {
		StringBuffer date = new StringBuffer();
		Calendar calendar = GregorianCalendar.getInstance();
		String y = makeUpZero(String.valueOf(calendar.get(1) - 1911), 3);
		String m = makeUpZero(String.valueOf(calendar.get(2) + 1), 2);
		String d = makeUpZero(String.valueOf(calendar.get(5)), 2);
		date.append(y).append(m).append(d);
		return date.toString();
	}

	public static String getChineseDateWithoutDay() {
		String dateString = getChineseDate();
		return dateString.substring(0, dateString.length() - 2);
	}

	public static Date addDate(Date date, int day) {
		Calendar calendar = GregorianCalendar.getInstance();
		if (date != null) {
			calendar.setTime(date);
		}
		calendar.add(5, day);
		return calendar.getTime();
	}

	public static int calculateAge(Date birthDay) {
		Calendar birth_c = Calendar.getInstance();
		birth_c.setTime(birthDay);

		Date today = new Date(System.currentTimeMillis());
		Calendar c2 = Calendar.getInstance();
		c2.setTime(today);

		long remaindar = c2.getTimeInMillis() - birth_c.getTimeInMillis();

		long aYear = 31536000000L;

		int age = (int) (remaindar / aYear);
		return age;
	}

	public static Date parseDate(String rawDate, String pattern) throws ParseException {
		Date date = null;
		SimpleDateFormat dateFormatter = new SimpleDateFormat();
		dateFormatter.applyPattern(pattern);
		date = dateFormatter.parse(rawDate);

		return date;
	}

	public static int getLastDateOfMonth(int year, int month) {
		Calendar c = getDate(year, month, 1);
		c.add(2, 1);
		c.add(5, -1);
		return c.get(5);
	}

	public static Calendar getCalendar(String dateStr, String pattern) throws ParseException {
		try {
			Date date = parseDate(dateStr, pattern);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);

			return calendar;
		} catch (ParseException pe) {
			throw pe;
		}
	}

	public static Timestamp getCurrentTimestamp(String pattern) {
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		String currentTsStr = df.format(new Date());
		Timestamp currentTs = Timestamp.valueOf(currentTsStr);

		return currentTs;
	}

	public static Timestamp getCurrentTimestamp() {
		return new Timestamp(System.currentTimeMillis());
	}

	/**
	 * description:把轉換date的格式按原先格式format1轉成format2
	 * 
	 * @param date
	 * @param format1
	 * @param format2
	 * @return
	 */
	public static String convertDate(String date, String format1, String format2) {
		if ("".equals(date) || "00000000".equals(date)) {
			return "";
		}
		SimpleDateFormat fmt1 = new SimpleDateFormat(format1);
		SimpleDateFormat fmt2 = new SimpleDateFormat(format2);
		String rtnStr = null;
		try {
			Date d = fmt1.parse(date);
			rtnStr = fmt2.format(d);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rtnStr;
	}

	/**
	 * 將String 類型的日期進行格式化
	 * 
	 * @param str-需格式化的字符串
	 * @param sDateFormat_p-format格式
	 * @param sDateFormat_F-parse格式
	 * @param language-格式化語言
	 * @date 2012-02-01
	 * @author junyichu
	 * @return
	 */
	public static String convertDate(String str, String sDateFormat_p, String sDateFormat_F, Locale language) {
		try {
			SimpleDateFormat sdf;
			SimpleDateFormat df;
			if ("".equals(str) || "00000000".equals(str)) {
				return "";
			}
			if (language.equals("")) {
				sdf = new SimpleDateFormat(sDateFormat_p);
				df = new SimpleDateFormat(sDateFormat_F);
			} else {
				sdf = new SimpleDateFormat(sDateFormat_p, language);
				df = new SimpleDateFormat(sDateFormat_F, language);
			}
			str = sdf.format(df.parse(str));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return str;
	}

	/**
	 * 月累加1，取下個月的日期 把str 開始日期
	 * 
	 * @param str    開始日期
	 * @param format 輸入和輸出的日期格式，例如：yyyyMMdd
	 * @return
	 */
	public static String addMonth(String str, String format) {

		return addMonth(str, 1, format);
	}

	/**
	 * 月份加減
	 * 
	 * @param str    開始日期
	 * @param months 月數，例如：-1表示上個月，1表示下個月
	 * @param format 輸入和輸出的日期格式，例如：yyyyMMdd
	 * @return
	 */
	public static String addMonth(String sDate, int iMonths, String format) {
		String rtn = "";
		try {
			if (sDate != null && !"".equals(sDate)) {
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat sd = new SimpleDateFormat(format);
				Date date = sd.parse(sDate);
				cal.setTime(date);
				cal.add(Calendar.MONTH, iMonths);
				Date date2 = cal.getTime();
				rtn = sd.format(date2);
			}
		} catch (ParseException e) {
			e.printStackTrace();
			return rtn;
		}
		return rtn;
	}

	/**
	 * 日期加減
	 * 
	 * @param sDate  開始日期
	 * @param iDays  -1 表示上一天，1表示下一天
	 * @param format 輸入和輸出的日期格式，例如：yyyyMMdd
	 * @return
	 */
	public static String addDay(String sDate, int iDays, String format) {
		String rtn = "";
		try {
			if (sDate != null && !"".equals(sDate)) {
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat sd = new SimpleDateFormat(format);
				Date date = sd.parse(sDate);
				cal.setTime(date);
				cal.add(Calendar.DAY_OF_MONTH, iDays);
				Date date2 = cal.getTime();
				rtn = sd.format(date2);
			}
		} catch (ParseException e) {
			e.printStackTrace();
			return rtn;
		}
		return rtn;
	}

	/**
	 * 日期加減
	 * 
	 * @param sDate        開始日期
	 * @param iDays        -1 表示上一天，1表示下一天
	 * @param inputFormat  輸入的日期格式，例如：yyyyMMdd
	 * @param outputFormat 輸出的日期格式，例如：yyyy-MM-dd
	 * @return
	 */
	public static String addDay(String sDate, int iDays, String inputFormat, String outputFormat) {
		String rtnDate = "";
		try {
			if (sDate != null && !"".equals(sDate)) {
				// 验证日期是否合法
				boolean bool = isValidDate(sDate);
				if (!bool) {
					return "";
				}
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat fmt1 = new SimpleDateFormat(inputFormat);
				SimpleDateFormat fmt2 = new SimpleDateFormat(outputFormat);
				Date date = fmt1.parse(sDate);
				cal.setTime(date);
				cal.add(Calendar.DATE, iDays);
				Date date2 = cal.getTime();
				rtnDate = fmt2.format(date2);
			}
		} catch (ParseException e) {
			e.printStackTrace();
			return rtnDate;
		}
		return rtnDate;
	}

	/**
	 * 計算兩個日期之間相差的月數,不考慮日的情況
	 * 
	 * @param startDate 開始時間
	 * @param endDate   結束時間
	 * @param format    日期格式形式 例如：yyyyMMdd
	 * @return 相差月數
	 */
	public static int dispersionMonth(String startDate, String endDate, String format) {
		int difMonth = -1;
		try {
			if (startDate != null && !"".equals(startDate) && endDate != null && !"".equals(endDate)) {
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat sd = new SimpleDateFormat(format);
				// 開始時間
				Date start_date = sd.parse(startDate);
				cal.setTime(start_date);

				// 結束時間
				Calendar cal2 = Calendar.getInstance();
				Date end_date = sd.parse(endDate);
				cal2.setTime(end_date);
				// 開始時間與結束時間相等
				if (cal.equals(cal2)) {
					difMonth = 0;
					return difMonth;
				}
				/**
				 * 若結束時間（endDate）小於開始時間（startDate），置換位置. 始終保持cal放小的日期，cal2放大的日期
				 */
				if (cal.after(cal2)) {
					Calendar calTemp = cal;
					cal = cal2;
					cal2 = calTemp;
				}
				int startYear = cal.get(Calendar.YEAR);
				int startMonth = cal.get(Calendar.MONTH);

				int endYear = cal2.get(Calendar.YEAR);
				int endMonth = cal2.get(Calendar.MONTH);

				// 結束時間的年大於開始時間的年，年與月均相減計算相差月數
				if (cal2.get(Calendar.YEAR) > cal.get(Calendar.YEAR)) {
					difMonth = (endYear - startYear) * 12 + (endMonth - startMonth);
				}
				// 結束時間的年等於開始時間的年，表示為同一年，只需把月份相減即可
				else {
					difMonth = endMonth - startMonth;
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
			return difMonth;
		}
		return difMonth;
	}

	/**
	 * 獲得指定年月的天數
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	public static int getDays(int year, int month) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month - 1);// the month between 0-11
		c.set(Calendar.DATE, 1); // add by tyun 2012/06/29
		return c.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 獲得當前的系統日期
	 * 
	 * @param format 格式：yyyyMMdd或者yyyyMM等
	 * @return
	 */
	public static String getCurrDateString(String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date dt = new Date();
		return sdf.format(dt);
	}

	/**
	 * 格式化指定日期
	 * 
	 * @param timestamp 時間戳
	 * @param format    格式：yyyyMMdd或者yyyyMM等
	 * @return
	 */
	/*
	 * public static String getFormatDateString(String sDate, String format) {
	 * SimpleDateFormat sdf = new SimpleDateFormat(format); Date dt = null; try { dt
	 * = sdf.parse(sDate); } catch (ParseException e) { e.printStackTrace(); }
	 * return (null == dt) ? "" : sdf.format(dt); }
	 */

	/**
	 * 格式化指定日期
	 * 
	 * @param timestamp 時間戳
	 * @param format    格式：yyyyMMdd或者yyyyMM等
	 * @return
	 */
	public static String getFormatDateString(Timestamp timestamp, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);

		return sdf.format(timestamp);
	}

	/**
	 * 格式化指定日期
	 * 
	 * @param timestamp 時間戳
	 * @param format    格式：yyyyMMdd或者yyyy-MM-dd等
	 * @return
	 */
	public static Timestamp str2Timestamp(String sTimestamp, String format) {
		Timestamp timestamp = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			timestamp = new Timestamp(sdf.parse(sTimestamp).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return timestamp;
	}

	/**
	 * 檢查日期是否合法(只要實現日期是否超过當月最大日期的合法性判斷)
	 * 
	 * @param date 需檢查的日期
	 * @return 日期是否合法
	 */
	public static boolean isValidDate(String date) {
		try {
			date = date.replace("/", "");
			// 如果输入日期不是8位的，判定為false
			if (null == date || "".equals(date) || !date.matches("[0-9]{8}")) {
				return false;
			}
			int year = Integer.parseInt(date.substring(0, 4));
			int month = Integer.parseInt(date.substring(4, 6)) - 1;
			int day = Integer.parseInt(date.substring(6));
			Calendar calendar = GregorianCalendar.getInstance();
			// 當Calendar處于non-lenient模式時，如果日曆字段存在任何不一致性，它都會抛出一个異常
			calendar.setLenient(false);
			calendar.set(Calendar.YEAR, year);
			calendar.set(Calendar.MONTH, month);
			calendar.set(Calendar.DATE, day);
			// 如果日期錯誤，執行該语句必定抛異常
			calendar.get(Calendar.YEAR);
		} catch (IllegalArgumentException e) {
			return false;
		}
		return true;
	}

	/**
	 * 獲取當前日期的上一個月月份 格式為yyyymm
	 * 
	 * @return
	 */
	public static String getLastMonth() {
		Calendar cal = Calendar.getInstance();
		Date date = new Date();
		cal.setTime(date);
		int month = cal.get(Calendar.MONTH); // 上个月月份
		int year = cal.get(Calendar.YEAR);
		return (year + "" + String.format("%02d", month));
	}

	/**
	 * 獲取每個月的最後一天的日期
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	public static String getLastDayOfMonth(int year, int month) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.DATE, 1); // add by tyun 2012/06/29
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DATE));
		return new SimpleDateFormat("yyyyMMdd ").format(cal.getTime());
	}

	/**
	 * 獲取指定日期所在月份的最後一個工作日日期
	 * 
	 * @return
	 * @throws ParseException
	 */
	public static String getLastWorkDay(String cdate) throws ParseException {
		Calendar cal = Calendar.getInstance();
		// Date date = new Date();
		cal.setTime(new SimpleDateFormat("yyyyMM").parse(cdate));
		int month = cal.get(Calendar.MONTH) + 1; // cdate月月份
		int year = cal.get(Calendar.YEAR);

		String date1 = getLastDayOfMonth(year, month - 1);// 獲取cdate所在月的最後一天
		Date date2 = new SimpleDateFormat("yyyyMMdd").parse(date1);
		cal.setTime(date2);

		// 判斷最後一天,如果是星期六就,往前一天,如果是星期日,就往前兩天
		int day = cal.get(Calendar.DAY_OF_WEEK);
		String lastWeekDay = "";
		if ((day == Calendar.SUNDAY)) {
			cal.set(Calendar.DATE, cal.get(Calendar.DATE) - 2);
			lastWeekDay = new SimpleDateFormat("yyyyMMdd").format(cal.getTime());
		} else if ((day == Calendar.SATURDAY)) {
			cal.set(Calendar.DATE, cal.get(Calendar.DATE) - 1);
			lastWeekDay = new SimpleDateFormat("yyyyMMdd").format(cal.getTime());
		} else {
			lastWeekDay = new SimpleDateFormat("yyyyMMdd").format(cal.getTime());
		}
		return lastWeekDay;
	}

	/**
	 * 獲取指定日期所在月份的最後一個工作日日期+1即出表日期
	 * 
	 * @return
	 * @throws ParseException
	 */
	public static String getExportDay(String cdate) throws ParseException {
		Calendar cal = Calendar.getInstance();
		// Date date = new Date();
		cal.setTime(new SimpleDateFormat("yyyyMM").parse(cdate));
		int month = cal.get(Calendar.MONTH) + 1; // cdate月月份
		int year = cal.get(Calendar.YEAR);

		String date1 = getLastDayOfMonth(year, month - 1);// 獲取cdate所在月的最後一天
		Date date2 = new SimpleDateFormat("yyyyMMdd").parse(date1);
		cal.setTime(date2);

		// 判斷最後一天,如果是星期六就,往前一天,如果是星期日,就往前兩天
		int day = cal.get(Calendar.DAY_OF_WEEK);

		String exportDate = "";
		if ((day == Calendar.SUNDAY)) {
			cal.set(Calendar.DATE, cal.get(Calendar.DATE) - 1);
			exportDate = new SimpleDateFormat("yyyyMMdd").format(cal.getTime());
		} else if ((day == Calendar.SATURDAY)) {
			cal.set(Calendar.DATE, cal.get(Calendar.DATE));
			exportDate = new SimpleDateFormat("yyyyMMdd").format(cal.getTime());
		} else {// 加1後進入下一個月
			cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + 1);
			cal.set(Calendar.DATE, 1);
			exportDate = new SimpleDateFormat("yyyyMMdd").format(cal.getTime());
		}
		return exportDate;
	}

	public static String makeUpZero(String number, int length) {
		StringBuffer s = new StringBuffer(number);
		int srcLength = number.length();
		for (int i = 0; i < length - srcLength; i++) {
			s.insert(0, "0");
		}
		return s.toString();
	}
}
