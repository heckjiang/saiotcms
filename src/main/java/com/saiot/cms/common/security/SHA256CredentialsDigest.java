package com.saiot.cms.common.security;

/**
 * SHA256证书加密
 * 
 * @author jiangjun
 * 
 */
public class SHA256CredentialsDigest extends HashCredentialsDigest implements
		CredentialsDigest {
	@Override
	protected byte[] digest(byte[] input, byte[] salt) {
		return Digests.sha256(input, salt, HASH_INTERATIONS);
	}
}