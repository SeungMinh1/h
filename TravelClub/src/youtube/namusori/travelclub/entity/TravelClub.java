package youtube.namusori.travelclub.entity;

import java.util.UUID;

import youtube.namusori.travelclub.util.Dateutil;

public class TravelClub {
	
	//필드
	private static final int MINIMUM_NAME_LENGTH = 3;
	private static final int MINIMUM_INTRO_LENGTH = 10;
	
	private String id;
	private String clubName; //입력받을꺼
	private String intro; //입력받을꺼
	private String message;
	private String foundationDay;
	
	
	//생성자
	private TravelClub() {
		this.id = UUID.randomUUID().toString();
	}
	
	public TravelClub(String clubName, String intro) {
		this();
		this.clubName = clubName;
		this.intro = intro;
		this.foundationDay = Dateutil.today();
	}

	//메서드
	public void setClubName(String clubName) {  //클럽네임 변경?
		if(clubName.length() < MINIMUM_NAME_LENGTH) {
			System.out.println("클럽이름은 3글자보다 길어야됩니다.");
			return;
		}
		this.clubName = clubName;	
	}
	public String getClubName() {  //클럽네임 변경?
		return this.clubName;
	}
	
	
	
}
