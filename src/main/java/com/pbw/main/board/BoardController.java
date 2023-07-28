package com.pbw.main.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/notice/*")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="list", method = RequestMethod.GET)
	public String getList(Model model)throws Exception{
		List<BoardDTO> ar = boardService.getList();
		model.addAttribute("list", ar);
		return "board/list";
	}
	
	//form
	@RequestMapping(value="add", method = RequestMethod.GET)
	public String setAdd() throws Exception{
		System.out.println("add");
		return "board/add";
	}
	
	//db insert
	@RequestMapping(value="add", method = RequestMethod.POST)
	public String setAdd(BoardDTO boardDTO) throws Exception{
		System.out.println("addpost");
		int result = boardService.setAdd(boardDTO);
		System.out.println(result);
		return "redirect:/notice/list";
	}
	
	@RequestMapping(value="detail")  //method = RequestMethod.GET을 안쓰면 기본적으로 GET
	public ModelAndView getDetail(BoardDTO boardDTO, ModelAndView mv)throws Exception{
		boardDTO = boardService.getDetail(boardDTO);
		mv.addObject("dto", boardDTO);   //detail.jsp에서 dto로 꺼내고 있어서
		mv.setViewName("/board/detail");
		return mv;
	}
	
//	@RequestMapping(value="detail")  //method = RequestMethod.GET을 안쓰면 기본적으로 GET
//	public String getDetail(BoardDTO boardDTO, Model model)throws Exception{
//		boardDTO = boardService.getDetail(boardDTO);
//		model.addAttribute("dto", boardDTO);   //detail.jsp에서 dto로 꺼내고 있어서
//		
//		return "/board/detail";
//	}
	
	// update form
	@RequestMapping(value="update", method = RequestMethod.GET)
	public String setUpdate(BoardDTO boardDTO, Model model) throws Exception{
		boardDTO = boardService.getDetail(boardDTO);
		model.addAttribute("dto", boardDTO);
		return "board/update";
	}
	
	// update
	@RequestMapping(value="update", method = RequestMethod.POST)
	public String setUpdate(BoardDTO boardDTO) throws Exception{
		int result = boardService.setUpdate(boardDTO);
		System.out.println(result);
		return "redirect:./list";
	}
	
	//delete
	@RequestMapping(value="delete")
	public String delete(BoardDTO boardDTO) throws Exception{
		int result = boardService.setDelete(boardDTO);
		System.out.println(result);
		return "redirect:./list";
	}
	
}
