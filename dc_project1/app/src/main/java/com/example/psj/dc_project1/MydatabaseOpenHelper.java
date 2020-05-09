package com.example.psj.dc_project1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MydatabaseOpenHelper extends SQLiteOpenHelper {
    public MydatabaseOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE volunteer(name TEXT, address TEXT, age INTEGER, date TEXT, phone_number TEXT, money INTEGER);");//이름 집주소 나이 휴대폰번호 후원금액 후원서명날짜
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS volunteer");
        onCreate(db);

    }
}
