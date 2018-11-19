package ca.ubco.cosc341.eatalyorders;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class OrderSummary extends AppCompatActivity {

    int cutlery = 0, plates = 0;

    DecimalFormat decimal = new DecimalFormat("0.00");
    double tax, total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_summary);

        getSupportActionBar().setTitle("Order Summary");

        //TODO: Take in order items, quantities, and prices

        Bundle extras = getIntent().getExtras();
        assert extras != null;

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
                cutlery = cutlery -1;
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
                plates = plates -1;
                quantity.setText(Integer.toString(plates));
            }
        });

        TextView subtotal = (TextView) findViewById(R.id.subSummary);
        double subDouble = extras.getDouble("subtotal");
        Double doubleInstance = new Double(subDouble);
        String temp = doubleInstance.toString();
        subtotal.setText(temp);



    }

    public void menu (View view){
        Intent intentM = new Intent(this, Menu.class);
        startActivity(intentM);
    }

    public void confirm(View view){
        Intent intentC = new Intent(this, OrderConfirm.class);

        //TODO: Take in comments, and quantities

        startActivity(intentC);
    }
}
