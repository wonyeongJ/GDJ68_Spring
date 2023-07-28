package com.pbw.main.member;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pbw.main.util.FileManager;

@Service
public class MemberService {

	@Autowired
	private MemberDAO memberDAO;
	
	public MemberDTO getLogin(MemberDTO memberDTO)throws Exception{
		return memberDAO.getLogin(memberDTO);
	}
	
	public int setJoin(MemberDTO memberDTO, MultipartFile multipartFile, HttpSession session) throws Exception {
		int result = memberDAO.setJoin(memberDTO);
		
		String path = "/resources/upload/member/";

		if (!multipartFile.isEmpty()) {
			FileManager fileManager = new FileManager();
			String fileName = fileManager.fileSave(path, session, multipartFile);
			
			MemberFileDTO memberFileDTO = new MemberFileDTO();
			memberFileDTO.setId(memberDTO.getId());
			memberFileDTO.setOriginalName(multipartFile.getOriginalFilename());
			memberFileDTO.setFileName(fileName);
			
			result = memberDAO.setFileJoin(memberFileDTO);
		}
		
		
		return result;
	}

}
