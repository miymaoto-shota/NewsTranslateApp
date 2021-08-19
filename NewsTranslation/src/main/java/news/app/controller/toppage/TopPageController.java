package news.app.controller.toppage;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.annotation.SessionScope;

import news.app.controller.newsview.NewsViewForm;

@Controller
@SessionScope
public class TopPageController {

	@RequestMapping(value = "/TopPage",method = RequestMethod.GET)
	public String TopPage(Model model) {
		return "TopPage";
	}

	@RequestMapping(value = "/TopPage", method = RequestMethod.POST)
	public String gotoEdit(Model model) {
		return "TopPage";
	}

	@RequestMapping(value = "/SignOut", method = RequestMethod.POST)
	public String gotoSignOut(Model model) {
		return "SignIn";
	}

	@RequestMapping(value = "/NewsView", method = RequestMethod.POST)
	public String gotoNewsView(Model model, @ModelAttribute("NewsViewForm") NewsViewForm newsViewForm) {
		model.addAttribute("title", newsViewForm.getTitle());
		model.addAttribute("text", newsViewForm.getTraslated_text().replace("\\", "\n"));
		return "NewsView";
	}
}
