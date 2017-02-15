package com.aurora.controllers.html;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/index")
public class IndexCtrl {
	
	@RequestMapping(method=RequestMethod.GET)
	public String goIndex(){
		return "index";
	}

}
