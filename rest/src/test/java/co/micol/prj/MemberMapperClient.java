package co.micol.prj;


import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.micol.prj.member.mapper.MemberMapper;
import co.micol.prj.member.service.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/config/*-context.xml")
public class MemberMapperClient {
	
	@Autowired MemberMapper mapper;
	
	//@Test
	public void listTest() {
		List<MemberVO> list = mapper.memberSelectList();
		System.out.println(list);
		
	}
	
	@Test
	public void selectTest() {
		MemberVO vo = mapper.memberSelect("test");
		System.out.println(vo);
		assertEquals(vo.getId(), "test");
		
	} 
	
	//@Test
	public void insertTest() {
		MemberVO vo = new MemberVO();
		vo.setId("test2");
		vo.setName("test");
		vo.setPassword("test");
		vo.setTel("test");
		vo.setAddress("test");
		int r = mapper.memberInsert(vo);
		assertEquals(r, 1);

	}
	
}
