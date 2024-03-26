package com.yedam.java.app;

import java.util.List;
import java.util.Scanner;

import com.yedam.education.EduClass;
import com.yedam.education.EduClassDAO;

public class EnrolmentMng {
	
	private Scanner sc = new Scanner(System.in);
	private EduClassDAO educlassDAO= EduClassDAO.getInstance();
	
	public void run() {
		
		while(true) {
			menuPrint();
			
			int menuNo = menuSelect();
			
			if(menuNo == 1) {
				System.out.println("수강 가능한 강좌");
				selectClassALL();
				
			}else if(menuNo == 2) {
				System.out.println("신청할 강의번호를 입력하세요");
				System.out.println("------------------------------------------------------------");
				selectClassALL();
				System.out.println(selectEClassNum());
				//EduClass eclass = selectEClassNum();
				
			}else if(menuNo == 3) {
				System.out.println("강의 취소?");
			}else if(menuNo == 9) {
				break;
			}else {
				System.out.println("메뉴에서 선택하세요");
			}
		}
		end();
			
	}
	
	
	private void selectClassALL(){
		List<EduClass> list = educlassDAO.selectClassALL();
		for(EduClass data : list) {
			System.out.println(data);
		}
	}

	private EduClass selectEClassNum() {

		int num = menuSelect();
		EduClass eclass = educlassDAO.selectClassNum(num);
		//System.out.println(eclass);
		return eclass;
		
	}
	
	private void selectEClassTitle() {
		
		String title = inputTitle2();	
		List<EduClass> list = educlassDAO.selectClassTitle(title);
		for(EduClass data : list) {
			System.out.println(data);
		}
		
	}
	private String inputTitle2() {
		System.out.print("강의제목 입력 : ");
		String changeTitle = sc.next();
		return changeTitle;
	}
	
	// 메소드
	private void end() {
		System.out.println("이전메뉴로 돌아갑니다.");
	}
	
	private void menuPrint() {
		String menu = "";
		menu += "1.수강가능한 강좌보기 ";
		menu += "2.강의신청하기 ";
		menu += "3.강의취소 ";
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
	
	
	
	

}