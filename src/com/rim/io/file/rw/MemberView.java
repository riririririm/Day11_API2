package com.rim.io.file.rw;

import java.util.ArrayList;

public class MemberView {

	public void view(ArrayList<Person> info) {
		for (Person p : info) {
			System.out.println("그룹:"+p.getGname() + "  이름:" + p.getName() + 
					"  나이:" + p.getAge() + "  역할:" + p.getPosition() + 
					"  소속사:"+ p.getAgency());
		}
	}
	
	public void view(Person p) {
		System.out.println("그룹:"+p.getGname() + "  이름:" + p.getName() + 
				"  나이:" + p.getAge() + "  역할:" + p.getPosition() + 
				"  소속사:"+ p.getAgency());
	}
	
	public void view(String str) {
		System.out.println(str);
	}
}
