package com.me.demo.util;

import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 * Request参数工具类
 */
public class ParamUtils {

	private HttpServletRequest request;

	/**
	 * 获取参数
	 * 
	 * @param name
	 *            参数名称
	 * @return 参数值
	 */
	public String getParameter(String name) throws ServletException {
		return request.getParameter(name);

	}

	/**
	 * 获取一个int型的参数.
	 * 
	 * @param name
	 *            参数名称
	 * @param defaultNum
	 *            默认的数值
	 * @return int型参数值
	 */
	public int getIntParameter(String name, int defaultNum)
			throws ServletException {
		String temp = getParameter(name);
		if (temp != null && !temp.equals("")) {
			int num = defaultNum;
			try {
				num = Integer.parseInt(correctNumber(temp));
			} catch (Exception ignored) {
				System.out.println("===ParamUtils.getIntParameter exception:"
						+ ignored.getMessage());
			}
			return num;
		}
		return defaultNum;
	}

	/**
	 * 获取一个long型的参数.
	 * 
	 * @param name
	 *            参数名称
	 * @param defaultNum
	 *            默认的数值
	 * @return int型参数值
	 */
	public long getLongParameter(String name, long defaultNum)
			throws ServletException {
		String temp = getParameter(name);
		if (temp != null && !temp.equals("")) {
			long num = defaultNum;
			try {
				num = Long.parseLong(correctNumber(temp));
			} catch (Exception ignored) {
				System.out.println("===ParamUtils.getLongParameter exception:"
						+ ignored.getMessage());
			}
			return num;
		}
		return defaultNum;
	}

	/**
	 * 获取一个double型的参数.
	 * 
	 * @param name
	 *            参数名称
	 * @param defaultNum
	 *            默认的数值
	 * @return double型参数值
	 */
	public double getDoubleParameter(String name, double defaultNum)
			throws ServletException {
		String temp = getParameter(name);
		if (temp != null && !temp.equals("")) {
			double num = defaultNum;
			try {
				num = Double.parseDouble(correctNumber(temp));
			} catch (Exception ignored) {
				System.out
						.println("===ParamUtils.getDoubleParameter exception:"
								+ ignored.getMessage());
			}
			return num;
		}
		return defaultNum;
	}

	/**
	 * 获取int型数组
	 * 
	 * @param name
	 *            参数名称
	 * @param defaultNum
	 *            默认的数值
	 * @return int型数组
	 * @throws ServletException
	 */
	public int[] getIntParameterValues(String name, int defaultNum)
			throws ServletException {
		String[] paramValues = getParameterValues(name);
		if (paramValues == null) {
			return null;
		}
		int paramValuesCount = paramValues.length;
		if (paramValuesCount < 1) {
			return new int[0];
		}
		int[] values = new int[paramValuesCount];
		for (int i = 0; i < paramValuesCount; i++) {
			try {
				values[i] = Integer.parseInt(correctNumber(paramValues[i]));
			} catch (Exception e) {
				values[i] = defaultNum;
			}
		}
		return values;
	}

	/**
	 * 获取long型数组
	 * 
	 * @param name
	 *            参数名称
	 * @param defaultNum
	 *            默认的数值
	 * @return int型数组
	 * @throws ServletException
	 */
	public long[] getLongParameterValues(String name, long defaultNum)
			throws ServletException {
		String[] paramValues = getParameterValues(name);
		if (paramValues == null) {
			return null;
		}
		int paramValuesCount = paramValues.length;
		if (paramValuesCount < 1) {
			return new long[0];
		}
		long[] values = new long[paramValuesCount];
		for (int i = 0; i < paramValuesCount; i++) {
			try {
				values[i] = Long.parseLong(correctNumber(paramValues[i]));
			} catch (Exception e) {
				values[i] = defaultNum;
			}
		}
		return values;
	}

	/**
	 * 获取double型数组
	 * 
	 * @param name
	 *            参数名称
	 * @param defaultNum
	 *            默认的数值
	 * @return double型数组
	 * @throws ServletException
	 */
	public double[] getDoubleParameterValues(String name, double defaultNum)
			throws ServletException {
		String[] paramValues = getParameterValues(name);
		if (paramValues == null) {
			return null;
		}
		int paramValuesCount = paramValues.length;
		if (paramValuesCount < 1) {
			return new double[0];
		}
		double[] values = new double[paramValuesCount];
		for (int i = 0; i < paramValuesCount; i++) {
			try {
				values[i] = Double.parseDouble(correctNumber(paramValues[i]));
			} catch (Exception e) {
				values[i] = defaultNum;
			}
		}
		return values;
	}

	/**
	 * 获取参数
	 * 
	 * @param name
	 *            参数名称
	 * @return
	 */
	public String[] getParameterValues(String name) throws ServletException {

		return request.getParameterValues(name);
	}

	/**
	 * 修正数字（如千分位的数字把千分位字符去掉）
	 * 
	 * @param numberString
	 *            原始数字串
	 * @return 修正后的数字串
	 */
	private synchronized String correctNumber(String numberString) {
		String value = numberString;
		if (value != null && !value.equals("")) {
			value = StringUtils.replace(value, ",", "");
		}
		return value;
	}

	/**
	 * @param cl
	 *            要封装的DTO的Class对象。
	 * @param inputPrefix
	 *            输入域的前缀，一般是DTO的类名。
	 * @throws Exception
	 *             如果通过cl参数创建DTO对象失败，将抛出InstantiationException异常。
	 */
	public Object generateObject(Class cl, String inputPrefix) throws Exception {
		Object object = cl.newInstance();
		// 获取所有set方法
		List methodList = ObjectUtils.getSetter(cl);

		int methodLength = methodList.size();
		for (int i = 0; i < methodLength; i++) {
			Method method = (Method) methodList.get(i);
			if (method.getName().endsWith("Object_OrderBy")
					|| method.getName().endsWith("Object_Condition")) {
				method.invoke(object, new Object[] { "" });
				continue;
			}
			String fieldName = method.getName().substring(3);
			String stripped = fieldName; // stripped存储实际的Input字段名
			// 如果有前缀则Input字段名添加前缀
			if (inputPrefix != null && inputPrefix.trim().length() > 0) {
				stripped = inputPrefix
						+ StringUtils.upperCaseFirstChar(fieldName);
			}

			Object parameterValue = request.getParameter(stripped);

			try {
				Class parameterType = method.getParameterTypes()[0];
				// 如果Input域在request不存在则设置为空并继续
				if (parameterValue == null) {
					if (parameterType.isPrimitive()) {
						
					} else {
						method.invoke(object, new Object[] { null });
					}
				} else {
					String valueString = (String) parameterValue;
					valueString = StringUtils.rightTrim(valueString);

					// 日期值的特殊处理
					if (parameterType == Timestamp.class) {

						DateTime d = getDateTime(valueString);
						if (d == null) {
							parameterValue = null;
						} else {
							parameterValue = new Timestamp(d.getTime());
						}
					} else if (parameterType == Date.class) {

						DateTime d = getDateTime(valueString);
						if (d == null) {
							parameterValue = null;
						} else {
							parameterValue = d;
						}
					} else if (parameterType == Double.class) {
						if (valueString == null || valueString.equals("")) {
							parameterValue = null;
						} else
							parameterValue = Double
									.valueOf(correctNumber(valueString));
					} else if (parameterType == Long.class) {
						if (valueString == null || valueString.equals("")) {
							parameterValue = null;
						} else
							parameterValue = Long
									.valueOf(correctNumber(valueString));
					} else if (parameterType == Integer.class) {
						if (valueString == null || valueString.equals("")) {
							parameterValue = null;
						} else {
							parameterValue = Integer
									.valueOf(correctNumber(valueString));
						}
					}

					method.invoke(object, new Object[] { parameterValue });
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return object;
	}

	/**
	 * @see <p>
	 *      generateList(Class cl, String inputPrefix, int startIndex)
	 *      </p>
	 *      <p>
	 *      这个方法默认的起始行号是1。
	 *      </p>
	 * @param cl
	 *            要封装的DTO的Class对象。
	 * @param inputPrefix
	 *            输入域的前缀，一般是DTO的类名。
	 * @return 封装好的DTO集合。
	 * @throws Exception
	 */
	public List generateList(Class cl, String inputPrefix) throws Exception {
		return generateList(cl, inputPrefix, 1);
	}

	/**
	 * @param cl
	 *            要封装的DTO的Class对象。
	 * @param inputPrefix
	 *            输入域的前缀，一般是DTO的类名。
	 * @param startIndex
	 *            要封装的多行输入域的起始行号。 <br>
	 *            对于多行输入域来讲，一般起始行号是1，因为第0行多行输入域的隐藏部分("_Data"部分)；对于普通的多行输入的情况，
	 *            起始行号是0。 通过这个参数可以自定义起始行号。
	 * @return 封装好的DTO集合。
	 * @throws Exception
	 *             如果通过cl参数创建DTO对象失败，将抛出InstantiationException异常。
	 */
	public List generateList(Class cl, String inputPrefix, int startIndex)
			throws Exception {
		List resultList = new ArrayList();
		// 获取所有set方法
		List methodList = ObjectUtils.getSetter(cl);
		// 存储所有Object对象的Map,Key为序号
		TreeMap treeMap = new TreeMap();
		if (startIndex < 0) {
			startIndex = 0;
		}
		int methodLength = methodList.size();
		for (int i = 0; i < methodLength; i++) {
			Method method = (Method) methodList.get(i);
			String fieldName = method.getName().substring(3);
			String stripped = fieldName;
			if (inputPrefix != null && inputPrefix.trim().length() > 0) {
				stripped = inputPrefix
						+ StringUtils.upperCaseFirstChar(fieldName);
			}
			Object[] parameterValue = request.getParameterValues(stripped);
			if (parameterValue != null) {
				for (int j = startIndex; j < parameterValue.length; j++) {
					Object object = cl.newInstance();
					treeMap.put(new Integer(j), object);
				}
				break;
			}
		}
		// 如果treeMap为空，表示没有数据
		if (treeMap.isEmpty()) {
			return resultList;
		}
		HashSet treeKeySet = new HashSet();
		for (int i = 0; i < methodLength; i++) {
			Method method = (Method) methodList.get(i);
			if (method.getName().endsWith("Object_OrderBy")
					|| method.getName().endsWith("Object_Condition")) {
				continue;
			}
			String fieldName = method.getName().substring(3);
			String stripped = fieldName;
			if (inputPrefix != null && inputPrefix.trim().length() > 0) {
				stripped = inputPrefix
						+ StringUtils.upperCaseFirstChar(fieldName);
			}

			Object[] parameterValue = request.getParameterValues(stripped);
			if (parameterValue == null) {
				continue;
			}
			for (int j = startIndex; j < parameterValue.length; j++) {
				try {
					Class parameterType = method.getParameterTypes()[0];

					Object object = treeMap.get(new Integer(j));
					if (object != null) {
						// 如果Input域在request不存在则设置为空并继续
						if (parameterValue == null) {
							if (parameterType.isPrimitive()) {
								
							} else {
								method.invoke(object, new Object[] { null });
							}
						} else {
							Object value = parameterValue[j];
							String valueString = (String) value;
							valueString = StringUtils.rightTrim(valueString);
							if (parameterType == Timestamp.class) {
								DateTime d = getDateTime(valueString);
								if (d == null) {
									value = null;
								} else {
									value = new Timestamp(d.getTime());
								}
							} else if (parameterType == Date.class) {
								DateTime d = getDateTime(valueString);
								if (d == null) {
									value = null;
								} else {
									value = d;
								}
							} else if (parameterType == Double.class) {
								if (valueString == null
										|| valueString.equals("")) {
									value = null;
								} else {
									value = Double
											.valueOf(correctNumber(valueString));
								}
							} else if (parameterType == Long.class) {
								if (valueString == null
										|| valueString.equals("")) {
									value = null;
								} else {
									value = Long
											.valueOf(correctNumber(valueString));
								}
							} else if (parameterType == Integer.class) {
								if (valueString == null
										|| valueString.equals("")) {
									value = null;
								} else {
									value = Integer
											.valueOf(correctNumber(valueString));
								}
							}
							method.invoke(object, new Object[] { value });
						}
						if (!treeKeySet.contains(new Integer(j))) {
							resultList.add(object);
							treeKeySet.add(new Integer(j));
						}
					}
				} catch (Exception e) {
					System.out.println("===ParamUtils.generateList exception:"
							+ e.getMessage());
				}
			}
		}
		return resultList;
	}

	public DateTime getDateTime(String value) {
		DateTime d = null;
		if (value.trim().length() == 0) {
			return d;
		}
		try {
			d = new DateTime(value, DateTime.YEAR_TO_MILLISECOND);
		} catch (IllegalArgumentException e1) {
			try {
				d = new DateTime(value, DateTime.YEAR_TO_SECOND);
			} catch (IllegalArgumentException e2) {
				try {
					d = new DateTime(value, DateTime.YEAR_TO_HOUR);
				} catch (IllegalArgumentException e3) {
					try {
						d = new DateTime(value, DateTime.YEAR_TO_DAY);
					} catch (IllegalArgumentException e4) {
					}
				}
			}
		}
		return d;
	}
}