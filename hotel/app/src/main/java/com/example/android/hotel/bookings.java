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
Cursor cursor;
    String[] select;

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
                 select= new String[]{"Single"};
                 //cursor=db.query(contract.entry.table_name,columns,selection,select,null,null,null);

                break;
            case 1:  roomstoshow.clear();
                select= new String[]{"Double"};

                break;
            case 2: roomstoshow.clear();
                select= new String[]{"Luxury"};
                break;

            case 3:roomstoshow.clear();
                    select=new String[]{"Luxury"};
                   break;


            default:break;
        }
        cursor=db.query(contract.entry.table_name,columns,selection,select,null,null,null);
        my_cursor cursed=new my_cursor(this,cursor);
        listView.setAdapter(cursed);
    }

}
