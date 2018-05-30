package com.me.demo.common;

import java.io.Serializable;

/**
 * @author 徐明杰 created on 2006-2-16
 */
public class Pagination implements Serializable {
    private static final long serialVersionUID = 1L;

    private int pageNo = 0;

    private int rowsPerPage = 0;

    private int totalCount = 0;

    public Pagination() {
    }

    public Pagination(int pageNo, int rowsPerPage) {
        pageNo = pageNo == 0 ? 1 : pageNo;
        rowsPerPage = rowsPerPage == 0 ? 15 : rowsPerPage;
        this.pageNo = pageNo;
        this.rowsPerPage = rowsPerPage;
    }

    public int getStartPosition() {
        return (pageNo - 1) * rowsPerPage;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getRowsPerPage() {
        return rowsPerPage;
    }

    public void setRowsPerPage(int rowsPerPage) {
        this.rowsPerPage = rowsPerPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append(Pagination.class.getName());
        stringBuffer.append("[");
        stringBuffer.append("pageNo=").append(pageNo);
        stringBuffer.append(",rowsPerPage=").append(rowsPerPage);
        stringBuffer.append(",totalCount=").append(totalCount);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
