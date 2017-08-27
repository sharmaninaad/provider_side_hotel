package com.example.android.hotel;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.android.hotel.data.contract;
import com.example.android.hotel.data.feedenter;

import java.util.ArrayList;

import static android.R.string.yes;

public class bookings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookings);
        //ArrayList<String> rooms=new ArrayList<>();
        int value = getIntent().getIntExtra("type",0);
        ListView listView= (ListView) findViewById(R.id.bookings);
        feedenter hoteldb = new feedenter(getApplicationContext(),feedenter.DATABASE_NAME,null,feedenter.DATABASE_VERSION);
        SQLiteDatabase db = hoteldb.getReadableDatabase();
        String columns[]={contract.entry.room_no};
        String selection= contract.entry.room_type+"=?";
        ArrayList<String> roomstoshow=new ArrayList<>();
       // ContentValues values = new ContentValues();

        switch (value)
        {
            case 0:
                roomstoshow.clear();
                String[] select= new String[]{"Single"};
                Cursor cursor=db.query(contract.entry.table_name,columns,selection,select,null,null,null);
                if(cursor!=null)
                {
                    if(cursor.moveToFirst()){
                    do{
                        roomstoshow.add(cursor.getString(cursor.getColumnIndex(contract.entry.room_no)));

                    }
                    while(cursor.moveToNext());
                    }
                }
                assert cursor != null;
                cursor.close();
                break;
            case 1:  roomstoshow.clear();
                String[] select_double= new String[]{"Double"};
                Cursor cursor_double=db.query(contract.entry.table_name,columns,selection,select_double,null,null,null);
                if(cursor_double!=null) {
                    if (cursor_double.moveToFirst()) {
                        do {
                            roomstoshow.add(cursor_double.getString(cursor_double.getColumnIndex(contract.entry.room_no)));

                        }
                        while (cursor_double.moveToNext());
                    }
                }
                assert cursor_double != null;
                cursor_double.close();
                break;
            case 2: roomstoshow.clear();
                String[] select_triple= new String[]{"Luxury"};
                Cursor cursor_triple=db.query(contract.entry.table_name,columns,selection,select_triple,null,null,null);
                if(cursor_triple!=null) {
                    if (cursor_triple.moveToFirst()) {

                        do {
                            roomstoshow.add(cursor_triple.getString(cursor_triple.getColumnIndex(contract.entry.room_no)));

                        }

                        while (cursor_triple.moveToNext());

                    }
                }
                assert cursor_triple != null;
                cursor_triple.close();
                break;

            case 3:roomstoshow.clear();
                    String select_lux[]={"Luxury"};
                    Cursor cursor_lux=db.query(contract.entry.table_name,columns,selection,select_lux,null,null,null);
                    if(cursor_lux!=null)
                    {
                        if(cursor_lux.moveToFirst())
                        {
                            do
                            {
                                roomstoshow.add(cursor_lux.getString(cursor_lux.getColumnIndex(contract.entry.room_no)));
                            }
                            while(cursor_lux.moveToNext());
                        }
                    }
                assert cursor_lux != null;
                cursor_lux.close();

                break;
            default:break;
        }
        ArrayAdapter arrayAdapter=new ArrayAdapter(bookings.this,android.R.layout.simple_list_item_1,roomstoshow);
        listView.setAdapter(arrayAdapter);
    }

}
