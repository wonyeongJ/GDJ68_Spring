package com.pbw.main.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BoardService {
	
	@Autowired
	private BoardDAO boardDAO;
	
	public List<BoardDTO> getList() throws Exception {
		return boardDAO.getList();
	}
	
	public int setAdd(BoardDTO boardDTO)throws Exception {
		return boardDAO.setAdd(boardDTO);
	}
	
	public BoardDTO getDetail(BoardDTO boardDTO)throws Exception {
		return boardDAO.getDetail(boardDTO);
	}
	
	public int setUpdate(BoardDTO boardDTO)throws Exception{
		return boardDAO.setUpdate(boardDTO);
	}
	
	public int setDelete(BoardDTO boardDTO)throws Exception {
		return boardDAO.setDelete(boardDTO);
	}
	
}
