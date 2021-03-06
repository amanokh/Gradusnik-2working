package com.example.android.sunshine.app.data;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class WeatherDb {
    private WeatherDbHelper mDbHelper;
    private SQLiteDatabase mDb;

    public WeatherDb(Context context) {
        mDbHelper = new WeatherDbHelper(context);
    }

    public Cursor getAllItems() {
        mDb = mDbHelper.getReadableDatabase();
        return mDb.query(WeatherContract.WeatherEntry.TABLE_NAME, null, null, null, null, null, WeatherContract.WeatherEntry.COLUMN_TITLE);
    }

    public void close() {
        if (mDbHelper != null) mDbHelper.close();
        if (mDb != null) mDb.close();
    }}
