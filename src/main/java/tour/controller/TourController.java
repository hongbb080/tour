package tour.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import tour.dto.PickDto;
import tour.dto.PickDto2;
import tour.dto.TourDto;
import tour.dto.TourFoodDto;
import tour.dto.UserDto;
import tour.service.TourService;

@Controller
public class TourController {
	@Autowired
	private TourService tourService;
	
	// 메인 페이지 
	@RequestMapping(value="/tour/busanTour" ,method=RequestMethod.GET)
	public String getMainPage() throws Exception {
		return "/tour/busanTour";
	}
	
	@ResponseBody
	@RequestMapping(value="/tour/tourAreaApiData", method= {RequestMethod.POST, RequestMethod.GET})
	public Object getMainList() throws Exception {
		List<TourDto> newDbItemList = tourService.getDbAreaListRange();
		
		return newDbItemList;
	}
	
	@ResponseBody
	@RequestMapping(value="/tour/tourFoodApiData", method= {RequestMethod.POST, RequestMethod.GET})
	public Object getTourFoodData() throws Exception {
		List<TourFoodDto> newDbItemList = tourService.getDbFoodListRange();
		
		return newDbItemList;
	}
	
//	로그인 사용자 정보 확인
	@ResponseBody
	@RequestMapping(value="/tour/loginCheck", method=RequestMethod.POST)
	public String loginCheck(@RequestParam String userId, @RequestParam String userPw, @RequestParam String userUrl, HttpServletRequest request) throws Exception {
		int count = tourService.selectUserInfoYn(userId, userPw);
		String resultmsg;
		

		if(count == 1) {
			String nickname = tourService.getnickname(userId);
			HttpSession session = request.getSession();
			session.setAttribute("userId", userId);
			session.setAttribute("nickname", nickname);
			session.setMaxInactiveInterval(300);
			resultmsg="<script>alert('로그인에 성공하였습니다.'); window.location.href='" + userUrl + "';</script>";
			return resultmsg;
		}
		else {
			
			resultmsg="<script>alert('로그인에 실패하였습니다.'); history.back();</script>";
			return resultmsg;
		}
	}
	
	// 로그아웃
	@RequestMapping(value="/tour/logout", method=RequestMethod.GET)
	public String logout(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();

		session.removeAttribute("userId");
		session.invalidate();
		
		return "redirect:/tour/busanTour";
	}
	
	// 회원가입 페이지 호출
	@RequestMapping(value="/tour/openSignUp", method=RequestMethod.GET)
	public String openSignUp() throws Exception {
		
		return "/tour/signup";
	}
	
	// 회원가입
	@RequestMapping(value="/tour/signUpPage", method={RequestMethod.POST, RequestMethod.GET})
	public String signUpPage(UserDto sign) throws Exception {

		tourService.signUpPage(sign);
		
		return "/tour/busanTour";
	}
	
	// 아이디 중복 확인
	@ResponseBody
	@RequestMapping(value = "/tour/signupIdCheck", method = RequestMethod.GET)
	public int idCheck(@RequestParam("userId") String userId) throws Exception {

		return tourService.userIdCheck(userId);
	}
	
	// 닉네임 중복 확인
	@ResponseBody
	@RequestMapping(value = "/tour/signupNicknameCheck", method = RequestMethod.GET)
	public int nicknameCheck(@RequestParam("nickname") String nickname) throws Exception {

		return tourService.userNickNameCheck(nickname);
	}
	
	// 이메일 중복 확인
	@ResponseBody
	@RequestMapping(value = "/tour/signupEmailCheck", method = RequestMethod.GET)
	public int userEmailCheck(@RequestParam("userEmail") String userEmail) throws Exception {

		return tourService.userEmailCheck(userEmail);
	}
	
	// 교통 클릭시 화면
	@RequestMapping("/tour/transport")
	public String openTourTransport() throws Exception {
			return "/tour/transport";
	}
	
	// 명소 클릭시 화면
	@RequestMapping("/tour/area")
	public String openTourArea() throws Exception {
			return "/tour/area";
	}
	
	// 먹거리 클릭시 화면
	@RequestMapping("/tour/food")
	public String openTourFood() throws Exception {
			return "/tour/food";
	}
	
	// 코스 클릭시 화면
	@RequestMapping("/tour/cos")
	public String openTourcos() throws Exception {
			return "/tour/cos";
	}
	
	// 픽 추천 게시판
	@ResponseBody
	@RequestMapping(value="/tour/pickWrite", method=RequestMethod.POST)
	public Object insertTourBoard(PickDto data, HttpSession session) throws Exception {
		String writer = (String) session.getAttribute("userId");
		String nickname = (String) session.getAttribute("nickname");
		String resultmsg;
		
		if(writer != null) {
			data.setWriter(writer);
			data.setNickname(nickname);
			tourService.insertTourBoard(data);
			resultmsg="<script>window.location.href='" + "/tour/pickList" + "';</script>";
			return resultmsg;
		}
		else {
			resultmsg= "<script>alert('로그인이 필요합니다.'); history.back();</script>";
			return resultmsg;
		}
		
	}
	// 픽 클릭시 목록
	@RequestMapping(value="/tour/pickList", method=RequestMethod.GET)
	public ModelAndView selectPickBoardList() throws Exception {
		ModelAndView mv = new ModelAndView("/tour/pick");
		
		List<PickDto> list = tourService.selectPickBoardList();
		mv.addObject("Datas", list);
		
		return mv;
	}
	// 픽 삭제
	@RequestMapping(value="tour/pickDelete", method=RequestMethod.GET)
	public String pickDelete(@RequestParam String num) throws Exception {
		tourService.pickDelete(num);
		//String result;
		//result="<script> window.location.reload();</script>";
		//return result;
		
		return "redirect:/tour/pickList";
		//return "/tour/pickList";
	}

	
	// 명소 리스트 페이지
	@ResponseBody
	@RequestMapping(value="/tour/tourAreaApi", method= {RequestMethod.POST, RequestMethod.GET})
	public Object getTourArea(@RequestParam Map<String, String> param) throws Exception {
		
		List<TourDto> dbItemList = tourService.getDbAreaList(param.get("GUGUNNM"));
		
		return dbItemList;
	}
	
	// 명소 디테일 페이지
	@RequestMapping("/tour/areaDetail/{num}")
	public String openTourAreaDetail() throws Exception {
			return "/tour/areaDetail";
	}
	@ResponseBody
	@RequestMapping(value="/tour/tourAreaDetail", method={RequestMethod.POST, RequestMethod.GET})
	public Object tourAreaDetail(@RequestParam Map<String, String> param) throws Exception {
		
		List<TourDto> dbItemList = tourService.getDbAreaDetail(param.get("num"));
		
		return dbItemList;
	}
	// 먹거리 api
	@ResponseBody
	@RequestMapping(value="/tour/tourFoodApi", method={RequestMethod.POST, RequestMethod.GET})
	public Object getTourFood(@RequestParam Map<String, String> param) throws Exception {
		
		List<TourFoodDto> dbItemList = tourService.getDbFoodList(param.get("GUGUNNM"));
		
		return dbItemList;
	}
	
	// 먹거리 디테일 페이지
	@RequestMapping("/tour/foodDetail/{num}")
	public String openTourFoodDetail() throws Exception {
			return "/tour/foodDetail";
	}
	@ResponseBody
	@RequestMapping(value="/tour/tourFoodDetail", method={RequestMethod.POST, RequestMethod.GET})
	public Object tourFoodDetail(@RequestParam Map<String, String> param) throws Exception {
		
		List<TourFoodDto> dbItemList = tourService.getDbFoodDetail(param.get("num"));
		
		return dbItemList;
	}
	
	// 디테일 후기 게시판
	@ResponseBody
	@RequestMapping(value="/tour/areaDetailReview", method=RequestMethod.POST)
	public Object insertTourBoard2(PickDto2 data2, HttpSession session, @RequestParam String uc) throws Exception {
		String userId = (String) session.getAttribute("userId");
		String nickname = (String ) session.getAttribute("nickname");
		
		String resultmsg;
		if(userId != null) {
			data2.setUserid(userId);
			data2.setNickname(nickname);
			tourService.insertTourBoard2(data2);
			resultmsg="<script>history.back();</script>";
			return resultmsg;
		}
		else {
			resultmsg= "<script>alert('로그인이 필요합니다.'); history.back();</script>";
			return resultmsg;
		}
	}
	@ResponseBody
	@RequestMapping(value="/tour/areaDetailReviewList", method={RequestMethod.POST, RequestMethod.GET})
	public Object selectPickBoardList2(@RequestParam Map<String, String> param) throws Exception {
		
		List<PickDto2> reviewList = tourService.selectPickBoardList2(param.get("uc"));
		
		return reviewList;
	}
	
	@RequestMapping("/tour/cos1")
	public String openTourCos1() throws Exception {
			return "/tour/cos1";
	}
	@RequestMapping("/tour/cos2")
	public String openTourCos2() throws Exception {
			return "/tour/cos2";
	}
	@RequestMapping("/tour/cos3")
	public String openTourCos3() throws Exception {
			return "/tour/cos3";
	}
	@RequestMapping("/tour/cos4")
	public String openTourCos4() throws Exception {
			return "/tour/cos4";
	}
	@RequestMapping("/tour/cos5")
	public String openTourCos5() throws Exception {
			return "/tour/cos5";
	}
	@RequestMapping("/tour/cos6")
	public String openTourCos6() throws Exception {
			return "/tour/cos6";
	}
	
}
