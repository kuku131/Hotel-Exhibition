package com.kuku.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class ProgrammeActivity extends Activity{
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modelpage);
        TextView title=(TextView)findViewById(R.id.screen_title);
        title.setText("Programme");
        
        String[] Days = new String[] { "Day One", "Day Two", "Day Three" };
        ListView itemlist = (ListView) findViewById(R.id.index_list);     
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.listviewlayout,R.id.listItems,Days);
        itemlist.setAdapter(adapter);
        itemlist.setSelection(0);
        
        Button index=(Button)findViewById(R.id.INDEX);
        index.setOnClickListener(new View.OnClickListener() {    
        	public void onClick(View v) {
        		Intent myIntent = new Intent(v.getContext(), HotelExhibitionActivity.class);
        		startActivity(myIntent);
            }       		  
        });
    }

}
