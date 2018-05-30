package com.me.demo.util;

import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.acegisecurity.context.SecurityContextHolder;
import org.acegisecurity.providers.UsernamePasswordAuthenticationToken;
import org.acegisecurity.ui.WebAuthenticationDetails;
import org.acegisecurity.ui.webapp.AuthenticationProcessingFilter;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.Globals;

import com.me.demo.dto.GgUserDto;



/**
 * 模拟登陆工具类 单例
 * @author nong
 *
 */
public class SimulateLoginUtil {
	
	private static SimulateLoginUtil simulateLogin = new SimulateLoginUtil();
	
	private SimulateLoginUtil(){}
	
	public static SimulateLoginUtil getInstance(){
		return simulateLogin;
	}
	
	/**
	 * 登陆操作
	 * @param request
	 * @param userName
	 * @param password
	 * @param language
	 * @return 0-账号密码错误 1-登陆成功或者已登陆
	 */
	public String login(HttpServletRequest request, String userName, String password, String language){
		HttpSession session = request.getSession();
		// 已登录
		GgUserDto loginedUser = (GgUserDto) session.getAttribute("user");
		if(loginedUser != null && loginedUser.getUserCode().equals(userName)){
			return "1";
		}
		
		// 未登陆
		// GgUserDto user = ServiceManager.platform.getGgUserService().findByPrimaryKey(userName);
		GgUserDto user = new GgUserDto();
		if(user != null){
			// 校验密码
			if(StringUtils.isBlank(password)){
				return "0";
			}
			//同意登录特殊处理
			String encryptPassword ="";
			if(password.length()<32){
				encryptPassword = KeysMD5Utils.GetMD5Code(password).toUpperCase();
			}else{
				encryptPassword= password;
			}
			if(!user.getPassword().equals(encryptPassword)){
				return "0";
			}
			
			// 设置语言
	        String[] lang = StringUtils.split(language, "_");
	        Locale locale;
	        switch(lang.length) {
	            case 1:
	                locale = new Locale(lang[0]);
	                break;
	            case 2:
	                locale = new Locale(lang[0], lang[1]);
	                break;
	            case 3:
	                locale = new Locale(lang[0], lang[1], lang[2]);
	                break;
	            default:
	                locale = Locale.getDefault();
	                break;
	        }
	        session.setAttribute(Globals.LOCALE_KEY, locale);
	        String currentLanguage = "E"; // 默认语言为英文
	        if(locale.equals(Locale.SIMPLIFIED_CHINESE)) {
	            currentLanguage = "C";
	        }
	        else if(locale.getCountry().equals("HK")) {
	            currentLanguage = "T";
	        }
			
			
	        user.setCurrentLanguage(currentLanguage);
			user.setLoginSystemCode("application");
			user.setLoginComCode(user.getCompanyCode());
			user.setClientAddr(request.getRemoteAddr());
			user.setLoginTime(new DateTime(new Date(), DateTime.YEAR_TO_SECOND));
			user.setSessionString(session.toString());
			session.setAttribute("user", user);
			session.setAttribute("fromQcar", "1");//为新车险过来的设置标示（页面展示的时候，定义不统一）
			session.setAttribute("PASSWORD", password);
			
			session.setAttribute(AuthenticationProcessingFilter.ACEGI_SECURITY_LAST_USERNAME_KEY, userName);
			

			 //根据userDetails构建新的Authentication,这里使用了  
		    //PreAuthenticatedAuthenticationToken当然可以用其他token,如UsernamePasswordAuthenticationToken                 
			UsernamePasswordAuthenticationToken              authentication =   
		          new UsernamePasswordAuthenticationToken(user, user.getPassword());  
		      
		    //设置authentication中details  
		    authentication.setDetails(new WebAuthenticationDetails(request));  
		      
		    //存放authentication到SecurityContextHolder  
		    SecurityContextHolder.getContext().setAuthentication(authentication); 
		    
			
			return "1";
		}else{
			// 账号密码错误
			return "0";
		}
	}
}
