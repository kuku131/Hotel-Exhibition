package com.kuku.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class TodoDbAdapter {

	// Database fields
	public static final String KEY_COMPANYID = "company_id";
	public static final String KEY_COMPANYNAME = "company_name";
	public static final String KEY_COMPANYDESCRIPTION = "company_description";
	public static final String KEY_WEBSITE = "company_website";
	public static final String KEY_COMPANYIMG = "company_img";
	private static final String DATABASE_TABLE = "company_info";
	private Context context;
	private SQLiteDatabase database;
	private TodoDatabaseHelper dbHelper;

	public TodoDbAdapter(Context context) {
		this.context = context;
	}

	public TodoDbAdapter open() throws SQLException {
		dbHelper = new TodoDatabaseHelper(context);
		database = dbHelper.getWritableDatabase();
		return this;
	}

	public void close() {
		dbHelper.close();
	}

	/**
	 * Create a new todo If the todo is successfully created return the new
	 * rowId for that note, otherwise return a -1 to indicate failure.
	 */
	public long createcompanyInfo(String companyName, String companyDescription, String companyWebsite, String companyImg) {
		ContentValues initialValues = createContentValues(companyName, companyDescription, companyWebsite,
				companyImg);

		return database.insert(DATABASE_TABLE, null, initialValues);
	}

	/**
	 * Updates the todo
	 */
	public boolean updateTodo(long companyId, String companyName, String companyDescription, String companyWebsite, 
			String companyImg) {
		ContentValues updateValues = createContentValues(companyName, companyDescription, companyWebsite,
				companyImg);

		return database.update(DATABASE_TABLE, updateValues, KEY_COMPANYID + "="
				+ companyId, null) > 0;
	}

	/**
	 * Deletes todo
	 */
	public boolean deleteTodo(long companyId) {
		return database.delete(DATABASE_TABLE, KEY_COMPANYID + "=" + companyId, null) > 0;
	}

	/**
	 * Return a Cursor over the list of all todo in the database
	 * 
	 * @return Cursor over all notes
	 */
	public Cursor fetchAllTodos() {
		return database.query(DATABASE_TABLE, new String[] { KEY_COMPANYID,
				KEY_COMPANYNAME, KEY_COMPANYDESCRIPTION, KEY_WEBSITE, KEY_COMPANYIMG }, null, null, null,
				null, null);
	}

	/**
	 * Return a Cursor positioned at the defined todo
	 */
	public Cursor fetchTodo(long companyId) throws SQLException {
		Cursor mCursor = database.query(true, DATABASE_TABLE, new String[] {
				KEY_COMPANYID, KEY_COMPANYNAME, KEY_COMPANYDESCRIPTION, KEY_WEBSITE,KEY_COMPANYIMG},
				KEY_COMPANYID + "=" + companyId, null, null, null, null, null);
		if (mCursor != null) {
			mCursor.moveToFirst();
		}
		return mCursor;
	}

	private ContentValues createContentValues(String companyName, String companyDescription, String companyWebsite,
			String companyImg) {
		ContentValues values = new ContentValues();
		values.put(KEY_COMPANYNAME, companyName);
		values.put(KEY_COMPANYDESCRIPTION, companyDescription);
		values.put(KEY_COMPANYIMG, companyImg);
		values.put(KEY_WEBSITE, companyWebsite);
		return values;
	}
}


