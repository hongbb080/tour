package tour.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

// 명소 api dto 부분
@XmlRootElement(name="item")
public class TourDto {
	private String num;
	private String UCSEQ;
	private String ADDR1;
	private String GUGUNNM;
	private String MAINTITLE;
	private String SUBTITLE;
	private String HOMEPAGEURL;
	private String TRFCINFO;
	private String MIDDLESIZERM1;
	private String ITEMCNTNTS;
	private String MAINIMGTHUMB;
	private String MAINIMGNORMAL;
	private String LNG;
	private String LAT;
	private String CNTCTTEL;
	private String USAGEDAYWEEKANDTIME;
	private String TITLE;
	
	@XmlElement
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getUC_SEQ() {
		return UCSEQ;
	}
	public void setUC_SEQ(String uC_SEQ) {
		UCSEQ = uC_SEQ;
	}
	public String getADDR1() {
		return ADDR1;
	}
	public void setADDR1(String aDDR1) {
		ADDR1 = aDDR1;
	}
	public String getGUGUN_NM() {
		return GUGUNNM;
	}
	public void setGUGUN_NM(String gUGUN_NM) {
		GUGUNNM = gUGUN_NM;
	}
	public String getMAIN_TITLE() {
		return MAINTITLE;
	}
	public void setMAIN_TITLE(String mAIN_TITLE) {
		MAINTITLE = mAIN_TITLE;
	}
	public String getSUBTITLE() {
		return SUBTITLE;
	}
	public void setSUBTITLE(String sUBTITLE) {
		SUBTITLE = sUBTITLE;
	}
	public String getHOMEPAGE_URL() {
		return HOMEPAGEURL;
	}
	public void setHOMEPAGE_URL(String hOMEPAGE_URL) {
		HOMEPAGEURL = hOMEPAGE_URL;
	}
	public String getTRFC_INFO() {
		return TRFCINFO;
	}
	public void setTRFC_INFO(String tRFC_INFO) {
		TRFCINFO = tRFC_INFO;
	}
	public String getMIDDLE_SIZE_RM1() {
		return MIDDLESIZERM1;
	}
	public void setMIDDLE_SIZE_RM1(String mIDDLE_SIZE_RM1) {
		MIDDLESIZERM1 = mIDDLE_SIZE_RM1;
	}
	public String getITEMCNTNTS() {
		return ITEMCNTNTS;
	}
	public void setITEMCNTNTS(String iTEMCNTNTS) {
		ITEMCNTNTS = iTEMCNTNTS;
	}
	public String getMAIN_IMG_THUMB() {
		return MAINIMGTHUMB;
	}
	public void setMAIN_IMG_THUMB(String mAIN_IMG_THUMB) {
		MAINIMGTHUMB = mAIN_IMG_THUMB;
	}
	public String getMAIN_IMG_NORMAL() {
		return MAINIMGNORMAL;
	}
	public void setMAIN_IMG_NORMAL(String mAIN_IMG_NORMAL) {
		MAINIMGNORMAL = mAIN_IMG_NORMAL;
	}
	public String getLNG() {
		return LNG;
	}
	public void setLNG(String lNG) {
		LNG = lNG;
	}
	public String getLAT() {
		return LAT;
	}
	public void setLAT(String lAT) {
		LAT = lAT;
	}
	public String getCNTCT_TEL() {
		return CNTCTTEL;
	}
	public void setCNTCT_TEL(String cNTCT_TEL) {
		CNTCTTEL = cNTCT_TEL;
	}
	public String getUSAGE_DAY_WEEK_AND_TIME() {
		return USAGEDAYWEEKANDTIME;
	}
	public void setUSAGE_DAY_WEEK_AND_TIME(String uSAGE_DAY_WEEK_AND_TIME) {
		USAGEDAYWEEKANDTIME = uSAGE_DAY_WEEK_AND_TIME;
	}
	public String getTITLE() {
		return TITLE;
	}
	public void setTITLE(String tITLE) {
		TITLE = tITLE;
	}

	
}
