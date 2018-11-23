package ca.ubco.cosc341.eatalyorders;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class OrderConfirm extends AppCompatActivity {
    Bundle extras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_confirm);

        getSupportActionBar().setTitle("Confirmation");

        extras = getIntent().getExtras();
        assert extras != null;
        //TODO: Take in time order is placed & generate a random order number
        //Produce estimated time of delivery with order number
        TextView timeTv = findViewById(R.id.textView22);
//        Date date = new Date();
//        date.setHours(Integer.valueOf(hoursOrder));
//        date.setHours(Integer.valueOf(minuteOrder));
//        DateFormat df = new SimpleDateFormat("h:mm a");
        String timeOfDelivery = "Thank you for your purchase.The order has been placed and will be ready at " + extras.getString("hour") + ":"
                + extras.getString("minutes") + "pm";
        timeTv.setText(timeOfDelivery);

        //generate unique random order number
        TextView orderIdTv = findViewById(R.id.textView24);

        Random rand = new Random(); //set random order id
        int id = 1 + rand.nextInt(100);
        orderIdTv.setText(Integer.toString(id));
    }

    public void done(View view){
        write_to_file();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    // "+" acts as delimiter within same category, like food/ customer info
    // "," acts as delimiter for different categories and items.
    public void write_to_file() {
        String filename = "order_summary.txt";
        String fileContents = "";
        fileContents += extras.getString("customer_name") + "+" + extras.getString("phone_number") + "+" + extras.getString("hour")
                + "+" + extras.getString("minutes");
        if(extras.containsKey("payment")) fileContents += extras.getString("payment") + "+" + extras.getString("address") + ",";
        else fileContents += ",";
        fileContents += extras.getString("comments") + "+" + extras.getInt("cutlery") + "+" + extras.getInt("plates") + ",";
        if(extras.containsKey("minestrone"))
            fileContents += extras.getString("minestrone") + "+" + extras.getInt("q_minestrone") + "+" + extras.getDouble("price_minestrone") + ",";
        if(extras.containsKey("caesar"))
            fileContents += extras.getString("caesar") + "+" + extras.getInt("q_caesar") + "+" + extras.getDouble("price_caesar") + ",";
        if(extras.containsKey("spaghetti"))
            fileContents += extras.getString("spaghetti") + "+" + extras.getInt("q_spaghetti") + "+" + extras.getDouble("price_spaghetti") + ",";
        if(extras.containsKey("lasagna"))
            fileContents += extras.getString("lasagna") + "+" + extras.getInt("q_lasagna") + "+" + extras.getDouble("price_lasagna") + ",";
        if(extras.containsKey("fettuccine"))
            fileContents += extras.getString("fettuccine") + "+" + extras.getInt("q_fettuccine") + "+" + extras.getDouble("price_fettuccine") + ",";
        if(extras.containsKey("coke"))
            fileContents += extras.getString("coke") + "+" + extras.getInt("q_coke") + "+" + extras.getDouble("price_coke") + ",";
        if(extras.containsKey("icedtea"))
            fileContents += extras.getString("icedtea") + "+" + extras.getInt("q_icedtea") + "+" + extras.getDouble("price_icedtea") + ",";
        fileContents += "\n";
        FileOutputStream outputStream;
        try {
            outputStream = openFileOutput(filename, Context.MODE_APPEND);
            outputStream.write(fileContents.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
