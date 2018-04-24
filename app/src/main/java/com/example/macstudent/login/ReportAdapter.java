package com.example.macstudent.login;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by macstudent on 2018-04-17.
 */

public class ReportAdapter extends BaseAdapter {


    SharedPreferences prefs;


    LayoutInflater inflater;
    Context context;
    String[] companies = {"Lexus", "BMW"};
    String[] amounts = {"$10", "$30"};
    String[] lots = {"A", "B"};
    String[] spots = {"20", "1"};
    String[] datetimes  = {"12-04-2018 12:12:12 AM", "12-04-2018 12:12:12 AM"};
    String[] carPlates = {"ABCD123", "QWER456"} ;

    ReportAdapter(Context context){
        inflater = (LayoutInflater.from(context));
    }
    @Override
    public int getCount( ) {
        return companies.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {



        convertView = inflater.inflate(R.layout.datalayout,null);

        TextView company = (TextView) convertView.findViewById(R.id.txtCompany);
        TextView amount = (TextView) convertView.findViewById(R.id.txtAmount);
        TextView lot = (TextView) convertView.findViewById(R.id.txtLot);
        TextView spot = (TextView) convertView.findViewById(R.id.txtspot);
        TextView carPlate = (TextView) convertView.findViewById(R.id.txtCarPlate);
        TextView dateTime = (TextView) convertView.findViewById(R.id.txtDateTime);

        company.setText(companies[position]);
        amount.setText(amounts[position]);
        lot.setText(lots[position]);
        spot.setText(spots[position]);
        carPlate.setText(carPlates[position]);
        dateTime.setText(datetimes[position]);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"item clicked ", Toast.LENGTH_LONG).show();
            }
        });

        return convertView;
    }
}
