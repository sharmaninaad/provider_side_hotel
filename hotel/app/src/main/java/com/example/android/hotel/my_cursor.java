package com.example.android.hotel;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.android.hotel.data.contract;

import static java.security.AccessController.getContext;

/**
 * Created by Ninaad on 8/27/2017.
 */

public class my_cursor extends CursorAdapter {
    public my_cursor(Context context, Cursor c) {
        super(context, c);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {

        return(LayoutInflater.from(context).inflate(R.layout.my_list, null));
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView name= (TextView) view.findViewById(R.id.names);
        TextView room= (TextView) view.findViewById(R.id.room_no);
        name.setText(cursor.getString(cursor.getColumnIndex(contract.entry.user_name)));
        room.setText(cursor.getString(cursor.getColumnIndex(contract.entry.room_no)));
    }
}
