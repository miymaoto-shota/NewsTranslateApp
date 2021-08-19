package news.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "newslist")
public class NewsDataEntity {
	@Id
	@Column(name = "news_id")
	private int news_id;

	@Column(name = "date")
	private String date;

	@Column(name = "url")
	private String url;

	@Column(name = "title")
	private String title;

	@Column(name = "original_html")
	private String original_html;

	@Column(name = "translated_html")
	private String translated_html;

	@Column(name = "translate_flag")
	private int translate_flag;
}
