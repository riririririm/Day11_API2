package com.rim.io.file.rw;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MemberAdd {

	public void backup(File file, ArrayList<Person> info) {
		// 파일저장경로 : 원래파일에 덮어쓰기
		FileWriter writer = null;
		try {
			writer = new FileWriter(file,false);

			for (Person p : info) {
				writer.write(p.getGname() + "-");
				writer.write(p.getName() + "-");
				writer.write(p.getAge() + "-");
				writer.write(p.getPosition() + "-");
				writer.write(p.getAgency() + "\r\n");
				writer.flush();
			}
			System.out.println("백업완료");

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} // end of finally

	}

	public void add(Scanner sc, ArrayList<Person> info) {
		Person p = new Person();

		System.out.println("그룹명:");
		p.setGname(sc.next());
		System.out.println("이름:");
		p.setName(sc.next());
		System.out.println("나이:");
		p.setAge(sc.nextInt());
		System.out.println("역할:");
		p.setPosition(sc.next());
		System.out.println("소속사:");
		p.setAgency(sc.next());

		info.add(p);

	}

}
