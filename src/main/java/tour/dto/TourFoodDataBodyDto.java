package tour.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="body")
public class TourFoodDataBodyDto {
	private int numOfRows;
	private int pageNo;
	private int totalCount;
	private TourData2Dto items;
	
	@XmlElement
	public int getNumOfRows() {
		return numOfRows;
	}
	public void setNumOfRows(int numOfRows) {
		this.numOfRows = numOfRows;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	@XmlElement(name="items")
	public TourData2Dto getItems() {
		return items;
	}
	public void setItems(TourData2Dto items) {
		this.items = items;
	}
}
