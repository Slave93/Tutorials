package rs.slavko.tutorials.jpa.services.authentication;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

public class UnauthorisedEntryPoint implements AuthenticationEntryPoint {
	@Override
	public final void commence(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException authException)
			throws IOException {
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
	}
	
}
