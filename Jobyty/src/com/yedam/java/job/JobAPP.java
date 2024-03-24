package com.yedam.java.job;

import java.util.List;
import java.util.Scanner;

public class JobAPP {

	public static void main(String[] args) {
		boolean run = true;
		
		Scanner scanner = new Scanner(System.in);
		JobDAO jobDao = JobDAO.getInstance();
		Empjob job = null;
		
		while(run) {
			System.out.println("");
			System.out.println("====================================================================");
			System.out.println("1.등록   2.수정  3.삭제  4.직업최소월급검색조회  5.직업전체조회  6.직업id조회 7.id all 9.종료");
			System.out.println("====================================================================");
			
			System.out.print("선택>> ");
			int menuNo = scanner.nextInt(); //Integer.parseInt(scanner.nextLine());
			scanner.nextLine();
			
			
			if(menuNo == 1) {
				job = new Empjob();
				System.out.print("id>> ");
				job.setJobid(scanner.nextLine());
				System.out.print("title>> ");
				job.setJobtitle(scanner.next());
				System.out.print("max_salary>> ");
				job.setMaxsalary(scanner.nextInt());
				System.out.print("min_salary>> ");
				job.setMinsalary(scanner.nextInt());
				
				jobDao.insertJobinfo(job);
			}
			
			if(menuNo == 4) {
				System.out.print("사번>> ");
				int minsalary = scanner.nextInt();
				job = jobDao.selectJobInfo(minsalary);
				System.out.println(job);
			}
			if(menuNo == 5) {
				List<Empjob> list = jobDao.selectJobALL();
				for(Empjob data : list) {
					System.out.println(data);
				}		
			}
			if(menuNo == 6) {
				System.out.print("아이디>> ");
				String id= scanner.nextLine();
				job = jobDao.selectJobInfoID(id);
				System.out.println(job);
			}	
			
			if(menuNo == 7) {   ////안되네 왜안되지 어떻게하지 = CLEAR
				System.out.print("아이디>> ");
				String id= scanner.nextLine();
				List<Empjob> list = jobDao.selectJobInfoIDALL(id);
				for(Empjob data : list) {
					System.out.println(data);
				}		
			}	
			if(menuNo == 9) {
				System.out.println("시스템 종료");
				run = false;
			}
		}
	}
}
