package com.example.newsTranslation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

	@RequestMapping(value = "/SignIn", method = RequestMethod.GET)
	public String setMessage(Model model) {
		model.addAttribute("title", "サインイン画面");

		model.addAttribute("userName", "ユーザ名:");
		model.addAttribute("password", "パスワード:");

		return "SignIn";
	}

	@RequestMapping(value = "/SignIn", method = RequestMethod.POST)
	public String getMessage(@ModelAttribute Form form, Model model) {
		model.addAttribute("title", form.getUserName() + "::" + form.getPassword());

		return "SignIn";
	}
}
