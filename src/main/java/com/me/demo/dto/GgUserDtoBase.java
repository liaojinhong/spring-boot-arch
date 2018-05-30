package com.me.demo.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 这是GGUser-员工代码表的数据传输对象基类,直接与表对应<br>
 */
public abstract class GgUserDtoBase extends BaseDto implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 属性:员工代码<br>
     */
    private String userCode = null;
    /**
     * 属性:员工简体中文名称<br>
     */
    private String userCName = null;
    /**
     * 属性:员工繁体中文名称<br>
     */
    private String userTName = null;
    /**
     * 属性:员工英文名称<br>
     */
    private String userEName = null;
    /**
     * 属性:密码<br>
     */
    private String password = null;
    /**
     * 属性:印鉴<br>
     */
    private String seal = null;
    /**
     * 属性:密码设置日期<br>
     */
    private Date passwordSetDate = null;
    /**
     * 属性:密码过期日期<br>
     */
    private Date passwordExpireDate = null;
    /**
     * 属性:归属机构代码<br>
     */
    private String companyCode = null;
    /**
     * 属性:出单机构代码<br>
     */
    private String issueCompany = null;
    /**
     * 属性:账号代码<br>
     */
    private String accountCode = null;
    /**
     * 属性:电话号码<br>
     */
    private String phone = null;
    /**
     * 属性:手机号码<br>
     */
    private String mobile = null;
    /**
     * 属性:通信地址<br>
     */
    private String address = null;
    /**
     * 属性:邮政编码<br>
     */
    private String postCode = null;
    /**
     * 属性:邮箱<br>
     */
    private String email = null;
    /**
     * 属性:员工标志<br>
     * 含义:--** [1]: 1操作员--** [2]: 1经办人--** [3]：1业务员<br>
     */
    private String userInd = null;
    /**
     * 属性:允许登录的应用系统<br>
     * 含义:--** [1]: 1核心业务系统--** [2]：1财务系统--** [3]：1再保险系统--** [4]：1 单证系统--** [5]：1核保核赔系统<br>
     */
    private String loginSystem = null;
    /**
     * 属性:创建人<br>
     */
    private String creatorCode = null;
    /**
     * 属性:创建时间<br>
     */
    private Date createTime = null;
    /**
     * 属性:最后修改人<br>
     */
    private String updaterCode = null;
    /**
     * 属性:最后修改时间<br>
     */
    private Date updateTime = null;
    /**
     * 属性:有效标志<br>
     */
    private String validInd = null;
    /**
     * 属性:备注<br>
     */
    private String remark = null;
    /**
     * 属性:标志字段<br>
     */
    private String flag = null;

    private String ipaddress = null;
    private String macaddress = null;
    /**
     * 属性:职业证号<br>
     */
    private String registerNo = null;
    
    private String personClassId= null;//人员类别：1-直销、2-经纪、3-个代、4-银保、5-专代、6-车商
    
    private String teamCode = null;
    
    private String rootSalesFlag = null;
    
    private String rootSalesChannel = null;
    
    private String supSalesCode = null;
    
    private String wxOrgCode = null;
    
    private String wxTeamCode = null;
    
    private String rootSalesCode = null;
    
    private Date salesDate = null;
    
    private String salesIdentifyNumber = null;
    
    /**
     * 属性:业绩归属人代码<br>
     */
    private String performanceAttrUserCode  = null;
    
    public String getRegisterNo() {
		return registerNo;
	}

	public void setRegisterNo(String registerNo) {
		this.registerNo = registerNo;
	}

	public String getIpaddress() {
		return ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}

	public String getMacaddress() {
		return macaddress;
	}

	public void setMacaddress(String macaddress) {
		this.macaddress = macaddress;
	}

	/**
     * 默认构造方法,构造一个默认的GgUserDtoBase对象
     */
    public GgUserDtoBase() {
    }

    /**
     * 设置属性员工代码<br>
     * @param userCode 待设置的属性员工代码的值
     */
    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    /**
     * 获取属性员工代码<br>
     * @return 属性员工代码的值
     */
    public String getUserCode() {
        return userCode;
    }

    /**
     * 设置属性员工简体中文名称<br>
     * @param userCName 待设置的属性员工简体中文名称的值
     */
    public void setUserCName(String userCName) {
        this.userCName = userCName;
    }

    /**
     * 获取属性员工简体中文名称<br>
     * @return 属性员工简体中文名称的值
     */
    public String getUserCName() {
        return userCName;
    }

    /**
     * 设置属性员工繁体中文名称<br>
     * @param userTName 待设置的属性员工繁体中文名称的值
     */
    public void setUserTName(String userTName) {
        this.userTName = userTName;
    }

    /**
     * 获取属性员工繁体中文名称<br>
     * @return 属性员工繁体中文名称的值
     */
    public String getUserTName() {
        return userTName;
    }

    /**
     * 设置属性员工英文名称<br>
     * @param userEName 待设置的属性员工英文名称的值
     */
    public void setUserEName(String userEName) {
        this.userEName = userEName;
    }

    /**
     * 获取属性员工英文名称<br>
     * @return 属性员工英文名称的值
     */
    public String getUserEName() {
        return userEName;
    }

    /**
     * 设置属性密码<br>
     * @param password 待设置的属性密码的值
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取属性密码<br>
     * @return 属性密码的值
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置属性印鉴<br>
     * @param seal 待设置的属性印鉴的值
     */
    public void setSeal(String seal) {
        this.seal = seal;
    }

    /**
     * 获取属性印鉴<br>
     * @return 属性印鉴的值
     */
    public String getSeal() {
        return seal;
    }

    /**
     * 设置属性密码设置日期<br>
     * @param passwordSetDate 待设置的属性密码设置日期的值
     */
    public void setPasswordSetDate(Date passwordSetDate) {
        this.passwordSetDate = passwordSetDate;
    }

    /**
     * 获取属性密码设置日期<br>
     * @return 属性密码设置日期的值
     */
    public Date getPasswordSetDate() {
        return passwordSetDate;
    }

    /**
     * 设置属性密码过期日期<br>
     * @param passwordExpireDate 待设置的属性密码过期日期的值
     */
    public void setPasswordExpireDate(Date passwordExpireDate) {
        this.passwordExpireDate = passwordExpireDate;
    }

    /**
     * 获取属性密码过期日期<br>
     * @return 属性密码过期日期的值
     */
    public Date getPasswordExpireDate() {
        return passwordExpireDate;
    }

    /**
     * 设置属性归属机构代码<br>
     * @param companyCode 待设置的属性归属机构代码的值
     */
    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    /**
     * 获取属性归属机构代码<br>
     * @return 属性归属机构代码的值
     */
    public String getCompanyCode() {
        return companyCode;
    }

    /**
     * 设置属性出单机构代码<br>
     * @param issueCompany 待设置的属性出单机构代码的值
     */
    public void setIssueCompany(String issueCompany) {
        this.issueCompany = issueCompany;
    }

    /**
     * 获取属性出单机构代码<br>
     * @return 属性出单机构代码的值
     */
    public String getIssueCompany() {
        return issueCompany;
    }

    /**
     * 设置属性账号代码<br>
     * @param accountCode 待设置的属性账号代码的值
     */
    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    /**
     * 获取属性账号代码<br>
     * @return 属性账号代码的值
     */
    public String getAccountCode() {
        return accountCode;
    }

    /**
     * 设置属性电话号码<br>
     * @param phone 待设置的属性电话号码的值
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取属性电话号码<br>
     * @return 属性电话号码的值
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置属性手机号码<br>
     * @param mobile 待设置的属性手机号码的值
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取属性手机号码<br>
     * @return 属性手机号码的值
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置属性通信地址<br>
     * @param address 待设置的属性通信地址的值
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取属性通信地址<br>
     * @return 属性通信地址的值
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置属性邮政编码<br>
     * @param postCode 待设置的属性邮政编码的值
     */
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    /**
     * 获取属性邮政编码<br>
     * @return 属性邮政编码的值
     */
    public String getPostCode() {
        return postCode;
    }

    /**
     * 设置属性邮箱<br>
     * @param email 待设置的属性邮箱的值
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取属性邮箱<br>
     * @return 属性邮箱的值
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置属性员工标志<br>
     * 含义:--** [1]: 1操作员--** [2]: 1经办人--** [3]：1业务员<br>
     * @param userInd 待设置的属性员工标志的值
     */
    public void setUserInd(String userInd) {
        this.userInd = userInd;
    }

    /**
     * 获取属性员工标志<br>
     * 含义:--** [1]: 1操作员--** [2]: 1经办人--** [3]：1业务员<br>
     * @return 属性员工标志的值
     */
    public String getUserInd() {
        return userInd;
    }

    /**
     * 设置属性允许登录的应用系统<br>
     * 含义:--** [1]: 1核心业务系统--** [2]：1财务系统--** [3]：1再保险系统--** [4]：1 单证系统--** [5]：1核保核赔系统<br>
     * @param loginSystem 待设置的属性允许登录的应用系统的值
     */
    public void setLoginSystem(String loginSystem) {
        this.loginSystem = loginSystem;
    }

    /**
     * 获取属性允许登录的应用系统<br>
     * 含义:--** [1]: 1核心业务系统--** [2]：1财务系统--** [3]：1再保险系统--** [4]：1 单证系统--** [5]：1核保核赔系统<br>
     * @return 属性允许登录的应用系统的值
     */
    public String getLoginSystem() {
        return loginSystem;
    }

    /**
     * 设置属性创建人<br>
     * @param creatorCode 待设置的属性创建人的值
     */
    public void setCreatorCode(String creatorCode) {
        this.creatorCode = creatorCode;
    }

    /**
     * 获取属性创建人<br>
     * @return 属性创建人的值
     */
    public String getCreatorCode() {
        return creatorCode;
    }

    /**
     * 设置属性创建时间<br>
     * @param createTime 待设置的属性创建时间的值
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取属性创建时间<br>
     * @return 属性创建时间的值
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置属性最后修改人<br>
     * @param updaterCode 待设置的属性最后修改人的值
     */
    public void setUpdaterCode(String updaterCode) {
        this.updaterCode = updaterCode;
    }

    /**
     * 获取属性最后修改人<br>
     * @return 属性最后修改人的值
     */
    public String getUpdaterCode() {
        return updaterCode;
    }

    /**
     * 设置属性最后修改时间<br>
     * @param updateTime 待设置的属性最后修改时间的值
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取属性最后修改时间<br>
     * @return 属性最后修改时间的值
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置属性有效标志<br>
     * @param validInd 待设置的属性有效标志的值
     */
    public void setValidInd(String validInd) {
        this.validInd = validInd;
    }

    /**
     * 获取属性有效标志<br>
     * @return 属性有效标志的值
     */
    public String getValidInd() {
        return validInd;
    }

    /**
     * 设置属性备注<br>
     * @param remark 待设置的属性备注的值
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取属性备注<br>
     * @return 属性备注的值
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置属性标志字段<br>
     * @param flag 待设置的属性标志字段的值
     */
    public void setFlag(String flag) {
        this.flag = flag;
    }

    /**
     * 获取属性标志字段<br>
     * @return 属性标志字段的值
     */
    public String getFlag() {
        return flag;
    }

    public String getPersonClassId() {
		return personClassId;
	}

	public void setPersonClassId(String personClassId) {
		this.personClassId = personClassId;
	}

	public String getTeamCode() {
		return teamCode;
	}

	public void setTeamCode(String teamCode) {
		this.teamCode = teamCode;
	}

	public String getRootSalesFlag() {
		return rootSalesFlag;
	}

	public void setRootSalesFlag(String rootSalesFlag) {
		this.rootSalesFlag = rootSalesFlag;
	}

	public String getRootSalesChannel() {
		return rootSalesChannel;
	}

	public void setRootSalesChannel(String rootSalesChannel) {
		this.rootSalesChannel = rootSalesChannel;
	}

	public String getSupSalesCode() {
		return supSalesCode;
	}

	public void setSupSalesCode(String supSalesCode) {
		this.supSalesCode = supSalesCode;
	}

	public String getWxOrgCode() {
		return wxOrgCode;
	}

	public void setWxOrgCode(String wxOrgCode) {
		this.wxOrgCode = wxOrgCode;
	}

	public String getWxTeamCode() {
		return wxTeamCode;
	}

	public void setWxTeamCode(String wxTeamCode) {
		this.wxTeamCode = wxTeamCode;
	}
	
	public String getPerformanceAttrUserCode() {
		return performanceAttrUserCode;
	}

	public void setPerformanceAttrUserCode(String performanceAttrUserCode) {
		this.performanceAttrUserCode = performanceAttrUserCode;
	}
	
	public String getRootSalesCode() {
		return rootSalesCode;
	}

	public void setRootSalesCode(String rootSalesCode) {
		this.rootSalesCode = rootSalesCode;
	}

	public Date getSalesDate() {
		return salesDate;
	}

	public void setSalesDate(Date salesDate) {
		this.salesDate = salesDate;
	}

	/**
     * 比较两个对象在逻辑上是否相等
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GgUserDtoBase)) {
            return false;
        }

        final GgUserDtoBase otherDto = (GgUserDtoBase) other;
        if (getUserCode()!=null && !getUserCode().equals(otherDto.getUserCode())) {
            return false;
        }
        return true;
    }

    /**
     * 根据主键生成HashCode
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        String key = "" + "|" + getUserCode();
        return key.hashCode();
    }

	public String getSalesIdentifyNumber() {
		return salesIdentifyNumber;
	}

	public void setSalesIdentifyNumber(String salesIdentifyNumber) {
		this.salesIdentifyNumber = salesIdentifyNumber;
	}
}
