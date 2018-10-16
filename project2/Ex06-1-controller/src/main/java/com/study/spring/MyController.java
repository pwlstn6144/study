package com.study.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	@RequestMapping("/board/view")
	public String view() {
		
		
		return "/board/view";
	}
	
	@RequestMapping("/board/content")
	public String content(Model model) {
		
		model.addAttribute("id",30);
		return "/board/content";
	}
	
	@RequestMapping(value = ":", method = RequestMethod.GET)
	public ModelAndView reply() {
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("id",30);
		mv.setViewName("board/reply");
		return mv;
	}
}
