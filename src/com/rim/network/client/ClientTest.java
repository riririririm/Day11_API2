package com.rim.network.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientTest {

	public static void main(String[] args) {
		Socket s=null;
		OutputStream os=null;
		OutputStreamWriter ow = null;
		BufferedWriter bw = null;
		InputStream is=null;
		InputStreamReader ir = null;
		BufferedReader br = null;
		Scanner sc = new Scanner(System.in);
		ClientInfo info = new ClientInfo();
				
		try {
			boolean check=true;
			
			s = new Socket("211.238.142.24", 8282);
			System.out.println("서버와 접속 성공");
			os = s.getOutputStream();//byte
			ow = new OutputStreamWriter(os);//char
			bw = new BufferedWriter(ow);
			while(check) {
//			System.out.println("서버로 보낼 메세지 입력");
//			String str= sc.next();
//			bw.write(str);
//			bw.write("\r\n");
//			bw.flush();
//			if(str.equals("false"))
//				break;
			check = info.sendServer(bw);
			
//			is = s.getInputStream();//byte
//			ir = new InputStreamReader(is);//char
//			br = new BufferedReader(ir);
//			String str = br.readLine();
//			if(str.equals("false"))
//				break;
//			System.out.println("Message : "+str);
			String str=info.receiveServer(s);
			if (str.equals("false"))
				break;
			System.out.println("Message : " + str);
			
			}	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				bw.close();
				ow.close();
				os.close();
				br.close();
				ir.close();
				is.close();
				s.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("Client 종료");

	}


}
