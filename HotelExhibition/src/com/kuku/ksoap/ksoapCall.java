package com.kuku.ksoap;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.AndroidHttpTransport;

import com.google.gson.Gson;
import com.kuku.model.CompanyInformation;

public class ksoapCall{
	
	public CompanyInformation makeCallAndgetResult()
    {
        String NAMESPACE = "http://WebService.kuku.com/xsd";
        String METHOD_NAME = "getCompanyInfo";
        String SOAP_ACTION = "http://WebService.kuku.com/xsd/getCompanyInfo";
        String URL = "http://10.10.1.102:8080/WSTest/services/CompanyInfoWS?wsdl";
        
        SoapObject Request = new SoapObject(NAMESPACE, METHOD_NAME); 

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        
        envelope.setOutputSoapObject(Request);
        AndroidHttpTransport androidHttpTransport = new AndroidHttpTransport(URL);

        try
        {
            androidHttpTransport.call(SOAP_ACTION, envelope);
            SoapPrimitive s = (SoapPrimitive) envelope.getResponse();
            Gson gson=new Gson();
            CompanyInformation companyInformation=gson.fromJson(s.toString(), CompanyInformation.class);
            
            
            return companyInformation;
            
           
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
