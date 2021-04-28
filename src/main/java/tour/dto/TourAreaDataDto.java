package tour.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="response")
public class TourAreaDataDto {
	private TourAreaDataHeaderDto header;
	private TourAreaDataBodyDto body;
	
	@XmlElement(name="header")
	public TourAreaDataHeaderDto getHeader() {
		return header;
	}
	public void setHeader(TourAreaDataHeaderDto header) {
		this.header = header;
	}
	
	@XmlElement(name="body")
	public TourAreaDataBodyDto getBody() {
		return body;
	}
	public void setBody(TourAreaDataBodyDto body) {
		this.body = body;
	}
	
}
