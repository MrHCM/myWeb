package myWeb.qn215.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("provider")
public class ProviderController {
	
	@RequestMapping("pr")
	public String provider() {
		
		return "providerlist";
	}
}
