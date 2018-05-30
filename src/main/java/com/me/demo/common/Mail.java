package com.me.demo.common;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
/**
 * 邮件类
 */
public class Mail implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 收件人地址列表 */
    private Collection toList;
    /** 抄件人地址列表 */
    private Collection ccList;
    /** 秘密抄件人地址列表 */
    private Collection bccList;
    /** 附件列表,集合中存放Attachment对象 */
    private Collection attachmentList;
    /** 回复地址列表 */
    private Collection replyToList;
    /** 发信人地址 */
    private String fromAddress;
    /** 发信人名称 */
    private String fromName;
    /** 邮件主题 */
    private String subject;
    /** 邮件正文 */
    private String content;
    /**
     * 构造一个默认的邮件
     */
    public Mail() {
        attachmentList = new ArrayList();
        toList = new ArrayList();
        ccList = new ArrayList();
        bccList = new ArrayList();
        replyToList = new ArrayList();
    }
    public String getContent() {
        return content;
    }
    public String getSubject() {
        return subject;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public Collection getAttachmentList() {
        return attachmentList;
    }
    /**
     * 添加收件人
     * 
     * @param to
     */
    public void addTo(String to) {
        toList.add(to);
    }
    /**
     * 添加抄件人
     * 
     * @param cc
     */
    public void addCc(String cc) {
        ccList.add(cc);
    }
    /**
     * 添加秘密抄件人
     * 
     * @param bcc
     */
    public void addBcc(String bcc) {
        bccList.add(bcc);
    }
    /**
     * 添加附件
     * 
     * @param sttachment 附件文件名
     */
    public void addAttachment(String sttachment) {
        attachmentList.add(sttachment);
    }
    public Collection getCcList() {
        return ccList;
    }
    public Collection getToList() {
        return toList;
    }
    public Collection getBccList() {
        return bccList;
    }
    public String getFromAddress() {
        return fromAddress;
    }
    public String getFromName() {
        return fromName;
    }
    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }
    public void setFromName(String fromName) {
        this.fromName = fromName;
    }
    public Collection getReplyToList() {
        return replyToList;
    }
    public void addReplyTo(String replyTo) {
        replyToList.add(replyTo);
    }
}
