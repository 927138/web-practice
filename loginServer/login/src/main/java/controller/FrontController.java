package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

import common.ConnectDB;
import common.Controller;
import common.DemoDB;
import common.Exception;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.DemoUser;
import repository.TestConnectedDB;


@WebServlet("/loginAPI/*")
public class FrontController extends HttpServlet {
	
	private final String REDIRECT = "redirect:";
	private final String PREFIX = "/loginAPI";
	private final Map<String, Controller> controllerList = new HashMap<>();
	
	@Override
	public void init() throws ServletException {
		// Controller DI 
		controllerList.put("/member", new MemberController());
		controllerList.put("/login", new LoginController());
		controllerList.put("/", new InitPageController());
		
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method r
		
		String uri = req.getRequestURI();
		String uriT = headUri(uri);
		
		System.out.println(uriT + " er " + uri);
		Controller controller = controllerList.get(uriT);
		if(Objects.isNull(controller)) {
			// 404 와 동일 -> 404로 띄우는 방법이 있나 찾아보기
			return;
		}

		TestConnectedDB db = new TestConnectedDB(getServletContext());
		db.insertTest();
		
		DemoDB test = (DemoDB) req.getServletContext().getAttribute("storage");
		
		Map<String, String> getParam = requestToMapParam(req);
		getParam.put("storage", test.getDemoUser("1").getUserId());
		Map<String, Object> setParam = new HashMap<>();
		String view = null;
		switch (req.getMethod()) {
			case "GET" : 
				view = controller.get(getParam, setParam);
				break;
			case "POST" :
				view = controller.post(getParam, setParam);
				break;
			case "PUT" :
				break;
			case "DELETE" :
				break;
			default:
				throw new Exception(500, "??");
		}
		
		
		req.getRequestDispatcher(viewMapping(view)).forward(req, resp);
		
	}
	
	private String viewMapping(String viewPath) {
		return "/view"+viewPath+".jsp";
	}
	
	private String headUri(String uri) {
		
		String processedUri  = uri.replace(PREFIX, "");
		
		return controllerList.keySet().stream()
		        .filter(temp -> temp.equals(processedUri))
		        .findFirst()
		        .orElse("/");
	}
	
	private Map<String, String> requestToMapParam(HttpServletRequest req){
		
		Map<String, String> params = new HashMap<>();
		req.getParameterNames().asIterator()
								.forEachRemaining(name -> params.put(name, req.getParameter(name)));
		
		return params;
	}
	
	
	
}
