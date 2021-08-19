package news.app.controller.newsview;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.annotation.SessionScope;

import news.app.controller.signin.NewsData;
import news.domain.model.NewsDataEntity;
import news.domain.repository.NewsDataRepository;

@Controller
@SessionScope
public class NewsViewController {
	@Autowired
	private NewsDataRepository newsDataRepository;

	NewsData newsData = new NewsData();

	@RequestMapping(value = "/NewsView", method = RequestMethod.GET)
	public String NewsView(Model model, @ModelAttribute("NewsViewForm") NewsViewForm newsViewForm) {
		newsData.setText(newsViewForm.getOriginal_text());
		newsData.setTranslatedText(newsViewForm.getTraslated_text());

		return "NewsView";
	}

	@RequestMapping(value = "/NewsViewOriginal", method = RequestMethod.POST)
	public String newsOriginalText(Model model) {
		model.addAttribute("text", newsData.getText());
		return "NewsView";
	}
	
	@RequestMapping(value = "/NewsViewTranslated", method = RequestMethod.POST)
	public String newsTraslatedText(Model model) {
		model.addAttribute("text", newsData.getTranslatedText());
		return "NewsView";
	}

	private void SetNewsList(Model model) {
		List<NewsData> newsList = new ArrayList<NewsData>();
		List<NewsDataEntity> newsDataEntitys = newsDataRepository.findAll();

		for (NewsDataEntity newsDataEntity : newsDataEntitys) {
			NewsData newsData = new NewsData();
			newsData.setDate(newsDataEntity.getDate());
			newsData.setTitle(newsDataEntity.getTitle());
			newsData.setText(newsDataEntity.getOriginal_html());
			newsData.setTranslatedText(newsDataEntity.getTranslated_html());
			newsList.add(newsData);
		}
		model.addAttribute("newslist", newsList);
	}
}
