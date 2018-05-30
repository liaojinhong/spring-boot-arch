package com.me.demo.common;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
/**
 * 封装分页时的数据，包括查询出来的count值和一页的数据。
 */
public class PageRecord implements Serializable{
    private static final long serialVersionUID = 1L;
    private int count;
    /**
     * 当前页号
     */
    private int pageNo;
    /**
     * 本次查询要查的页数
     */
    private int pageCount = 1;
    /**
     * 一页的条数
     */
    private int rowsPerPage = 10;
    /**
     * 总页数
     */
    private int totalPageCount = -1;
    /**
     * 结果集
     */
    private Collection result = new ArrayList();
    /**
     * @return 返回属性 count.
     */
    public int getCount() {
        return count;
    }
    /**
     * @return 返回属性 result.
     */
    public Collection getResult() {
        return result;
    }
    /**
     * @return 返回属性pageCount.
     */
    public int getPageCount() {
        return pageCount;
    }
    /**
     * @return 返回属性pageNo.
     */
    public int getPageNo() {
        return pageNo;
    }
    /**
     * 构造一个PageRecord
     * 
     * @deprecated use PageRecord(int count, int pageNo, int pageCount, int rowsPerPage,Collection result)
     * @param count 查询出来的结果的总数
     * @param result 查询出来的一页的结构集
     */
    public PageRecord(int count, Collection result) {
        this.count = count;
        this.result = result;
        if (this.result == null) {
            this.result = new ArrayList();
        }
    }
    /**
     * @param count 查询出来的结果的总数
     * @param pageNo 当前页号
     * @param result 查询出来的一页的结构集
     */
    public PageRecord(int count, int pageNo, Collection result) {
        this(count, pageNo, 1, result);
    }
    /**
     * @param count 查询出来的结果的总数
     * @param pageNo 当前页号
     * @param pageCount 本次查询要查的页数
     * @param result 查询出来的一页的结构集
     * @deprecated use PageRecord(int count, int pageNo, int pageCount, int rowsPerPage,Collection result)
     */
    public PageRecord(int count, int pageNo, int pageCount, Collection result) {
        this(count, pageNo, pageCount, 10, result);
    }
    /**
     * @param count 查询出来的结果的总数
     * @param pageNo 当前页号
     * @param pageCount 本次查询要查的页数
     * @param rowsPerPage 一页的条数
     * @param result 查询出来的一页的结构集
     */
    public PageRecord(int count, int pageNo, int pageCount, int rowsPerPage, Collection result) {
        this.count = count;
        this.pageNo = pageNo;
        this.pageCount = pageCount;
        this.result = result;
        this.rowsPerPage = rowsPerPage;
        if (this.result == null) {
            this.result = new ArrayList();
        }
        if (rowsPerPage <= 0) {
            rowsPerPage = 10;
        }
        totalPageCount = count / rowsPerPage; //取模
        //如果有余数,则加一
        if (count - count / rowsPerPage * rowsPerPage > 0) {
            totalPageCount++;
        }
    }
    /**
     * 返回每页的条数
     * 
     * @return 每页的条数
     */
    public int getRowsPerPage() {
        return rowsPerPage;
    }
    /**
     * 返回总的页数
     * 
     * @return 总的页数
     */
    public int getTotalPageCount() {
        return totalPageCount;
    } 
}