package ca.ubco.cosc341.eatalyorders;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

        extras = getOrder();
        assert extras != null;

        Button addCutlery = findViewById(R.id.addCutlery);
        addCutlery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView quantity = findViewById(R.id.cutleryQuantity);
                cutlery = cutlery +1;
                quantity.setText(Integer.toString(cutlery));
            }
        });

        Button subCutlery = findViewById(R.id.subCutlery);
        subCutlery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView quantity = findViewById(R.id.cutleryQuantity);
                if (cutlery > 0) {
                    cutlery = cutlery - 1;
                }
                quantity.setText(Integer.toString(cutlery));
            }
        });

        Button addPlates = findViewById(R.id.addPlates);
        addPlates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView quantity = findViewById(R.id.platesQuantity);
                plates = plates +1;
                quantity.setText(Integer.toString(plates));
            }
        });

        Button subPlates = findViewById(R.id.subPlates);
        subPlates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView quantity = findViewById(R.id.platesQuantity);
                if (plates > 0) {
                    plates = plates - 1;
                }
                quantity.setText(Integer.toString(plates));
            }
        });

        //set subtotal
        TextView subtotal = findViewById(R.id.subSummary);

        double subDouble = extras.getDouble("subtotal");
        Double doubleInstance = new Double(subDouble);
        //String temp = doubleInstance.toString();
        String temp = doubleInstance.toString();
        subtotal.setText("$" + decimal.format(doubleInstance));

        tax = 0.05 * Double.valueOf(temp);
        TextView taxTv = findViewById(R.id.tax);
        taxTv.setText("$" + decimal.format(tax));

        total = Double.valueOf(temp) + tax;
        TextView totalTv = findViewById(R.id.totalSummary);
        totalTv.setText("$" + decimal.format(total));
        //update order list
        //note: "Remove" Button is currently unavailable
        extras.putDouble("subtotal", total);//update subtotal
        TextView summary = findViewById(R.id.summary_food);
        summary.setText(getFoodSummary());
        summary = findViewById(R.id.summary_quantity);
        summary.setText(getQuantitySummary());
        summary = findViewById(R.id.summary_price);
        summary.setText(getPriceSummary());
    }

    public void previous (View view){
        //TODO: back to Menu with selected orders
        finish();
    }

    public void confirm(View view){
        Intent intent = new Intent(this, OrderConfirm.class);

        //TODO: Take in quantities
        EditText comments = findViewById(R.id.editText2);
        extras.putString("comments", comments.getText().toString());
        extras.putInt("cutlery", cutlery);
        extras.putInt("plates", plates);
        intent.putExtras(extras);
        startActivity(intent);
    }
    //get order from previous activity
    public Bundle getOrder() {
        extras = getIntent().getExtras();
        extras.putString("hour", extras.getString("hour"));
        extras.putString("minutes", extras.getString("minutes"));
        extras.putString("customer_name", extras.getString("customer_name"));
        extras.putString("phone_number", extras.getString("phone_number"));

        if(extras.containsKey("address"))
            extras.putString("address", extras.getString("address"));
        if(extras.containsKey("payment"))
            extras.putString("payment", extras.getString("payment"));

        if(extras.containsKey("minestrone")) {
            extras.putString("minestrone", extras.getString("minestrone") );//passing ordered food name
            extras.putDouble("price_minestrone", extras.getDouble("price_minestrone"));//passing ordered food price
            extras.putInt("q_minestrone", extras.getInt("q_minestrone"));//passing ordered food quantity
        }
        if(extras.containsKey("caesar")) {
            extras.putString("caesar", extras.getString("caesar") );//passing ordered food name
            extras.putDouble("price_caesar", extras.getDouble("price_caesar"));//passing ordered food price
            extras.putInt("q_caesar", extras.getInt("q_caesar"));//passing ordered food quantity
        }
        if(extras.containsKey("spaghetti")) {
            extras.putString("spaghetti", extras.getString("spaghetti") );//passing ordered food name
            extras.putDouble("price_spaghetti", extras.getDouble("price_spaghetti"));//passing ordered food price
            extras.putInt("q_spaghetti", extras.getInt("q_spaghetti"));//passing ordered food quantity
        }
        if(extras.containsKey("lasagna")) {
            extras.putString("lasagna", extras.getString("lasagna") );//passing ordered food name
            extras.putDouble("price_lasagna", extras.getDouble("price_lasagna"));//passing ordered food price
            extras.putInt("q_lasagna", extras.getInt("q_lasagna"));//passing ordered food quantity
        }
        if(extras.containsKey("fettuccine")) {
            extras.putString("fettuccine", extras.getString("fettuccine") );//passing ordered food name
            extras.putDouble("price_fettuccine", extras.getDouble("price_fettuccine"));//passing ordered food price
            extras.putInt("q_fettuccine", extras.getInt("q_fettuccine"));//passing ordered food quantity
        }
        if(extras.containsKey("coke")) {
            extras.putString("coke", extras.getString("coke") );//passing ordered food name
            extras.putDouble("price_coke", extras.getDouble("price_coke"));//passing ordered food price
            extras.putInt("q_coke", extras.getInt("q_coke"));//passing ordered food quantity
        }
        if(extras.containsKey("icedtea")) {
            extras.putString("icedtea", extras.getString("icedtea") );//passing ordered food name
            extras.putDouble("price_icedtea", extras.getDouble("price_icedtea"));//passing ordered food price
            extras.putInt("q_icedtea", extras.getInt("q_icedtea"));//passing ordered food quantity
        }
        extras.putDouble("subtotal", extras.getDouble("subtotal"));

        return extras;
    }

    public String getFoodSummary() {
        String str = "Summary: \n";
        if(extras.containsKey("minestrone"))
            str+= extras.getString("minestrone") + '\n';
        if(extras.containsKey("caesar"))
            str+= extras.getString("caesar") + '\n';
        if(extras.containsKey("spaghetti"))
            str+= extras.getString("spaghetti") + '\n';
        if(extras.containsKey("lasagna"))
            str+= extras.getString("lasagna") + '\n';
        if(extras.containsKey("fettuccine"))
            str+= extras.getString("fettuccine") + '\n';
        if(extras.containsKey("coke"))
            str+= extras.getString("coke") + '\n';
        if(extras.containsKey("icedtea"))
            str+= extras.getString("icedtea") + '\n';
        return str;
    }

    public String getQuantitySummary() {
        String str = "\n";
        if(extras.containsKey("q_minestrone"))
            str+= "X" + extras.getInt("q_minestrone") + '\n';
        if(extras.containsKey("q_caesar"))
            str+= "X" + extras.getInt("q_caesar") + '\n';
        if(extras.containsKey("q_spaghetti"))
            str+= "X" + extras.getInt("q_spaghetti") + '\n';
        if(extras.containsKey("q_lasagna"))
            str+= "X" + extras.getInt("q_lasagna") + '\n';
        if(extras.containsKey("q_fettuccine"))
            str+= "X" + extras.getInt("q_fettuccine") + '\n';
        if(extras.containsKey("q_coke"))
            str+= "X" + extras.getInt("q_coke") + '\n';
        if(extras.containsKey("q_icedtea"))
            str+= "X" + extras.getInt("q_icedtea") + '\n';
        return str;
    }

    public String getPriceSummary() {
        String str = "\n";
        if(extras.containsKey("price_minestrone"))
            str+= "$" + (decimal.format(extras.getInt("q_minestrone") * extras.getDouble("price_minestrone"))) + '\n';
        if(extras.containsKey("price_caesar"))
            str+= "$" + (decimal.format(extras.getInt("q_caesar") * extras.getDouble("price_caesar"))) + '\n';
        if(extras.containsKey("price_spaghetti"))
            str+= "$" + (decimal.format(extras.getInt("q_spaghetti") * extras.getDouble("price_spaghetti"))) + '\n';
        if(extras.containsKey("price_lasagna"))
            str+= "$" + (decimal.format(extras.getInt("q_lasagna") * extras.getDouble("price_lasagna"))) + '\n';
        if(extras.containsKey("price_fettuccine"))
            str+= "$" + (decimal.format(extras.getInt("q_fettuccine") * extras.getDouble("price_fettuccine"))) + '\n';
        if(extras.containsKey("price_coke"))
            str+= "$" + (decimal.format(extras.getInt("q_coke") * extras.getDouble("price_coke"))) + '\n';
        if(extras.containsKey("price_icedtea"))
            str+= "$" + (decimal.format(extras.getInt("q_icedtea") * extras.getDouble("price_icedtea"))) + '\n';
        return str;
    }
}
