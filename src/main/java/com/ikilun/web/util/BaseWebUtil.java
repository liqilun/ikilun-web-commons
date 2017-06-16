package com.ikilun.web.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

public abstract class BaseWebUtil {
	public static final String getRemoteIp(HttpServletRequest request) {
		String xfwd = request.getHeader("X-Forwarded-For");
		String result = getRemoteIpFromXfwd(xfwd);
		if(StringUtils.isNotBlank(result)){
			return result;
		}
		return request.getRemoteAddr();
	}
	public static final String getRemoteIpFromXfwd(String xfwd){
		if (StringUtils.isNotBlank(xfwd)) {
			String[] ipList = xfwd.split(",");
			for(int i=ipList.length -1; i>=0; i--){
				String ip = ipList[i];
				ip = StringUtils.trim(ip);
				if (!ip.equals("127.0.0.1") && !ip.equals("localhost")){
					return ip;
				}
			}
		}
		return null; 
	}
}
