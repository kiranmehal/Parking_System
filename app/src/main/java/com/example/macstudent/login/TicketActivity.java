package com.example.macstudent.login;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.macstudent.AddTicket;
import com.example.macstudent.AddTicketDao;
import com.example.macstudent.AppDatabase;

import java.util.Calendar;
import java.util.Date;



public class TicketActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener{
   /* @InjectView(R.id.edtCarPlate)
    EditText edtCarPlate;
    @InjectView(R.id.spinCompany)
    Spinner spinCompany;
    @InjectView(R.id.rdoHalfHour)
    RadioButton rdoHalfHour;
    @InjectView(R.id.rdoOneHour)
    RadioButton rdoOneHour;
    @InjectView(R.id.rdoTwoHour)
    RadioButton rdoTwoHour;
    @InjectView(R.id.rdoThreeHour)
    RadioButton rdoThreeHour;
    @InjectView(R.id.rdoTime)
    RadioGroup rdoTime;
    @InjectView(R.id.txtAmount)
    TextView txtAmount;
    @InjectView(R.id.spinLot)
    Spinner spinLot;
    @InjectView(R.id.spinSpot)
    Spinner spinSpot;
    @InjectView(R.id.spinPayment)
    Spinner spinPayment;
    @InjectView(R.id.txtDateTime)
    TextView txtDateTime;
    @InjectView(R.id.btnSave)
    Button btnSave;*/
   RadioButton rdoHalfHour, rdoOneHour, rdoTwoHour, rdoThreeHour;
   RadioGroup timeRg;
    TextView txtAmount, txtDateTime;
    int parkingRate[] = {5,10,20,30};
    String lots[]={"A","B","C","D","E"};
    String spots[] = {"1","2","3","4","5"};
    String paymentMethods[] = {"Debit", "Visa", "Master", "Cash","American Express"};
    int logos[]={R.drawable.img_bmw,R.drawable.img_audi,
            R.drawable.img_mercedes,R.drawable.img_jaguar,
            R.drawable.img_lexus};
    String companyNames[]={"BMW","Audi","Mercedes","Jaguar","Lexus"};
    String lot, spot, carPlate, payment, dateTime, company;
    Button btnSave;
    int amount;

    EditText edtCarPlate;
    Spinner spinCompany;
    Spinner spinLot;
    Spinner spinSpot;
    Spinner spinPayment;
    RadioButton rbTiming;
    //RadioButton rdoHalfHour=(RadioButton)findViewById(R.id.rdoHalfHour);
    //RadioButton rdoOneHour=(RadioButton)findViewById(R.id.rdoOneHour);
    //RadioButton rdoTwoHour=(RadioButton)findViewById(R.id.rdoTwoHour);
    //RadioButton rdoThreeHour=(RadioButton)findViewById(R.id.rdoThreeHour);
   // TextView txtAmount=(TextView)findViewById(R.id.txtAmount);
   // TextView txtDateTime=(TextView)findViewById(R.id.txtDateTime);
    //Button btnSave=(Button)findViewById(R.id.btnSave);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "AddTicket-database").build();
        timeRg=(RadioGroup)findViewById(R.id.rdoTime);



      //  ButterKnife.inject(this);
        rdoHalfHour=(RadioButton)findViewById(R.id.rdoHalfHour);
        rdoHalfHour.setOnClickListener(this);

        rdoOneHour=(RadioButton)findViewById(R.id.rdoOneHour);
        rdoOneHour.setOnClickListener(this);

        rdoTwoHour=(RadioButton)findViewById(R.id.rdoTwoHour);
        rdoTwoHour.setOnClickListener(this);

        rdoThreeHour=(RadioButton)findViewById(R.id.rdoThreeHour);
        rdoThreeHour.setOnClickListener(this);

        txtAmount=(TextView)findViewById(R.id.txtAmount);
        txtAmount.setText("$" + String.valueOf(parkingRate[0]));

        txtDateTime=(TextView)findViewById(R.id.txtDateTime);
        Date dt = Calendar.getInstance().getTime();
        txtDateTime.setText(dt.toString());


        spinLot = (Spinner) findViewById(R.id.spinLot);
        ArrayAdapter adaptLot = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                lots);
        adaptLot.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        spinLot.setAdapter(adaptLot);
          spinLot.setOnItemSelectedListener(this);




        spinSpot = (Spinner) findViewById(R.id.spinSpot);
        ArrayAdapter adaptSpot = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                spots);
        adaptSpot.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        spinSpot.setAdapter(adaptSpot);
        spinSpot.setOnItemSelectedListener(this);

        spinPayment = (Spinner) findViewById(R.id.spinPayment);
        ArrayAdapter adaptPayment = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                paymentMethods);
        adaptPayment.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        spinPayment.setAdapter(adaptPayment);
        spinPayment.setOnItemSelectedListener(this);

        spinCompany = (Spinner) findViewById(R.id.spinCompany);
        CarAdapter carAdapter = new CarAdapter(getApplicationContext(),
                logos, companyNames);
        spinCompany.setAdapter(carAdapter);
        spinCompany.setOnItemSelectedListener(this);

        btnSave = (Button) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);





    }



    @Override
    public void onClick(View v) {
       // int i=0;

        int selectId=timeRg.getCheckedRadioButtonId();
        rbTiming=(RadioButton)findViewById(selectId);

        if(selectId == R.id.rdoHalfHour)
        {
            txtAmount.setText("$"+String.valueOf(parkingRate[0]));
        }
        else if(selectId==R.id.rdoOneHour)
        {
            txtAmount.setText("$"+String.valueOf(parkingRate[1]));
        }
        else if(selectId==R.id.rdoTwoHour)
        {
            txtAmount.setText("$" + String.valueOf(parkingRate[2]));
        }
        else
        {
            txtAmount.setText("$" + String.valueOf(parkingRate[3]));
        }

      /*  if(rdoHalfHour.isChecked())
        {
            txtAmount.setText("$"+String.valueOf(parkingRate[0]));
        }
        else if(rdoOneHour.isChecked())
        {
            txtAmount.setText("$"+String.valueOf(parkingRate[1]));
        }
        else if (rdoTwoHour.isChecked()){
            txtAmount.setText("$" + String.valueOf(parkingRate[2]));
        }else if (rdoThreeHour.isChecked()){

            txtAmount.setText("$" + String.valueOf(parkingRate[3]));
        }*/

        //button click
       if(v.getId()==btnSave.getId())
       {

           dateTime = txtDateTime.getText().toString();
           edtCarPlate = (EditText) findViewById(R.id.edtCarPlate);
           carPlate = edtCarPlate.getText().toString();
           String strAmount = txtAmount.getText().toString();
           strAmount = strAmount.substring(1);
           amount = Integer.parseInt(strAmount);
           AddTicketDao addTicketDao = AppDatabase.getInstance(TicketActivity.this).addTicket();
           final AddTicket addTicket=new AddTicket();
           addTicket.setCarPlate(edtCarPlate.getText().toString());
           addTicket.setAmount(String.valueOf(amount));
           addTicket.setCarLot(spinLot.getSelectedItem().toString());
           addTicket.setCarCompany(spinCompany.getSelectedItem().toString());
           addTicket.setCarSlot(spinSpot.getSelectedItem().toString());
           addTicket.setCarTiming(rbTiming.getText().toString());
           addTicket.setPayment(spinPayment.getSelectedItem().toString());




           addTicketDao.insertNewAddTicket(addTicket);

         /*  SharedPreferences sp = getSharedPreferences("ticketGeneration", Context.MODE_PRIVATE);
           SharedPreferences.Editor edit = sp.edit();

           edit.putString("CarPlate",carPlate);
           edit.putString("Company",company);
           edit.putString("Amount",amount+"");
           edit.putString("DateTime",dateTime);
           edit.putString("Lot",lot);
           edit.putString("Spot",spot);
           edit.putString("Payment",payment);
           edit.commit();*/
           Toast.makeText(this,carPlate,Toast.LENGTH_LONG).show();


;           Intent receiptIntent = new Intent(TicketActivity.this,HomeActivity.class);
         //  Bundle b=new Bundle();
          // receiptIntent.putExtras(b);
           startActivity(receiptIntent);

       }


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        if (adapterView.getId() == spinLot.getId()){
            //Toast.makeText(this,lots[position],Toast.LENGTH_LONG).show();
            lot = lots[position];
        }else if (adapterView.getId() == spinSpot.getId()){
            //Toast.makeText(this,spots[position],Toast.LENGTH_LONG).show();
            spot = spots[position];
        }else if (adapterView.getId() == spinPayment.getId()){
            //Toast.makeText(this,paymentMethods[position],Toast.LENGTH_LONG).show();
            payment = paymentMethods[position];
    }else if (adapterView.getId() == spinCompany.getId()){
        company = companyNames[position];
        //Toast.makeText(this,companyNames[position],Toast.LENGTH_LONG).show();
    }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
