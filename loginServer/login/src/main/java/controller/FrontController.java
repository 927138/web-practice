package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.DependencyFactory;


@WebServlet("/loginAPI/*")
public class FrontController extends HttpServlet {
	
	private final String REDIRECT = "redirect:";
	private final String PREFIX = "/loginAPI";
	private DependencyFactory dependencyFactory;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		this.dependencyFactory = new DependencyFactory(config.getServletContext());
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		Controller controller =  (Controller) dependencyFactory.getController(uri.replace(PREFIX, ""));
		
		if(Objects.isNull(controller)) {
			resp.sendError(404);
			return;
		}
		
		Map<String, Object> reqParam = requestToreqParam(req);
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
				view = controller.put(reqParam, respParam);
				break;
			case "DELETE" :
				view = controller.delete(reqParam, respParam);
				break;
			default:
				throw new exception.Exception(500, "??");
		}
		
		reqParamToRequset(req, reqParam);
		
		if(view.startsWith(REDIRECT)) {
			String redirectLink = view.substring(REDIRECT.length());
			resp.sendRedirect(redirectLink);
			return;
		}
		
		req.getRequestDispatcher(viewMapping(view)).forward(req, resp);
		
	}
	
	private String viewMapping(String viewPath) {
		return "/view"+viewPath+".jsp";
	}
	
	private void reqParamToRequset(HttpServletRequest req, Map<String, Object> reqParam) {
		reqParam.entrySet().forEach(
				param -> {
					req.setAttribute(param.getKey(), param.getValue());
				}
			);
		req.setAttribute(PREFIX, reqParam);
	}
	
	private Map<String, Object> requestToreqParam(HttpServletRequest req){
		Map<String, Object> params = new HashMap<>();
		req.getParameterNames().asIterator()
								.forEachRemaining(name -> params.put(name, req.getParameter(name)));
		return params;
	}
		
}
