package com.rim.io.file.rw;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class MemberController {
	private Scanner sc = new Scanner(System.in);
	private ArrayList<Person> info; 
	private MemberView mv; 
	private MemberInfo mi; 
	private MemberAdd ma; 
	
	public MemberController() {
		this.info = new ArrayList<Person>();
		this.mv = new MemberView();
		this.mi = new MemberInfo();
		this.ma = new MemberAdd();
				
	}
	public void start() {
		
		File file = new File("C:\\test", "readTest.txt");
		FileReader fr = null;
		BufferedReader br = null;
		
		while(true) {
			System.out.println("1.멤버정보 가져오기 / 2.정보출력 / 3.멤버검색 / 4.그룹검색 / 5.멤버추가 / 6.백업 / 7.종료");
			int select = sc.nextInt();
			
			if(select==1) {
				info = mi.getMembers(file);
			}else if(select==2) {
				if(info.size()>0)
					mv.view(info);
				else
					mv.view("정보없음");
			}else if(select==3) {
				Person p = mi.searchMember(sc, info);
				if(p!=null)
					mv.view(p);
				else
					mv.view("해당 멤버 정보가 없음");
			}else if(select==4) {
				ArrayList<Person> search = mi.searchGroup(sc, info);
				if(search.size()>0)
					mv.view(search);
				else
					mv.view("등록된 정보가 없음");
			}else if(select==5) {
				ma.add(sc, info);
			}else if(select ==6) {
				ma.backup(file, info);
			}
			else if(select==7) {
				mv.view("프로그램 종료");
				break;
			}else {
				mv.view("1~3중에 선택하세요");
			}
		}//end of while

	}
}
