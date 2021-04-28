package tour.common;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import tour.dto.TourDto;
import tour.dto.TourFoodDto;
import tour.service.TourService;

@Component
public class TourScheduling {
	@Autowired
	private TourService tourService;
	
	@Scheduled(cron = "0 0 0 13 * *")
	@ResponseBody
	@RequestMapping(value="/tour/tourAreaApiData", method= {RequestMethod.POST, RequestMethod.GET})
	public Object getTourData() throws Exception {
		String endPoint = "http://apis.data.go.kr/6260000/AttractionService/";
		String serviceFunc = "getAttractionKr?";
		String keyFunc ="serviceKey=";
		String rows = "&numOfRows=200";
		String pageNo = "&pageNo=1";

		String serviceKey = "iA9mszuAh3%2BTw5SCV8bqVDa8iHldcx3mcQf6lG1%2FduXjx%2FAMbb88qymukadXjrWIo7FBOm%2F6A%2F4FFAD8CEYXtw%3D%3D";
		String urlStr = endPoint + serviceFunc + keyFunc + serviceKey + rows + pageNo;

		List<TourDto> itemLists = tourService.gettourAreaRange(urlStr);
		List<TourDto> dbItemList = tourService.getDbAreaListRange();
		List<TourDto> newItemList = new ArrayList<TourDto>();
		
 		for (TourDto item : itemLists) {
			boolean isEquals = false ;
			
			if (item.getUC_SEQ() != null) {
				for (TourDto dbItem : dbItemList) {
					if (item.getUC_SEQ().equals(dbItem.getUC_SEQ())) {
						isEquals = true;
					}
				}
				
				if (!isEquals) {
					newItemList.add(item);
				}
			}
		}
 		tourService.setDbAreaList(newItemList);
		List<TourDto> newDbItemList = tourService.getDbAreaListRange();
		
		return newDbItemList;
	}
	
	@Scheduled(cron = "0 0 13 * * *")
	@ResponseBody
	@RequestMapping(value="/tour/tourFoodApi", method= {RequestMethod.POST, RequestMethod.GET})
	public Object getTourFoodData() throws Exception {
		
		String endPoint = "http://apis.data.go.kr/6260000/FoodService/";
		String serviceFunc = "getFoodKr?";
		String keyFunc ="serviceKey=";
		String rows = "&numOfRows=200";
		String pageNo = "&pageNo=1";

	 	String serviceKey = "iA9mszuAh3%2BTw5SCV8bqVDa8iHldcx3mcQf6lG1%2FduXjx%2FAMbb88qymukadXjrWIo7FBOm%2F6A%2F4FFAD8CEYXtw%3D%3D";
		String urlStr2 = endPoint + serviceFunc + keyFunc + serviceKey + rows + pageNo;

		List<TourFoodDto> itemLists = tourService.gettourFoodRange(urlStr2);
		
		List<TourFoodDto> dbItemList = tourService.getDbFoodListRange();
		
		List<TourFoodDto> newItemList = new ArrayList<TourFoodDto>();
		
 		for (TourFoodDto item : itemLists) {
			boolean isEquals = false ;
			
			if (item.getUC_SEQ() != null) {
				for (TourFoodDto dbItem : dbItemList) {
					if (item.getUC_SEQ().equals(dbItem.getUC_SEQ())) {
						isEquals = true;
					}
				}
				
				if (!isEquals) {
					newItemList.add(item);
				}
			}
		}
		
		tourService.setDbFoodList(newItemList);
		
		List<TourFoodDto> newDbItemList = tourService.getDbFoodListRange();
		
		return newDbItemList;
	}
}
