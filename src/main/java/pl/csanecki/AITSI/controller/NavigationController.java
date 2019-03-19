package pl.csanecki.AITSI.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavigationController {
	@GetMapping("/")
	public String getWelcomePage() {
		return "welcomePage";
	}
	
	@GetMapping("/main")
	public String getMainPage() {
		return "mainPage";
	}
}
