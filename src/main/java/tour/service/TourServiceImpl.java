package tour.service;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tour.dto.PickDto;
import tour.dto.PickDto2;
import tour.dto.TourAreaDataBodyDto;
import tour.dto.TourAreaDataDto;
import tour.dto.TourData2Dto;
import tour.dto.TourDataDto;
import tour.dto.TourDto;
import tour.dto.TourFoodDataBodyDto;
import tour.dto.TourFoodDataDto;
import tour.dto.TourFoodDto;
import tour.dto.UserDto;
import tour.mapper.TourMapper;

@Service
public class TourServiceImpl implements TourService {
	@Autowired
	private TourMapper tourMapper;
	
	//	로그인
	@Override
	public int selectUserInfoYn(String userId, String userPw) throws Exception {
		return tourMapper.selectUserInfoYn(userId, userPw);
	}
	
	@Override
	public String getnickname(String userId) throws Exception {
		
		return tourMapper.getnickname(userId);
	}
	
	//	회원가입
	@Override
	public void signUpPage(UserDto sign) throws Exception {
		tourMapper.signUpPage(sign);
	}
	
	// 아이디 중복 확인
	@Override
	public int userIdCheck(String userId) throws Exception {
		
		return tourMapper.userIdCheck(userId);
	}
	
	// 닉네임 중복 확인
	@Override
	public int userNickNameCheck(String nickname) throws Exception {
		
		return tourMapper.userNickNameCheck(nickname);
	}
	
	// 이메일 중복 확인
	@Override
	public int userEmailCheck(String userEmail) throws Exception {
		
		return tourMapper.userEmailCheck(userEmail);
	}
	
	// 픽 게시글 작성
	@Override
	public void insertTourBoard(PickDto data) throws Exception {
		tourMapper.insertTourBoard(data);
	}
	// 픽 게시글
	@Override
	public List<PickDto> selectPickBoardList() throws Exception {
		return tourMapper.selectPickBoardList();
	}
	
	// 픽 게시글 삭제
	public void pickDelete(String num) throws Exception {
		tourMapper.pickDelete(num);
	}

	
	// 명소 api 
	public List<TourDto> gettourAreaRange(String urlStr) throws Exception {
		
		List<TourDto> itemLists = null;
		URL url = null;
		HttpURLConnection urlConn = null;
		
		try {

			url = new URL(urlStr);
			urlConn = (HttpURLConnection)url.openConnection();
			urlConn.setRequestMethod("GET");
			
			JAXBContext jc = JAXBContext.newInstance(TourAreaDataDto.class);
			Unmarshaller um = jc.createUnmarshaller();
			
			TourAreaDataDto infoData = (TourAreaDataDto)um.unmarshal(url);
			
			TourAreaDataBodyDto infoBody = infoData.getBody();
			TourDataDto infoItems = infoBody.getItems();
			
			itemLists = infoItems.getItemList();
			
			
			urlConn.disconnect();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {

			urlConn.disconnect();
		}
		
		return itemLists;
	}
	
	// 명소 리스트
	@Override
	public List<TourDto> getDbAreaList(String GUGUNNM) throws Exception {
		
		List<TourDto> dbItemList = tourMapper.getDbAreaList(GUGUNNM);
		return dbItemList; 
	}
	
	// 명소 디테일
	@Override
	public List<TourDto> getDbAreaDetail(String num) throws Exception{
		
		List<TourDto> dbItemList = tourMapper.getDbAreaDetail(num);
		return dbItemList; 
	}
	
	// 명소 입력된 구역 
	@Override
	public List<TourDto> getDbAreaListRange() throws Exception {
		List<TourDto> dbItemList = tourMapper.getDbAreaListRange();
		
		return dbItemList;
	}
	
	// 명소 api
	public void setDbAreaList(List<TourDto> newItemList) throws Exception {
		
		for (TourDto item : newItemList) {
			tourMapper.setDbArea(item);
		}
	}
	
	// 명소 후기
	@Override
	public void insertTourBoard2(PickDto2 data2) throws Exception{
		tourMapper.insertTourBoard2(data2);
	}
	
	@Override
	public List<PickDto2> selectPickBoardList2(String uc) throws Exception {
		List<PickDto2> reviewList = tourMapper.selectPickBoardList2(uc);
		
		return reviewList;
	}
	
	// 먹거리 api
	public List<TourFoodDto> gettourFoodRange(String urlStr2) throws Exception {
		
		List<TourFoodDto> itemLists = null;
		URL url = null;
		HttpURLConnection urlConn = null;
		
		try {

			url = new URL(urlStr2);
			urlConn = (HttpURLConnection)url.openConnection();
			urlConn.setRequestMethod("GET");
			
			JAXBContext jc = JAXBContext.newInstance(TourFoodDataDto.class);
			Unmarshaller um = jc.createUnmarshaller();
			
			TourFoodDataDto infoData = (TourFoodDataDto)um.unmarshal(url);
			
			TourFoodDataBodyDto infoBody = infoData.getBody();
			TourData2Dto infoItems = infoBody.getItems();
			
			itemLists = infoItems.getItemList();
			
			urlConn.disconnect();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {

			urlConn.disconnect();
		}
		
		return itemLists;
	}
	
	// 먹거리 리스트
	@Override
	public List<TourFoodDto> getDbFoodList(String GUGUNNM) throws Exception {
		
		return tourMapper.getDbFoodList(GUGUNNM); 
	}
	
	// 먹거리 상세페이지
	@Override
	public List<TourFoodDto> getDbFoodDetail(String num) throws Exception {
		return tourMapper.getDbFoodDetail(num);
	}
	
	@Override
	public List<TourFoodDto> getDbFoodListRange() throws Exception {
		List<TourFoodDto> dbItemList = tourMapper.getDbFoodListRange();
		
		return dbItemList;
	}
	
	public void setDbFoodList(List<TourFoodDto> newItemList) throws Exception {
		for (TourFoodDto item : newItemList) {
			tourMapper.setDbFood(item);
		}
	}
}
