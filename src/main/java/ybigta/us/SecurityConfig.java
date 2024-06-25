package ybigta.us;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import ybigta.us.service.CustomOAuth2UserService;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http

                /*//for SMScertification Testing
               .authorizeRequests()
               .anyRequest().permitAll() // 모든 요청에 대해 인증 비활성화
               .and()
               .csrf().disable(); // CSRF 비활성화 (테스트 목적)
               */
                .authorizeHttpRequests(authorizeRequests -> {
                    authorizeRequests.requestMatchers("/**").permitAll();//모두에게 허용되는 페이지
                    authorizeRequests.requestMatchers("/login").permitAll(); // 모두에게 허용되는 페이지
                    authorizeRequests.requestMatchers("/user").hasRole("USER");//user role이 있어야지만 허용하도록
                    authorizeRequests.anyRequest().authenticated();
                })
                .exceptionHandling(exceptionHandling ->
                        exceptionHandling.accessDeniedPage("/accessDenied")
                )
                .logout(logout ->
                        logout.logoutUrl("/logout")
                                .logoutSuccessUrl("/")
                )
                .csrf(csrf -> csrf.disable())//일단 csrf 비활성화
                .oauth2Login(oauth2Login ->
                        oauth2Login.loginPage("/login")
                                .successHandler(authenticationSuccessHandler())
                                .userInfoEndpoint(userInfoEndpoint ->
                                        userInfoEndpoint.userService(customOAuth2UserService)
                                )
                );

        return http.build();
    }

    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        return (request, response, authentication) -> {
            // Authentication 성공 후 처리 로직
            String targetUrl = "/login/success?code=" + request.getParameter("code");
            response.sendRedirect(targetUrl);
        };
    }
}


