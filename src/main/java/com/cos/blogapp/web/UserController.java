package com.cos.blogapp.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;

import com.cos.blogapp.domain.user.User;
import com.cos.blogapp.domain.user.UserRepository;
import com.cos.blogapp.web.dto.JoinReqDto;
import com.cos.blogapp.web.dto.LoginReqDto;

@Controller
public class UserController {

	private UserRepository userRepository;
	private HttpSession session;
	
	//DI 디펜더십 인덱션 의존성 주입
	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
		this.session = session;
		
	}
	
	@GetMapping("/test/quert/join")
	public void testQueryJoin() {
		userRepository.join("cos", "1234", "cos@nate.com");
	}
	
	@GetMapping("/test/join")
	public void testJoin() {
		User user = new User();
		user.setUsername("ssar");
		user.setPassword("1234");
		user.setEmail("ssar@nate.com");
		
		//insert into user(username, password, email) values('ssar', '1234', 'ssar@nate.com');
		userRepository.save(user);
	}
	
	// views/user/login.jsp
	// /login -> login.jsp
	
	@GetMapping("/loginForm")
	public String loginForm() {
		return "user/loginForm";
	}
	
	@GetMapping("/joinForm")
	public String joinForm() {
		return "user/joinForm";
	}
	
	@PostMapping("/login")
	public String login(LoginReqDto dto) {
		//1. username, password 받기
		System.out.println(dto.getUsername());
		System.out.println(dto.getPassword());
		//2. DB -> 조회
		User userEntity = userRepository.mLogin(dto.getUsername(), dto.getPassword());
		
		if(userEntity == null) {
			return "redirect:/loginForm";
			
		}else {
			session.setAttribute("principal",userEntity);
			return"redirect:/home";
		}
		//3. 있으면
		//4. session에 저장
		//5. 메인페이지를 돌려주기
	
	}
	
	@PostMapping("/join")
	public String join(JoinReqDto dto) {//username=love&password=1234&email=love@nate.com
	
		User user = new User();
		user.setUsername(dto.getUsername());
		user.setPassword(dto.getPassword());
		user.setEmail(dto.getEmail());

		
		userRepository.save(dto);
		
		return "redirect:/loginForm";//리다이렉션 (300)
	}
}
