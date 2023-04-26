package com.lop.smartcitykhouribga.security;

import com.lop.smartcitykhouribga.models.Entities.User;
import com.lop.smartcitykhouribga.models.Enum.Role;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtTokenFilter extends OncePerRequestFilter {
    @Autowired
    JwtTokenUtil jwtUtil;


    /**
     * Check if the request has a valid Authorization Bearer token. A token is valid if it starts with "Bearer"
     *
     * @param request the request to check
     * @return true if the request has a valid Authorization Bearer token, false otherwise
     */
    private boolean hasAuthorizationBearer(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        return !ObjectUtils.isEmpty(header) && header.startsWith("Bearer");
    }

    /**
     * Get the access token from the request
     *
     * @param request the request to get the token from
     * @return the access token
     */
    private String getAccessToken(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        return header.split(" ")[1].trim();
    }

    private UserDetails getUserDetails(String token) {
        User user = new User();
        String[] jwtSubject = jwtUtil.getSubject(token).split(",");

        user.setId(Long.parseLong(jwtSubject[0]));
        user.setMail(jwtSubject[1]);
        user.setRole(Role.valueOf(jwtSubject[2]));


        return user;
    }


    /**
     * Set the authentication context with the user details from the token
     *
     * @param token   the token to get the user details from
     * @param request the request to get the details from
     */
    private void setAuthenticationContext(String token, HttpServletRequest request) {
        UserDetails userDetails = getUserDetails(token);
        System.out.println(userDetails);

        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain)
            throws ServletException, IOException {

        if (!hasAuthorizationBearer(request)) {
            /* Customize AuthenticationException */


            filterChain.doFilter(request, response);

            return;
        }

        String token = getAccessToken(request);

        if (!jwtUtil.validateAccessToken(token)) {


            filterChain.doFilter(request, response);

            return;
        }

        setAuthenticationContext(token, request);
        filterChain.doFilter(request, response);
    }


}
