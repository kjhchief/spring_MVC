package ezen.springmvc.web.controller.v1;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
/**
 * 에노테이션 내부에 @Component 에노테이션이 포함되어 있어 컴포넌트 스캔 대상이 되며, 
 * 핸들러 매핑 객체가 메소드 레벨에 선언된 @RequestMapping 정보를 읽어 간다.
 * @Component + @RequestMapping
 */
public class HelloController{
	// 핸들러 매핑에게 찾아가라 하기
	@RequestMapping("/springmvc/hello")
//	@RequestMapping("/springmvc/*")
	// 에노테이션 기반으로 동작하기 때문에 메소드 이름은 임의로 작성하면 된다
	public ModelAndView	hello() {
		String message = "안녕하세요. Spring MVC";
		
		// 뷰의 논리적 이름과 뷰가 사용할 데이터를 저장하여 반환
		//원래 hello.jsp인데, 나중에 실제 실행 엔진이 다른게 될수도 있으니 걍 hello로 쓴다.
		ModelAndView mav = new ModelAndView("hello"); 
		//필요한 데이터 담기
		mav.addObject("message", message); 
		return mav;
	}
	
	@RequestMapping("/springmvc/today")
	public ModelAndView	today() {
		Calendar today = Calendar.getInstance();
		String formatToday = String.format("%1$tF %1$tT", today);
		
		// 뷰의 논리적 이름과 뷰가 사용할 데이터를 저장하여 반환
		ModelAndView mav = new ModelAndView("today"); //실제로는 today.jsp파일이 동작 
		//필요한 데이터 담기
		mav.addObject("today", formatToday); 
		return mav;
	}
}


