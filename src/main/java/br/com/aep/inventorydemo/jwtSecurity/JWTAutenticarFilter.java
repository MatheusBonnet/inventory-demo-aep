package br.com.aep.inventorydemo.jwtSecurity;

import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.aep.inventorydemo.model.EmployeeModel;

/**
 * @author matheus
 *
 */
public class JWTAutenticarFilter extends UsernamePasswordAuthenticationFilter {

    public static final int TOKEN_EXPIRACAO = 600_000;
    public static final String TOKEN_SENHA = "463408a1-54c9-4307-bb1c-6cced559f5a7";

    private final AuthenticationManager authenticationManager;
    

    public JWTAutenticarFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {
        try {
        	EmployeeModel usuario = new ObjectMapper()
                    .readValue(request.getInputStream(), EmployeeModel.class);

            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    usuario.getCpf(),
                    usuario.getPassword(),
                    usuario.getAuthorities()
            ));

        } catch (IOException e) {
            throw new RuntimeException("Falha ao autenticar usuario ", e);
        }

    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {

        try {

            String cpf = authResult.getName();

            String token = com.auth0.jwt.JWT.create().
                    withSubject(cpf)
                    .withExpiresAt(new Date(System.currentTimeMillis() + TOKEN_EXPIRACAO))
                    .sign(com.auth0.jwt.algorithms.Algorithm.HMAC512(TOKEN_SENHA));

            response.getWriter().write(token);
        }catch (Exception e){
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
        }
    }
}
