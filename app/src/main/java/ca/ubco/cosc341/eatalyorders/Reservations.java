package ca.ubco.cosc341.eatalyorders;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Reservations extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservations);

        getSupportActionBar().setTitle("Reservations");
    }

    public void booking(View view){
        Intent intentBook = new Intent(this, Booking.class);
        startActivity(intentBook);
    }

    public void revise(View view){

    }

    public void cancellation(View view){

    }
}
