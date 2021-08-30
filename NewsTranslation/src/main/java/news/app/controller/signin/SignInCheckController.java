package news.app.controller.signin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SignInCheckController {

	@RequestMapping(value = "/SignInCheck")
	public String SignInCheck() {
		return "/SignInCheck";
	}
}
