package com.example.android.hotel.data;

import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.util.Date;

/**
 * Created by Ninaad on 8/24/2017.
 */

public class contract
{
    public contract(){}
    public static class entry implements BaseColumns
    {
        public static final String table_name="bookings";
        public static final String user_name="Name";
        public static final String room_no ="Room_number";
        public static final String purpose="purpose";
        public static final String room_type="Room_type";
        public static final String date_arrival="Date_of_Arrival";
        public static final String date_departure="Date_of_Departure";
        public static final String aadhar_no="Aadhar_card_number";

    }
    public static final String create_table="CREATE TABLE "+entry.table_name+" ("+entry.user_name+" TEXT ,"+entry.room_no+" INTEGER ,"+entry.room_type+" TEXT ,"+entry.aadhar_no+" INTEGER ,"+entry.date_arrival+" TEXT ,"+entry.date_departure+" TEXT ,"+entry.purpose+" TEXT)";

}
