package com.me.demo.dto;

import java.io.Serializable;

/**
 * 所有Dto的基类
 * 
 */
public class BaseDto implements Serializable {
    private static final long serialVersionUID = 1L;

    /** OrderBy属性，供查询用 */
    private String object_OrderBy;
    /** 附加条件属性，供查询用 */
    private String object_Condition;

    public String getObject_Condition() {
        return object_Condition;
    }

    public void setObject_Condition(String object_Condition) {
        this.object_Condition = object_Condition;
    }

    public String getObject_OrderBy() {
        return object_OrderBy;
    }

    public void setObject_OrderBy(String object_OrderBy) {
        this.object_OrderBy = object_OrderBy;
    }
}
