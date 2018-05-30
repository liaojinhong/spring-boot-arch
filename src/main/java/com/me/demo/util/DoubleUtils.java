package com.me.demo.util;
import java.math.BigDecimal;

import net.sf.cglib.transform.impl.AddDelegateTransformer;

/**
 * 该类型提供Double类型的 + - *  / 四规则运算的精确计算
 * <p>注：在运算时,如果@param==null,则会按0进行处理运算,scale默认按{@link #DEFAULT_SCALE}处理
 * @see 加：{@link #add(Number value1, Number value2)}
 * @see 减：{@link #sub(Number value1, Number value2)}
 * @see 乘：{@link #mul(Number value1, Number value2)}
 * @see 除：{@link #div(Double dividend, Double divisor, Integer scale)}
 * @see 四舍五入:{@link #round(Double value, Integer scale)}
 * @author admin
 *
 */
public class DoubleUtils {
	
	public static void main(String[] args) {
		Double d1 = 0.800001;
		Double d2 = 1.200001;
		//4231.90 * 45 /100
		Double result = null;
		//加
		result = sub(d1,d2);
		
		System.out.println(result);
		System.out.println(d1-d2);
		
	}

	/**
	 * 小数位默认取2位
	 */
	private static final Integer DEFAULT_SCALE = 2;

	/**
	 * 提供精确的加法运算。
	 * @param value1 被加数
	 * @param value2 加数
	 * @return 两个参数的和
	 */
	public static Double add(Number value1, Number value2) {
		if(value1==null) value1 = 0;
		if(value2==null) value2 = 0;
		BigDecimal b1 = new BigDecimal(Double.toString(value1.doubleValue()));
		BigDecimal b2 = new BigDecimal(Double.toString(value2.doubleValue()));
		return b1.add(b2).doubleValue();
	}

	/**
	 * 提供精确的减法运算。
	 * 
	 * @param value1 被减数
	 * @param value2 减数
	 * @return 两个参数的差
	 */
	public static Double sub(Number value1, Number value2) {
		if(value1==null) value1 = 0;
		if(value2==null) value2 = 0;
		BigDecimal b1 = new BigDecimal(Double.toString(value1.doubleValue()));
		BigDecimal b2 = new BigDecimal(Double.toString(value2.doubleValue()));
		return b1.subtract(b2).doubleValue();
	}

	/**
	 * 提供精确的乘法运算。
	 * 
	 * @param value1 被乘数
	 * @param value2  乘数
	 * @return 两个参数的积
	 */
	public static Double mul(Number value1, Number value2) {
		if(value1==null) value1 = 0;
		if(value2==null) value2 = 0;
		BigDecimal b1 = new BigDecimal(Double.toString(value1.doubleValue()));
		BigDecimal b2 = new BigDecimal(Double.toString(value2.doubleValue()));
		return b1.multiply(b2).doubleValue();
	}

	/**
	 * 提供（相对）精确的除法运算 
	 * @param dividend 被除数
	 * @param divisor  除数
	 * @return 两个参数的商
	 * 
	 * @see {@link #DEFAULT_SCALE}
	 */
	public static Double div(Number dividend, Number divisor) {
		return div(dividend, divisor, DEFAULT_SCALE);
	}

	/**
	 * 提供（相对）精确的除法运算。 
	 * 
	 * @param dividend 被除数
	 * @param divisor 除数
	 * @param scale 表示表示需要精确到小数点以后几位。
	 * @return 两个参数的商
	 */
	public static Double div(Number dividend, Number divisor, Integer scale) {
		if(dividend==null) return  0D;
		if(divisor ==null || divisor.doubleValue() == 0){
			throw new IllegalArgumentException(
					"The divisor cannot be zero or null !");
		}
		
		if(scale == null) scale = DEFAULT_SCALE;
		
		if (scale < 0) {
			throw new IllegalArgumentException(
					"The scale must be a positive integer or zero");
		}
		BigDecimal b1 = new BigDecimal(Double.toString(dividend.doubleValue()));
		BigDecimal b2 = new BigDecimal(Double.toString(divisor.doubleValue()));
		return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	/**
	 * 提供精确的小数位四舍五入处理。
	 * 
	 * @param value 需要四舍五入的数字
	 * @return 四舍五入后的结果
	 * 
	 * @see {@link #DEFAULT_SCALE}
	 */
	public static Double round(Double value){
		return round(value,DEFAULT_SCALE);
	}

	/**
	 * 提供精确的小数位四舍五入处理。
	 * 
	 * @param value 需要四舍五入的数字
	 * @param scale 小数点后保留几位
	 * @return 四舍五入后的结果
	 */
	public static Double round(Double value, Integer scale) {
		if(value == null) return 0D;
		
		if(scale == null) scale = DEFAULT_SCALE;
		
		if (scale < 0) {
			throw new IllegalArgumentException(
					"The scale must be a positive integer or zero");
		}
		BigDecimal b = new BigDecimal(Double.toString(value));
		return b.divide(BigDecimal.ONE, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
}
