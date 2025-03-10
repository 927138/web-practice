package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.ControllerDynamicFactory;
import utils.ControllerStaticFactory;


@WebServlet("/loginAPI/*")
public class FrontController extends HttpServlet {
	
	private final String REDIRECT = "redirect:";
	private final String PREFIX = "/loginAPI";
	private ControllerStaticFactory staticFactory;
	
	@Override
	public void init() throws ServletException {
		// Controller DI 
		this.staticFactory = new ControllerStaticFactory();
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
//		String uriT = headUri(uri);
		

		Controller controller = staticFactory.getController(uri.replace(PREFIX, ""));
		
		if(Objects.isNull(controller)) {
			resp.sendError(404);
			return;
		}
		

		// db connect test code
//		TestConnectedDB db = new TestConnectedDB(getServletContext());
//		db.insertTest();
		
		
		if(controller instanceof LoginController) {
			controller = new ControllerDynamicFactory(req, resp).createLoginController();
		}
		
		Map<String, String> reqParam = requestToMapParam(req);
		Map<String, Object> respParam = new HashMap<>();
		
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
				throw new exception.Exception(500, "??");
		}
		
		
		
		req.getRequestDispatcher(viewMapping(view)).forward(req, resp);
		
	}
	
	private String viewMapping(String viewPath) {
		return "/view"+viewPath+".jsp";
	}
	
//	private String headUri(String uri) {
//		
//		String processedUri  = uri.replace(PREFIX, "");
//		
//		return controllerList.keySet().stream()
//		        .filter(temp -> temp.equals(processedUri))
//		        .findFirst()
//		        .orElse("/");
//	}
	
	private Map<String, String> requestToMapParam(HttpServletRequest req){
		
		Map<String, String> params = new HashMap<>();
		req.getParameterNames().asIterator()
								.forEachRemaining(name -> params.put(name, req.getParameter(name)));
		
		return params;
	}
	
	
	
}
