package com.kuku.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class HotelExhibitionActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index);
        String[] names = new String[] { "Programme", "Exhibitors", "Speakers", "Networking",
				"Sponsors", "Contact" };
        ListView listView = (ListView) findViewById(R.id.index_list);     
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.listviewlayout,R.id.listItems,names);
        listView.setAdapter(adapter);
        listView.setSelection(0);
        listView.setOnItemClickListener(new OnItemClickListener() {    
			public void onItemClick(AdapterView<?> parent, View view,        
					int position, long id) {  
				Intent myIntent;
				switch(position){
				case 0: 
					myIntent = new Intent(view.getContext(), ProgrammeActivity.class);
				    startActivity(myIntent);
				    break;
				case 1:
					myIntent = new Intent(view.getContext(), ExhibitorsActivity.class);
				    startActivity(myIntent);
				    break;
				case 2:
					myIntent = new Intent(view.getContext(), ProgrammeActivity.class);
				    startActivity(myIntent);
				    break;
				case 3:
					myIntent = new Intent(view.getContext(), ProgrammeActivity.class);
				    startActivity(myIntent);
				    break;
				case 4:
					myIntent = new Intent(view.getContext(), ProgrammeActivity.class);
				    startActivity(myIntent);
				    break;
				case 5:
					myIntent = new Intent(view.getContext(), ProgrammeActivity.class);
				    startActivity(myIntent);
				    break;
				}
				
			}
			});
    }
}
