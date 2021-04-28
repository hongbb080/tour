package tour.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="response")
public class TourFoodDataDto {
	private TourFoodDataHeaderDto header;
	private TourFoodDataBodyDto body;
	
	@XmlElement(name="header")
	public TourFoodDataHeaderDto getHeader() {
		return header;
	}
	public void setHeader(TourFoodDataHeaderDto header) {
		this.header = header;
	}
	
	@XmlElement(name="body")
	public TourFoodDataBodyDto getBody() {
		return body;
	}
	public void setBody(TourFoodDataBodyDto body) {
		this.body = body;
	}
	
	
}
