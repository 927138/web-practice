package service;

public interface AuthoriztionService {
	
	// TODO 3.10 적정 메소드 미정
	// 우선 인증 부여, 삭제 기능 구현
	
	default void createAuth(String userId, String userPw) {
		throw new IllegalArgumentException();
	}
	
    default String getdAuth(String validVariable, String id){
		throw new IllegalArgumentException();
	}
    
    default void updateAuth(String userId, int time){
		throw new IllegalArgumentException();
	}
    
    default void deleteAuth(String userId) {
    	throw new IllegalArgumentException();
    }
}
