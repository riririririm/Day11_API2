package com.rim.network.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientTest3 {

	public static void main(String[] args) {
		Scanner ssc = new Scanner(System.in);
		Socket sc = null;
		OutputStream os = null;
		OutputStreamWriter ow = null;
		BufferedWriter bw = null;
		InputStream is = null;
		InputStreamReader ir = null;
		BufferedReader br = null;

		try {
			sc = new Socket("211.238.142.24", 8282);
			os =  sc.getOutputStream();
			ow = new OutputStreamWriter(os);
			bw = new BufferedWriter(ow);
			System.out.println("1.점심 / 2.저녁  / 3.아무거나");
			int select = ssc.nextInt();
			bw.write(select+"");
			bw.write("\r\n");
			
			bw.flush();
			
			is = sc.getInputStream();
			ir = new InputStreamReader(is);
			br = new BufferedReader(ir);
			String menu = br.readLine();
			System.out.println("추천메뉴: "+menu);

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				br.close();
				ir.close();
				is.close();
				bw.close();
				ow.close();
				os.close();
				sc.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

	}

}
