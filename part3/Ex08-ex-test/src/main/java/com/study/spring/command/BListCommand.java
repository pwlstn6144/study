package com.study.spring.command;

import java.util.ArrayList;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.study.spring.Dao.BDao;
import com.study.spring.Dto.BDto;

@Component("listHandler")
public class BListCommand implements BCommand {

	@Override
	public void execute(Model model) 
	{
		
		BDao dao = new BDao();
		
	
		ArrayList<BDto> dtos = dao.list(); // 검색어 파라미터 추가
		model.addAttribute("list", dtos);
		
		
		
	}

}
