package com.example.android.hotel;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.hotel.data.contract;
import com.example.android.hotel.data.feedenter;

import org.w3c.dom.Text;

import static java.security.AccessController.getContext;

public class new_booking extends AppCompatActivity {
    private EditText namet;
    private EditText purposet;
    private EditText datearrival;
    private EditText datedeparture;
    private EditText aadhart;
    private   String room_type;
    int count=0;
    int flag;

    public void fill_in_database()
    {
        String names=namet.getText().toString();
        String purposes=purposet.getText().toString();
        String datearrivals=datearrival.getText().toString();
        String datedepartures=datedeparture.getText().toString();
        String aadhars=aadhart.getText().toString();


        feedenter hoteldb = new feedenter(getApplicationContext(),feedenter.DATABASE_NAME,null,feedenter.DATABASE_VERSION);
        SQLiteDatabase db = hoteldb.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(contract.entry.user_name,names);
        values.put(contract.entry.purpose,purposes);
        values.put(contract.entry.aadhar_no,aadhars);
        values.put(contract.entry.date_arrival,datearrivals);
        values.put(contract.entry.date_departure,datedepartures);
        values.put(contract.entry.room_type,room_type);
        values.put(contract.entry.room_no, count);

        Toast.makeText(this, "Booking done, Your room no . is "+count, Toast.LENGTH_LONG).show();

        namet.setText("");
        purposet.setText("");
        datearrival.setText("");
        datedeparture.setText("");
        aadhart.setText("");
        
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_booking);

        flag=0;

        namet= (EditText) findViewById(R.id.name);

        purposet= (EditText) findViewById(R.id.purpose);
        datearrival= (EditText) findViewById(R.id.date_arrival);
        datedeparture= (EditText) findViewById(R.id.date_departure);
        aadhart= (EditText) findViewById(R.id.aadhar);

        RadioGroup radioGroup= (RadioGroup) findViewById(R.id.group);
        int id= radioGroup.getCheckedRadioButtonId();

        switch(id)
        {
            case 0:room_type="Single";break;
            case 1:room_type="Double";break;
            case 2:room_type="Luxury";break;
            case 3:room_type="Deluxe";break;
            default:break;
        }



    }
    public void book_room(View view)
    {
        count++;
        flag=1;
        fill_in_database();

    }
    public void back(View view)
    {
        if(flag==1)
        {
            Intent intent=new Intent(new_booking.this,MainActivity.class);
            startActivity(intent);
        }
        else
            {
                //code asks if you are sure you don't want to book a room

            }

    }
}
