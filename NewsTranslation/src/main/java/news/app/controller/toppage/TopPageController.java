package news.app.controller.toppage;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.annotation.SessionScope;

@Controller
@SessionScope
@RequestMapping("/NewsTranslate")
public class TopPageController {

	@RequestMapping(value = "/TopPage", method = RequestMethod.GET)
	public String TopPage(Model model) {
		return "TopPage";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String gotoEdit(Model model) {
		return "TopPage";
	}

	@RequestMapping(value = "/SignOut", method = RequestMethod.POST)
	public String gotoSignOut(Model model) {
		return "SignIn";
	}
}