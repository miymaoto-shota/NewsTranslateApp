package news.app.controller.toppage;

import lombok.Data;

@Data
public class NewsData {
	private String date;
	private String title;
	private String text;
	private String translatedText;
	private String url;
}
