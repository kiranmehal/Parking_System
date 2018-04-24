package com.example.macstudent.login;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.macstudent.AddTicket;
import com.example.macstudent.AddTicketDao;
import com.example.macstudent.AppDatabase;

import java.util.ArrayList;
import java.util.List;

public class ReportActivity extends AppCompatActivity {

    ListView receiptList;
//    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
    ListAdapter adapter;
    List<AddTicket> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

      //  AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                //AppDatabase.class, "AddTicket-database").build();
        AddTicketDao addTicketDao = AppDatabase.getInstance(ReportActivity.this).addTicket();
      list=addTicketDao.getAllAddTicket();
      adapter=new ListAdapter(this,list);

       // list.add("kiran");



       // String carPlate = preferences.getString("CarPlate","");
        //list.add(carPlate);


        /*mypref=getSharedPreferences("ticketGeneration",MODE_PRIVATE);

        String carPlate = mypref.getString("CarPlate","");
        String company = mypref.getString("Company","");
        String amount = mypref.getString("Amount","");
        String dateTime = mypref.getString("DateTime","");
        String lot = mypref.getString("Lot","");
        String spot = mypref.getString("Spot","");
        String payment = mypref.getString("Payment","");*/

        receiptList = (ListView) findViewById(R.id.list_receipt);
        receiptList.setAdapter(adapter);
      // String car= preferences.getString("carPlate",null);
      // receiptList.getAdapter(car);








    }
}
