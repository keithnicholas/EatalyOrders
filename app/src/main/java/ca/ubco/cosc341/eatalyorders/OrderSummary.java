package ca.ubco.cosc341.eatalyorders;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class OrderSummary extends AppCompatActivity {

    int cutlery = 0, plates = 0;
    Bundle extras;
    DecimalFormat decimal = new DecimalFormat("0.00");
    double tax, total;

    //Bundle orderConfirmBundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_summary);

        getSupportActionBar().setTitle("Order Summary");

        //TODO: Take in order items, quantities, and prices

        extras = getIntent().getExtras();
        //extras=  getIntent();
        //assert extras != null;

        Button addCutlery = (Button) findViewById(R.id.addCutlery);
        addCutlery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView quantity = (TextView) findViewById(R.id.cutleryQuantity);
                cutlery = cutlery +1;
                quantity.setText(Integer.toString(cutlery));
            }
        });

        Button subCutlery = (Button) findViewById(R.id.subCutlery);
        subCutlery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView quantity = (TextView) findViewById(R.id.cutleryQuantity);
                if (cutlery > 0) {
                    cutlery = cutlery - 1;
                }
                quantity.setText(Integer.toString(cutlery));
            }
        });

        Button addPlates = (Button) findViewById(R.id.addPlates);
        addPlates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView quantity = (TextView) findViewById(R.id.platesQuantity);
                plates = plates +1;
                quantity.setText(Integer.toString(plates));
            }
        });

        Button subPlates = (Button) findViewById(R.id.subPlates);
        subPlates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView quantity = (TextView) findViewById(R.id.platesQuantity);
                if (plates > 0) {
                    plates = plates - 1;
                }
                quantity.setText(Integer.toString(plates));
            }
        });

        //set subtotal
        TextView subtotal = (TextView) findViewById(R.id.subSummary);

        double subDouble = Double.valueOf(extras.getString("subtotal"));
        Double doubleInstance = new Double(subDouble);
        //String temp = doubleInstance.toString();
        String temp = doubleInstance.toString();
        subtotal.setText("$" + decimal.format(doubleInstance));

        tax = 0.12 * Double.valueOf(temp);
        TextView taxTv = (TextView) findViewById(R.id.tax);
        taxTv.setText("$" + decimal.format(tax));

        total = Double.valueOf(temp) + tax;
        TextView totalTv = (TextView) findViewById(R.id.totalSummary);
        totalTv.setText("$" + decimal.format(total));
    }

    public void menu (View view){
        Intent intentM = new Intent(this, Menu.class);

        startActivity(intentM);
    }

    public void confirm(View view){
        Intent intentC = new Intent(this, OrderConfirm.class);
        Bundle old = getIntent().getExtras();
        Bundle newbundle = new Bundle();
        String hoursPickup = old.getString("hour_pickup");
        String minPickup = old.getString("minutes_pickup");
        newbundle.putString("hour_pickup", hoursPickup);
        newbundle.putString("minutes_pickup", minPickup);

        //TODO: Take in quantities

        EditText comments = (EditText) findViewById(R.id.editText2);

        newbundle.putString("comments_pickup", comments.getText().toString());
        //intentC.putExtras(orderConfirmBundle);

        intentC.putExtras(newbundle); //put previous bundle in
        startActivity(intentC);
    }
}
