package co.micol.prj.member.mapper;

import java.util.List;

import co.micol.prj.member.service.MemberVO;

public interface MemberMapper {
	List<MemberVO> memberSelectList();
	MemberVO memberSelect(String id);
	int memberInsert(MemberVO vo);
	int memberUpdate(MemberVO vo);
	int MemberDelete(MemberVO vo);
	
}
