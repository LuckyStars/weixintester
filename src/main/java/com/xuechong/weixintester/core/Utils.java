package com.xuechong.weixintester.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

public class Utils {
	public static String postXml(String content,String postUrl) throws IOException{
		OutputStreamWriter out = null;
		URLConnection con=null;
		BufferedReader br = null;
		try {
			
			URL url = new URL(postUrl);
			con = url.openConnection();
			con.setDoOutput(true);
			con.setDoInput(true);
			con.setRequestProperty("Pragma:", "no-cache");
			con.setRequestProperty("Cache-Control", "no-cache");
			con.setRequestProperty("Content-Type", "text/xml");
			out = new OutputStreamWriter(con.getOutputStream());
			
			out.write(new String(content.getBytes("UTF-8")));
			out.flush();
			
			br = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			
			StringBuilder result = new StringBuilder();
			String line = "";
			for (line = br.readLine(); line != null; line = br.readLine()) {
				result.append(line + "\n");
			}
			
			return result.toString();
			
		} catch (Exception e) {
			e.printStackTrace();
			return e.toString();
		}finally{
			if(out!=null){out.close();}
			if(br!=null){br.close();}
		}
	}
}
