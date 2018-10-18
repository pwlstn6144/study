package com.study.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.study.spring.command.BCommand;
import com.study.spring.command.BContentCommand;
import com.study.spring.command.BDeleteCommand;
import com.study.spring.command.BListCommand;
import com.study.spring.command.BModifyCommand;
import com.study.spring.command.BReplyCommand;
import com.study.spring.command.BReplyViewCommand;
import com.study.spring.command.BWriteCommand;
import com.study.spring.util.Constent;

@Controller
public class BController {
	
	BCommand command = null;
	
	@Autowired
	private ApplicationContext context;	
	
	public JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constent.template = this.template;
	}
	@RequestMapping("/list")
	public String list(Model model)
	{
		command = (BListCommand) context.getBean("listHandler");
		command.execute(model);
		
		return "list";
	}
	
	@RequestMapping("/write_view")
	public String write_view(Model model) 
	{
		return "write_view";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model)
	{
		model.addAttribute("request", request);
		command = (BWriteCommand) context.getBean("writeHandler");
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model)
	{
		model.addAttribute("request", request);
		command = (BContentCommand) context.getBean("contentHandler");
		command.execute(model);
		
		return "content_view";
	}
	
	@RequestMapping(value="/modify_view", method=RequestMethod.GET)
	public String modify_view(HttpServletRequest request,Model model)
	{
		model.addAttribute("request", request);
		command = (BContentCommand) context.getBean("contentHandler");
		command.execute(model);
		
		return "modify_view";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modify(HttpServletRequest request, Model model)
	{
		model.addAttribute("request", request);
		command = (BModifyCommand) context.getBean("modifyHandler");
		command.execute(model);
		
		command = (BContentCommand) context.getBean("contentHandler");
		command.execute(model);
		
		return "content_view";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request,Model model)
	{
		model.addAttribute("request", request);
		command = (BDeleteCommand) context.getBean("deleteHandler");
		command.execute(model);

		return "redirect:list";
	}
	
	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest request, Model model)
	{
		model.addAttribute("request", request);
		command = (BReplyViewCommand) context.getBean("replyViewHandler");
		command.execute(model);
		
		return "reply_view";
	}
	
	@RequestMapping("/reply")
	public String reply(HttpServletRequest request, Model model)
	{
		model.addAttribute("request", request);
		command = (BReplyCommand) context.getBean("replyHandler");
		command.execute(model);
		
		return "redirect:list";
	}
	
}
