package news.app.controller.newsview;

public class NewsViewForm {
	private String title;
	private String original_text;
	private String traslated_text;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getOriginal_text() {
		return original_text;
	}
	public void setOriginal_text(String original_text) {
		this.original_text = original_text;
	}
	
	public String getTraslated_text() {
		return traslated_text;
	}
	public void setTraslated_text(String traslated_text) {
		this.traslated_text = traslated_text;
	}
}
