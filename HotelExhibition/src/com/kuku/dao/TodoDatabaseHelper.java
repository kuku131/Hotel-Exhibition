package com.kuku.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class TodoDatabaseHelper extends SQLiteOpenHelper {
	private static final String DATABASE_NAME = "hotelexhibition.db";

	private static final int DATABASE_VERSION = 1;

	// Database creation sql statement
	private static final String TABLE_CREATE = "create table if not exists company_info(company_id integer primary key autoincrement, "
			+ "company_name text not null, company_description text not null, company_website text not null, company_img text not null);";

	public TodoDatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	// Method is called during creation of the database
	@Override
	public void onCreate(SQLiteDatabase database) {
		database.execSQL(TABLE_CREATE);
	}

	// Method is called during an upgrade of the database, e.g. if you increase
	// the database version
	@Override
	public void onUpgrade(SQLiteDatabase database, int oldVersion,
			int newVersion) {
		Log.w(TodoDatabaseHelper.class.getName(),
				"Upgrading database from version " + oldVersion + " to "
						+ newVersion + ", which will destroy all old data");
		database.execSQL("DROP TABLE IF EXISTS company_info");
		onCreate(database);
	}
}

