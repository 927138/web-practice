package service;

public interface AuthoriztionService {
	String generateAuth(String userId);
    void saveAuth(String userId, String token);
    String getAuth(String userId);
    void deleteAuth(String userId);
}
