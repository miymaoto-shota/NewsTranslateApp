package news.app.controller.signin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SignInController {

	@RequestMapping(value = "/SignIn")
	public String SignIn() {
		return "/SignIn";
	}
}
