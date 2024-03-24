package com.yedam.java.job;

public class Empjob {

	//필드
	private String jobid;
	private String jobtitle;
	private int minsalary;
	private int maxsalary;
	
	
	
	//생성자
	
	
	
	//메소드
	public String getJobid() {
		return jobid;
	}
	public void setJobid(String jobid) {
		this.jobid = jobid;
	}
	public String getJobtitle() {
		return jobtitle;
	}
	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}
	public int getMinsalary() {
		return minsalary;
	}
	public void setMinsalary(int minsalary) {
		this.minsalary = minsalary;
	}
	public int getMaxsalary() {
		return maxsalary;
	}
	public void setMaxsalary(int maxsalary) {
		this.maxsalary = maxsalary;
	}
	
	@Override
	public String toString() {
		return "Empjob [jobid=" + jobid + ", jobtitle=" + jobtitle + ", minsalary=" + minsalary + ", maxsalary=" + maxsalary + "]";
	}
	
	
	
	
	
}
