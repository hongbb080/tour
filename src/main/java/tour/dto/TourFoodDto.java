package tour.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="item")
public class TourFoodDto {
	
	private String num;
	private String UCSEQ;
	private String MAINTITLE;
	private String CNTCTTEL;
	private String MAINIMGNORMAL;
	private String ITEMCNTNTS;
	private String PLACE;
	private String ADDR2;
	private String USAGEDAYWEEKANDTIME;
	private String GUGUNNM;
	private String ADDR1;
	private String RPRSNTVMENU;
	private String HOMEPAGEURL;
	private String TITLE;
	private String MAINIMGTHUMB;
	private String LAT;
	private String LNG;
	
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
	public void setUC_SEQ(String uc_SEQ) {
		UCSEQ = uc_SEQ;
	}
	public String getMAIN_TITLE() {
		return MAINTITLE;
	}
	public void setMAIN_TITLE(String mAIN_TITLE) {
		MAINTITLE = mAIN_TITLE;
	}
	public String getCNTCT_TEL() {
		return CNTCTTEL;
	}
	public void setCNTCT_TEL(String cNTCT_TEL) {
		CNTCTTEL = cNTCT_TEL;
	}
	public String getMAIN_IMG_NORMAL() {
		return MAINIMGNORMAL;
	}
	public void setMAIN_IMG_NORMAL(String mAIN_IMG_NORMAL) {
		MAINIMGNORMAL = mAIN_IMG_NORMAL;
	}
	public String getITEMCNTNTS() {
		return ITEMCNTNTS;
	}
	public void setITEMCNTNTS(String iTEMCNTNTS) {
		ITEMCNTNTS = iTEMCNTNTS;
	}
	public String getPLACE() {
		return PLACE;
	}
	public void setPLACE(String pLACE) {
		PLACE = pLACE;
	}
	public String getADDR2() {
		return ADDR2;
	}
	public void setADDR2(String aDDR2) {
		ADDR2 = aDDR2;
	}
	public String getUSAGE_DAY_WEEK_AND_TIME() {
		return USAGEDAYWEEKANDTIME;
	}
	public void setUSAGE_DAY_WEEK_AND_TIME(String uSAGE_DAY_WEEK_AND_TIME) {
		USAGEDAYWEEKANDTIME = uSAGE_DAY_WEEK_AND_TIME;
	}
	public String getGUGUN_NM() {
		return GUGUNNM;
	}
	public void setGUGUN_NM(String gUGUN_NM) {
		GUGUNNM = gUGUN_NM;
	}
	public String getADDR1() {
		return ADDR1;
	}
	public void setADDR1(String aDDR1) {
		ADDR1 = aDDR1;
	}
	public String getRPRSNTV_MENU() {
		return RPRSNTVMENU;
	}
	public void setRPRSNTV_MENU(String rPRSNTV_MENU) {
		RPRSNTVMENU = rPRSNTV_MENU;
	}
	public String getHOMEPAGE_URL() {
		return HOMEPAGEURL;
	}
	public void setHOMEPAGE_URL(String hOMEPAGE_URL) {
		HOMEPAGEURL = hOMEPAGE_URL;
	}
	public String getTITLE() {
		return TITLE;
	}
	public void setTITLE(String tITLE) {
		TITLE = tITLE;
	}
	public String getMAIN_IMG_THUMB() {
		return MAINIMGTHUMB;
	}
	public void setMAIN_IMG_THUMB(String mAIN_IMG_THUMB) {
		MAINIMGTHUMB = mAIN_IMG_THUMB;
	}
	public String getLAT() {
		return LAT;
	}
	public void setLAT(String lAT) {
		LAT = lAT;
	}
	public String getLNG() {
		return LNG;
	}
	public void setLNG(String lNG) {
		LNG = lNG;
	}
	
}
