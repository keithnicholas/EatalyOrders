package ca.ubco.cosc341.eatalyorders;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class OrderConfirm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_confirm);

        getSupportActionBar().setTitle("Confirmation");

        Bundle bundle = getIntent().getExtras();
        //TODO: Take in time order is placed & generate a random order number
        //Produce estimated time of delivery with order number
        TextView timeTv = findViewById(R.id.textView22);
//        Date date = new Date();
//        date.setHours(Integer.valueOf(hoursOrder));
//        date.setHours(Integer.valueOf(minuteOrder));
//        DateFormat df = new SimpleDateFormat("h:mm a");
        String timeOfDelivery = bundle.getString("hour") + ":"
                + bundle.getString("minutes") + "pm";
        timeTv.setText(timeOfDelivery);

        //generate unique random order number
        TextView orderIdTv = findViewById(R.id.textView24);

        Random rand = new Random(); //set random order id
        int id = 1 + rand.nextInt(100);
        orderIdTv.setText(Integer.toString(id));
    }

    public void done(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
