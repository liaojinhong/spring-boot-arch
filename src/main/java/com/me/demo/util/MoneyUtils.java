package com.me.demo.util;
import java.text.DecimalFormat;
/**
 * 金额数据类型相关处理工具类
 */
public class MoneyUtils { 
	/** 英文金额单位常量 */
	protected static final String DOLLARS = "DOLLARS";
	protected static final String DOLLAR = "DOLLAR";
	protected static final String CENTS = "CENTS";
	protected static final String CENT = "CENT";
	protected static final String BILLION = "BILLION";
	protected static final String MILLION = "MILLION";
	protected static final String THOUSAND = "THOUSAND";
	protected static final String HUNDRED = "HUNDRED";
	protected static final String ZERO = "ZERO";
	protected static final String ONLY = "ONLY";
	/** 数字金额单位常量 */
	protected static final int ONE_BILLION = 1000000000;
	protected static final int ONE_MILLION = 1000000;
	protected static final int ONE_THOUSAND = 1000;
	/**
	 * 构造方法，禁止实例化
	 */
	private MoneyUtils() {
	}
	/**
	 * 将int型的金额数值转化为中文大写金额. <br>
	 * <br>
	 * <b>示例: </b>
	 * 
	 * <pre>
	 *  MoneyUtils.toChinese(2000,&quot;CNY&quot;); 返回 &quot;贰仟圆整&quot;
	 * </pre>
	 * 
	 * @param iFee 金额
	 * @param iCurrency 币别
	 * @return 中文的大写金额
	 */
	public static String toChinese(int iFee, String iCurrency) {
		return toChinese((double) iFee, iCurrency);
	}
	/**
	 * 将long型的金额数值转化为中文大写金额. <br>
	 * <br>
	 * <b>示例: </b>
	 * 
	 * <pre>
	 *  MoneyUtils.toChinese(5030000000L,&quot;CNY&quot;); 返回 &quot;伍拾亿零叁仟万圆整&quot;
	 * </pre>
	 * 
	 * @param iFee long型的金额数值
	 * @param iCurrency 币别
	 * @return 中文的大写金额
	 */
	public static String toChinese(long iFee, String iCurrency) {
		return toChinese((double) iFee, iCurrency);
	}
	/**
	 * 将double型的金额数值转化为中文大写金额. <br>
	 * <br>
	 * <b>示例: </b>
	 * 
	 * <pre>
	 *  MoneyUtils.toChinese(382672.34d,&quot;CNY&quot;); 返回 &quot;叁拾捌万贰仟陆佰柒拾贰圆叁角肆分&quot;
	 *  MoneyUtils.toChinese(382672d,&quot;CNY&quot;); 返回 &quot;叁拾捌万贰仟陆佰柒拾贰圆整&quot;
	 * </pre>
	 * 
	 * @param iFee double型的金额数值
	 * @param iCurrency 币别
	 * @return 返回中文大写金额
	 */
	public static String toChinese(double iFee, String iCurrency) {
		String strChineseMoney = "";
		String strNumber = "              ";
		String strFee = "";
		String strThat = "";
		int intLength = 0;
		int i = 0, j = 0;
		if (iCurrency == null || iCurrency.length() == 0)
			iCurrency = "CNY";
		if (iFee < 0) {
			throw new IllegalArgumentException("金额不能为负");
		}
		if (iFee == 0)
			return strChineseMoney;
		strFee = new DecimalFormat("0").format(iFee * 100);
		intLength = strFee.length();
		if (intLength > 14) {
			throw new IllegalArgumentException("金额超出范围");
		}
		strNumber = strNumber.substring(0, 14 - intLength) + strFee;
		for (i = 14 - intLength; i < 14; i++) {
			j = new Integer(strNumber.substring(i, i + 1)).intValue();
			if (j > 0) //大于0
			{
				strChineseMoney = strChineseMoney.trim() + strThat.trim()
						+ getUpperChineseDigit(j).trim() + getUpperChineseUnit(i, iCurrency);
				strThat = "";
			} else {
				if (strChineseMoney.length() != 0) {
					if (i == 11) {
						strChineseMoney = strChineseMoney + getUpperChineseUnit(11, iCurrency);
					} else if (i == 7 && (strNumber.substring(4, 8).equals("0000") == false)) {
						strChineseMoney = strChineseMoney + "万";
					} else if (i == 3 && (strNumber.substring(0, 4).equals("0000") == false)) {
						strChineseMoney = strChineseMoney + "亿";
					}
					if (i < 11 || i == 12) {
						strThat = getUpperChineseDigit(0);
					}
				}
			}
		}
		//美圆等币别的.9应当为9拾分
		if (strChineseMoney.endsWith("拾")) {
			strChineseMoney = strChineseMoney + "分";
		}
		if (strChineseMoney.endsWith("圆")) {
			strChineseMoney = strChineseMoney + "整";
		}
		/* modify by liruijuan add begin 030909 */
		//reason:调整大写格式
		if (strChineseMoney.endsWith("角")) {
			strChineseMoney = strChineseMoney + "整";
		}
		/* modify by liruijuan add end 030909 */
		return strChineseMoney;
	}
	/**
	 * 获取数字的中文大写. <br>
	 * <br>
	 * <b>示例: </b>
	 * 
	 * <pre>
	 *  MoneyUtils.getUpperChineseDigit(int)(2); 返回 &quot;贰&quot;
	 * </pre>
	 * 
	 * @param iDigit 传入数字(0-9)
	 * @return 数字大写字符串
	 */
	public static String getUpperChineseDigit(int iDigit) {
		String strUpperChineseDigit = "";
		String strUpperChineseChar = "零壹贰叁肆伍陆柒捌玖";
		if (iDigit > 9)
			throw new IllegalArgumentException("金额超出范围");
		if (iDigit < 0)
			throw new IllegalArgumentException("金额不能为负");
		strUpperChineseDigit = strUpperChineseChar.substring(iDigit, iDigit + 1);
		return strUpperChineseDigit;
	}
	/**
	 * 获取不同币别下的中文大写计算单位. <br>
	 * <br>
	 * <b>示例: </b>
	 * 
	 * <pre>
	 *  MoneyUtils.getUpperChineseUnit(0,&quot;CNY&quot;); 返回 &quot;仟&quot;
	 * </pre>
	 * 
	 * @param iPoint 位置(从0开始)
	 * @param iCurrency 币别
	 * @return 传出单位字符串
	 */
	private static String getUpperChineseUnit(int iPoint, String iCurrency) {
		String strUpperChineseUnit = "";
		String strUpperChineseUnitChar = "";
		if (iPoint > 13)
			throw new IllegalArgumentException("金额超出范围");
		if (iPoint < 0)
			throw new IllegalArgumentException("金额不能为负");
		iCurrency = iCurrency.trim();
		if (iCurrency.equals("CNY")) //人民币
		{
			strUpperChineseUnitChar = "仟佰拾亿仟佰拾万仟佰拾圆角分";
		} else if (iCurrency.equals("HKD")) //港币
		{
			strUpperChineseUnitChar = "仟佰拾亿仟佰拾万仟佰拾圆角分";
		} else if (iCurrency.equals("JPY")) //日圆
		{
			strUpperChineseUnitChar = "仟佰拾亿仟佰拾万仟佰拾圆角分";
		} else if (iCurrency.equals("GBP")) //英镑
		{
			strUpperChineseUnitChar = "仟佰拾亿仟佰拾万仟佰拾镑先令便士";
		} else {
			strUpperChineseUnitChar = "仟佰拾亿仟佰拾万仟佰拾圆拾分";
		}
		strUpperChineseUnit = strUpperChineseUnitChar.substring(iPoint, iPoint + 1);
		return strUpperChineseUnit;
	}
	/**
	 * 英文数字大写. <br>
	 * <br>
	 * <b>示例: </b>
	 * 
	 * <pre>
	 *  MoneyUtils.getUpperEnglishDigit(2); 返回 &quot;TWO&quot;
	 * </pre>
	 * 
	 * @param iFee 传入数字(0-27)
	 * @return 英文数字大写字符串
	 */
	public static String getUpperEnglishDigit(int iFee) {
		//0~~~27
		String[] strTemp = {"ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT",
				"NINE", "TEN", "ELEVEN", "TWELVE", "THIRTEEN", "FOURTEEN", "FIFTEEN", "SIXTEEN",
				"SEVENTEEN", "EIGHTEEN", "NINETEEN", "TWENTY", "THIRTY", "FORTY", "FIFTY", "SIXTY",
				"SEVENTY", "EIGHTY", "NINETY"};
		if (iFee > 27 || iFee < 0)
			throw new IllegalArgumentException("Array index overflow!");
		return strTemp[iFee];
	}
	/**
	 * 截取数字某一部分(整数部分)（代替除法，如20000/100）
	 * 
	 * @param iFee 传入数字
	 * @param iLen 长度
	 * @return 整数部分 @
	 */
	private static double getInt(double iFee, int iLen) {
		String strFee = "";
		int index = 0;
		strFee = new DecimalFormat("0.00").format(iFee);
		index = strFee.indexOf(".");
		strFee = strFee.substring(0, index - iLen);
		return Double.parseDouble(strFee);
	}
	/**
	 * 截取数字某一部分(小数部分)（代替除法，如20000/100）
	 * 
	 * @param iFee 传入数字
	 * @param iLen 长度
	 * @return 小数部分 @
	 */
	private static double getDecimal(double iFee, int iLen) {
		String strFee = "";
		int index = 0;
		strFee = new DecimalFormat("0.00").format(iFee);
		index = strFee.indexOf(".");
		strFee = strFee.substring(index - iLen);
		return Double.parseDouble(strFee);
	}
	/**
	 * 数值转换，将数字0-99经算法转换到英文
	 * 
	 * @param iFee：传入数字
	 * @return 传出英文金额 @
	 */
	private static String format_99(int iFee) {
		String strOutFee = "";
		int i = 0;
		int j = 0;
		if (iFee > 0 && iFee < 100) {
			if (iFee <= 20) {
				strOutFee = getUpperEnglishDigit(iFee);
			} else {
				j = new Double(iFee / 10).intValue();
				strOutFee = getUpperEnglishDigit(j + 18);
				i = iFee - 10 * j;
				if (i != 0)
					strOutFee = strOutFee + " " + getUpperEnglishDigit(i);
			}
		} else {
			strOutFee = "";
		}
		return strOutFee;
	}
	/**
	 * 数值转换，将数字0-999经算法转换到英文
	 * 
	 * @param iFee：传入数字
	 * @return 传出英文金额 @
	 */
	private static String format_999(double iFee) {
		String strOutFee = "";
		int i = 0;
		int j = 0;
		if (iFee >= 0 && iFee < 1000) {
			i = new Double(iFee / 100).intValue();
			j = new Double(iFee).intValue() % 100;
			strOutFee = format_99(j);
			if (i != 0) {
				if (strOutFee.length() > 0) {
					if (!strOutFee.substring(0, 1).equals(" "))
						strOutFee = " AND " + strOutFee;
				}
				strOutFee = getUpperEnglishDigit(i) + " " + HUNDRED + strOutFee;
			}
		} else {
			strOutFee = "";
		}
		return strOutFee;
	}
	/**
	 * 将金额转化为英文
	 * 
	 * @param iFee：传入数字
	 * @return 传出英文金额 @
	 */
	private static String formatToEnglish(double iFee) {
		String strOutFee = "";
		String strTmpFee = "";
		if (iFee < 0) {
			strOutFee = formatToEnglish(-iFee);
			strOutFee = "MINUS " + strOutFee;
			return strOutFee; //add
		}
		if (iFee < 1) {
			strOutFee = ZERO;
			return strOutFee;
		}
		if (iFee >= ONE_BILLION) {
			strOutFee = formatToEnglish(getInt(iFee, 9));
			strTmpFee = formatToEnglish(getDecimal(iFee, 9));
			if (!strTmpFee.equals(ZERO)) {
				strTmpFee = " " + strTmpFee;
			}
			if (strTmpFee.indexOf(MILLION) > -1)
				strOutFee = strOutFee + " " + BILLION + strTmpFee;
			else
				strOutFee = strOutFee + " " + BILLION + " AND " + strTmpFee;
		} else if (iFee >= ONE_MILLION && iFee < ONE_BILLION) {
			strOutFee = format_999(getInt(iFee, 6));
			strTmpFee = formatToEnglish(getDecimal(iFee, 6));
			if (!strTmpFee.equals(ZERO)) {
				strTmpFee = " " + strTmpFee;
			}
			if (strTmpFee.indexOf(THOUSAND) > -1)
				strOutFee = strOutFee + " " + MILLION + strTmpFee;
			else
				strOutFee = strOutFee + " " + MILLION + " AND " + strTmpFee;
		} else if (iFee >= ONE_THOUSAND && iFee < ONE_MILLION) {
			strOutFee = format_999(getInt(iFee, 3));
			strTmpFee = formatToEnglish(getDecimal(iFee, 3));
			if (!strTmpFee.equals(ZERO)) {
				strTmpFee = " " + strTmpFee;
			}
			if (strTmpFee.indexOf(HUNDRED) > -1)
				strOutFee = strOutFee + " " + THOUSAND + strTmpFee;
			else
				strOutFee = strOutFee + " " + THOUSAND + " AND " + strTmpFee;
		} else if (iFee >= 1 && iFee < ONE_THOUSAND) {
			strOutFee = format_999(iFee);
		}
		return strOutFee;
	}
	/**
	 * 数字转换为英文. <br>
	 * <br>
	 * <b>示例: </b>
	 * 
	 * <pre>
	 *  MoneyUtils.toEnglish(382672.34d); 返回 &quot;THREE HUNDRED AND EIGHTY TWO THOUSAND SIX HUNDRED AND SEVENTY TWO AND CENTS THIRTY FOUR ONLY&quot;
	 *  MoneyUtils.toEnglish(382672d); 返回 &quot;THREE HUNDRED AND EIGHTY TWO THOUSAND SIX HUNDRED AND SEVENTY TWO ONLY&quot;
	 * </pre>
	 * 
	 * @param iFee 传入数字
	 * @return 传出大写金额
	 */
	public static String toEnglish(double iFee) {
		String strOutFee = "";
		String strFee = "";
		String strCent = "";
		String strTmpFee = "";
		int i = 0;
		if (iFee < 0) {
			throw new IllegalArgumentException("Money can not be negative!");
		}
		strFee = new DecimalFormat("0").format(iFee * 100);
		i = strFee.length();
		if (i > 14) {
			throw new IllegalArgumentException("Money exceeds its range(fourteen digits)!");
		}
		if (iFee == 0) {
			strOutFee = ZERO;
		}
		strCent = CENTS;
		//输出整数部分
		strOutFee = formatToEnglish(getInt(iFee, 0));
		//输出小数部分
		strTmpFee = formatToEnglish(DataUtils.round(getDecimal(iFee, 0) * 100,0));
		if (strTmpFee.equals(getUpperEnglishDigit(1))) //单数
			strCent = CENT;
		if (!strTmpFee.equals(ZERO)) //小数部分不为0
		{
			if (strOutFee.equals(ZERO)) //整数部分为0
				strOutFee = strTmpFee + " " + strCent;
			else
				//整数部分不为0
				strOutFee = strOutFee + " AND " + strCent + " " + strTmpFee;
		}
		strOutFee += " ONLY";
		return strOutFee;
	}
	/**
	 * 将int型的金额数值转化为英文大写金额. <br>
	 * <br>
	 * <b>示例: </b>
	 * 
	 * <pre>
	 *  MoneyUtils.toEnglish(2000); 返回 &quot;TWO THOUSAND AND ZERO ONLY&quot;
	 * </pre>
	 * 
	 * @param iFee int型的金额数值
	 * @return 返回英文大写金额
	 */
	public static String toEnglish(int iFee) {
		return toEnglish((double) iFee);
	}
	/**
	 * 将long型的金额数值转化为英文大写金额. <br>
	 * <br>
	 * <b>示例: </b>
	 * 
	 * <pre>
	 *  MoneyUtils.toEnglish(5030000000L); 返回 &quot;FIVE BILLION THIRTY MILLION AND ZERO ONLY&quot;
	 * </pre>
	 * 
	 * @param iFee long型的金额数值
	 * @return 返回英文大写金额
	 */
	public static String toEnglish(long iFee) {
		return toEnglish((double) iFee);
	}
	/**
	 * 转换成财务计数形式. <br>
	 * <b>示例: </b>
	 * 
	 * <pre>
	 *  MoneyUtils.toAccount(&quot;50300000.005&quot;); 返回 &quot;50300000.01&quot;
	 * </pre>
	 * 
	 * @param strMoney 钱数
	 * @return formatMoney 返回财务计数形式的钱数
	 */
	public static String toAccount(String strMoney) {
		String formatMoney = "";
		DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
		formatMoney = decimalFormat.format(DataUtils.round(Double.valueOf(strMoney).doubleValue(),2));
		return formatMoney;
	}
}