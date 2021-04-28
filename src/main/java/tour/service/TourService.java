package tour.service;

import java.util.List;

import tour.dto.PickDto;
import tour.dto.PickDto2;
import tour.dto.TourDto;
import tour.dto.TourFoodDto;
import tour.dto.UserDto;

public interface TourService {
//	List<TourDto> getMainPage() throws Exception;

	// 로그인
	int selectUserInfoYn(String userId, String userPw) throws Exception;
	String getnickname(String userId) throws Exception;

	// 회원가입
	void signUpPage(UserDto sign) throws Exception;
	int userIdCheck(String userId) throws Exception;
	int userNickNameCheck(String nickname) throws Exception;
	int userEmailCheck(String userEmail) throws Exception;
	
	// 명소 api 부분
	List<TourDto> gettourAreaRange(String urlStr) throws Exception;
	List<TourDto> getDbAreaListRange() throws Exception;
	void setDbAreaList(List<TourDto> newItemList) throws Exception;
	
	// 명소 리스트, 상세페이지
	List<TourDto> getDbAreaList(String GUGUNNM) throws Exception;
	List<TourDto> getDbAreaDetail(String num) throws Exception;
	
	// 먹거리 api 부분
	List<TourFoodDto> gettourFoodRange(String urlStr2) throws Exception;
	List<TourFoodDto> getDbFoodListRange() throws Exception;
	void setDbFoodList(List<TourFoodDto> newItemList) throws Exception;

	// 먹거리 리스트, 상세페이지
	List<TourFoodDto> getDbFoodList(String GUGUNNM) throws Exception;
	List<TourFoodDto> getDbFoodDetail(String num) throws Exception;
	// 후기 게시판
	
	// 추천 게시판
	void insertTourBoard(PickDto data) throws Exception;
	List<PickDto> selectPickBoardList() throws Exception;
	void pickDelete(String num) throws Exception;

	
	// 상세 후기
	void insertTourBoard2(PickDto2 data2) throws Exception;
	List<PickDto2> selectPickBoardList2(String uc) throws Exception;
	
}
