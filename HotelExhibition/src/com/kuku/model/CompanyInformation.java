package com.kuku.model;

import java.util.List;


public class CompanyInformation {
	public List<CompanyInfo> companyInfo;
	public int CompanyNumber;
	
	public List<CompanyInfo> getCompanyInfo(){
		return companyInfo;
	}
	public int getCompanyNumber(){
		return CompanyNumber;
	}
}
