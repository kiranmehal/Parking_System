package com.example.macstudent;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by macstudent on 2018-04-18.
 */


@Dao
public interface AddTicketDao {

    @Query("Select * from AddTicket")
    public List<AddTicket> getAllAddTicket();

    @Insert(onConflict = REPLACE)
    public void insertNewAddTicket(AddTicket addTicket);


}
