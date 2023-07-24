package com.pbw.main.student;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAO {

	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE="com.pbw.main.student.StudentDTO.";
	
	//List
	public List<StudentDTO> getList() throws Exception{
		return sqlSession.selectList(NAMESPACE+"getList");
	}
	
	//Detail
	public StudentDTO getDetail(StudentDTO studentDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getDetail", studentDTO);
	}
	
}
