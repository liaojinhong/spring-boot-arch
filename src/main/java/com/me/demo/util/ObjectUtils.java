package com.me.demo.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

/**
 * 对象工具类
 * 
 * @author ljh
 * 
 */
public final class ObjectUtils {

	/**
	 * 默认构造函数,禁止实例化
	 */
	private ObjectUtils() {
	}

	/**
	 * Returns the classname without the package. Example: If the input class is
	 * java.lang.String than the return value is String.
	 * 
	 * @param cl
	 *            The class to inspect
	 * @return The classname
	 */
	public static String getClassNameWithoutPackage(Class cl) {
		String className = cl.getName();
		int pos = className.lastIndexOf('.') + 1;
		if (pos == -1)
			pos = 0;
		String name = className.substring(pos);
		return name;
	}

	public static void main(String[] args) {
		String className = "";
		if (args.length > 0)
			className = args[0];
		else
			className = JOptionPane
					.showInputDialog("Input class name (e.g. java.util.Date): ");
		try {
			Class cl = Class.forName(className);
			Class supercl = cl.getSuperclass();
			System.out.print(Modifier.toString(cl.getModifiers()));
			System.out.print(" class " + className);
			if (supercl != null && supercl != Object.class)
				System.out.println(" extends " + supercl.getName());
			System.out.println("\n{\n");
			printConstructors(cl);
			System.out.println();
			printMethods(cl);
			System.out.println();
			printFields(cl);
			System.out.println();
			System.out.println("}");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.exit(0);
	}

	public static void printConstructors(Class cl) {
		System.out.println("    //Constructors");
		Constructor[] constructors = cl.getDeclaredConstructors();
		for (int i = 0; i < constructors.length; i++) {
			System.out.print("    "
					+ Modifier.toString(constructors[i].getModifiers()));
			System.out.print(" " + constructors[i].getName() + "(");
			Class[] paramTypes = constructors[i].getParameterTypes();
			for (int j = 0; j < paramTypes.length; j++) {
				if (j > 0)
					System.out.print(", ");
				System.out.print(paramTypes[j].getName());
			}
			System.out.print(")");
			Class[] exceptions = constructors[i].getExceptionTypes();
			for (int j = 0; j < exceptions.length; j++) {
				if (j == 0)
					System.out.print("throws ");
				else if (j > 0)
					System.out.print(", ");
				System.out.print(exceptions[j].getName());
			}
			System.out.println(";");
		}
	}

	public static void printMethods(Class cl) {
		System.out.println("    //Methods");
		Method[] methods = cl.getDeclaredMethods();
		for (int i = 0; i < methods.length; i++) {
			System.out.print("    "
					+ Modifier.toString(methods[i].getModifiers()));
			System.out.print(" " + methods[i].getReturnType() + " "
					+ methods[i].getName() + "(");
			Class[] paramTypes = methods[i].getParameterTypes();
			for (int j = 0; j < paramTypes.length; j++) {
				if (j > 0)
					System.out.print(", ");
				System.out.print(paramTypes[j].getName());
			}
			System.out.print(")");
			Class[] exceptions = methods[i].getExceptionTypes();
			for (int j = 0; j < exceptions.length; j++) {
				if (j == 0)
					System.out.print("throws ");
				else if (j > 0)
					System.out.print(", ");
				System.out.print(exceptions[j].getName());
			}
			System.out.println(";");
		}
	}

	public static void printFields(Class cl) throws Exception {
		System.out.println("    //Fields");
		Object o = new Double(100);
		Field f = null;
		Field[] fields = cl.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			System.out.print("    "
					+ Modifier.toString(fields[i].getModifiers()));
			System.out.print(" " + fields[i].getType() + " "
					+ fields[i].getName());
			f = cl.getField(fields[i].getName());
			System.out.print(" = " + f.get(o));
			System.out.println(";");
		}
	}

	public static Object invoke(String className, String methodName,
			Class[] argsClass, Object[] args) throws ClassNotFoundException,
			SecurityException, NoSuchMethodException, IllegalArgumentException,
			IllegalAccessException, InvocationTargetException,
			InstantiationException {
		Object object;
		Class cl = Class.forName(className);
		Method method = cl.getDeclaredMethod(methodName, argsClass);
		object = method.invoke(cl.newInstance(), args);
		return object;
	}

	public static Object invoke(Object oldObject, String methodName,
			Class[] argsClass, Object[] args) throws SecurityException,
			NoSuchMethodException, IllegalArgumentException,
			IllegalAccessException, InvocationTargetException {
		Class cl = oldObject.getClass();
		Method method = cl.getDeclaredMethod(methodName, argsClass);
		Object object = method.invoke(oldObject, args);
		return object;
	}

	public static String[] getFieldsName(Class cl) throws Exception {
		String[] fieldNames = new String[0];
		Object o = new Double(100);
		Field f = null;
		Field[] fields = cl.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			System.out.print("    "
					+ Modifier.toString(fields[i].getModifiers()));
			System.out.print(" " + fields[i].getType() + " "
					+ fields[i].getName());
			f = cl.getField(fields[i].getName());
			System.out.print(" = " + f.get(o));
			System.out.println(";");
		}
		return fieldNames;
	}

	public static List getAllFieldName(Class cl) {
		List list = new ArrayList();
		Field[] fields = cl.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			if (field.getName().equals("serialVersionUID")) {
				continue;
			}
			list.add(field.getName());
		}
		while (true) {
			cl = cl.getSuperclass();
			if (cl == Object.class) {
				break;
			}
			list.addAll(getAllFieldName(cl));
		}
		return list;
	}

	public static List getSetter(Class cl) {
		List list = new ArrayList();
		Method[] methods = cl.getDeclaredMethods();
		for (int i = 0; i < methods.length; i++) {
			Method method = methods[i];
			String methodName = method.getName();
			if (!methodName.startsWith("set")) {
				continue;
			}
			list.add(method);
		}
		while (true) {
			cl = cl.getSuperclass();
			if (cl == Object.class) {
				break;
			}
			list.addAll(getSetter(cl));
		}
		return list;
	}

	public static List getGetter(Class cl) {
		List list = new ArrayList();
		Method[] methods = cl.getDeclaredMethods();
		for (int i = 0; i < methods.length; i++) {
			Method method = methods[i];
			String methodName = method.getName();
			if (!methodName.startsWith("get") && !methodName.startsWith("is")) {
				continue;
			}
			list.add(method);
		}
		while (true) {
			cl = cl.getSuperclass();
			if (cl == Object.class) {
				break;
			}
			list.addAll(getGetter(cl));
		}
		return list;
	}
}