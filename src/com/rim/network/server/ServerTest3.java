package com.rim.network.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;

public class ServerTest3 {

	public static void main(String[] args) {
		ServerSocket ss = null;
		Socket sc = null;
		InputStream is =null;
		InputStreamReader ir = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		OutputStream os = null;
		OutputStreamWriter ow = null;
		String select=null;
		ArrayList<String> lunch=null;
		ArrayList<String> dinner=null;
		ServerMenu m = new ServerMenu();
		
		try {
			System.out.println("connecting...");
			ss = new ServerSocket(8282);
			sc = ss.accept();
			System.out.println("연결성공...");
			
			is = sc.getInputStream();
			ir = new InputStreamReader(is);
			br = new BufferedReader(ir);
			select=br.readLine();//1.점심 2.저녁 선택값
			 System.out.println(select);
			if(select.equals("1")) {
				File file = new File("C:\\test\\lunch.txt");
				lunch = m.readMenu(file, br);
				m.randomMenu(lunch, sc, os, ow, bw);
				
			}else if(select.equals("2")) {
				File file = new File("C:\\test\\dinner.txt");
				dinner = m.readMenu(file, br);				
				m.randomMenu(dinner, sc, os, ow, bw);
				
			}else if(select.equals("3")) {
				Random r = new Random();
				int num = r.nextInt(2)+1;
				
				if(num==1) {
					File file = new File("C:\\test\\lunch.txt");
					lunch = m.readMenu(file, br);
					m.randomMenu(lunch, sc, os, ow, bw);
				}else if(num==2) {
					File file = new File("C:\\test\\dinner.txt");
					dinner = m.readMenu(file, br);
					m.randomMenu(dinner, sc, os, ow, bw);
				}
				
			}
		
			
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				br.close();
				ir.close();
				is.close();
				bw.close();
				ow.close();
				os.close();
				sc.close();
				ss.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

}
