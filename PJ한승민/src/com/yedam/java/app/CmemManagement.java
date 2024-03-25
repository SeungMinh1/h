package com.yedam.java.app;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.yedam.java.center.CenterMember;
import com.yedam.java.center.CmemberDAO;


public class CmemManagement {
	
	private Scanner sc = new Scanner(System.in);
	private CmemberDAO memberDAO = CmemberDAO.getInstance();
	
	public void run() {
		
		while(true) {
			menuPrint();
			
			int menuNo = menuSelect();
			
			
			if(menuNo == 1) {
				insertEmp();
			}if(menuNo == 2) {
				 updateEmp();
			}if(menuNo == 3) {
				deleteEmp();
			}if(menuNo == 4) {
				selectEmpInfo();
			}if(menuNo == 5) {
				selectEmpAll();
			}if(menuNo == 9) {
				break;
			}
		}
		end();
	}
	
	// 메소드
	private void end() {
		System.out.println("프로그램을 종료합니다.");
	}
	
	private void menuPrint() {
		String menu = "";
		menu += "1.회원등록 ";
		menu += "2.회원정보수정 ";
		menu += "3.회원삭제 ";
		menu += "4.회원조회 ";
		menu += "5.사원전체조회 ";
		menu += "9.종료 ";
		System.out.println("===========================================================");
		System.out.println(menu);
		System.out.println("===========================================================");
	}
	
	private int menuSelect() {
		int menuNo = 0;
		try {
			System.out.print("선택>> ");
			menuNo = sc.nextInt();
		}catch(NumberFormatException e) {
			System.out.println("숫자를 입력하세요.");
		}
		return menuNo;
	}
	
	private void insertEmp() {
		CenterMember member = inputAll();
		memberDAO.insertCenterMember(member);
	}
	
	private void updateEmp() {         /////////차후 수정예정
		
		int menu =selectUpdate();
		if(menu == 1) {
			updatePrint1();
		}else if(menu == 2) {
			updatePrint2();
		}else if(menu == 3) {
			updatePrint3();
		}else {
			System.out.println("잘못된 메뉴선택입니다.");
		}
	}
	private void updatePrint1() { ////////////////////////////////////////////아이디는 변경못하는가..?
		String Id = inputId();
		CenterMember member = memberDAO.slectMember(Id);    
		
		if(member == null) {
			System.out.println("없는 정보입니다.");
		}else {
			System.out.println(member);
			String changeid = inputid();
			member.setId(changeid);
			memberDAO.updateMemberid(member);
			System.out.println("수정되었습니다.");
		}
		
	}
	private void updatePrint2() {
		String Id = inputId();
		CenterMember member = memberDAO.slectMember(Id);    
		if(member == null) {
			System.out.println("없는 정보입니다.");
		}else {
			System.out.println(member);
			String changepwd = inputpwd();
			member.setPwd(changepwd);
			memberDAO.updateMemberpwd(member);
			System.out.println("수정되었습니다.");
		}
		
	}
	private void updatePrint3() {
		String Id = inputId();
		CenterMember member = memberDAO.slectMember(Id);    
		if(member == null) {
			System.out.println("없는 정보입니다.");
		}else {
			System.out.println(member);
			String changeaddress = inputaddress();
			member.setAddress(changeaddress);
			memberDAO.updateMemberaddress(member);
			System.out.println("수정되었습니다.");
		}
		
	}
	
	
	
	private void deleteEmp() {
		String Id = inputId();
		memberDAO.deleteMember(Id);
	}
	
	private void selectEmpInfo() {
		
		String Id = inputId();
		CenterMember member = memberDAO.slectMember(Id);
		System.out.println(member);
	}
	
	private int selectUpdate() {
		int menu = 0;
		System.out.println("=====================================");
		System.out.println("1.아이디 변경 | 2.비밀번호 변경 | 3.주소변경");
		System.out.println("=====================================");
		System.out.print("메뉴를 선택하시오 : ");
		menu = sc.nextInt();
		return menu;
	}
	
	
	
	
	
	private void selectEmpAll() {
		List<CenterMember> list = memberDAO.selectMemberALL();
		for(CenterMember data : list) {
			System.out.println(data);
		}
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
	
	private String inputId() {
		System.out.print("아이디>> ");
		String id = sc.next(); 
		return id;
	}
	
	private String inputpwd() {
		System.out.print("변경할 비밀번호 입력 : ");
		String changepwd = sc.next();
		return changepwd;
	}
	
	private String inputid() {
		System.out.print("변경할 아이디 입력 : ");
		String changeid = sc.next();
		return changeid;
	}
	private String inputaddress() {
		System.out.print("변경할 주소 입력 : ");
		String changeaddress = sc.next();
		return changeaddress;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
