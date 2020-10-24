package com.ap.covid19.api.apcovid19.security.jwt;

import com.ap.covid19.api.apcovid19.repositories.UserRepository;
import com.ap.covid19.api.apcovid19.models.User;
import com.ap.covid19.api.apcovid19.security.services.UserDetailsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class JwtAuthTokenFilter extends OncePerRequestFilter {


    @Autowired
    private JwtProvider tokenProvider;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(JwtAuthTokenFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {
        try {

            String jwt = getJwt(request);
            if (jwt!=null && tokenProvider.validateJwtToken(jwt)) {
                String username = tokenProvider.getUserNameFromJwtToken(jwt);

                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                UsernamePasswordAuthenticationToken authentication
                        = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (Exception e) {
            logger.error("Can NOT set user authentication -> Message: {}", e);
        }

        filterChain.doFilter(request, response);
    }

    private String getJwt(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            return authHeader.replace("Bearer ","");
        }

        return null;
    }


    public Optional<User> getUserFromJWT(final String jwtToken){
        Optional<User> user = null;
        if (jwtToken != null && jwtToken.startsWith("Bearer ")) {
            final String finalToken = jwtToken.replace("Bearer ","");
            if(tokenProvider.validateJwtToken(finalToken)){
                final String username = tokenProvider.getUserNameFromJwtToken(finalToken);
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                if(userDetails != null)
                    user = userRepository.findByUserName(Long.parseLong(userDetails.getUsername()));
            }
        }
        return user;
    }


}
