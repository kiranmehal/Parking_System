package com.example.macstudent.login;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.macstudent.AddTicket;

import java.util.List;

/**
 * Created by macstudent on 2018-04-19.
 */

public class ListAdapter extends ArrayAdapter<AddTicket> {

    public ListAdapter(Context context, List<AddTicket> ticketArrayList)
    {
        super(context, 0, ticketArrayList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        // Get the data item for this position
        AddTicket ticket = getItem(position);
        ViewHolder viewHolder;

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.cell_list, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder)convertView.getTag();
        }

        // Populate the data into the template view using the data object
        //viewHolder.tvEmployeeID.setText(String.valueOf(employee.getEmployeeId()));
        viewHolder.car_name.setText(ticket.getCarPlate());
        viewHolder.txtPayment.setText(ticket.getPayment());
        viewHolder.date_time.setText(ticket.getDate());
        viewHolder.slot.setText(ticket.getCarLot());

        viewHolder.txtAmount.setText("$"+ticket.getAmount());




        return convertView;
    }

    private class ViewHolder
    {

        TextView car_plate;
        TextView date_time;
        TextView car_name;
        TextView slot;
        TextView txtPayment;
        TextView txtAmount;

        ViewHolder(View convertView)
        {
            car_plate=(TextView)convertView.findViewById(R.id.car_plate);
           car_name = (TextView) convertView.findViewById(R.id.car_name);
           date_time = (TextView) convertView.findViewById(R.id.date_time);
           slot=(TextView)convertView.findViewById(R.id.car_slot);
            txtPayment=(TextView)convertView.findViewById(R.id.payment);
            txtAmount=(TextView)convertView.findViewById(R.id.amount);


            //tvEmployeeName = (TextView) convertView.findViewById(R.id.txtEmployeeName);
        }
    }

}
