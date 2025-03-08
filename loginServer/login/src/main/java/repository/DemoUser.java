package repository;

import java.time.LocalDateTime;

public class DemoUser {
	private String uuid;
	private String userId;
	private String userPw;
	private String userEmail;
	private LocalDateTime createUserTime;
	
	private DemoUser(String uuid, String userId, String userPw, String userEmail) {
		this.createUserTime = LocalDateTime.now();
		this.uuid = uuid;
		this.userId = userId;
		this.userPw = userPw;
		this.userEmail = userEmail;
	}
	
	public String getUuid() {
		return uuid;
	}
	
	public LocalDateTime getCreateUserTime() {
		return createUserTime;
	}
	
	public String getUserEmail() {
		return userEmail;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public String getUserPw() {
		return userPw;
	}
	
	public static DemoUser createUser(String uuid, String userId, String userPw, String userEmail) {
		return new DemoUser(uuid, userId, userPw, userEmail);
	}
	
}
