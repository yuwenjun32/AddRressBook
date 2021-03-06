package com.example.lovem.addrressbook;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ContactDao {

    private Context mContext;
    private DBHelper helper;
    private static String TABLE_NAME = "contact";

    //生成DBHelper类
    public ContactDao(Context context) {
        this.mContext = context;
        helper = new DBHelper(mContext);
    }

    //添加联系人
    public long insert(ContentValues values) {
        SQLiteDatabase db = helper.getWritableDatabase();
        long number = db.insert(TABLE_NAME, null, values);
        db.close();
        return number;
    }

    //删除全部数据
    public int deleteAll() {
        SQLiteDatabase db = helper.getWritableDatabase();
        int number = db.delete(TABLE_NAME, null, null);
        db.close();
        return number;
    }

    //根据联系人姓名删除数据
    public int deleteByName(Contact contact) {
        SQLiteDatabase db = helper.getWritableDatabase();
        int number = db.delete(TABLE_NAME, "name=?", new String[]{contact.getName()});
        db.close();
        return number;
    }

    //根据联系人姓名修改数据
    public int update(ContentValues values, String name) {
        SQLiteDatabase db = helper.getWritableDatabase();
        int number = db.update(TABLE_NAME, values, "name=?", new String[]{name});
        db.close();
        return number;
    }

    //查询所有记录
    public Cursor selectAll() {

        SQLiteDatabase db = helper.getWritableDatabase();
        return db.query(TABLE_NAME, null, null, null, null, null, null);
    }
}
