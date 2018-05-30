package com.me.demo.dto;

import java.io.Serializable;
import java.util.Date;


/**
 * 这是GGUser-员工代码表的数据传输对象类<br>
 */
public class GgUserDto extends GgUserDtoBase implements Serializable {

    private static final long serialVersionUID = 1L;

    // 新密码
    private String newPasswd = "";

    // 重复密码
    private String repeatPasswd = "";

    // Session ID
    private String sid = "";

    // Remote Addr
    private String remoteAddr = "";

    // Login time
    private Date loginTime = null;

    // 老密码
    private String oldPasswd = "";

    // 当前登录的机构代码
    private String loginComCode = "";

    // 当前登录的岗位代码列表
    private String loginGradeCodes = "";

    // 当前登录的系统代码
    private String loginSystemCode = "";

    // 当前正在配置的系统代码，主要用于菜单配置
    private String configSystemCode = "";

    // 存储效率状态的中文名称
    private String validStatusName = "无效";

    // 当前操作的险种代码
    private String currentRiskCode = "";

    // 当前操作的计划代码
    private String currentPlanCode = null;

    // 当前险种是否动态标的标志
    private String currentRiskDynamicInd = "";

    // 当前登录语种
    private String currentLanguage = null;

    // 存储员工类别
    private String prpDuserFlag2 = "";

    // 最后配置的菜单的系统代码
    private String lastConfigMenuSystemCode = "";

    // 所属机构名称
    private String comName = "";

    // log4j的NDC
    private String logNdc = null;

    private String userShowUserName = null;
    
    //存储登录信息
    private String serverAddr = null;
    
    private String clientAddr = null;
    
    private Date lastAccessedTime = null;
    
    private String currentLocation = null;
    
    private String sessionString = null;
    
    private Integer userLevel = null;

    //派发业务系统用户标志
    private String tdUserInd = null;

    //拥有的岗位代码
    private String userGrade;
    
    //允许出单的险种
    private String permitRiskCode;
    
    //收付机构
    private String centerCode;
    //收付机构名称
    private String centerName;
    /**
     * 默认构造方法,构造一个默认的GgUserDto对象
     */
    public GgUserDto() {
    }

    public String getSessionString() {
        return sessionString;
    }

    public void setSessionString(String sessionString) {
        this.sessionString = sessionString;
    }

    public String getComName() {
        return comName;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public String getClientAddr() {
        return clientAddr;
    }

    public void setClientAddr(String clientAddr) {
        this.clientAddr = clientAddr;
    }

    public Date getLastAccessedTime() {
        return lastAccessedTime;
    }

    public void setLastAccessedTime(Date lastAccessedTime) {
        this.lastAccessedTime = lastAccessedTime;
    }

    public String getServerAddr() {
        return serverAddr;
    }

    public void setServerAddr(String serverAddr) {
        this.serverAddr = serverAddr;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getConfigSystemCode() {
        return configSystemCode;
    }

    public void setConfigSystemCode(String configSystemCode) {
        this.configSystemCode = configSystemCode;
    }

    public String getCurrentLanguage() {
        return currentLanguage;
    }

    public void setCurrentLanguage(String currentLanguage) {
        this.currentLanguage = currentLanguage;
    }

    public String getCurrentRiskCode() {
        return currentRiskCode;
    }

    public void setCurrentRiskCode(String currentRiskCode) {
        this.currentRiskCode = currentRiskCode;
    }

    public String getLastConfigMenuSystemCode() {
        return lastConfigMenuSystemCode;
    }

    public void setLastConfigMenuSystemCode(String lastConfigMenuSystemCode) {
        this.lastConfigMenuSystemCode = lastConfigMenuSystemCode;
    }

    public String getLoginComCode() {
        return loginComCode;
    }

    public void setLoginComCode(String loginComCode) {
        this.loginComCode = loginComCode;
    }

    public String getLoginGradeCodes() {
        return loginGradeCodes;
    }

    public void setLoginGradeCodes(String loginGradeCodes) {
        this.loginGradeCodes = loginGradeCodes;
    }

    public String getLoginSystemCode() {
        return loginSystemCode;
    }

    public void setLoginSystemCode(String loginSystemCode) {
        this.loginSystemCode = loginSystemCode;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getLogNdc() {
        return logNdc;
    }

    public void setLogNdc(String logNdc) {
        this.logNdc = logNdc;
    }

    public String getNewPasswd() {
        return newPasswd;
    }

    public void setNewPasswd(String newPasswd) {
        this.newPasswd = newPasswd;
    }

    public String getOldPasswd() {
        return oldPasswd;
    }

    public void setOldPasswd(String oldPasswd) {
        this.oldPasswd = oldPasswd;
    }

    public String getPrpDuserFlag2() {
        return prpDuserFlag2;
    }

    public void setPrpDuserFlag2(String prpDuserFlag2) {
        this.prpDuserFlag2 = prpDuserFlag2;
    }

    public String getRemoteAddr() {
        return remoteAddr;
    }

    public void setRemoteAddr(String remoteAddr) {
        this.remoteAddr = remoteAddr;
    }

    public String getRepeatPasswd() {
        return repeatPasswd;
    }

    public void setRepeatPasswd(String repeatPasswd) {
        this.repeatPasswd = repeatPasswd;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getValidStatusName() {
        return validStatusName;
    }

    public void setValidStatusName(String validStatusName) {
        this.validStatusName = validStatusName;
    }

    public String getUserShowUserName() {
        return userShowUserName;
    }

    public void setUserShowUserName(String userShowUserName) {
        this.userShowUserName = userShowUserName;
    }

    public String getCurrentRiskDynamicInd() {
        return currentRiskDynamicInd;
    }

    public void setCurrentRiskDynamicInd(String currentRiskDynamicInd) {
        this.currentRiskDynamicInd = currentRiskDynamicInd;
    }

    public String getCurrentPlanCode() {
        return currentPlanCode;
    }

    public void setCurrentPlanCode(String currentPlanCode) {
        this.currentPlanCode = currentPlanCode;
    }

	public String getTdUserInd() {
		return tdUserInd;
	}

	public void setTdUserInd(String tdUserInd) {
		this.tdUserInd = tdUserInd;
	}

	public Integer getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(Integer userLevel) {
		this.userLevel = userLevel;
	}

	public String getUserGrade() {
		return userGrade;
	}

	public void setUserGrade(String userGrade) {
		this.userGrade = userGrade;
	}

	public String getPermitRiskCode() {
		return permitRiskCode;
	}

	public void setPermitRiskCode(String permitRiskCode) {
		this.permitRiskCode = permitRiskCode;
	}

	public String getCenterCode() {
		return centerCode;
	}

	public void setCenterCode(String centerCode) {
		this.centerCode = centerCode;
	}

	public String getCenterName() {
		return centerName;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}
	
	
}
