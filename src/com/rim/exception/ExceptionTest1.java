package com.rim.exception;

import java.util.Scanner;

public class ExceptionTest1 {

	public static void main(String[] args) {
		//Error : 컴파일시 에러
		//Exception : 실행중 발생하는 에러
		//예외처리
		//목적 : 비정상적인 종료를 막고 정상적으로 프로그램을 진행
		//1. try{예외가 발생할만한 코드}catch(발생할 Exception타입의 매개변수){예외가 발생했을때 실행}
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자입력:");
		int num = sc.nextInt();
		int a=10;
		try {
			int result = a/num;
			//throw new ArithmeticException(); //수학적 오류예외발생
			System.out.println(result);
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("0으로는 나눌 수 없음");
		}
		
	
	}

}
