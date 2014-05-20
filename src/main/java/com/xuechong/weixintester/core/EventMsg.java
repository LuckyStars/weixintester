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
	public static final String TO_USER = "${toUser}";
	public static final String FROM_USER = "${fromUser}";
	public static final String CREATE_TIME = "${CreateTime}";//1348831860
	public static final String MSG_TYPE = "${msgType}";//text
	public static final String EVENT = "${event}";//
	public static final String EVENT_KEY = "${eventKey}";//this is a test
	
	private String xml;
	
	public EventMsg (String toUser,String fromUser,String createTime, String event,String eventKey){
		this.xml = new String(XML);
		this.setProperty(TO_USER, toUser);
		this.setProperty(FROM_USER, fromUser);
		this.setProperty(CREATE_TIME, createTime);
		this.setProperty(EVENT, event);
		this.setProperty(EVENT_KEY, eventKey);
	}
	
	public static EventMsg simpleClickMsg(String eventKey){
		return new EventMsg("toUser", "fromUser", "123456789", "click", eventKey);
	}
	
	public static EventMsg simpleViewMsg(String eventKey){
		return new EventMsg("toUser", "fromUser", "123456789", "view", eventKey);
	}
	
	public void setProperty(String key,String value){
		this.xml = this.xml.replace(key, value);
	}
	
	@Override
	public String toString() {
		return this.xml.toString();
	}
	
	
}
