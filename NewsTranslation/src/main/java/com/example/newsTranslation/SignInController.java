package com.example.newsTranslation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/NewsTranslate")
public class SignInController {

	@RequestMapping(value = "/SignIn", method = RequestMethod.GET)
	public String SignIn(Model model) {
		return "SignIn";
	}

	@RequestMapping(value = "SignInCheck", method = RequestMethod.POST)
	public String SignInCheck(Model model, @ModelAttribute("SignInForm") SignInForm signInForm) {
		AccountData accountData = new AccountData();
		if (!accountData.getAccountData(signInForm.getUserName(), signInForm.getPassword())) {
			model.addAttribute("caution", "アカウント取得失敗");
			return "SignIn";
		}

		if (accountData.getName() != null && accountData.getPassword() != null) {
			model.addAttribute("userName", signInForm.getUserName());
			return "TopPage";
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
