package common.filter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;


@WebFilter("/loginAPI/*"
		+ "")
public class CharacterEncodingFilter implements Filter{
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain)
			throws IOException, ServletException {
		
		resp.setCharacterEncoding(StandardCharsets.UTF_8.toString());
		req.setCharacterEncoding(StandardCharsets.UTF_8.toString());
		filterChain.doFilter(req, resp);
		
	}
}
