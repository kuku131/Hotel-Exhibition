package com.kuku.DataHandler;

import java.util.List;

import com.kuku.ksoap.ksoapCall;
import com.kuku.model.CompanyInfo;
import com.kuku.model.CompanyInformation;

public class CompanyInfoHandler {
	
	public CompanyInformation companyInformation;
	List<CompanyInfo> companyInfo;
	public String companyNames[];
	public String companyDescriptions[];
	public String websites[];
	public String companyImgs[];

	
	public CompanyInfoHandler(){
		ksoapCall kC=new ksoapCall();
        companyInformation=kC.makeCallAndgetResult();
        companyInfo=companyInformation.getCompanyInfo();
        companyNames=new String[companyInformation.getCompanyNumber()];
        companyDescriptions=new String[companyInformation.getCompanyNumber()];
        websites=new String[companyInformation.getCompanyNumber()];
        companyImgs=new String[companyInformation.getCompanyNumber()];
        int i=0;
        for(CompanyInfo cI:companyInfo)
        {
        	this.companyNames[i]=cI.getCompanyName();
        	this.companyDescriptions[i]=cI.getCompanyDescription();
        	this.websites[i]=cI.getwebsite();
        	this.companyImgs[i]=cI.getcompanyImg();
        	i++;
        }
		
	}
	
	public String[] getCompanyNames(){
		
		return companyNames;

	}
	
	public String[] getCompanyDescriptions(){
		
		return companyDescriptions;
	}
	
	public String[] getCompanywebsites(){

		return websites;
	}
	
	public String[] getCompanyImgs(){

		return companyImgs;
	}

}
