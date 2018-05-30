package com.me.demo.util;
import java.util.*;
/**
 * 数组处理工具类
 */
public class ArrayUtils {
    /**
     * 构造方法，禁止实例化
     */
    private ArrayUtils() {
    }
    /**
     * 生成一个填充字符串. <br>
     * <br>
     * <b>示例: </b>
     * 
     * <pre>
     * 
     *   StringUtils.equals(null,null) 返回 true
     *   StringUtils.newString(null,new String[0]) 返回 false
     *   StringUtils.newString(new String[]{&quot;a&quot;,&quot;b&quot;},new String[]{&quot;a&quot;,&quot;b&quot;}) 返回 true
     *   StringUtils.newString(new String[]{&quot;a&quot;,&quot;b&quot;},new String[]{&quot;a&quot;,&quot;ab&quot;}) 返回 false
     *  
     * </pre>
     * 
     * @param array1 String数组1
     * @param array2 String数组2
     * @return 数组1和数组1的值如果相等则返回true
     */
    public static boolean equals(String[] array1, String[] array2) {
        if (array1 == null && array2 == null) {
            return true;
        }
        if (array1 == null || array2 == null) {
            return false;
        }
        if (array1.length != array2.length) {
            return false;
        }
        if (array1 == array2) {
            return true;
        }
        for (int i = 0, n = array1.length; i < n; i++) {
            if (!array1[i].equals(array2[i])) {
                return false;
            }
        }
        return true;
    }
    /**
     * 抽样
     * 
     * @param source 传入对象数组
     * @param sampleCount 抽样数目
     * @return 返回抽样后的数组
     */
    public static Object[] sample(Object[] source, int sampleCount) {
        Collection result = new ArrayList();
        if (source == null) {
            return null;
        }
        int count = source.length;
        int[] keys = sample(count, sampleCount);
        for (int i = 0, n = keys.length; i < n; i++) {
            result.add(source[keys[i]]);
        }
        return result.toArray();
    }
    /**
     * 取得随机数数组(数据不相同）
     * 
     * @param maxNo 最大号
     * @param sampleCount 取样数目
     * @return int[]
     */
    public static int[] sample(int maxNo, int sampleCount) {
        Hashtable hash = new Hashtable();
        if (sampleCount > maxNo) {
            sampleCount = maxNo;
        }
        int[] keys = new int[sampleCount];
        int sampleIndex = 0;
        int index = 0;
        for (int i = 0; i < sampleCount; i++) {
            while (true) {
                sampleIndex = (int) Math.round(Math.random() * (maxNo - 1));
                if (!hash.containsKey("" + sampleIndex)) {
                    hash.put("" + sampleIndex, "" + sampleIndex);
                    break;
                }
            }
            keys[index++] = sampleIndex;
        }
        Arrays.sort(keys);
        return keys;
    }
    
    /**
     * 测试抽样
     * 
     * @param args
     */
    public static void main(String [] args){
    	Object[] source = new Object[] {1,2,3,4,5,6,7,8,9,10};
    	source = sample(source,5);
    	for (int i = 0, n = source.length; i < n; i++) {
            System.out.println(source[i]);
        }
    }
}