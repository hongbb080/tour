package tour.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import tour.dto.PickDto;
import tour.dto.PickDto2;
import tour.dto.TourDto;
import tour.dto.TourFoodDto;
import tour.dto.UserDto;

@Mapper
public interface TourMapper {
//	로그인부분
	int selectUserInfoYn(@Param("userId") String userId, @Param("userPw") String userPw) throws Exception;
	String getnickname(@Param("userId")String userId) throws Exception;
	
//	가입부분
	public void signUpPage(UserDto sign) throws Exception;
	int userIdCheck(@Param("userId") String userId) throws Exception;
	int userNickNameCheck(@Param("nickname") String nickname) throws Exception;
	int userEmailCheck(@Param("userEmail") String userEmail) throws Exception;
	
//	명소 api부분
	List<TourDto> getDbAreaListRange() throws Exception;
	void setDbArea(TourDto item) throws Exception;
	void setDbAreaList(TourDto newItemList) throws Exception;
	
//	명소 리스트, 상세 페이지
	List<TourDto> getDbAreaList(@Param("GUGUNNM")String GUGUNNM) throws Exception;
	List<TourDto> getDbAreaDetail(@Param("num")String num) throws Exception;
	
//	먹거리 api 부분
	List<TourFoodDto> getDbFoodListRange() throws Exception;
	void setDbFood(TourFoodDto item) throws Exception;
	void setDbFoodList(TourFoodDto newItemList) throws Exception;

//	먹거리 리스트, 상세페이지
	List<TourFoodDto> getDbFoodList(@Param("GUGUNNM")String GUGUNNM) throws Exception;
	List<TourFoodDto> getDbFoodDetail(@Param("num")String num) throws Exception;
	
//	픽부분
	void insertTourBoard(PickDto data) throws Exception;
	List<PickDto> selectPickBoardList() throws Exception;
	void pickDelete(@Param("num")String num) throws Exception;
	

	
//	후기
	void insertTourBoard2(PickDto2 data2) throws Exception;
	List<PickDto2> selectPickBoardList2(@Param("uc")String uc) throws Exception;
}
