package com.kuku.dao;

import android.content.Context;

import com.kuku.DataHandler.CompanyInfoHandler;

public class companyInfoDao extends CompanyInfoHandler{
	
	private TodoDbAdapter dbadapter;
	private CompanyInfoHandler cIH;
	Context context;
	
	public companyInfoDao(Context context){
		this.context=context;
	}
	
	public void pushDataToDB(){
		
		dbadapter=new TodoDbAdapter(context);
		dbadapter.open();
		cIH=new CompanyInfoHandler();
        for(int i=0;i<cIH.companyInformation.getCompanyNumber();i++){
        	dbadapter.createcompanyInfo(super.getCompanyNames()[i],super.getCompanyDescriptions()[i],super.getCompanywebsites()[i],super.getCompanyImgs()[i]);
        }
		
	}

}
