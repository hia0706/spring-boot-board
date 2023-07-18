package kr.co.jhta.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http
				.csrf()
					.disable()
				.formLogin()
					.loginPage("/user/login")
					.usernameParameter("email")
					.passwordParameter("password")
					.loginProcessingUrl("/user/login")
					.defaultSuccessUrl("/")
					.failureUrl("/user/login?error=fail")
				.and()
					.logout()
						.logoutSuccessUrl("/user/logout")
						.logoutSuccessUrl("/")
						.invalidateHttpSession(true)
				.and()
					.exceptionHandling()
					.authenticationEntryPoint((req, res, ex) -> res.sendRedirect("/emp/login?error=denied"))
				.and()
					.exceptionHandling()
					.accessDeniedHandler((req, res, ex) -> res.sendRedirect("/emp/login?error=forbidden"))
				.and()
					.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
