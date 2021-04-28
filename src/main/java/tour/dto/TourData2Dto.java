package tour.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="items")
public class TourData2Dto {
	private List<TourFoodDto> itemList;
	
	@XmlElement(name="item")
	public List<TourFoodDto> getItemList() {
		return itemList;
	}
	public void setItemList(List<TourFoodDto> itemList) {
		this.itemList = itemList;
	}
}
