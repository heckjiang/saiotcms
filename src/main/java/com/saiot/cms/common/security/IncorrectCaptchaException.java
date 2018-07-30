package com.saiot.cms.common.security;

import org.apache.shiro.authc.CredentialsException;

/**
 * 验证码错误异常
 * 
 * @author jiangjun
 * 
 */
public class IncorrectCaptchaException extends CredentialsException {
	private static final long serialVersionUID = 1L;
}
