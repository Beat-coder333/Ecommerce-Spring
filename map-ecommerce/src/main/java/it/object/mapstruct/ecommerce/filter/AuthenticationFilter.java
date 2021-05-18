package it.object.mapstruct.ecommerce.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import it.object.mapstruct.ecommerce.service.JWTService;

@Component
@Order(2)
public class AuthenticationFilter implements Filter {

	private static Logger log = LoggerFactory.getLogger(AuthenticationFilter.class);

	@Autowired
	private JWTService jwtServ;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpServletResponse httpResp = (HttpServletResponse) response;
		String url = httpReq.getRequestURI();
		log.trace(url);

		if (url.endsWith("login")) {
			chain.doFilter(request, response);
		} else {
			String token = httpReq.getHeader("auth-token");
			if (token != null) {
				if (jwtServ.checkJWTToken(token)) {

					chain.doFilter(request, response);
				} else {
					log.info("TOKEN NON VALIDO ");
					httpResp.setStatus(HttpServletResponse.SC_FORBIDDEN);
				}
			} else {
				log.error("TOKEN NON PRESENTE");
				httpResp.setStatus(HttpServletResponse.SC_FORBIDDEN);
			}

		}

	}

}
