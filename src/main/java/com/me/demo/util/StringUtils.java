package com.me.demo.util;

import java.util.*;

/**
 * 提供各种对字符串进行处理的工具. <br>
 * 类StringUtils是对java.lang.String在功能上的补充，包括了很多应用软件中经常使用的字符串处理功能，
 * 例如：对字符串中空格的处理，字符串的比较，字符串的替换等等，大大增强了应用软件 对字符串的处理能力
 */
public class StringUtils {
    /**
     * 构造方法，禁止实例化
     */
    private StringUtils() {
    }

    /**
     * 生成一个填充字符串. <br> <br> <b>示例: </b> <br>
     * StringUtils.newString(&quot;Sinosoft&quot;,3) 返回
     * &quot;SinosoftSinosoftSinosoft&quot;
     * StringUtils.newString(&quot;Cmm&quot;,2) 返回 &quot;CmmCmm&quot;
     * StringUtils.newString(&quot;a&quot;,2) 返回 &quot;aa&quot;
     * 
     * @param value value
     * @param length length
     * @return 填充字符串
     */
    public static String newString(String value, int length) {
        StringBuffer buffer = new StringBuffer();
        if(value == null) {
            return null;
        }
        for(int i = 0; i < length; i++) {
            buffer.append(value);
        }
        return buffer.toString();
    }

    /**
     * 生成一个填充字符串. <br> <br> <b>示例: </b> <br> StringUtils.newString('C',3) 返回
     * &quot;CCC&quot; StringUtils.newString('a',2) 返回 &quot;aa&quot;
     * 
     * @param ch 填充字符
     * @param length 长度
     * @return 填充字符串
     */
    public static String newString(char ch, int length) {
        return newString(String.valueOf(ch), length);
    }

    /**
     * 将指定字符串复制指定的次数,并返回复制后的字符串. <br> <br> <b>示例: </b> <br>
     * StringUtils.copyString(&quot;Sinosoft&quot;,3) 返回
     * &quot;SinosoftSinosoftSinosoft&quot;
     * StringUtils.copyString(&quot;Cmm&quot;,2) 返回 &quot;CmmCmm&quot;
     * 
     * @param str 指定的字符串,字符串的值不能为null
     * @param copyTimes 复制字符串的次数,有效范围是>0的自然数
     * @return 复制后的字符串
     */
    public static String copyString(String str, int copyTimes) {
        StringBuffer buffer = new StringBuffer();
        if(str == null) {
            return null;
        }
        for(int i = 0; i < copyTimes; i++) {
            buffer.append(str);
        }
        return buffer.toString();
    }

    /**
     * 获得指定字符串转化为Bytes数组后,数组的长度. <br> <br> <b>示例: </b> <br>
     * StringUtils.getBytesLength(&quot;中国人&quot;) 返回 6
     * StringUtils.getBytesLength(&quot;Cmm&quot;) 返回 3
     * StringUtils.getBytesLength(&quot;&quot;) 返回 0
     * StringUtils.getBytesLength(null) 返回 -1
     * 
     * @param str 指定的字符串,字符串的值不能为null
     * @return 指定字符串转化为Bytes数组后,数组的长度
     */
    public static int getBytesLength(String str) {
        if(str == null) {
            return -1;
        }
        return str.getBytes().length;
    }

    /**
     * 获取从主字符串的指定位置开始,子字符串在主字符串中第n次出现的位置. <br> <br> <b>示例 </b> <br>
     * StringUtils.indexOf(&quot;Sinosoft is a software
     * corpration&quot;,&quot;soft&quot;,0,2) 返回 14 StringUtils.indexOf(&quot;ab
     * ab ab ab&quot;,&quot;a&quot;,4,2) 返回 9 StringUtils.indexOf(&quot;ab ab ab
     * ab&quot;,&quot;a&quot;,4,3) 返回 -1
     * 
     * @param str 主字符串,字符串的值不能为null
     * @param subStr 子字符串,字符串的值不能为null
     * @param startIndex 指定的位置,有效范围是>=0的整数
     * @param occurrenceTimes 第几次出现,有效范围是>0的自然数
     * @return 返回从主字符串的指定位置开始,子字符串在主字符串中第n次出现的位置,子字符串没有搜索到时返回-1
     */
    public static int indexOf(String str, String subStr, int startIndex, int occurrenceTimes) {
        int foundCount = 0;
        int index = startIndex;
        int substrLength = subStr.length();
        if(occurrenceTimes <= 0)
            return -1;
        if(str.length() - 1 < startIndex)
            return -1;
        if(subStr.equals(""))
            return 0;
        while(foundCount < occurrenceTimes) {
            index = str.indexOf(subStr, index);
            if(index == -1)
                return -1;
            foundCount++;
            index += substrLength;
        }
        return index - substrLength;
    }

    /**
     * 获取从主字符串的起始位置开始,子字符串在主字符串中第n次出现的位置. <br> <br> <b>示例 </b> <br>
     * StringUtils.indexOf(&quot;Sinosoft is a software
     * corpration&quot;,&quot;soft&quot;,2) 返回 14 <br>
     * StringUtils.indexOf(&quot;ab ab ab ab&quot;,&quot;a&quot;,2) 返回 3 <br>
     * StringUtils.indexOf(&quot;ab ab ab ab&quot;,&quot;a&quot;,5) 返回 -1<br>
     * 
     * @param str 主字符串,字符串的值不能为null
     * @param subStr 子字符串,字符串的值不能为null
     * @param occurrenceTimes 第几次出现,有效范围是>0的自然数
     * @return 返回从主字符串的起始位置开始,子字符串在主字符串中第n次出现的位置,子字符串没有搜索到时返回-1
     */
    public static int indexOf(String str, String subStr, int occurrenceTimes) {
        return indexOf(str, subStr, 0, occurrenceTimes);
    }

    /**
     * 获取从主字符串的fromIndex位置开始,子字符串在主字符串中第1次出现的位置. <br> <br> <b>示例 </b> <br>
     * StringUtils.indexOf(&quot;Tom's name is Tom&quot;, &quot;tom&quot;,
     * 0,true) 返回 -1<br> StringUtils.indexOf(&quot;Tom's name is Tom&quot;,
     * &quot;Tom&quot;, 0,true) 返回 0 <br> StringUtils.indexOf(&quot;Tom's name
     * is Tom&quot;, &quot;Tom&quot;, 2,true) 返回 14 <br>
     * 
     * @param str 主字符串,字符串的值不能为null
     * @param subStr 子字符串,字符串的值不能为null
     * @param fromIndex 起始位置
     * @param caseSensitive 是否大小写敏感，true-敏感，false-不敏感
     * @return 返回从主字符串的fromIndex位置开始,子字符串在主字符串中第1次出现的位置,子字符串没有搜索到时返回-1
     */
    public static int indexOf(String str, String subStr, int fromIndex, boolean caseSensitive) {
        if(caseSensitive == false) {
            return str.toLowerCase().indexOf(subStr.toLowerCase(), fromIndex);
        }
        return str.indexOf(subStr, fromIndex);
    }

    /**
     * 将字符串str中所有的searchStr都替换为replaceStr. <br> <br> <b>示例 </b> <br>
     * StringUtils.replace(&quot;Tom's name is
     * Tom&quot;,&quot;Tom&quot;,&quot;Peter&quot;,true) 返回 &quot;Peter's name
     * is Peter&quot; <br> StringUtils.replace(&quot;Tom's name is
     * Tom&quot;,&quot;tom&quot;,&quot;Peter&quot;,true) 返回 &quot;Tom's name is
     * Tom&quot; <br> StringUtils.replace(&quot;Tom's name is
     * Tom&quot;,&quot;tom&quot;,&quot;Peter&quot;,false) 返回 &quot;Peter's name
     * is Peter&quot; <br>
     * 
     * @param str 原字符串,字符串的值不能为null
     * @param searchStr 被替换的字符串,字符串的值不能为null
     * @param replaceStr 用作替换的字符串,字符串的值如果为null，则自动按空串处理
     * @param caseSensitive 是否大小写敏感，true-敏感，false-不敏感
     * @return 替换后的字符串
     */
    public static String replace(String str, String searchStr, String replaceStr,
            boolean caseSensitive) {
        String result = "";
        int i = 0;
        int j = 0;
        if(str == null) {
            return null;
        }
        if(str.equals("")) {
            return "";
        }
        if(searchStr == null || searchStr.equals("")) {
            return str;
        }
        if(replaceStr == null) {
            replaceStr = "";
        }
        while((j = indexOf(str, searchStr, i, caseSensitive)) > -1) {
            result = result + str.substring(i, j) + replaceStr;
            i = j + searchStr.length();
        }
        result = result + str.substring(i, str.length());
        return result;
    }

    /**
     * 将字符串str中所有的oldStr都替换为newStr. <br> <br> <b>示例 </b> <br>
     * StringUtils.replace(null, *, *) = null <br>
     * StringUtils.replace(&quot;&quot;, *, *) = &quot;&quot; <br>
     * StringUtils.replace(&quot;aba&quot;, null, null) = &quot;aba&quot; <br>
     * StringUtils.replace(&quot;aba&quot;, null, null) = &quot;aba&quot; <br>
     * StringUtils.replace(&quot;aba&quot;, &quot;a&quot;, null) =
     * &quot;aba&quot; <br> StringUtils.replace(&quot;aba&quot;, &quot;a&quot;,
     * &quot;&quot;) = &quot;b&quot; <br> StringUtils.replace(&quot;aba&quot;,
     * &quot;a&quot;, &quot;z&quot;) = &quot;zbz&quot; <br>
     * 
     * @param str 原字符串,字符串的值不能为null
     * @param searchStr 被替换的字符串,字符串的值不能为null
     * @param replaceStr 用作替换的字符串,字符串的值不能为null
     * @return 替换后的字符串
     */
    public static String replace(String str, String searchStr, String replaceStr) {
        return replace(str, searchStr, replaceStr, true);
    }

    /**
     * 将字符串str中所有的searchChar都替换为newStr. <br> <br> <b>示例 </b> <br>
     * StringUtils.replace(null, *, *) = null <br>
     * StringUtils.replace(&quot;&quot;, *, *) = &quot;&quot; <br>
     * StringUtils.replace(&quot;aba&quot;, null, null) = &quot;aba&quot; <br>
     * StringUtils.replace(&quot;aba&quot;, null, null) = &quot;aba&quot; <br>
     * StringUtils.replace(&quot;aba&quot;, 'a', null) = &quot;aba&quot; <br>
     * StringUtils.replace(&quot;aba&quot;, 'a', &quot;&quot;) = &quot;b&quot;
     * <br> StringUtils.replace(&quot;aba&quot;, 'a', &quot;z&quot;) =
     * &quot;zbz&quot; <br>
     * 
     * @param str 原字符串,字符串的值不能为null
     * @param searchChar 被替换的字符
     * @param replaceStr 用作替换的字符串,字符串的值不能为null
     * @return 替换后的字符串
     */
    public static String replace(String str, char searchChar, String replaceStr) {
        return replace(str, searchChar + "", replaceStr, true);
    }

    /**
     * 替换字符串中从指定位置开始的、替换字符串长度的信息. <br> <br> <b>示例 </b> <br>
     * StringTools.replace(&quot;abcde f g&quot;,1,&quot;xx&quot;) 返回
     * &quot;axxde f g&quot;
     * 
     * @param str 原字符串,字符串的值不能为null
     * @param beginIndex 起始位置
     * @param replaceStr 用作替换的字符串,字符串的值不能为null
     * @return 替换后的字符串
     */
    public static String replace(String str, int beginIndex, String replaceStr) {
        String result = null;
        if(str == null) {
            return null;
        }
        if(replaceStr == null) {
            replaceStr = "";
        }
        result = str.substring(0, beginIndex) + replaceStr
                + str.substring(beginIndex + replaceStr.length());
        return result;
    }

    // /**
    // * 将字符串中的html保留字符进行转义,以便于该字符串嵌入到html页面中的时候，不会引起页面解析的混乱. <br>
    // * 需要转义的字符有' <'，'>'，'\n'，'\r'，' '<br>
    // *
    // * @param str 转义之前的字符串,字符串的值不能为null
    // * @return 转义之后的字符串
    // */
    // public static String htmlFormat(String str) throws Exception {
    // return "";
    // }
    /**
     * 将指定的字符串按给定的长度进行分割，返回分割后的字符串数组.如果最后一个字节是中文的半个字符，则该字节进入数组的下一条。 <br> <br>
     * <b>示例 </b> <br> StringUtils.split(&quot;a123bcd12345&quot;,5) 返回 new
     * String[]{&quot;a123b&quot;,&quot;cd123&quot;,&quot;45&quot;}
     * StringUtils.split(&quot;中国人民保险公司两千年特别条款&quot;,8) 返回 new
     * String[]{&quot;中国人民&quot;,&quot;保险公司&quot;,&quot;两千年特&quot;,&quot;别条款&quot;}
     * 特别说明：如果遇到截取到半个汉字的情况,工具会采取如下例所示的原则
     * StringUtils.split(&quot;机动车险A类费率&quot;,7) 返回 new
     * String[]{&quot;机动车&quot;,&quot;险A类费&quot;,&quot;率&quot;}
     * 
     * @param originalString 指定的字符串,字符串的值不能为null
     * @param splitByteLength 给定字节的长度
     * @return 返回按照给定长度分割后的字符串数组
     */
    public static String[] split(String originalString, int splitByteLength) {
        // 定义变量
        ArrayList vector = new ArrayList(); // 存放截后的字符串
        String strText = ""; // 临时存放字符串
        byte[] arrByte = null; // 被拆分的字符串生成的Byte数组
        int intStartIndex = 0; // 游标起始位置
        int intEndIndex = 0; // 游标终止位置
        int index = 0;
        int fixCount = 0; // 需要修正的byte数
        String[] arrReturn = null; // 返回
        // 特殊值处理（长度<1、空、空字符串）
        if(originalString == null) {
            return new String[0]; // 空数组
        }
        if(originalString.equals("")) {
            return new String[0]; // 空数组
        }
        if(originalString.trim().equals("")) {
            return new String[]{ "" }; // 空字符串
        }
        if(splitByteLength <= 1) {
            return new String[]{ originalString };
        }
        // 正常处理
        arrByte = originalString.getBytes();
        intEndIndex = 0; // 设置最初值
        while(true) {
            // 初步设置游标位置
            intStartIndex = intEndIndex;
            intEndIndex = intStartIndex + splitByteLength;
            // 起始位置已经超过数组长度
            if(intStartIndex >= arrByte.length) {
                break;
            }
            // 终止位置已经超过数组长度
            if(intEndIndex > arrByte.length) {
                intEndIndex = arrByte.length;
                strText = new String(arrByte, intStartIndex, intEndIndex - intStartIndex);
                vector.add(strText);
                break;
            }
            // 检查末尾的半个汉字问题
            fixCount = 0;
            strText = new String(arrByte, intStartIndex, intEndIndex - intStartIndex);
            byte[] bytes = strText.getBytes();
            if(bytes.length < splitByteLength) {
                intEndIndex = intStartIndex + bytes.length;
            }
            for(index = intEndIndex - 1; index >= intStartIndex; index--) {
                if(arrByte[index] != bytes[index - intStartIndex]) {
                    // 出现解码错误，需要修正
                    fixCount++;
                }
                else {
                    break;
                }
            }

            // 出现解码错误，需要修正
            if(fixCount > 0) {
                if(fixCount >= intEndIndex) {
                    fixCount = 0;
                    System.out.println("split length " + splitByteLength + " is too small.");
                }
                intEndIndex = intEndIndex - fixCount;

                // 构造字串
                strText = new String(arrByte, intStartIndex, intEndIndex - intStartIndex);
            }
            vector.add(strText);
        }// end while
        // 转成字符串数组
        arrReturn = new String[vector.size()];
        vector.toArray(arrReturn);
        // 返回
        return arrReturn;
    }

    /**
     * 将指定的字符串按给定的分割符进行分割，返回分割后的字符串数组. <br> <br> <b>示例 </b> <br>
     * StringUtils.split(&quot;a123.bc.d12.34.5&quot;,&quot;.&quot;) 返回 new
     * String[]{&quot;a123&quot;,&quot;bc&quot;,&quot;d12&quot;,&quot;34&quot;,&quot;5&quot;}
     * StringUtils.split(&quot;a123|bc|d12|34|5|&quot;,&quot;|&quot;) 返回 new
     * String[]{&quot;a123&quot;,&quot;bc&quot;,&quot;d12&quot;,&quot;34&quot;,&quot;5&quot;,&quot;&quot;}
     * StringUtils.split(&quot;&circ;a123&circ;bc&circ;d12&circ;34&circ;5&circ;&quot;,&quot;&circ;&quot;)
     * 返回 new
     * String[]{&quot;&quot;,&quot;a123&quot;,&quot;bc&quot;,&quot;d12&quot;,&quot;34&quot;,&quot;5&quot;,&quot;&quot;}
     * StringUtils.split(&quot;abcd&quot;,&quot;&circ;&quot;) 返回 new
     * String[]{&quot;abcd&quot;}
     * StringUtils.split(&quot;&circ;abcd&quot;,&quot;&circ;&quot;) 返回 new
     * String[]{&quot;&quot;,&quot;abcd&quot;}
     * StringUtils.split(&quot;abcd&circ;&quot;,&quot;&circ;&quot;) 返回 new
     * String[]{&quot;abcd&quot;,&quot;&quot;}
     * StringUtils.split(&quot;&circ;abcd&circ;&quot;,&quot;&circ;&quot;) 返回 new
     * String[]{&quot;&quot;,&quot;abcd&quot;,&quot;&quot;}
     * StringUtils.split(&quot;a123._.bc._.d12._.34._.5&quot;,&quot;._.&quot;)
     * 返回 new
     * String[]{&quot;a123&quot;,&quot;bc&quot;,&quot;d12&quot;,&quot;34&quot;,&quot;5&quot;}
     * 
     * @param originalString 指定的字符串
     * @param delimiterString 给定的分割符
     * @return 返回按照给定的分割符进行分割后的字符串数组
     */
    public static String[] split(String originalString, String delimiterString) {
        int index = 0;
        String[] returnArray = null; // 返回值字符串数组
        int length = 0; // 数组的大小
        // null值校验
        if(originalString == null || delimiterString == null || originalString.equals("")) {
            return new String[0];
        }
        // 空串校验
        if(originalString.equals("") || delimiterString.equals("")
                || originalString.length() < delimiterString.length()) {
            return new String[]{ originalString };
        }
        // 计算字符串有多少个分隔符
        String strTemp = originalString;
        while(strTemp != null && !strTemp.equals("")) {
            index = strTemp.indexOf(delimiterString);
            if(index == -1) {
                break;
            }
            length++;
            strTemp = strTemp.substring(index + delimiterString.length());
        }
        returnArray = new String[++length];
        // 生成字符串数组
        for(int i = 0; i < length - 1; i++) {
            index = originalString.indexOf(delimiterString);
            returnArray[i] = originalString.substring(0, index);
            originalString = originalString.substring(index + delimiterString.length());
        }
        returnArray[length - 1] = originalString;
        return returnArray;
    }

    /**
     * 截取字符串右边的空格. <br> <br> <b>示例 </b> <br> StringUtils.rightTrim(&quot; ab cd
     * e &quot;) 返回 &quot; ab cd e&quot; StringUtils.rightTrim(null) 返回
     * &quot;&quot;
     * 
     * @param str 原字符串
     * @return 返回截掉右边空格后的字符串
     */
    public static String rightTrim(String str) {
        if(str == null) {
            return "";
        }
        int length = str.length();
        for(int i = length - 1; i >= 0; i--) {
            if(str.charAt(i) != 0x20) {
                break;
            }
            length--;
        }
        return str.substring(0, length);
    }

    /**
     * 截取字符串左边的空格. <br> <br> <b>示例 </b> <br> StringUtils.leftTrim(&quot; ab cd e
     * &quot;) 返回 &quot;ab cd e &quot; StringUtils.leftTrim(null) 返回
     * &quot;&quot;
     * 
     * @param str 原字符串
     * @return 返回截掉左边空格后的字符串
     */
    public static String leftTrim(String str) {
        if(str == null) {
            return "";
        }
        int start = 0;
        for(int i = 0, n = str.length(); i < n; i++) {
            if(str.charAt(i) != 0x20) {
                break;
            }
            start++;
        }
        return str.substring(start);
    }

    /**
     * 剔除字符串中所有出现的空格字符. <br> <br> <b>示例 </b> <br>
     * StringUtils.absoluteTrim(&quot; ab cd e &quot;) 返回 &quot;abcde&quot;
     * 
     * @param str 原字符串
     * @return 返回剔除掉所有出现的空格字符后的字符串
     */
    public static String absoluteTrim(String str) {
        String result = replace(str, " ", "");
        return result;
    }

    /**
     * 将指定字符串的从beginIndex到endIndex的字符变为小写. <br> <br> <b>示例 </b> <br>
     * StringUtils.lowerCase(&quot;aBcDefgHIJ&quot;,0,4) 返回
     * &quot;abcdefgHIJ&quot; StringUtils.lowerCase(&quot;Abc&quot;,0,0) 返回
     * &quot;Abc&quot;
     * 
     * @param str 指定字符串
     * @param beginIndex 起始位置
     * @param endIndex 终止位置
     * @return 返回字符串
     */
    public static String lowerCase(String str, int beginIndex, int endIndex) {
        StringBuffer buffer = new StringBuffer();
        buffer.append(str.substring(0, beginIndex));
        buffer.append(str.substring(beginIndex, endIndex).toLowerCase());
        buffer.append(str.substring(endIndex));
        return buffer.toString();
    }

    /**
     * 将指定字符串的从beginIndex到endIndex的字符变为大写. <br> <br> <b>示例 </b> <br>
     * StringUtils.upperCase(&quot;aBcDefgHIJ&quot;,0,4) 返回
     * &quot;ABCDefgHIJ&quot; StringUtils.upperCase(&quot;policy&quot;,0,0) 返回
     * &quot;policy&quot;
     * 
     * @param str 指定字符串
     * @param beginIndex 起始位置
     * @param endIndex 终止位置
     * @return 返回字符串
     */
    public static String upperCase(String str, int beginIndex, int endIndex) {
        StringBuffer buffer = new StringBuffer();
        buffer.append(str.substring(0, beginIndex));
        buffer.append(str.substring(beginIndex, endIndex).toUpperCase());
        buffer.append(str.substring(endIndex));
        return buffer.toString();
    }

    /**
     * 将字符串的第一个字符小写. <br> <br> <b>示例 </b> <br>
     * StringUtils.lowerCaseFirstChar(&quot;ABc&quot;) 返回 &quot;aBc&quot;
     * 
     * @param iString 传入字符串
     * @return 传出字符串
     */
    public static String lowerCaseFirstChar(String iString) {
        String newString;
        newString = iString.substring(0, 1).toLowerCase() + iString.substring(1);
        return newString;
    }

    /**
     * 将字符串的第一个字符大写. <br> <br> <b>示例 </b> <br>
     * StringUtils.upperCaseFirstChar(&quot;aBc&quot;) 返回 &quot;ABc&quot;
     * 
     * @param iString 传入字符串
     * @return 传出字符串
     */
    public static String upperCaseFirstChar(String iString) {
        String newString;
        newString = iString.substring(0, 1).toUpperCase() + iString.substring(1);
        return newString;
    }

    /**
     * 获取子字符串在主字符串中出现的次数. <br> <br> <b>示例 </b> <br>
     * StringUtils.timesOf(&quot;2004-10-10 00:00:00:2005-10-11
     * 00:00:00&quot;,&quot;:&quot;) 返回 5
     * 
     * @param str 主字符串,字符串的值不能为null
     * @param subStr 子字符串,字符串的值不能为null
     * @return 返回子字符串在主字符串中出现的次数,子字符串没有搜索到时返回0
     */
    public static int timesOf(String str, String subStr) {
        int foundCount = 0;
        if(subStr.equals("")) {
            return 0;
        }
        int fromIndex = str.indexOf(subStr);
        while(fromIndex != -1) {
            foundCount++;
            fromIndex = str.indexOf(subStr, fromIndex + subStr.length());
        }
        return foundCount;
    }

    /**
     * 获取字符在主字符串中出现的次数. <br> <br> <b>示例 </b> <br>
     * StringUtils.timesOf(&quot;2004-10-10 00:00:00:2005-10-11
     * 00:00:00&quot;,':') 返回 5
     * 
     * @param str 主字符串,字符串的值不能为null
     * @param ch 字符,值不能为null
     * @return 返回字符在主字符串中出现的次数,字符没有搜索到时返回0
     */
    public static int timesOf(String str, char ch) {
        int foundCount = 0;
        int fromIndex = str.indexOf(ch);
        while(fromIndex != -1) {
            foundCount++;
            fromIndex = str.indexOf(ch, fromIndex + 1);
        }
        return foundCount;
    }

    /**
     * 变为Map,如果一个条目包含等于号"="，则等于号前为Key，后为Value<br> <b>示例 </b> <br> Map map =
     * StringUtils.toMap("00010000,00020000,00030000,00040000",",");
     * 
     * Map map = StringUtils.toMap("1=true,0=false",",");
     * 
     * @param str
     * @param splitString
     * @return
     */
    public static Map toMap(String str, String splitString) {
        Map map = Collections.synchronizedMap(new HashMap());
        String[] values = split(str, splitString);
        for(int i = 0; i < values.length; i++) {
            String tempValue = values[i];
            int pos = tempValue.indexOf("=");
            String key = "";
            String value = "";
            if(pos > -1) {
                key = tempValue.substring(0, pos);
                value = tempValue.substring(pos + splitString.length());
            }
            else {
                key = tempValue;
            }
            map.put(key, value);
        }
        return map;
    }

    /**
     * 本地编码转换为Ascii编码，同native2ascii.exe<br>示例:
     * native2ascii("出险时保单信息");返回\u51fa\u9669\u65f6\u4fdd\u5355\u4fe1\u606f
     * 
     * @param str 本地String.
     * @return 转化后的Ascii编码，形如\u51fa\u9669\u65f6\u4fdd\u5355\u4fe1\u606f
     */
    public static String native2ascii(String str) {
        char[] ca = str.toCharArray();
        StringBuffer buffer = new StringBuffer(ca.length * 6);
        for(int x = 0; x < ca.length; ++x) {
            char a = ca[x];
            if((int)a > 255) {
                buffer.append("\\u").append(Integer.toHexString((int)a));
            }
            else {
                buffer.append(a);
            }
        }
        return buffer.toString();
    }
    
	public static Map countStr(String str) {
		Map map = new HashMap();
		int len = str.length();

		int letterCount = 0; // 英文字母个数
		int blankCount = 0; // 空格个数
		int numCount = 0; // 数字个数
		int otherCount = 0; // 其他字符个数
		for (int i = 0; i < len; i++) {
			char tem = str.charAt(i);
			if ((tem >= 'A' && tem <= 'Z') || (tem >= 'a' && tem <= 'z'))// 英文字母
				letterCount++;
			else if (tem == ' ')// 空格
				blankCount++;
			else if (tem >= '0' && tem <= '9')// 数字
				numCount++;
			else
				// 其他
				otherCount++;
		}
		map.put("letter", letterCount);
		map.put("blank", blankCount);
		map.put("num", numCount);
		map.put("other", otherCount);
		
		return map;
	}

}