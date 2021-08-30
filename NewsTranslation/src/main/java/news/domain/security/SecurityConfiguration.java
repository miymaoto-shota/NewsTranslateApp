package news.domain.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import news.domain.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsServiceImpl userDetailService;

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/")	
		.permitAll()
		.antMatchers("/SignUp")
		.permitAll()
		.antMatchers("/SignUpCheck")
		.permitAll()
		.antMatchers("/TopPage")
		.permitAll()
		.anyRequest()
		.authenticated()
		.and()				// ↑ログインしていなくても見れる画面の設定
		.formLogin()
		.loginPage("/SignIn")	// ログイン画面
			.loginProcessingUrl("/SignInCheck")		// ログインチェック用画面
			.usernameParameter("userName")
			.passwordParameter("password")
			.successForwardUrl("/SignInCheck")		// ログイン成功時の遷移先
			.failureUrl("/SignIn?error=true")		// ログイン失敗時の遷移先と送信データ
			.permitAll()
			.and()
		.logout()
			.logoutUrl("/SignOut")
			.logoutSuccessUrl("/SignIn")	//　ログアウト時の遷移先
			.permitAll();
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
	}
}