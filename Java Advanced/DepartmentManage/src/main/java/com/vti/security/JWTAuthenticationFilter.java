//package com.vti.security;
//
//import java.io.IOException;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//import com.vti.entity.User;
//import com.vti.service.IUserService;
//import com.vti.service.JWTTokenService;
//
//public class JWTAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
//	
//	private IUserService service;
//	
//    public JWTAuthenticationFilter(String url, AuthenticationManager authManager, IUserService service) {
//        super(new AntPathRequestMatcher(url));
//        setAuthenticationManager(authManager);
//        this.service = service;
//    }
//
//    @Override
//    public Authentication attemptAuthentication(
//    		HttpServletRequest request, 
//    		HttpServletResponse response) 
//    		throws AuthenticationException, IOException, ServletException {
//    	
//    	String username = request.getParameter("username");
//    	String password = request.getParameter("password");
//    	
//    	User user = service.findByUserName(username);
//    	
//    	if(user == null) {
//    		return null;
//    	}
//    	
//        return getAuthenticationManager().authenticate(
//                new UsernamePasswordAuthenticationToken(
//                		username,
//                		password,
//                		AuthorityUtils.createAuthorityList(user.getRole())
//                )
//        );
//    }
//
//    @Override
//    protected void successfulAuthentication(
//    		HttpServletRequest request, 
//    		HttpServletResponse response, 
//    		FilterChain chain, 
//    		Authentication authResult) throws IOException, ServletException {
//        JWTTokenService.addJWTTokenToHeader(response, authResult.getName());
//    }
//}
