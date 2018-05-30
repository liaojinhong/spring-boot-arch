package com.me.demo.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 徐明杰 created on 2006-3-10
 */
public abstract class BaseException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private List causeList = new ArrayList();

    public BaseException() {
        super();
    }

    public void addCause(ExceptionCause exceptionCause) {
        this.causeList.add(exceptionCause);
    }

    public List getCauseList() {
        return this.causeList;
    }

}
