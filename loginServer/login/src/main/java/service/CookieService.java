package service;

public interface CookieService {
	String getCookie(String name);
	void setCookie(String name, String value, int maxAge);
	void deleteCookie(String name);
}
