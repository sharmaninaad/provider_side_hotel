package com.example.android.hotel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import static android.R.attr.id;

public class MainActivity extends AppCompatActivity {
public ArrayList<String> rooms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rooms=new ArrayList<>();
        rooms.add("Single");
        rooms.add("Double");
        rooms.add("Luxury");
        rooms.add("deluxe");


        ListView listView=(ListView)findViewById(R.id.room_types);
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,rooms);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(MainActivity.this,bookings.class);
                intent.putExtra("type",position);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.newb)
        {
            Intent intent=new Intent(MainActivity.this,new_booking.class);
            startActivity(intent);
        }
        if(item.getItemId()==R.id.cancel)
        {

        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menus,menu);
        return true;
    }
}
