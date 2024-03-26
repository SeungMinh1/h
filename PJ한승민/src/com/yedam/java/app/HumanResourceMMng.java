package com.yedam.java.app;

import java.util.Scanner;

public class HumanResourceMMng {
	
Scanner sc = null; //new Scanner(System.in);
	
	// 생성자
		public HumanResourceMMng() {
			sc = new Scanner(System.in);
		}
	
	public void run() {
		boolean role = LoginControl.loginManger();
		while(true) {
			
			menuPrint(role);
			if(role == true) {
				int menu = selectMenu();
				if(menu ==1) {
					new CmemManagement().run();
				}else if(menu == 2) {
					new EduManagement().run();
				}else if(menu == 9) {
					end();
					break;
				}else {
					showError();
				}
			}else {
				int menu = selectMenu();
				if(menu ==1) {
					new EnrolmentMng().run();////////////////////////수강신청 만들어야됨
				}else if(menu == 9) {
					end();
					break;
				}else {
					showError();
				}
			}
			
		}
	}
	private void menuPrint(boolean role) {
		String menu = "";
		if(role) {
			menu += "1.회원관리 ";
			menu += "2.부서관리 ";
		}else {
			menu += "1. 수강신청 ";
		}
		menu += "9.로그아웃 ";
		System.out.println("===========================================================");
		System.out.println(menu);
		System.out.println("===========================================================");
		
	}
	
	
	private void showError() {
		System.out.println("메뉴에서 선택하세요.");
	}
	private void end() {
		System.out.println("로그아웃 합니다.");
	}
	private int selectMenu() {
		System.out.print("선택 > ");
		return inputNumber();
	}
	private int inputNumber() {
		int num = 0;
		try {
			num = Integer.parseInt(sc.nextLine());
		}catch(NumberFormatException e) {
			System.out.println("숫자를 입력하시오");
		}
		return num;
	}
	
	
	
	
	
	
}