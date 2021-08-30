package news.app.controller.toppage;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import news.app.controller.signin.NewsData;
import news.domain.model.NewsDataEntity;
import news.domain.repository.NewsDataRepository;

@Controller
public class TopPageController {

	@Autowired
	private NewsDataRepository newsDataRepository;

	@RequestMapping(value = "/")
	public String TopPage(Model model) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userName = "";
		String buttonText = "";

		if (!auth.getAuthorities().toString().equals("[ROLE_ANONYMOUS]")) {
			userName = auth.getName();
			buttonText = "ログアウト";
		} else {
			userName = "未ログイン";
			buttonText = "ログイン";
		}

		model.addAttribute("userName", userName);
		model.addAttribute("buttonText", buttonText);

		List<NewsData> newsList = new ArrayList<NewsData>();
		List<NewsDataEntity> newsDataEntitys = newsDataRepository.findAll();
		for (NewsDataEntity newsDataEntity : newsDataEntitys) {
			NewsData newsData = new NewsData();
			newsData.setDate(newsDataEntity.getDate());
			newsData.setTitle(newsDataEntity.getTitle());
			newsData.setText(newsDataEntity.getOriginal_html());
			newsData.setTranslatedText(newsDataEntity.getTranslated_html());
			newsData.setUrl("http://localhost:8080/NewsView/" + newsDataEntity.getNews_id());
			newsList.add(newsData);
		}
		model.addAttribute("newslist", newsList);

		return "/TopPage";
	}

	@RequestMapping(value = "/SignOut", method = RequestMethod.POST)
	public String gotoSignOut(Model model) {
		return "/SignIn";
	}
}
