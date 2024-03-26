package com.yedam.java.app;

import java.util.List;
import java.util.Scanner;

import com.yedam.education.EduClass;
import com.yedam.education.EduClassDAO;

public class EduManagement {
	
	
	
	private Scanner sc = new Scanner(System.in);
	private EduClassDAO educlassDAO= EduClassDAO.getInstance();
	
	public void run() {
			
			while(true) {
				menuPrint();
				
				int menuNo = menuSelect();
				
				if(menuNo == 1) {
					insertEClass();
				}if(menuNo == 2) {
					updateEClass();
				}if(menuNo == 3) {
					deleteEClass();
				}if(menuNo == 4) {
					selectEClassTitle();
				}if(menuNo == 5) {
					selectEClassAll();
				}
				

				
				if(menuNo == 9) {
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
		menu += "1.강의등록 ";
		menu += "2.강의수정 ";
		menu += "3.강의삭제 ";
		menu += "4.강의조회 ";
		menu += "5.강의전체조회 ";
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
	
	
	private void insertEClass() {
		EduClass eclass = inputAll();
		educlassDAO.insertClass(eclass);
	}
	
	private void updateEClass() {         /////////차후 수정예정
		
		int menu =selectUpdate();
		if(menu == 1) {
			updatePrint1();
		}
		/*
		else if(menu == 2) {
			updatePrint2();
		}else if(menu == 3) {
			updatePrint3();
			*/
		else {
			System.out.println("잘못된 메뉴선택입니다.");
		}
	}
	private void updatePrint1() { ////////////////////////////////////////////아이디는 변경못하는가..?
		int num = inputNum();
		EduClass elcass = educlassDAO.selectClassNum(num);    
		
		if(elcass == null) {
			System.out.println("없는 정보입니다.");
		}else {
			System.out.println(elcass);  
			
			String changetitle = inputTitle();
			elcass.setTitle(changetitle);
			educlassDAO.updateMemberTitle(elcass);
			System.out.println("수정되었습니다.");
		}
		
	}
	
	private int selectUpdate() {
		int menu = 0;
		System.out.println("===========================================");
		System.out.println("1.강의제목 변경 | 2.담당 교수 변경 | 3.최대인원수 변경");
		System.out.println("===========================================");
		System.out.print("메뉴를 선택하시오 : ");
		menu = sc.nextInt();
		return menu;
	}
	
	
	
	
	private EduClass inputAll() {
		EduClass eclass = new EduClass();
		System.out.print("강의번호>> ");
		eclass.setClassnum(sc.nextInt());
		System.out.print("강의제목 >> ");
		eclass.setTitle(sc.next());
		System.out.print("강의 교수>>");
		eclass.setProfessor(sc.next());
		System.out.print("최대 인원수>> ");
		eclass.setMaxNum(sc.nextInt());
		return eclass;
	}
	
	private int inputNum() {
		System.out.print("강의번호>> ");
		int id = sc.nextInt(); 
		return id;
	}
	
	
	private String inputTitle() {
		System.out.print("변경할 강의제목 입력 : ");
		String changeTitle = sc.next();
		return changeTitle;
	}
	private String inputTitle2() {
		System.out.print("강의제목 입력 : ");
		String changeTitle = sc.next();
		return changeTitle;
	}
	
	private void deleteEClass() {
		int num = inputNum();
		educlassDAO.deleteEclass(num);
	}
	
	

	private void selectEClassTitle() {
		
		String title = inputTitle2();	
		List<EduClass> list = educlassDAO.selectClassTitle(title);
		for(EduClass data : list) {
			System.out.println(data);
		}
	}
	
	
	
	private void selectEClassAll() {
		List<EduClass> list = educlassDAO.selectClassALL();
		for(EduClass data : list) {
			System.out.println(data);
		}
	}
	
	
	
	

	
	
	
	
	
	

}