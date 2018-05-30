package com.me.demo.util;

/**
 * @author xumingjie created on 2006-3-19
 */
public class ExceptionCause {
    private String messageKey = null;
    private Object[] messageArgs = null;
    private boolean resource = false;
    private int index = -1;

    public ExceptionCause() {
    }

    public ExceptionCause(String messageKey) {
        this(messageKey, true);
    }

    public ExceptionCause(String messageKey, boolean resource) {
        this.messageKey = messageKey;
        this.resource = resource;
    }

    public ExceptionCause(String messageKey, Object messageArgs) {
        this(messageKey, new Object[] { messageArgs });
    }

    public ExceptionCause(String messageKey, Object[] messageArgs) {
        this.messageKey = messageKey;
        this.messageArgs = messageArgs;
        this.resource = true;
    }

    public Object[] getMessageArgs() {
        return messageArgs;
    }

    public void setMessageArgs(Object[] messageArgs) {
        this.messageArgs = messageArgs;
    }

    public String getMessageKey() {
        return messageKey;
    }

    public void setMessageKey(String messageKey) {
        this.messageKey = messageKey;
    }

    public boolean isResource() {
        return resource;
    }

    public void setResource(boolean resource) {
        this.resource = resource;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}