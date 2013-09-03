package com.xuechong.weixintester.core;

public class EventMsg {
	private static final String XML = 
		" <xml>"
		+ "<ToUserName><![CDATA[${toUser}]]></ToUserName>"
		+ "<FromUserName><![CDATA[${fromUser}]]></FromUserName> "
		+ "<CreateTime>${CreateTime}</CreateTime>"
		+ "<MsgType><![CDATA[event]]></MsgType>"
		+ "<Event><![CDATA[${event}]]></Event>"
		+ "<EventKey><![CDATA[${eventKey}]]></EventKey>" 
		+ "</xml>";
		
	
	private String xml;
	
	public EventMsg (String toUser,String fromUser,String createTime, String event,String eventKey){
		
		
		
	}
	
	private void setProperty(String key,String value){
		this.xml = this.xml.replace(key, value);
	}
	
	
}
