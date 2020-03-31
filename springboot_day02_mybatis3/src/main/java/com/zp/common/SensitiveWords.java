package com.zp.common;
public class SensitiveWords {
	//敏感词汇
	public static String [] words={"尼玛","你妈","妈的","fuck","你妹夫的","丫的","曹尼玛","我去","我靠","我日","日你妹夫","日你妈","傻逼","沙雕"};
	public static String  isSensitiveWords(String word) {
		StringBuilder stringBuilder=new StringBuilder();
		for(int i=0;i<words.length;i++) {
			String tempWords=words[i];
			for(int j=0;j<tempWords.length();j++) {
				  stringBuilder.append("*");
			}
			word=word.replace(tempWords,stringBuilder.toString());
			stringBuilder=new StringBuilder("");
		}
		 return word;
	}
}
