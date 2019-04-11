package com.rim.network.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ServerMenu {
	
	public ArrayList<String> readMenu(File file, BufferedReader br) throws IOException {
		FileReader fr = new FileReader(file);
		br = new BufferedReader(fr);
		String menu = null;
		ArrayList<String> lunch_dinner = new ArrayList<String>();
		
		while((menu=br.readLine())!=null) {
			 lunch_dinner.add(menu);
		}
		br.close();
		return lunch_dinner;
	}
	
	public void randomMenu(ArrayList<String> lunch_dinner, Socket sc, OutputStream os, OutputStreamWriter ow, BufferedWriter bw) throws IOException {
		Random r = new Random();
		int index = r.nextInt(lunch_dinner.size());
		String menu = lunch_dinner.get(index);
		System.out.println(menu);
		
		os = sc.getOutputStream();
		ow = new OutputStreamWriter(os);
		bw = new BufferedWriter(ow);
		bw.write(menu);
		bw.write("\r\n");
		bw.flush();
	}

}
