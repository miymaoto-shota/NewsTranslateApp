package com.example.newsTranslation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/NewsTranslate")
public class SignUpController {

	@RequestMapping(value = "/SignUp", method = RequestMethod.GET)
	public String SignUp(Model model) {
		return "SignUp";
	}

	@RequestMapping(value = "SignUpCheck", method = RequestMethod.POST)
	public String SignUpCheck(Model model, @ModelAttribute("SignUpForm") SignUpForm signUpForm) {

		String nameCautionMessage = "";
		String passwordCautionMessage = "";
		boolean isError = false;
		// 入力チェック
		if (signUpForm.getUserName().equals("")) {
			nameCautionMessage = "ユーザ名が入力されていません\n";
			isError = true;
		}
		if (signUpForm.getPassword().equals("")) {
			passwordCautionMessage = "パスワードが入力されていません\n";
			isError = true;
		}
		if (!signUpForm.getPassword().equals(signUpForm.getPasswordCheck())) {
			passwordCautionMessage = "パスワードとパスワード確認の入力が一致しません";
			isError = true;
		}

		if (isError == true) {
			model.addAttribute("nameCaution", nameCautionMessage);
			model.addAttribute("passwordCaution", passwordCautionMessage);
			return "SignUp";
		}

		// 既に登録されているアカウントか確認
		AccountData accountData = new AccountData();
		accountData.getAccountData(signUpForm.getUserName(), "");
		if (accountData.getName() != null) {
			model.addAttribute("caution", "既に登録されているアカウントです");
			return "SignUp";
		}

		if (!accountData.createAccountData(signUpForm.getUserName(), signUpForm.getPassword())) {
			return "SignUp";
		}
		return "SignIn";
	}
}
