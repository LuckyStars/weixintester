package com.xuechong.weixintester.core;

import java.net.URL;
import java.net.URLConnection;

import com.xuechong.weixintester.form.MainForm;

public class Processor implements Runnable{

	private static final String VAL = "vali";
	
	private MainForm mainForm;
	
	public Processor(MainForm mainForm){
		this.mainForm = mainForm;
	}
	
	@Override
	public void run() {
		try {
			if (this.mainForm.getInputQuestion().equals(VAL)) {//验证接入

			} else {//处理消息
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.mainForm.notifyDone();
	}

}
