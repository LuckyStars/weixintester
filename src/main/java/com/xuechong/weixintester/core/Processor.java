package com.xuechong.weixintester.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.xuechong.weixintester.form.MainForm;
import com.xuechong.weixintester.utils.UrlConnectionUtil;
import com.xuechong.weixintester.utils.UrlConnectionUtil.Parameter;

public class Processor implements Runnable {

	private static final String VAL = "vali";
	private static final String EVENT_CLICK_KEY = "click_";
	private static final String EVENT_VIEW_KEY = "view_";

	private MainForm mainForm;

	public Processor(MainForm mainForm) {
		this.mainForm = mainForm;
	}

	@Override
	public void run() {
		try {
			String inputQuestion = this.mainForm.getInputQuestion().getText();
			
			if (inputQuestion.equals(VAL)) {// 验证接入
				vali();
			} else if (inputQuestion.equals(EVENT_CLICK_KEY)){
				handleClick();
			} else if(inputQuestion.equals(EVENT_VIEW_KEY)){
				handleView();
			}else {// 处理消息
				postXml();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.mainForm.notifyDone();
	}

	

	private void postXml() throws IOException {
		this.mainForm.appendNewLine("post xml");
		
		String postUrl = this.mainForm.getInputUrl().getText();
		
		String postXml = TextMsg.simpleTextMsg(
				this.mainForm.getInputQuestion().getText()).toString();
		
		this.mainForm.appendNewLine(new String(postXml.getBytes("UTF-8")));
		
		String resp = Utils.postXml(postXml, postUrl);
		
		this.mainForm.appendNewLine("response is :");
		this.mainForm.appendNewLine(resp);
		
	}

	private void handleView() {
		// TODO Auto-generated method stub
		String eventKey = this.mainForm.getInputQuestion().getText().toString().replaceFirst(EVENT_VIEW_KEY, "");
		
	}
	
	private void handleClick(){
		String eventKey = this.mainForm.getInputQuestion().getText().toString().replaceFirst(EVENT_CLICK_KEY, "");
		
		
		
	}
	
	
	
	/**
	 * 验证接入
	 * @throws NoSuchAlgorithmException
	 * @throws IOException
	 */
	@SuppressWarnings("serial")
	private void vali() throws NoSuchAlgorithmException, IOException {
		
		List<String> list = new ArrayList<String>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		
		final String token = mainForm.getInputToken().getText();
		final String timestamp = sdf.format(new Date());
		Double non = Math.random()*99999;
		final String nonce = String.valueOf(non.intValue());
		
		list.add(token);
		list.add(timestamp);
		list.add(nonce);
		
		Collections.sort(list);
		
		StringBuilder joinstr = new StringBuilder();
		for (String string : list) {
			joinstr.append(string);
		}
		
		MessageDigest md = MessageDigest.getInstance("SHA-1");
		md.update(joinstr.toString().getBytes());
		byte[] digest = md.digest();
		
		StringBuilder sha = new StringBuilder();
		for (byte b : digest) {
			String hexValue = Integer.toHexString(b >= 0 ? b : 256 + b);
			if(hexValue.length()<2){
				hexValue = "0" + hexValue;
			}
			sha.append(hexValue);
		}
		
		final String signature = sha.toString();
		
		
		List<UrlConnectionUtil.Parameter> params = 
			new ArrayList<UrlConnectionUtil.Parameter>(){{
			add(Parameter.newInstance("token", token));
			add(Parameter.newInstance("timestamp", timestamp));
			add(Parameter.newInstance("nonce", nonce));
			add(Parameter.newInstance("signature", signature));
			add(Parameter.newInstance("echostr", "vali ok"));
		}};
		
		URL url = new URL(this.mainForm.getInputUrl().getText() + "?" + UrlConnectionUtil.buildParameterStr(params));
		URLConnection con = url.openConnection();
		con.connect();
		StringBuilder resp = new StringBuilder();
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				con.getInputStream()));
		try {
			for (String line = reader.readLine(); line != null; line = reader
					.readLine()) {
				resp.append(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (reader != null)
				reader.close();
		}
		this.mainForm.appendNewLine("result = " + resp.toString());
	}

}
