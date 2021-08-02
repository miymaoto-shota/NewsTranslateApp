package com.example.newsTranslation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/NewsTranslate")
public class TopPageController {

	@RequestMapping(value = "/TopPage", method = RequestMethod.GET)
	public String setMessage(Model model) {
		return "TopPage";
	}

	@RequestMapping(params = "SignOut", method = RequestMethod.POST)
	public String SignUp(Model model) {
		return "SignIn";
	}
}
