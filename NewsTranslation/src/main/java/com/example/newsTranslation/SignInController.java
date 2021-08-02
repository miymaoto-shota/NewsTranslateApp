package com.example.newsTranslation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/NewsTranslate")
public class SignInController {

	@RequestMapping(value = "/SignIn", method = RequestMethod.GET)
	public String setMessage(Model model) {
		// model.addAttribute("title", "サインイン画面");

		// model.addAttribute("userName", "ユーザ名:");
		// model.addAttribute("password", "パスワード:");

		return "/SignIn";
	}

	@RequestMapping("/TopPage")
	public String SignIn(Model model) {
		return "TopPage.html";
	}

	@RequestMapping("/SignUp")
	public String SignUp(Model model) {
		return "SignUp.html";
	}
}
