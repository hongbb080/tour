package tour.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="items")
public class TourDataDto {
	private List<TourDto> itemList;
	
	@XmlElement(name="item")
	public List<TourDto> getItemList() {
		return itemList;
	}

	public void setItemList(List<TourDto> itemList) {
		this.itemList = itemList;
	}
}
