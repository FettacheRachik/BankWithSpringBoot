package org.sid.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {
	
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
	
	//Action Par defaut
	@RequestMapping (value="/")
	public String home() {
		return "redirect:/comptes";
	}
	
	//Action Par defaut
		@RequestMapping (value="/403")
		public String acceDenied() {
			return "403";
		}

}
