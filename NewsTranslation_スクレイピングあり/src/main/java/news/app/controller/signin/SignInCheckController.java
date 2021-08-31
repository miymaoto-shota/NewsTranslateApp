package news.app.controller.signin;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import news.domain.model.NewsDataEntity;
import news.domain.repository.NewsDataRepository;

@Controller
public class SignInCheckController {

	@Autowired
	private NewsDataRepository newsDataRepository;

	@RequestMapping(value = "/SignInCheck")
	public String SignInCheck() {
		try {
			Scrapring();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "/SignInCheck";
	}

	private void Scrapring() throws IOException {

		List<NewsDataEntity> newsDataEntitys = newsDataRepository.findAll();
		Integer newsNum = newsDataEntitys.size();

		String baseUrl = "https://www.army.mil/";

		// ニュース一覧取得
		Document newsList = Jsoup.connect("https://www.army.mil/news").get();

		Elements newsListHeadlines = newsList.select(".image-wrap a");

		int count = 0;
		for (Element headline : newsListHeadlines) {

			// 取得を１０件に制限中
			if (count == 10) {
				break;
			}
			count++;

			// ニュース内容を取得
			Document newsDetails = Jsoup.connect(baseUrl + headline.attr("href")).get();
			Elements newsDetailsHeadlines = newsDetails.select(".ql-editor p");
			boolean isMatch = false;

			for (NewsDataEntity newsDataEntity : newsDataEntitys) {
				if ((baseUrl + headline.attr("href")).equals(newsDataEntity.getUrl())) {
					isMatch = true;
					break;
				}
			}

			if (isMatch == false) {
				newsNum++;
				NewsDataEntity saveData = new NewsDataEntity();

				String originalText = "";
				for (Element headline2 : newsDetailsHeadlines) {
					originalText += headline2.text() + "\\\\";
				}

				saveData.setNews_id(newsNum);
				saveData.setUrl(baseUrl + headline.attr("href"));
				saveData.setTitle(newsDetails.title());
				saveData.setDate("20210831");
				saveData.setOriginal_html(originalText);
				saveData.setTranslated_html("");
				saveData.setTranslate_flag(0);
				newsDataRepository.save(saveData);
			}
		}
	}
}
