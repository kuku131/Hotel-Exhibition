package com.kuku.model;

public class CompanyInfo {
	
	public String CompanyName;
	public String CompanyDescription;
	public String website;
	public String companyImg;
	
	public void setCompanyName(String CompanyName){
		this.CompanyName=CompanyName;
	}
	public void setCompanyDescription(String CompanyDescription){
		this.CompanyDescription=CompanyDescription;
	}
	public void setwebsite(String website){
		this.website=website;
	}
	public void setcompanyImg(String companyImg){
		this.companyImg=companyImg;
	}
	public String getCompanyName(){
		return CompanyName;
	}
	public String getCompanyDescription(){
		return CompanyDescription;
	}
	public String getwebsite(){
		return website;
	}
	public String getcompanyImg(){
		return companyImg;
	}

}
