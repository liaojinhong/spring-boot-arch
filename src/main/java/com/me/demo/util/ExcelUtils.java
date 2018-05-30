/*
 * Excel工具类
 */
package com.me.demo.util;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;


public class ExcelUtils {
    /**
     * 从Excel文件得到二维数组，每个sheet的第一行为标题
     * 
     * @param file Excel文件
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static String[][] getData(File file) throws FileNotFoundException,
            IOException {
        return getData(file, 1);
    }

    /**
     * 从Excel文件得到二维数组
     * 
     * @param file Excel文件
     * @param ignoreRows 忽略的行数，通常为每个sheet的标题行数
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static String[][] getData(File file, int ignoreRows)
            throws FileNotFoundException, IOException {
        ArrayList result = new ArrayList();
        int rowSize = 0;
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(
                file));
        // 打开HSSFWorkbook        
        POIFSFileSystem fs = new POIFSFileSystem(in);
        HSSFWorkbook wb = new HSSFWorkbook(fs);
        HSSFCell cell = null;
        for (int sheetIndex = 0; sheetIndex < wb.getNumberOfSheets(); sheetIndex++) {
            HSSFSheet st = wb.getSheetAt(sheetIndex); 
            // 第一行为标题，不取
            for (int rowIndex = ignoreRows; rowIndex <= st.getLastRowNum(); rowIndex++) {
                HSSFRow row = st.getRow(rowIndex);
                if (row == null) {
                    continue;
                }
                int tempRowSize = row.getLastCellNum() + 1;
                if (tempRowSize > rowSize) {
                    rowSize = tempRowSize;
                }
                String[] values = new String[rowSize];
                Arrays.fill(values, "");
                boolean hasValue = false;
                for (short columnIndex = 0; columnIndex <= row.getLastCellNum(); columnIndex++) {
                    String value = "";
                    cell = row.getCell(columnIndex);
                    if (cell != null) {
                        // 注意：一定要设成这个，否则可能会出现乱码
                        cell.setEncoding(HSSFCell.ENCODING_UTF_16);
                        switch (cell.getCellType()) {
                        case HSSFCell.CELL_TYPE_STRING:
                            value = cell.getStringCellValue();
                            break;
                        case HSSFCell.CELL_TYPE_NUMERIC:
                            if (HSSFDateUtil.isCellDateFormatted(cell)) {
                                Date date = cell.getDateCellValue();
                                if (date != null) {
                                    value = new SimpleDateFormat("yyyy-MM-dd")
                                            .format(date);
                                } else {
                                    value = "";
                                }
                            } else {
                                value = new DecimalFormat("##########0.#########").format(cell
                                        .getNumericCellValue());
                            }
                            break;
                        case HSSFCell.CELL_TYPE_FORMULA:
                            // 导入时如果为公式生成的数据则无值
                            if (!cell.getStringCellValue().equals("")) {
                                value = cell.getStringCellValue();
                            } else {
                                value = cell.getNumericCellValue() + "";
                            }
                            break;
                        case HSSFCell.CELL_TYPE_BLANK:
                            break;
                        case HSSFCell.CELL_TYPE_ERROR:
                            value = "";
                            break;
                        case HSSFCell.CELL_TYPE_BOOLEAN:
                            value = (cell.getBooleanCellValue() == true ? "Y"
                                    : "N");
                            break;
                        default:
                            value = "";
                        }
                    }
                    if (columnIndex == 0 && value.trim().equals("")) {
                        break;
                    }
                    values[columnIndex] = StringUtils.rightTrim(value);
                    hasValue = true;
                }

                if (hasValue) {
                    result.add(values);
                }
            }
        }
        in.close();
        String[][] returnArray = new String[result.size()][rowSize];
        for (int i = 0; i < returnArray.length; i++) {
            returnArray[i] = (String[]) result.get(i);
        }
        return returnArray;
    }
    
    /**
     * 解析一个Excel文件的某个特定的sheet
     * sheet号码从1开始
     * 
     * @param file excel文件
     * @param ignoreRows	忽略的行数
     * @param index	sheet的页码
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static String[][] getData(File file, int ignoreRows, int index)
			throws FileNotFoundException, IOException
	{
		ArrayList result = new ArrayList();
		int rowSize = 0;
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(
				file));
		// 打开HSSFWorkbook        
		POIFSFileSystem fs = new POIFSFileSystem(in);
		HSSFWorkbook wb = new HSSFWorkbook(fs);
		HSSFCell cell = null;
		HSSFSheet st = wb.getSheetAt(index - 1);
		// 第一行为标题，不取
		for (int rowIndex = ignoreRows; rowIndex <= st.getLastRowNum(); rowIndex++)
		{
			HSSFRow row = st.getRow(rowIndex);
			if (row == null)
			{
				continue;
			}
			int tempRowSize = row.getLastCellNum() + 1;
			if (tempRowSize > rowSize)
			{
				rowSize = tempRowSize;
			}
			String[] values = new String[rowSize];
			Arrays.fill(values, "");
			boolean hasValue = false;
			for (short columnIndex = 0; columnIndex <= row.getLastCellNum(); columnIndex++)
			{
				String value = "";
				cell = row.getCell(columnIndex);
				if (cell != null)
				{
					// 注意：一定要设成这个，否则可能会出现乱码
					cell.setEncoding(HSSFCell.ENCODING_UTF_16);
					switch (cell.getCellType())
					{
					case HSSFCell.CELL_TYPE_STRING:
						value = cell.getStringCellValue();
						break;
					case HSSFCell.CELL_TYPE_NUMERIC:
						if (HSSFDateUtil.isCellDateFormatted(cell))
						{
							Date date = cell.getDateCellValue();
							if (date != null)
							{
								value = new SimpleDateFormat("yyyy-MM-dd")
										.format(date);
							}
							else
							{
								value = "";
							}
						}
						else
						{
							value = new DecimalFormat("0").format(cell
									.getNumericCellValue());
						}
						break;
					case HSSFCell.CELL_TYPE_FORMULA:
						// 导入时如果为公式生成的数据则无值
						if (!cell.getStringCellValue().equals(""))
						{
							value = cell.getStringCellValue();
						}
						else
						{
							value = cell.getNumericCellValue() + "";
						}
						break;
					case HSSFCell.CELL_TYPE_BLANK:
						break;
					case HSSFCell.CELL_TYPE_ERROR:
						value = "";
						break;
					case HSSFCell.CELL_TYPE_BOOLEAN:
						value = (cell.getBooleanCellValue() == true ? "Y" : "N");
						break;
					default:
						value = "";
					}
				}
				if (columnIndex == 0 && value.trim().equals(""))
				{
					break;
				}
				values[columnIndex] = StringUtils.rightTrim(value);
				hasValue = true;
			}

			if (hasValue)
			{
				result.add(values);
			}
		}

		in.close();
		String[][] returnArray = new String[result.size()][rowSize];
		for (int i = 0; i < returnArray.length; i++)
		{
			returnArray[i] = (String[]) result.get(i);
		}
		return returnArray;
	}
public static String[][] getDataForReins(File file, int ignoreRows)
	throws FileNotFoundException, IOException {
// 存在getLastRowNum取到的最終行數不正確的情況，所以增加一個標誌協助判斷，即某一列的數據是必須錄入的，一旦該列沒有數據，即認為行數到此終止//意外醫療判斷人員序號有沒有值。
	boolean endFalg = false;
	ArrayList result = new ArrayList();
	int rowSize = 0;
	BufferedInputStream in = new BufferedInputStream(new FileInputStream(
		file));
	// 打开HSSFWorkbook
	POIFSFileSystem fs = new POIFSFileSystem(in);
	HSSFWorkbook wb = new HSSFWorkbook(fs);
	HSSFCell cell = null;
for (int sheetIndex = 0; sheetIndex < wb.getNumberOfSheets(); sheetIndex++) {
	HSSFSheet st = wb.getSheetAt(sheetIndex);
	// 第一行为标题，不取
	for (int rowIndex = ignoreRows; rowIndex <= st.getLastRowNum(); rowIndex++) {
		HSSFRow row = st.getRow(rowIndex);
		if (row == null) {
			continue;
		}
		int tempRowSize = row.getLastCellNum() + 1;
		if (tempRowSize > rowSize) {
			rowSize = tempRowSize;
		}
		String[] values = new String[rowSize];
		Arrays.fill(values, "");
		boolean hasValue = false;
		for (short columnIndex = 0; columnIndex <= row.getLastCellNum(); columnIndex++) {
			String value = "";
			cell = row.getCell(columnIndex);
			if (cell != null) {
				// 注意：一定要设成这个，否则可能会出现乱码
//				cell.setEncoding(HSSFCell.ENCODING_UTF_16);
				switch (cell.getCellType()) {
				case HSSFCell.CELL_TYPE_STRING:
					value = cell.getStringCellValue();
					break;
				case HSSFCell.CELL_TYPE_NUMERIC:
					if (HSSFDateUtil.isCellDateFormatted(cell)) {
						Date date = cell.getDateCellValue();
						if (date != null) {
							value = new SimpleDateFormat("yyyy-MM-dd")
									.format(date);
						} else {
							value = "";
						}
					} else {
						value = new Double(DataUtils.round(cell
								.getNumericCellValue(), 6)).toString();
					}
					break;
				case HSSFCell.CELL_TYPE_FORMULA:
					// 导入时如果为公式生成的数据则无值
					if (!cell.getStringCellValue().equals("")) {
						value = cell.getStringCellValue();
					} else {
						value = cell.getNumericCellValue() + "";
					}
					break;
				case HSSFCell.CELL_TYPE_BLANK:
					break;
				case HSSFCell.CELL_TYPE_ERROR:
					value = "";
					break;
				case HSSFCell.CELL_TYPE_BOOLEAN:
					value = (cell.getBooleanCellValue() == true ? "Y"
							: "N");
					break;
				default:
					value = "";
				}
			}
			if (columnIndex == 11 && value.trim().equals("")) {
				endFalg = true;
				break;
			}
			values[columnIndex] = StringUtils.rightTrim(value);
			hasValue = true;
		}
		if (endFalg) {
			break;
		}
		if (hasValue) {
			result.add(values);
		}
	}
}
in.close();
String[][] returnArray = new String[result.size()][rowSize];
for (int i = 0; i < returnArray.length; i++) {
	returnArray[i] = (String[]) result.get(i);
}
return returnArray;
}

/**
 * 解析一个Excel文件的某个特定的sheet
 * sheet号码从1开始
 * 
 * @param file excel文件
 * @param ignoreRows	忽略的行数
 * @param index	sheet的页码
 * @return
 * @throws FileNotFoundException
 * @throws IOException
 */
public static String[][] getDataCorrect(File file, int ignoreRows, int index)
		throws FileNotFoundException, IOException
{
	ArrayList result = new ArrayList();
//	int rowSize = 0;
	BufferedInputStream in = new BufferedInputStream(new FileInputStream(
			file));
	// 打开HSSFWorkbook        
	POIFSFileSystem fs = new POIFSFileSystem(in);
	HSSFWorkbook wb = new HSSFWorkbook(fs);
	HSSFCell cell = null;
	HSSFSheet st = wb.getSheetAt(index - 1);
	int lastRowNum = st.getLastRowNum();
	
	// 列长度以标题为准
	HSSFRow titleRow = st.getRow(0);
	short rowSize = titleRow.getLastCellNum();
	
	// 第一行为标题，不取
	for (int rowIndex = ignoreRows; rowIndex <= lastRowNum; rowIndex++)
	{
		HSSFRow row = st.getRow(rowIndex);
		if (row == null)
		{
			continue;
		}
		// 是否空白行
		boolean isNullRow = true;
		for(short columnIndex = 0; columnIndex < rowSize; columnIndex++){
			String value = getCellValue(row.getCell(columnIndex));
			if(org.apache.commons.lang.StringUtils.isNotBlank(value)){
				isNullRow = false;
				break;
			}
		}
		
		if(isNullRow){
			continue;
		}
		
//		int tempRowSize = row.getLastCellNum() + 1;
//		if (lastCellNum > rowSize)
//		{
//			rowSize = lastCellNum;
//		}
		String[] values = new String[rowSize];
		Arrays.fill(values, "");
		boolean hasValue = false;
		for (short columnIndex = 0; columnIndex < rowSize; columnIndex++)
		{
			String value = "";
			cell = row.getCell(columnIndex);
			if (cell != null)
			{
				// 注意：一定要设成这个，否则可能会出现乱码
				cell.setEncoding(HSSFCell.ENCODING_UTF_16);
				switch (cell.getCellType())
				{
				case HSSFCell.CELL_TYPE_STRING:
					value = cell.getStringCellValue();
					break;
				case HSSFCell.CELL_TYPE_NUMERIC:
					if (HSSFDateUtil.isCellDateFormatted(cell))
					{
						Date date = cell.getDateCellValue();
						if (date != null)
						{
							value = new SimpleDateFormat("yyyy-MM-dd")
									.format(date);
						}
						else
						{
							value = "";
						}
					}
					else
					{
						value = new DecimalFormat("0").format(cell
								.getNumericCellValue());
					}
					break;
				case HSSFCell.CELL_TYPE_FORMULA:
					// 导入时如果为公式生成的数据则无值
					if (!cell.getStringCellValue().equals(""))
					{
						value = cell.getStringCellValue();
					}
					else
					{
						value = cell.getNumericCellValue() + "";
					}
					break;
				case HSSFCell.CELL_TYPE_BLANK:
					break;
				case HSSFCell.CELL_TYPE_ERROR:
					value = "";
					break;
				case HSSFCell.CELL_TYPE_BOOLEAN:
					value = (cell.getBooleanCellValue() == true ? "Y" : "N");
					break;
				default:
					value = "";
				}
			}
//			if (columnIndex == 0 && value.trim().equals(""))
//			{
//				break;
//			}
			values[columnIndex] = StringUtils.rightTrim(value);
			hasValue = true;
		}

		if (hasValue)
		{
			result.add(values);
		}
	}

	in.close();
	String[][] returnArray = new String[result.size()][rowSize];
	for (int i = 0; i < returnArray.length; i++)
	{
		returnArray[i] = (String[]) result.get(i);
	}
	return returnArray;
}

/**
 * 校验Excel标题
 * @param file
 * @param title
 * @param sheetAt
 * @return false:模板不正确，true:模板正确
 * @throws IOException
 */
public static boolean checkExcelTemplate(File file, String[] title, int sheetAt) throws IOException{
	BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
	// 打开HSSFWorkbook
	POIFSFileSystem fs = new POIFSFileSystem(in);
	HSSFWorkbook wb = new HSSFWorkbook(fs);
	if(wb == null){
		return false;
	}
	
	HSSFSheet sheet = wb.getSheetAt(sheetAt);
	boolean flag = true;
	if(sheet == null){
		return false;
	}
	HSSFRow row = sheet.getRow(0);// 取标题
	if(row == null){
		return false;
	}
	// 标题列数不对应
	if(row.getLastCellNum() != (short)(title.length)){
		return false;
	}
	
	// 校验模板的值和预设是否一致
	for(int i=0,len=title.length; i<len; i++){
		if(!title[i].equals(getCellValue(row.getCell((short) i)))){
			flag = false;
			break;
		}
	}
	
	return flag;
}

/**
 * 获取单元格的值，cell为null则返回空字符串
 * @param cell
 * @return
 */
public static String getCellValue(HSSFCell cell){
	String value = "";
	if(cell == null){
		return value;
	}
	
	switch (cell.getCellType()) {
		case HSSFCell.CELL_TYPE_STRING :
			value = cell.getStringCellValue();
			break;
		case HSSFCell.CELL_TYPE_NUMERIC :
			if (HSSFDateUtil.isCellDateFormatted(cell)) {
				Date date = cell.getDateCellValue();
				if (date != null) {
					value = new SimpleDateFormat("yyyy-MM-dd")
							.format(date);
				} else {
					value = "";
				}
			} else {
				value = new Double(DataUtils.round(cell
						.getNumericCellValue(), 6)).toString();
			}
			break;
		case HSSFCell.CELL_TYPE_FORMULA :
			// 导入时如果为公式生成的数据则无值
			if (!cell.getStringCellValue().equals("")) {
				value = cell.getStringCellValue();
			} else {
				value = cell.getNumericCellValue() + "";
			}
			break;
		case HSSFCell.CELL_TYPE_BLANK :
			break;
		case HSSFCell.CELL_TYPE_ERROR :
			value = "";
			break;
		case HSSFCell.CELL_TYPE_BOOLEAN :
			value = (cell.getBooleanCellValue() == true ? "Y"
					: "N");
			break;
		default:
			value = "";
	}
	
	return value;
}

}
