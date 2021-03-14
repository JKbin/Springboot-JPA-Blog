package com.cos.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// 사용자가 요청 > 응답(html 파일)
//	@Controller


// 사용자가 요청 > 응답(Data)
@RestController
public class HttpControllerTest {
	
	// http://localhost:8080/http/get
	// 인터넷 브라우저 요청은 무조건 get 요청밖에 할 수 없다.
	// 데이터 선택(Select)
	// http://localhost:8080/http/get?id=1&username=ssar&password=1234&email=ssar@nate.com (쿼리 스트링)
	@GetMapping("/http/get")
	public String getTest(Member m) {
		return "get 요청 : " + m.getId() + m.getUsername() + m.getPassword()+","+ m.getEmail();
		
	}
	
	@PostMapping("/http/post")
	// 데이터 추가(Insert)
	// application/json
	public String postTest(@RequestBody Member m) { // MessageConverter(스프링부트) 얘가 알아서 json을 파싱해서 Member 변수에 찍어줌
		return "post 요청 : " + m.getId() + m.getUsername() + m.getPassword()+","+ m.getEmail();
		
	}
	
	// 데이터 수정(Update)
	@PutMapping("/http/put")
	public String putTest(@RequestBody Member m) {
		return "put 요청 : " + m.getId() + "," + m.getUsername() + "," + m.getPassword()+","+ m.getEmail();
		
	}
	
	// 데이터 삭제(Delete)
	@DeleteMapping("http/delete")
	public String deleteTest() {
		return "delete 요청";
		
	}

}
