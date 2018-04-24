package com.example.macstudent.login;

import android.arch.persistence.room.Room;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.macstudent.AddTicketDao;
import com.example.macstudent.AppDatabase;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent in = new Intent(HomeActivity.this,LoginActivity.class);
            startActivity(in);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.myHome) {

            TextView showTotal=(TextView)findViewById(R.id.showTotal);
            AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                    AppDatabase.class, "AddTicket-database").build();
            AddTicketDao addTicketDao = AppDatabase.getInstance(HomeActivity.this).addTicket();

            //      List<AddTicket> stl = addTicketDao.getAllAddTicket();
            int total = addTicketDao.getAllAddTicket().size();
            showTotal.setText(String.valueOf(total));


           // Intent in = new Intent(HomeActivity.this,MannualActivity.class);
            //startActivity(in);
            // Handle the camera action
        } else if (id == R.id.myTicket) {
            Intent in = new Intent(HomeActivity.this,TicketActivity.class);
            startActivity(in);


        } else if (id == R.id.myLocation) {


           Intent in = new Intent(Intent.ACTION_VIEW);
            in.setData(Uri.parse("geo:0,0?q=43.6497688362,-79.38952512778(" + getString(R.string.app_name) + ")"));
            if (in.resolveActivity(getPackageManager()) != null) {
                startActivity(in);
            }
            else
            {
                Toast.makeText(this, "Maps application is not available.", Toast.LENGTH_LONG).show();
            }

          /*  Uri gmmIntentUri = Uri.parse("geo:37.7759,-122.4194");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);*/
            //Intent in = new Intent(HomeActivity.this,LocationActivity.class);
            //startActivity(in);

        } else if (id == R.id.myInstructions) {

            Intent in = new Intent(HomeActivity.this,MannualActivity.class);
            startActivity(in);


        } else if (id == R.id.my_Report) {
            Intent in = new Intent(HomeActivity.this,ReportActivity.class);
            startActivity(in);


        }else if (id == R.id.my_Help) {
            android.app.AlertDialog.Builder alertDialogBuilder = new android.app.AlertDialog.Builder(HomeActivity.this);
            alertDialogBuilder.setTitle("Need Help?");
            alertDialogBuilder.setMessage("Call us at +1 987-567-9876");
            alertDialogBuilder.setCancelable(false);
            alertDialogBuilder.setIcon(android.R.drawable.ic_dialog_alert);
            alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener()
            {
                public void onClick(DialogInterface dialog, int which)
                {
                    // continue with discard
                    Intent phoneIntent = new Intent(Intent.ACTION_CALL);
                    phoneIntent.setData(Uri.parse("tel:911"));

                }
            });
            alertDialogBuilder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener()
            {
                public void onClick(DialogInterface dialog, int which)
                {

                }
            });
            alertDialogBuilder.show();
        }
        else if (id == R.id.my_Logout) {
            Intent in = new Intent(HomeActivity.this,LoginActivity.class);
            startActivity(in);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
