package com.rim.network.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class ClientInfo {

	// sendServer
	public boolean sendServer(BufferedWriter bw) {
		boolean check = true;
		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("서버로 보낼 메세지 입력");
			String str = sc.next();
			bw.write(str);
			bw.write("\r\n");
			bw.flush();
			if (str.equals("false"))
				check = false;
		} catch (Exception e) {
			// TODO: handle exception
		}

		return check;

	}
	// receiveServer

	public String receiveServer(Socket s) {
		InputStream is = null;
		InputStreamReader ir = null;
		BufferedReader br = null;
		String str = null;
		try {
			is = s.getInputStream();
			ir = new InputStreamReader(is);// char
			br = new BufferedReader(ir);
			str = br.readLine();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // byte

		return str;
	}
}
