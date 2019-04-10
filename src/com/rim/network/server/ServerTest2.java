package com.rim.network.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class ServerTest2 {

	public static void main(String[] args) throws Exception {

		ServerSocket ss = null;
		Socket sc = null;
		InputStream is = null;
		InputStreamReader ir = null;
		BufferedReader br = null;
		OutputStream os = null;
		OutputStreamWriter ow = null;
		BufferedWriter bw = null;
		ServerInfo si = new ServerInfo();
		Scanner ssc = new Scanner(System.in);
		
		ArrayList<String> names = new ArrayList<String>();

		try {
			System.out.println("Server는 클라이언트  접속받을 준비중");
			ss = new ServerSocket(8282);
			sc = ss.accept();
			System.out.println("------연결성공------");
			boolean check = true;

			while (check) {
				check = si.receiveClient(sc, is, ir, br);
				
				if (!check)
					break;

				check = si.sendClient(sc, os, ow, bw, ssc);
				if (!check)
					break;

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
				ir.close();
				is.close();
				bw.close();
				ow.close();
				os.close();
				sc.close();
				ss.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
