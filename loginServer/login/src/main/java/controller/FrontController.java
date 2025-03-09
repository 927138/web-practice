package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import common.Controller;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.AuthorizationServiceImp;
import service.AuthoriztionService;
import service.CookieService;
import service.CookieServiceImp;


@WebServlet("/loginAPI/*")
public class FrontController extends HttpServlet {
	
	private final String REDIRECT = "redirect:";
	private final String PREFIX = "/loginAPI";
	private final Map<String, Controller> controllerList = new HashMap<>();
	
	@Override
	public void init() throws ServletException {
		// Controller DI 
		
		AuthoriztionService authorization = new AuthorizationServiceImp();
		CookieService cookieService = new CookieServiceImp(req, resp);
		
		
		
		controllerList.put("/member", new MemberController());
		controllerList.put("/login", new LoginController(new AuthorizationServiceImp()));
		controllerList.put("/", new InitPageController());
		controllerList.put("/jwtTest", new JwtController());
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		
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

		// db connect test code
//		TestConnectedDB db = new TestConnectedDB(getServletContext());
//		db.insertTest();
		
		Map<String, String> reqParam = requestToMapParam(req);
		Map<String, Object> respParam = new HashMap<>();
		
//		Cookie c = new Cookie(uri, uriT);
//		
//		Cookie findToken = Arrays.stream(req.getCookies()).filter(str -> str.getName().equals("token")).findFirst().orElseGet(null);
//		if(Objects.nonNull(findToken)) {
//			System.out.println("front-controller findToken");
//			getParam.put("token", findToken.getValue());
//		}
		
		//session param이 존재하면 추가 로직 구현하기
		
		
		String view = null;
		switch (req.getMethod()) {
			case "GET" : 
				view = controller.get(reqParam, respParam);
				break;
			case "POST" :
				view = controller.post(reqParam, respParam);
				break;
			case "PUT" :
				break;
			case "DELETE" :
				break;
			default:
				throw new common.Exception(500, "??");
		}
		
//		if(setParam.containsKey("cookie")) {
//			System.out.println("cookie call");
//			resp.addCookie(new Cookie("token", (String) setParam.get("token")));
//		}
//		
		
		
		
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
