package com.kuku.activity;

import org.apache.commons.codec.binary.Base64;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.kuku.DataHandler.CompanyInfoHandler;

public class CompanyInfoActivity extends Activity {
	
	CompanyInfoHandler cih;
	TextView title;
	Button exhibitorsbutton;
	TextView website;
	ImageView companyImg;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.companyinfopage);
        exhibitorsbutton=(Button)findViewById(R.id.INDEX); 
        exhibitorsbutton.setBackgroundDrawable(this.getResources().getDrawable(R.drawable.exhibitorbutton));
        exhibitorsbutton.setOnClickListener(new View.OnClickListener() {    
        	public void onClick(View v) {
        		Intent myIntent = new Intent(v.getContext(), ExhibitorsActivity.class);
        		startActivity(myIntent);
            }       		  
        });
        getUI();
	}
        
    public void getUI(){
    	
        cih=new CompanyInfoHandler();
        Bundle b = getIntent().getExtras();
        
		int company_position=b.getInt("company_position");
		title=(TextView)findViewById(R.id.screen_title);
        title.setText(cih.getCompanyNames()[company_position]);
        
        companyImg=(ImageView)findViewById(R.id.screen_title_image);
        
        if(cih.getCompanyImgs()[company_position].getBytes()!=null){
        	
        	byte[] buffer=new byte[8192];
            buffer=Base64.decodeBase64(cih.getCompanyImgs()[company_position].getBytes());
            Bitmap bm=BitmapFactory.decodeByteArray(buffer, 0, buffer.length);
            companyImg.setImageBitmap(bm);
        
        }
        TextView companydescription=(TextView)findViewById(R.id.company_description);
        companydescription.setText(cih.getCompanyDescriptions()[company_position]);
        website=(TextView)findViewById(R.id.website);
        website.setText(cih.getCompanywebsites()[company_position]);
        Linkify.addLinks(website, Linkify.WEB_URLS);
	}
	

}
