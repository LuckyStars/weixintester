package com.xuechong.weixintester.core;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.xuechong.weixintester.form.MainForm;

public class Processor implements Runnable {

	private static final String VAL = "vali";
	private static final String EVENT_KEY = "event_";

	private MainForm mainForm;

	public Processor(MainForm mainForm) {
		this.mainForm = mainForm;
	}

	@Override
	public void run() {
		try {
			if (this.mainForm.getInputQuestion().getText().equals(VAL)) {// 验证接入
				vali();
			} else if (this.mainForm.getInputQuestion().getText().equals(EVENT_KEY)){
				handleEvent();
			} else {// 处理消息
				postXml();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.mainForm.notifyDone();
	}

	private void postXml() throws IOException {
		this.mainForm.appendNewLine("post xml");
		OutputStreamWriter out = null;
		URLConnection con=null;
		BufferedReader br = null;
		try {
			
			URL url = new URL(this.mainForm.getInputUrl().getText());
			con = url.openConnection();
			con.setDoOutput(true);
			con.setDoInput(true);
			con.setRequestProperty("Pragma:", "no-cache");
			con.setRequestProperty("Cache-Control", "no-cache");
			con.setRequestProperty("Content-Type", "text/xml");
			out = new OutputStreamWriter(con.getOutputStream());
			
			String xm = TextMsg.simpleTextMsg(
					this.mainForm.getInputQuestion().getText()).toString();
			this.mainForm.appendNewLine(new String(xm.getBytes("UTF-8")));
			out.write(new String(xm.getBytes("UTF-8")));
			out.flush();
			
			br = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			this.mainForm.appendNewLine("response is :");
			String line = "";
			for (line = br.readLine(); line != null; line = br.readLine()) {
				this.mainForm.appendNewLine(new String(line.getBytes("utf-8")));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			this.mainForm.appendNewLine(e.toString());
		}finally{
			if(out!=null){out.close();}
			if(br!=null){br.close();}
		}
	}

	private void vali() throws NoSuchAlgorithmException {
		
		List<String> list = new ArrayList<String>();
		String timestamp,nonce,token,echostr;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		
		token = mainForm.getInputToken().getText();
		timestamp = sdf.format(new Date());
		Double non = Math.random()*99999;
		nonce = String.valueOf(non.intValue());
		echostr = UUID.randomUUID().toString();
		
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
		byte[] signature = md.digest();
		
		StringBuilder sha = new StringBuilder();
		for (byte b : signature) {
			//sha.append(Integer.toHexString(new Byte(b).intValue()) + "    ");
			sha.append(Byte.toString(b));
		}
		
		
		
		
	}
	
	private void handleEvent(){
		String eventKey = this.mainForm.getInputQuestion().getText().toString().replaceFirst(EVENT_KEY, "");
		
		
	}

}
