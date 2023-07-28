package com.pbw.main.bankbook;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pbw.main.util.FileManager;
import com.pbw.main.util.Pager;

@Service
public class BankBookService {
	
	@Autowired
	private BankBookDAO bankBookDAO;
	
	@Autowired
	private FileManager fileManager;
	
	public List<BankBookDTO> getList(Pager pager)throws Exception{
		pager.makeRowNum(); 
		Long total = bankBookDAO.getTotal(pager);  
		pager.makePageNum(total); 
		
		return bankBookDAO.getList(pager);
	}

	public BankBookDTO getDetail(BankBookDTO bankBookDTO)throws Exception{
		return bankBookDAO.getDetail(bankBookDTO);
	}
	
	public int setAdd(BankBookDTO bankBookDTO, MultipartFile [] files, HttpSession session)throws Exception{
		// /resources/upload/bankbook
		String path="/resources/upload/bankbook/";
		
		//long num = bankBookDAO.getSequence();
		//bankBookDTO.setBookNum(num);

		int result = bankBookDAO.setAdd(bankBookDTO);
		
		for(MultipartFile multipartFile: files) {
			String fileName=fileManager.fileSave(path, session, multipartFile);
			BankBookFileDTO bankBookFileDTO = new BankBookFileDTO();
			bankBookFileDTO.setOriginalName(multipartFile.getOriginalFilename());
			bankBookFileDTO.setFileName(fileName);
			bankBookFileDTO.setBookNum(bankBookDTO.getBookNum());
			result = bankBookDAO.setFileAdd(bankBookFileDTO);
		}
		
		return result;
	}
	
	public int setUpdate(BankBookDTO bankBookDTO)throws Exception{
		return bankBookDAO.setUpdate(bankBookDTO);
	} 
	
	public int setDelete(Long num)throws Exception{
		return bankBookDAO.setDelete(num);
	}
	
}
