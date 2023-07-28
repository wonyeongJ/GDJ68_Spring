package com.pbw.main.util;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileManager {
	
	public String fileSave(String path, HttpSession session, MultipartFile multipartFile) throws Exception{
	
		// 파일의 정보를 이용해서 서버의 하드디스크에 파일을 저장(서버의 'resources/upload/member' 경로에)
		// 1. 어디에 저장?
		// 2. 실제 경로 알아오기
		String realPath = session.getServletContext().getRealPath(path);
		System.out.println(realPath);
		
		File file = new File(realPath);
		
		// 해당 경로가 실제로 존재하지 않는다면 파일을 생성하도록 명령
		if(!file.exists()) {
			file.mkdirs();
		}
		
		/* 동일한 이름의 파일이 올라오면 기존의 파일을 덮어 씌워버림 이를 방지하기 위한 코드 1.
		-> 중복 가능성 최소화하기 위해 최대한 작은 단위 까지의 현재 시간을 활용 */
	//	Calendar ca = Calendar.getInstance();
	//	long result = ca.getTimeInMillis();
		// 파일을 오른쪽 매개값의 이름으로 저장
	//	file = new File(file, String.valueOf(result)+"_"+multipartFile.getOriginalFilename());
		
		/* 동일한 이름의 파일이 올라오면 기존의 파일을 덮어 씌워버림 이를 방지하기 위한 코드 2.
		-> API 사용 universal unique */		
		String uId = UUID.randomUUID().toString();
		uId = uId+"_"+multipartFile.getOriginalFilename();
		System.out.println(uId);
		
		file = new File(file, uId);
		
		// 3. 파일 저장 단계
		// A. Spring에서 제공하는 API FileCopyUtils의 copy 메소드 활용
		FileCopyUtils.copy(multipartFile.getBytes(), file);
		
		// B. MultipartFile의 transferTo 메소드 활용
		// multipartFile.transferTo(file);
		
		return uId;
	}
}