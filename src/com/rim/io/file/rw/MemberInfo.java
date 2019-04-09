package com.rim.io.file.rw;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MemberInfo {
	
	private ArrayList<Person> searchAgency(Scanner sc, ArrayList<Person> info) {
		ArrayList<Person> search = new ArrayList<Person>();
		System.out.println("소속사:");
		String agency = sc.next();
		for(Person person:info) {
			if(person.getAgency().equals(agency)) {
				search.add(person);
			}
		}
		return search;
		
	}
	
	private ArrayList<Person> searchTeam(Scanner sc, ArrayList<Person> info) {
		ArrayList<Person> search = new ArrayList<Person>();
	
		System.out.println("그룹명:");
		String gName = sc.next();
		for(Person person:info) {
			if(person.getGname().equals(gName)) {
				search.add(person);
			}
		}
		return search;
	
	}
	
	public ArrayList<Person> searchGroup(Scanner sc, ArrayList<Person> info) {
		System.out.println("1.그룹명 / 2.소속사");
		int select = sc.nextInt();
		ArrayList<Person> search = new ArrayList<Person>();
		
		
		if(select==1) {
			search = this.searchTeam(sc, info);
		}else if(select==2) {
			search = this.searchAgency(sc, info);
		}else {
			System.out.println("1,2번 중에 고르세요");
		}
		
		return search;
	}
	
	public Person searchMember(Scanner sc, ArrayList<Person> info) {
		System.out.println("검색할 멤버 이름:");
		String name = sc.next();
		Person member=null;
		
		for(Person p:info) {
			if(p.getName().equals(name)) {
				member=p;
				break;
			}
		}
		
		return member;
	}

	public ArrayList<Person> getMembers(File file) {
		FileReader fr = null;
		BufferedReader br = null;
		ArrayList<Person> info = new ArrayList<Person>();
		
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);

			String str = null;
			br.readLine();

			while ((str = br.readLine()) != null) {
				String[] str2 = str.split("-"); // 1라인

				for (int i = 0; i < str2.length; i += 5) {
					Person p = new Person();
					p.setGname(str2[i]);
					p.setName(str2[i + 1]);
					p.setAge(Integer.parseInt(str2[i + 2]));
					p.setPosition(str2[i + 3]);
					p.setAgency(str2[i + 4]);
					info.add(p);
				}
			} // end of while
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}//end of finally
		
		return info;
	}
	
	
}
