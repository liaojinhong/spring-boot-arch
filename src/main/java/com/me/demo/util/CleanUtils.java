package com.me.demo.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 清理日志的小工具
 * 包括文件读写，递归算法等
 * 
 * @author ljh
 * 
 */
public class CleanUtils {

	/**
	 * 清理源代码的日志
	 * 
	 * @param directory
	 */
	public static void cleanSystemOutPrint(String directory) {
		String logStr = "System.out.println"; // 指定日志内容
		try {
			File file = new File(directory);
			if (!file.exists()) {
				System.out.println("文件不存在!");
				return;
			}
			
			File[] files = file.listFiles();
			if (files.length == 0) {
				System.out.println("文件夹是空的!");
				return;
			} else {
				for (File tempFile : files) {
					if (tempFile.isDirectory()) {
						System.out.println("文件夹：" + tempFile.getAbsolutePath());
						// 递归调用
						cleanSystemOutPrint(tempFile.getAbsolutePath()); 
					} else {
						System.out.println("文件：" + tempFile.getAbsolutePath());
						if (tempFile.canWrite() == false) {
							System.out.println("文件没有写入权限：" + tempFile.getAbsolutePath());
							continue;
						}
						// 读取文件
						BufferedReader reader = new BufferedReader(
								new InputStreamReader(new FileInputStream(
										tempFile)));
						List<String> tempList = new ArrayList<String>();
						String readLine = reader.readLine();
						boolean isChange = false;
						// 逐行遍历文件内容
						for (; readLine != null; readLine = reader.readLine()) {
							// 判断本行内容是否包含日志信息
							if (readLine.contains(logStr)) {
								isChange = true;
								continue;
							}
							tempList.add(readLine);
						}
						if(isChange){
							System.out.println("文件被修改：" + tempFile.getAbsolutePath());
							// 写入文件（覆盖）
							PrintWriter writer = new PrintWriter(
									new BufferedWriter(new FileWriter(tempFile)));
							for (int k = 0; k < tempList.size(); k++) {
								writer.println(tempList.get(k));
							}
							writer.close();
							
						}
						reader.close();
						
					}
				}
			}
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
	
	/**
	 * 统计文件夹下面的所有文件内容中，包含多少个英文字母、数字、空格和其他字符
	 * 
	 * @param directory
	 */
	public static Map countFile(String directory) {
		Map map = new HashMap();

		int letterCount = 0; // 英文字母个数
		int blankCount = 0; // 空格个数
		int numCount = 0; // 数字个数
		int otherCount = 0; // 其他字符个数
		try {
			File file = new File(directory);
			if (!file.exists()) {
				System.out.println("文件不存在!");
				return null;
			}
			
			File[] files = file.listFiles();
			if (files.length == 0) {
				System.out.println("文件夹是空的!");
				return null;
			} else {
				for (File tempFile : files) {
					if (tempFile.isDirectory()) {
						// 递归调用
						countFile(tempFile.getAbsolutePath()); 
					} else {
						if (tempFile.canWrite() == false) {
							continue;
						}
						// 读取文件
						BufferedReader reader = new BufferedReader(
								new InputStreamReader(new FileInputStream(
										tempFile)));
						String readLine = reader.readLine();
						// 逐行遍历文件内容
						for (; readLine != null; readLine = reader.readLine()) {
							map = StringUtils.countStr(readLine);
							letterCount = letterCount + (Integer)map.get("letter");
							blankCount = blankCount + (Integer)map.get("blank");
							numCount = numCount + (Integer)map.get("num");
							otherCount = otherCount + (Integer)map.get("other");
						}
						System.out.println("文件：" + tempFile.getAbsolutePath());
						System.out.println("英文字母个数="+letterCount);
						System.out.println("空格个数="+blankCount);
						System.out.println("数字个数="+numCount);
						System.out.println("其他字符个数="+otherCount);
						reader.close();
						
					}
				}
			}
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		
		return map;
	}

	/**
	 * 用递归方法遍历文件夹
	 * 
	 * @param path
	 */
	public static void traverseFolder(String path) {
		File file = new File(path);
		if (file.exists()) {
			File[] files = file.listFiles();
			if (files.length == 0) {
				System.out.println("文件夹是空的!");
				return;
			} else {
				for (File tempFile : files) {
					if (tempFile.isDirectory()) {
						System.out.println("文件夹：" + tempFile.getAbsolutePath());
						// 递归调用
						traverseFolder(tempFile.getAbsolutePath());
					} else {
						System.out.println("文件：" + tempFile.getAbsolutePath());
					}
				}
			}

		} else {
			System.out.println("文件不存在!");
		}

	}

	public static void main(String[] args) {
		String path = "D:\\utils";
		// 遍历文件夹
		// traverseFolder(path);
		// 清理日志、、
		//cleanSystemOutPrint(path);
		// 统计字符串、、
		countFile(path);

	}
}
