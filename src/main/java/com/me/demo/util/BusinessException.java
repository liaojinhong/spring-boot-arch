package com.me.demo.util;

/**
 * 业务逻辑异常类
 */
public class BusinessException extends BaseException {
    private static final long serialVersionUID = 1L;

    /**
     * 构建一个默认的业务逻辑异常实例
     */
    public BusinessException() {
        super();
    }

    /**
     * 根据资源文件Key和参数值构建业务逻辑异常实例
     * @param messageKey 资源文件Key
     * @param arg 参数值
     */
    public BusinessException(String messageKey, Object arg) {
        this(messageKey, new Object[] { arg });
    }

    /**
     * 根据资源文件Key和参数值数组构建业务逻辑异常实例
     * @param messageKey 资源文件Key
     * @param args 参数值数组
     */
    public BusinessException(String messageKey, Object[] args) {
        super();
        ExceptionCause cause = new ExceptionCause(messageKey, args);
        addCause(cause);
    }
}
