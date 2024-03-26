package com.yedam.java.app;

import java.sql.Date;
import java.util.Scanner;

import com.yedam.java.center.CenterMember;
import com.yedam.java.center.CmemberDAO;
import com.yedam.java.center.LoginMemDAO;


public class LoginControl {
	
	Scanner sc = new Scanner(System.in);
	private CmemberDAO memberDAO = CmemberDAO.getInstance();
	
	//싱글톤
	private static CenterMember loginCon = null;
	public static CenterMember getLoginInfo() {
		return loginCon;
	}
		
	public void run() {
		
		while(true) {
			menuPrint(); //메뉴출력			
			int menuNo = menuSelect();	//메뉴선택
			if(menuNo == 1) {
				//로그인
				login();
			}else if(menuNo == 2) {
				insertMember();
			}else if(menuNo == 3) {
				//종료
				end();
				break;
			}else {
				showError();
			}
		}
	}
	
	
	private void menuPrint() {
		System.out.println("========================");
		System.out.println("1.로그인 2.회원가입 3.종료");
		System.out.println("=========================");
	}
	
	private void login() {
		//아이디와 비밀번호 입력
		CenterMember inputInfo = inputMember();
		//로그인 시도
		loginCon = LoginMemDAO.getInstance().selectOne(inputInfo);
		
		//실패할 경우 그대로 메소드 종료
		if(loginCon == null) return;
		
		//성공할 경우 프로그램을 실행
		new HumanResourceMMng().run();
	}
	private CenterMember inputMember() {
		CenterMember info = new CenterMember();
		System.out.print("아이디 > ");
		info.setId(sc.nextLine());
		System.out.print("비밀번호 > ");
		info.setPwd(sc.nextLine());
		return info;
	}
	
	
	private int menuSelect() {
		int menuNo = 0;
		try {
			System.out.print("선택하세요 : ");
			menuNo = Integer.parseInt(sc.nextLine());
		}catch(NumberFormatException e) {
			System.out.println("숫자를 입력하세요.");
		}
		return menuNo;
	}
	//////////////수정중

	
	
	private void end() {
		System.out.println("프로그램을 종료합니다.");
	}
	private void showError() {
		System.out.println("메뉴에서 선택하세요.");
	}
	
	//권한체크
	public static boolean loginManger() {
		String manager = "oracle";
		if(manager.equals(loginCon.getId()) == true) {
			return true;
		}else {
			return false;
		}
	}
	
	private void insertMember() {
		CenterMember member = inputAll();
		memberDAO.insertCenterMember(member);
	}
	
	private CenterMember inputAll() {
		CenterMember member = new CenterMember();
		System.out.print("회원ID>>");
		member.setId(sc.next());
		System.out.print("비밀번호>>");
		member.setPwd(sc.next());
		System.out.print("이름>>");
		member.setName(sc.next());
		System.out.print("성별>>");
		member.setGender(sc.next());
		System.out.print("생년월일>>");
		member.setBirthdate(Date.valueOf(sc.next()));
		System.out.print("주소>>");
		member.setAddress(sc.next());
		
		return member;
	}
	
	
	

}