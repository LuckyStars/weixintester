package com.xuechong.weixintester.core;

import org.apache.commons.lang3.StringUtils;

public class TextMsg {
	public static final String XML = 
			" <xml>"
			+ "<ToUserName><![CDATA[${toUser}]]></ToUserName>"
			+ "<FromUserName><![CDATA[${fromUser}]]></FromUserName> "
			+ "<CreateTime>${CreateTime}</CreateTime>"
			+ "<MsgType><![CDATA[${msgType}]]></MsgType>"
			+ "<Content><![CDATA[${content}]]></Content>"
			+ "<MsgId>${msgID}</MsgId>" 
			+ "</xml>";
	public static final String TO_USER = "${toUser}";
	public static final String FROM_USER = "${fromUser}";
	public static final String CREATE_TIME = "${CreateTime}";//1348831860
	public static final String MSG_TYPE = "${msgType}";//text
	public static final String CONTENT = "${content}";//this is a test
	public static final String MSG_ID = "${msgID}";//1234567890123456
	
	private String xml ;
	public TextMsg(String toUser,String fromUser,String createTime, String content,String msgId){
		this.xml = XML;
		this.setProperty(TO_USER, StringUtils.isNotBlank(toUser)?toUser:"touser");
		this.setProperty(FROM_USER,StringUtils.isNotBlank(fromUser)?fromUser:"fromUser");
		this.setProperty(MSG_TYPE, "text");
		this.setProperty(MSG_ID, StringUtils.isNotBlank(msgId)?msgId:"1234567890123456");
		this.setProperty(CONTENT, StringUtils.isNotBlank(content)?content:"content");
		this.setProperty(CREATE_TIME, StringUtils.isNotBlank(createTime)?createTime:"1348831860");
	}
	
	private void setProperty(String key,String value){
		this.xml = this.xml.replace(key, value);
	}
}
