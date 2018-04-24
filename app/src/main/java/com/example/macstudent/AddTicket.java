package com.example.macstudent;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by macstudent on 2018-04-18.
 */
@Entity(tableName = "AddTicket")
public class AddTicket {


    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "date")
    public String date;
    @ColumnInfo(name = "amount")
    public String amount;
    @ColumnInfo(name = "carPlate")
    public String carPlate;
    @ColumnInfo(name = "carCompany")
    public String carCompany;

    @ColumnInfo(name = "carTime")
    public String carTiming;
    @ColumnInfo(name = "carLot")
    public String carLot;
    @ColumnInfo(name = "carSlot")
    public String carSlot;
    @ColumnInfo(name = "payment")
    public String payment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCarPlate() {
        return carPlate;
    }

    public void setCarPlate(String carPlate) {
        this.carPlate = carPlate;
    }

    public String getCarCompany() {
        return carCompany;
    }

    public void setCarCompany(String carCompany) {
        this.carCompany = carCompany;
    }

    public String getCarTiming() {
        return carTiming;
    }

    public void setCarTiming(String carTiming) {
        this.carTiming = carTiming;
    }

    public String getCarLot() {
        return carLot;
    }

    public void setCarLot(String carLot) {
        this.carLot = carLot;
    }

    public String getCarSlot() {
        return carSlot;
    }

    public void setCarSlot(String carSlot) {
        this.carSlot = carSlot;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "AddTicket{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", amount='" + amount + '\'' +
                ", carPlate='" + carPlate + '\'' +
                ", carCompany='" + carCompany + '\'' +
                ", carTiming='" + carTiming + '\'' +
                ", carLot='" + carLot + '\'' +
                ", carSlot='" + carSlot + '\'' +
                ", payment='" + payment + '\'' +
                '}';
    }
}
