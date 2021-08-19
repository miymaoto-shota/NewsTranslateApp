package news.app.controller.signup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.annotation.SessionScope;

import news.domain.model.AccountDataEntity;
import news.domain.service.AccountDataService;

@Controller
@SessionScope
public class SignUpController {

	@Autowired
	private AccountDataService accountDataService;

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

		// 入力チェック エラー内容出力
		if (isError == true) {
			model.addAttribute("nameCaution", nameCautionMessage);
			model.addAttribute("passwordCaution", passwordCautionMessage);
			return "SignUp";
		}

		// 既に登録されているアカウントか確認
		AccountDataEntity userData = accountDataService.getName(signUpForm.getUserName());
		if (userData != null) {
			model.addAttribute("nameCaution", "既に登録されているアカウントです");
			return "SignUp";
		}

		// アカウントをDBに登録
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(signUpForm.getPassword());
		AccountDataEntity saveData = new AccountDataEntity();
		saveData.setName(signUpForm.getUserName());
		saveData.setPassword(encodedPassword);

		accountDataService.addAccount(signUpForm.getUserName(), encodedPassword);
		return "SignIn";
	}
}
