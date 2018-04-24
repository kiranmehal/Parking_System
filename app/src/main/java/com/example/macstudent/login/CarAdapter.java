package com.example.macstudent.login;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by macstudent on 2018-04-16.
 */

public class CarAdapter extends BaseAdapter {
    Context context;
    int logos[];
    String[] companyNames;
    LayoutInflater inflater;

    public CarAdapter(Context context, int logos[], String[] companyNames){
        this.context = context;
        this.logos = logos;
        this.companyNames = companyNames;
        inflater = (LayoutInflater.from(context));
    }




    @Override
    public int getCount() {
        return companyNames.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.car_company_item,
                null);

        ImageView carLogo = (ImageView) convertView.findViewById(
                R.id.imgLogo);
        TextView companyName = (TextView) convertView.findViewById(
                R.id.txtCompany);

        carLogo.setImageResource(logos[position]);
        companyName.setText(companyNames[position]);

        return convertView;

    }
}
