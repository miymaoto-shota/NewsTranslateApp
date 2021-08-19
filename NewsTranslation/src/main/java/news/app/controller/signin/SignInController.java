package news.app.controller.signin;

import java.util.ArrayList;
import java.util.List;

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
import news.domain.model.NewsDataEntity;
import news.domain.repository.NewsDataRepository;
import news.domain.service.AccountDataService;

@Controller
@SessionScope
public class SignInController {

	@Autowired
	private AccountDataService accountDataService;
	@Autowired
	private NewsDataRepository newsDataRepository;

	@RequestMapping(value = "/SignIn")
	public String SignIn() {
		return "/SignIn";
	}

	/*
	 * @RequestMapping(value = "SignInCheck", method = RequestMethod.POST) public
	 * String SignInCheck(Model model, @ModelAttribute("SignInForm") SignInForm
	 * signInForm) {
	 * 
	 * try { PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	 * AccountDataEntity userData =
	 * accountDataService.getName(signInForm.getUserName());
	 * 
	 * if (userData != null) { if (passwordEncoder.matches(signInForm.getPassword(),
	 * userData.getPassword())) { model.addAttribute("userName",
	 * userData.getUserName());
	 * 
	 * SetNewsList(model);
	 * 
	 * return "TopPage"; } } } catch (Exception e) { model.addAttribute("caution",
	 * e.getMessage()); return "SignIn"; }
	 * 
	 * model.addAttribute("caution", "入力したアカウントが見つかりませんでした"); return "SignIn"; }
	 */

	@RequestMapping(value = "SignUp", method = RequestMethod.POST)
	public String gotoSignUp(Model model) {
		return "SignUp";
	}

	@RequestMapping(value = "NotSignIn", method = RequestMethod.POST)
	public String gotoNotSignInTopPage(Model model) {
		// SetNewsList(model);
		return "TopPage";
	}

	/*
	 * private void SetNewsList(Model model) { List<NewsData> newsList = new
	 * ArrayList<NewsData>(); List<NewsDataEntity> newsDataEntitys =
	 * newsDataRepository.findAll();
	 * 
	 * for (NewsDataEntity newsDataEntity : newsDataEntitys) { NewsData newsData =
	 * new NewsData(); newsData.setDate(newsDataEntity.getDate());
	 * newsData.setTitle(newsDataEntity.getTitle());
	 * newsData.setText(newsDataEntity.getOriginal_html());
	 * newsData.setTranslatedText(newsDataEntity.getTranslated_html());
	 * newsList.add(newsData); } model.addAttribute("newslist", newsList); }
	 */
}
