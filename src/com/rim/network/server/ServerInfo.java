package com.rim.network.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ServerInfo {
	private String[] names;
	private String name;
	
	public ServerInfo() {
		// TODO Auto-generated constructor stub
		this.names=null;
		this.name=null;
	}

	// sendServer
	public boolean sendClient(Socket sc, OutputStream os, OutputStreamWriter ow, BufferedWriter bw, Scanner ssc)
			throws Exception {
		os = sc.getOutputStream();
		ow = new OutputStreamWriter(os);
		bw = new BufferedWriter(ow);
		String s;
		if (this.name == null) {
			System.out.println("클라이언트로 보낼 메세지 입력");
			s = ssc.next();
		} else
			s = this.name;

		boolean check = true;

		bw.write(s);
		bw.write("\r\n");
		bw.flush();
		if (s.equals("false"))
			check = false;

		return check;
	}

	public boolean receiveClient(Socket sc, InputStream is, InputStreamReader ir, BufferedReader br) throws Exception {
		is = sc.getInputStream();// byte
		ir = new InputStreamReader(is);// char
		br = new BufferedReader(ir);
		String s = br.readLine();

		this.names = s.split(",");
		this.name = pick(this.names);

		boolean check = true;
		if (s.equals("false"))
			check = false;
		else {
			System.out.println("client>> " + this.name);
		}

		return check;
	}

	public String pick(String[] names) {
		Random r = new Random();
		int num = r.nextInt(names.length);
		return names[num];
	}

}
