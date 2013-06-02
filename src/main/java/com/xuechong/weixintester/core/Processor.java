package com.xuechong.weixintester.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

import com.xuechong.weixintester.form.MainForm;

public class Processor implements Runnable {

	private static final String VAL = "vali";

	private MainForm mainForm;

	public Processor(MainForm mainForm) {
		this.mainForm = mainForm;
	}

	@Override
	public void run() {
		try {
			if (this.mainForm.getInputQuestion().equals(VAL)) {// 验证接入
				vali();
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
			con.setRequestProperty("Pragma:", "no-cache");
			con.setRequestProperty("Cache-Control", "no-cache");
			con.setRequestProperty("Content-Type", "text/xml");
			out = new OutputStreamWriter(con.getOutputStream());
			String xm = TextMsg.simpleTextMsg(
					this.mainForm.getInputQuestion().getText()).toString();
			this.mainForm.appendNewLine(xm);
			out.write(new String(xm.getBytes("UTF-8")));
			out.flush();
			
			br = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			this.mainForm.appendNewLine("response is :");
			String line = "";
			for (line = br.readLine(); line != null; line = br.readLine()) {
				this.mainForm.appendNewLine(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.mainForm.appendNewLine(e.toString());
		}finally{
			if(out!=null){out.close();}
			if(br!=null){br.close();}
		}
	}

	private void vali() {
		// TODO Auto-generated method stub
		
	}

}
