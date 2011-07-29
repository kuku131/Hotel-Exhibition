package com.kuku.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.kuku.DataHandler.CompanyInfoHandler;
import com.kuku.dao.companyInfoDao;

public class ExhibitorsActivity extends Activity {
	
	CompanyInfoHandler cIH;

	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modelpage);
        TextView title=(TextView)findViewById(R.id.screen_title);
        title.setText("Exhibitors");
        cIH=new CompanyInfoHandler();
        final String companyNames[]=cIH.getCompanyNames();
        ListView listView = (ListView) findViewById(R.id.index_list);     
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.listviewlayout,R.id.listItems,companyNames);
        listView.setAdapter(adapter);
        listView.setSelection(0);
        
        Button index=(Button)findViewById(R.id.INDEX);
        index.setOnClickListener(new View.OnClickListener() {    
        	public void onClick(View v) {
        		Intent myIntent = new Intent(v.getContext(), HotelExhibitionActivity.class);
        		startActivity(myIntent);
            }       		  
        });

        listView.setOnItemClickListener(new OnItemClickListener() {    
			public void onItemClick(AdapterView<?> parent, View view,        
					int position, long id) {      
				
				Intent myIntent = new Intent(view.getContext(), CompanyInfoActivity.class);
				Bundle b = new Bundle();
                b.putInt("company_position", position);
              	myIntent.putExtras(b);
				startActivity(myIntent);
			} 
        });
		
        addcompanyInfo();
	}
	
	public void addcompanyInfo(){
		
		companyInfoDao cc=new companyInfoDao(this);
        cc.pushDataToDB();
        
	}
}




