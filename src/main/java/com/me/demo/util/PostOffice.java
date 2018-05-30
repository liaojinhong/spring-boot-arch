package com.me.demo.util;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import com.me.demo.common.Mail;
/**
 * 邮局类，可以通过send发送邮件 需要mail.jar和activation.jar
 */
public class PostOffice {
    private Session session; //邮件会话对象
    private Properties props; //系统属性
    /**
     * 构造一个PostOffice实例
     * 
     * @param smtp SMTP服务器地址
     * @param user SMTP认证用户名
     * @param password 设置SMTP认证用户名的密码
     */
    public PostOffice(String smtp, String user, String password) {
        if (props == null)
            props = System.getProperties(); //获得系统属性对象
        props.put("mail.smtp.host", smtp); //设置SMTP认证用户名
        props.put("mail.smtp.user", user); //设置SMTP认证用户名的密码
        props.put("mail.smtp.password", password); //设置SMTP主机
        if ((user == null || user.trim().equals(""))
                && (password == null || password.trim().equals(""))) {
            props.put("mail.smtp.auth", "false");
        } else {
            props.put("mail.smtp.auth", "true");
        }
        session = Session.getDefaultInstance(props, null); //获得邮件会话对象
    }
    /**
     * 设置回复地址
     * 
     * @param mail 邮件
     * @throws AddressException
     * @throws MessagingException
     */
    private void setReplyTo(MimeMessage mimeMsg, Mail mail)
            throws AddressException, MessagingException {
        Address[] replyTos = new InternetAddress[mail.getToList().size()];
        int index = 0;
        for (Iterator iter = mail.getToList().iterator(); iter.hasNext();) {
            String replyTo = (String) iter.next();
            replyTos[index++] = new InternetAddress(replyTo);
        }
        mimeMsg.setReplyTo(replyTos);
    }
    /**
     * 设置收件人，包括to,cc,bcc
     * 
     * @param mail 邮件
     * @throws AddressException
     * @throws MessagingException
     */
    private void setRecipients(MimeMessage mimeMsg, Mail mail)
            throws AddressException, MessagingException {
        for (Iterator iter = mail.getToList().iterator(); iter.hasNext();) {
            String recipient = (String) iter.next();
            mimeMsg.addRecipients(Message.RecipientType.TO, InternetAddress
                    .parse(recipient));
        }
        for (Iterator iter = mail.getCcList().iterator(); iter.hasNext();) {
            String recipient = (String) iter.next();
            mimeMsg.addRecipients(Message.RecipientType.CC, InternetAddress
                    .parse(recipient));
        }
        for (Iterator iter = mail.getBccList().iterator(); iter.hasNext();) {
            String recipient = (String) iter.next();
            mimeMsg.addRecipients(Message.RecipientType.BCC, InternetAddress
                    .parse(recipient));
        }
    }
    /**
     * 发送一封邮件
     * 
     * @param mail 一封邮件
     * @throws Exception
     */
    public synchronized void send(Mail mail) throws Exception {
        send(new Mail[]{mail});
    }
    /**
     * 发送多封邮件
     * 
     * @param mails 多封邮件
     * @throws Exception
     */
    public synchronized void send(Mail[] mails) throws Exception {
        Transport transport = session.getTransport("smtp");
        transport.connect((String) props.get("mail.smtp.host"), (String) props
                .get("mail.smtp.user"), (String) props
                .get("mail.smtp.password"));
        for (int i = 0; i < mails.length; i++) {
            Mail mail = mails[i];
            MimeMessage mimeMsg = new MimeMessage(session); //创建MIME邮件对象
            Multipart mp = new MimeMultipart(); //Multipart对象,邮件内容,标题,附件等内容均添加到其中后再生成MimeMessage对象
            mimeMsg.setContent(mp);
            mimeMsg.setFrom(new InternetAddress(mail.getFromAddress(), mail
                    .getFromName())); //设置发信人
            setReplyTo(mimeMsg, mail);
            mimeMsg.setSubject(mail.getSubject());
            BodyPart bp = new MimeBodyPart();
            bp.setContent(mail.getContent(), "text/html;charset=gb2312");
            mp.addBodyPart(bp);
            //添加所有附件
            for (Iterator iter = mail.getAttachmentList().iterator(); iter
                    .hasNext();) {
                String attachment = (String) iter.next();
                bp = new MimeBodyPart();
                FileDataSource fileds = new FileDataSource(attachment);
                bp.setDataHandler(new DataHandler(fileds));
                bp.setFileName(MimeUtility.encodeText(fileds.getName()));
                mp.addBodyPart(bp);
            }
            setRecipients(mimeMsg, mail);//设置收件人
            mimeMsg.setSentDate(new Date());
            mimeMsg.saveChanges();
            transport.sendMessage(mimeMsg, mimeMsg.getAllRecipients());//发送邮件到所有地址
        }
        transport.close();
    }
}