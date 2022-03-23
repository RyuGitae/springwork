package co.micol.prj.member.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import co.micol.prj.member.mapper.MemberMapper;
import co.micol.prj.member.service.MemberVO;
@RestController
@CrossOrigin(origins = {"http://127.0.0.1:5500"})
public class MemberRestController {
	
	@Autowired MemberMapper mapper;
	
	@GetMapping("/movie")
	public Map movie() {
		RestTemplate template = new RestTemplate();
		String url = "https://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchWeeklyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20220320";
		Map map= template.getForObject(url, Map.class);
		return map;
	}
	
	
//	@GetMapping(value = "/test", produces = "text/plain")
//	//@ResponseBody // jackson : Object -> json String
//	public String test() {
//		return "plain test";
//	}
	
	@GetMapping(value = "/test", produces = "text/plain")
	//@ResponseBody // jackson : Object -> json String
	public ResponseEntity<String> test(@RequestParam int num) {
		if(num < 10) { // error
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("error");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body("success");			
		}
	}
	
	@GetMapping("/member")
	//@ResponseBody // jackson : Object -> json String
	public List<MemberVO> list() {
		return mapper.memberSelectList();
	}
	
	@PostMapping("/member")
	public MemberVO insert(MemberVO vo) {
		mapper.memberInsert(vo);
		return vo;
	}
	
	@PutMapping("/member")
	public MemberVO update(@RequestBody MemberVO vo) {
		mapper.memberUpdate(vo);
		return vo;
	}
	
	@GetMapping("/member/{id}")
	public MemberVO select(@PathVariable String id) {
		return mapper.memberSelect(id);
	}
	
	@DeleteMapping("/member/{id}")
	public MemberVO delete(@PathVariable String id) {
		MemberVO vo = new MemberVO();
		vo.setId(id);
		mapper.MemberDelete(vo);
		return vo;
	}
}
