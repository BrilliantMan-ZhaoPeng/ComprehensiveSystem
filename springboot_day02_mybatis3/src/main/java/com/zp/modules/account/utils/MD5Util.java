package com.zp.modules.account.utils;

import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

public class MD5Util {
private static final String SALT = "&%5123***&&%%$$#@";
	public static String getMD5(String str) {
		if (str.isEmpty()||str==null) {
			return null;
		}
		String base = str + "/" + SALT;
		return DigestUtils.md5DigestAsHex(base.getBytes());
	}
	public static void main(String[] args) {
		String md5 = getMD5("123");
		System.err.println(md5);
	}
}
