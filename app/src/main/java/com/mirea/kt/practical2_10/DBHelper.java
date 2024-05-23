package com.mirea.kt.practical2_10;



import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.database.Cursor;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "plants.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_PLANTS = "plants";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_SPECIES = "species";
    private static final String COLUMN_IS_GREENHOUSE = "is_greenhouse";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_PLANTS + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_SPECIES + " TEXT, " +
                COLUMN_IS_GREENHOUSE + " INTEGER)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PLANTS);
        onCreate(db);
    }

    public void savePlant(Plant plant) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, plant.getName());
        values.put(COLUMN_SPECIES, plant.getSpecies());
        values.put(COLUMN_IS_GREENHOUSE, plant.isGreenhouse() ? 1 : 0);
        db.insert(TABLE_PLANTS, null, values);
        db.close();
    }

    public ArrayList<Plant> getAllPlants() {
        ArrayList<Plant> plantList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_PLANTS, null, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
                String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
                String species = cursor.getString(cursor.getColumnIndex(COLUMN_SPECIES));
                boolean isGreenhouse = cursor.getInt(cursor.getColumnIndex(COLUMN_IS_GREENHOUSE)) == 1;

                Plant plant = new Plant(id, name, species, isGreenhouse);
                plantList.add(plant);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return plantList;
    }
}
