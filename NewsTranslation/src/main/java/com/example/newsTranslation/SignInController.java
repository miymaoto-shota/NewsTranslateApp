package com.example.newsTranslation;

import java.sql.SQLException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/NewsTranslate")
public class SignInController {

	@Autowired
	private AccountDataService accountDataService;

	@RequestMapping(value = "/SignIn", method = RequestMethod.GET)
	public String SignIn(Model model) {
		return "SignIn";
	}

	@RequestMapping(value = "SignInCheck", method = RequestMethod.POST)
	public String SignInCheck(Model model, @ModelAttribute("SignInForm") SignInForm signInForm) {

		try {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			AccountDataEntity userData = accountDataService.findByName(signInForm.getUserName());

			if (userData != null) {
				if (passwordEncoder.matches(signInForm.getPassword(), userData.getPassword())) {
					model.addAttribute("userName", userData.getName());
					return "TopPage";
				}
			}
		} catch (Exception e) {
			model.addAttribute("caution", e.getMessage());
			return "SignIn";
		}

		model.addAttribute("caution", "入力したアカウントが見つかりませんでした");
		return "SignIn";

	}

	@RequestMapping(value = "SignUp", method = RequestMethod.POST)
	public String gotoSignUp(Model model) {
		return "SignUp";
	}

	@RequestMapping(value = "NotSignIn", method = RequestMethod.POST)
	public String gotoNotSignInTopPage(Model model) {
		return "TopPage";
	}
}
