package utils;

import controller.Controller;
import controller.LoginController;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.AuthoriztionService;
import service.CookieService;
import service.CookieServiceImp;

public class ControllerDynamicFactory {

	private final HttpServletRequest request;
	private final HttpServletResponse response;
	
	public ControllerDynamicFactory(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}
	
	public Controller createLoginController() {
		AuthoriztionService authorService = null;
		CookieService cookieService = new CookieServiceImp(request, response);
		
		return new LoginController(authorService, cookieService);
	}
	
	// TODO
	// session, application scope 등 HttpServlet 속성 필요시 추가예정
}
