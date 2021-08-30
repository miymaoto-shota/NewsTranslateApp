package news.app.controller.newsview;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import news.app.awsTranslate.AwsTranslate;
import news.domain.model.NewsDataEntity;
import news.domain.repository.NewsDataRepository;

@Controller
public class NewsViewController {

	@Autowired
	private NewsDataRepository newsDataRepository;

	@RequestMapping(value = "/NewsView/{newsID}")
	public String NewsView(Model model, @PathVariable String newsID) {
		List<NewsDataEntity> newsDataEntity = newsDataRepository.findAll();

		for (NewsDataEntity newsData : newsDataEntity) {
			if (newsData.getNews_id().equals(Integer.parseInt(newsID))) {
				String newsText = "";

				if (newsData.getTranslate_flag() == 0) {
					AwsTranslate awsTranslate = new AwsTranslate();

					newsText = awsTranslate.TranslateText(newsData.getOriginal_html());

					NewsDataEntity saveData = new NewsDataEntity();
					saveData.setNews_id(newsData.getNews_id());
					saveData.setUrl(newsData.getUrl());
					saveData.setTitle(newsData.getTitle());
					saveData.setDate(newsData.getDate());
					saveData.setOriginal_html(newsData.getOriginal_html());
					saveData.setTranslated_html(newsText);
					saveData.setTranslate_flag(1);

					newsDataRepository.save(saveData);

				} else {
					newsText = newsData.getTranslated_html();
				}

				model.addAttribute("title", newsData.getTitle());
				model.addAttribute("text", newsText.replace("\\", "\n"));
			}
		}

		return "/NewsView";
	}
}
