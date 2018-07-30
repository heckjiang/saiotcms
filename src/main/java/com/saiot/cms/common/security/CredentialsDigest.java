package com.saiot.cms.common.security;

/**
 * 证书加密
 * 
 * @author jiangjun
 * 
 */
public interface CredentialsDigest {
	public String digest(String plainCredentials, byte[] salt);

	public boolean matches(String credentials, String plainCredentials,
			byte[] salt);
}
