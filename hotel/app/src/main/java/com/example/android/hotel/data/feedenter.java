package com.example.android.hotel.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ninaad on 8/25/2017.
 */

public class feedenter extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "FeedReader.db";
    public static final int DATABASE_VERSION=1;

    public feedenter(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL(contract.create_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
