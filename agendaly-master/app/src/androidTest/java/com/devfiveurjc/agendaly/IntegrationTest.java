package com.devfiveurjc.agendaly;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class IntegrationTest {

    private SQLiteDatabase database;

    public void testInsertRecord() {
        ContentValues values = new ContentValues();
        values.put("tittle", "Test Title");
        values.put("description", "Test Description");
        values.put("importance", "High");
        values.put("date", "2023-05-03");
        long rowId = database.insert("records", null, values);
        assertTrue(rowId != -1);

        Cursor cursor = database.query("records", null, null, null, null, null, null);
        assertTrue(cursor.moveToFirst());

        String tittle = cursor.getString(cursor.getColumnIndex("tittle"));
        String description = cursor.getString(cursor.getColumnIndex("description"));
        String importance = cursor.getString(cursor.getColumnIndex("importance"));
        String date = cursor.getString(cursor.getColumnIndex("date"));

        assertEquals("Test Title", tittle);
        assertEquals("Test Description", description);
        assertEquals("High", importance);
        assertEquals("2023-05-03", date);

        cursor.close();
    }
}

