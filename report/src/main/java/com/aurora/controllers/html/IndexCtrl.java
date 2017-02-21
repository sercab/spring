package com.aurora.controllers.html;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aurora.data.repositories.CountyRepository;

@Controller
@RequestMapping("/index")
public class IndexCtrl {
	
	private CountyRepository countyRepo;
	
	@Autowired
	public IndexCtrl(CountyRepository countyRepo) {
		this.countyRepo = countyRepo;
	}


	@RequestMapping(method=RequestMethod.GET)
	public String goIndex(Model model){
		model.addAttribute(countyRepo.findAll());
		return "index";
	}

}
