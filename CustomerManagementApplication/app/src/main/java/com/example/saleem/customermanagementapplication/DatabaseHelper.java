package com.example.saleem.customermanagementapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{
    public static final String DATABASE_NAME = "CUSTOMER.DB";
    public static final String TABLE_NAME = "CUSTOMER_TABLE";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "FIRSTNAME";
    public static final String COL_3 = "LASTNAME";
    public static final String COL_4 = "MOB";
    public static final String COL_5 = "EMAIL";
    public static final String COL_6 = "ADDRESS";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 3);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, FIRSTNAME TEXT, LASTNAME TEXT, MOB TEXT, EMAIL TEXT, ADDRESS TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // Below method is used to insert data in the table
    public Boolean insertData (String firstName, String lastName, String mob, String eMail, String address) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, firstName);
        contentValues.put(COL_3, lastName);
        contentValues.put(COL_4, mob);
        contentValues.put(COL_5, eMail);
        contentValues.put(COL_6, address);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    } // insertData method ends

    // Below method is used to delete data from the table
    public Integer deleteData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?", new String[] {id});
    } // deleteData method ends

    // Below method is used to select all the data from table
    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return  result;
    } // getAllData method ends

    // Below method is used to updata a certain record in the table
    public Boolean updateData(String id, String firstName, String lastName, String mob, String email, String address) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, id);
        contentValues.put(COL_2, firstName);
        contentValues.put(COL_3, lastName);
        contentValues.put(COL_4, mob);
        contentValues.put(COL_5, email);
        contentValues.put(COL_6, address);
        long result = db.update(TABLE_NAME, contentValues, "ID = ?", new String[] {id});
        if (result > 0)
            return true;
        return false;
    } // updateData method ends
}
