package com.example.omsagar.c0688084_kidsdraw;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by OmSagar on 4/18/2017.
 */

    public class DataBase extends SQLiteOpenHelper {

        private static final int DATABASE_VERSION = 1;
        private static final String DATABASE_NAME = "C0688084_KidsDraw";
        private static final String TABLE_NAME = "KidsDraw";
        private static final String KEY_NAME_ID = "name_id";
        private static final String KEY_NAME_TEXT = "name_text";

        private static final String DATABASE_CREATE_NAME = "create table "
                + TABLE_NAME
                + "(" + KEY_NAME_ID + " INTEGER PRIMARY KEY, "
                + KEY_NAME_TEXT + " text );";

        public DataBase(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DATABASE_CREATE_NAME);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w(DataBase.class.getName(),
                    "Upgrading database from version " + oldVersion + " to "
                            + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }

        public void addNewLetter(String DrawingText) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(KEY_NAME_TEXT, DrawingText);
            db.insert(TABLE_NAME, null, values);
            db.close();
        }

        public List<String> getDrawing(){
            SQLiteDatabase db = this.getWritableDatabase();
            List<String> dataList = new ArrayList<String>();
            String TABLE = TABLE_NAME;
            Cursor cursor = db.query(TABLE,null,null,null,null,null,null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                dataList.add(cursor.getString(1));
                cursor.moveToNext();
            }
            return dataList;
        }
    }

