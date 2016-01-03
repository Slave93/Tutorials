package rs.slavko.tutorials.jpa.webapp.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.filter.GenericFilterBean;

import rs.slavko.tutorials.jpa.services.authentication.CustomUserDetailService;

public class TicketProccessingFilter extends GenericFilterBean {

	public TicketProccessingFilter() {
		super();
	}

	private UserDetailsService customUserDetailsService;
	private AuthenticationManager authenticationManager;

	public UserDetailsService getCustomUserDetailsService() {
		return customUserDetailsService;
	}

	public void setCustomUserDetailsService(
			UserDetailsService customUserDetailsService) {
		this.customUserDetailsService = customUserDetailsService;
	}

	public AuthenticationManager getAuthenticationManager() {
		return authenticationManager;
	}

	public void setAuthenticationManager(
			AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("###############Custom filter################");
		
		//SecurityContextHolder.getContext().setAuthentication(null);
		chain.doFilter(request, response);
		// HttpServletRequest requestHTTP = (HttpServletRequest) request;

		/*UserDetails user = customUserDetailsService
				.loadUserByUsername("Slave93");
		Authentication authentication = new UsernamePasswordAuthenticationToken(
				user, null, user.getAuthorities());
		// authenticationManager.authenticate(authentication);
		System.out
				.println("Logging in with {}" + authentication.getPrincipal());
		SecurityContextHolder.getContext().setAuthentication(authentication);
*/
		
	}

}
