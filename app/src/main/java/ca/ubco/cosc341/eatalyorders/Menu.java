package ca.ubco.cosc341.eatalyorders;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class Menu extends AppCompatActivity {

    int minestrone = 0, caesar = 0, spaghetti = 0, lasagna = 0, fettuccine = 0, coke = 0, icedtea = 0;
    double minePrice = 7.00, caesarPrice = 8.00, spagPrice = 11.00, lasPrice = 10.00, fettPrice = 12.00, cokePrice = 2.00, ITPrice = 2.00;
    double subtotal;
    RadioGroup takeoutOption;
    RadioButton pickup, delivery;

    DecimalFormat decimal = new DecimalFormat("0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //TODO: Display subtotal

        getSupportActionBar().setTitle("Menu");

        Button addMine  =(Button) findViewById(R.id.addMine);
        addMine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView quantity = (TextView) findViewById(R.id.q1);
                minestrone = minestrone+1;
                quantity.setText(Integer.toString(minestrone));
            }
        });

        Button subMine = (Button) findViewById(R.id.subMine);
        subMine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(minestrone > 0) {
                    TextView quantity = (TextView) findViewById(R.id.q1);
                    minestrone = minestrone - 1;
                    quantity.setText(Integer.toString(minestrone));
                }
            }
        });

        Button addCaesar = (Button) findViewById(R.id.addCaesar);
        addCaesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView quantity = (TextView) findViewById(R.id.q2);
                caesar = caesar+1;
                quantity.setText(Integer.toString(caesar));
            }
        });

        Button subCaesar = (Button) findViewById(R.id.subCaesar);
        subCaesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(caesar > 0) {
                    TextView quantity = (TextView) findViewById(R.id.q2);
                    caesar = caesar - 1;
                    quantity.setText(Integer.toString(caesar));
                }
            }
        });

        Button addSpaghetti = (Button) findViewById(R.id.addSpaghetti);
        addSpaghetti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView quantity = (TextView) findViewById(R.id.q3);
                spaghetti = spaghetti+1;
                quantity.setText(Integer.toString(spaghetti));
            }
        });

        Button subSpaghetti = (Button) findViewById(R.id.subSpaghetti);
        subSpaghetti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(spaghetti > 0) {
                    TextView quantity = (TextView) findViewById(R.id.q3);
                    spaghetti = spaghetti - 1;
                    quantity.setText(Integer.toString(spaghetti));
                }
            }
        });

        Button addLasagna = (Button) findViewById(R.id.addLasagna);
        addLasagna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView quantity = (TextView) findViewById(R.id.q4);
                lasagna = lasagna+1;
                quantity.setText(Integer.toString(lasagna));
            }
        });

        Button subLasagna = (Button) findViewById(R.id.subLasagna);
        subLasagna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lasagna > 0) {
                    TextView quantity = (TextView) findViewById(R.id.q4);
                    lasagna = lasagna - 1;
                    quantity.setText(Integer.toString(lasagna));
                }
            }
        });

        Button addFettuccine = (Button) findViewById(R.id.addFettuccine);
        addFettuccine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView quantity = (TextView) findViewById(R.id.q5);
                fettuccine = fettuccine+1;
                quantity.setText(Integer.toString(fettuccine));
            }
        });

        Button subFettuccine = (Button) findViewById(R.id.subFettuccine);
        subFettuccine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(fettuccine > 0) {
                    TextView quantity = (TextView) findViewById(R.id.q5);
                    fettuccine = fettuccine - 1;
                    quantity.setText(Integer.toString(fettuccine));
                }
            }
        });

        Button addCoke = (Button) findViewById(R.id.addCoke);
        addCoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView quantity = (TextView) findViewById(R.id.q6);
                coke = coke+1;
                quantity.setText(Integer.toString(coke));
            }
        });

        Button subCoke = (Button) findViewById(R.id.subCoke);
        subCoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(coke > 0) {
                    TextView quantity = (TextView) findViewById(R.id.q6);
                    coke = coke - 1;
                    quantity.setText(Integer.toString(coke));
                }
            }
        });

        Button addIT = (Button) findViewById(R.id.addIcedTea);
        addIT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView quantity = (TextView) findViewById(R.id.q7);
                icedtea = icedtea+1;
                quantity.setText(Integer.toString(icedtea));
            }
        });

        Button subIT = (Button) findViewById(R.id.subIcedTea);
        subIT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(icedtea > 0) {
                    TextView quantity = (TextView) findViewById(R.id.q7);
                    icedtea = icedtea - 1;
                    quantity.setText(Integer.toString(icedtea));
                }
            }
        });

        takeoutOption = findViewById(R.id.radioGroup);
        pickup = findViewById(R.id.pickup);
        delivery = findViewById(R.id.delivery);

        //test
        subtotal = 1;
    }

    public void continueButton(View view){
//send data to order summary
        if(pickup.isChecked() == delivery.isChecked()){
            Toast.makeText(this, "Please pick a takeout option.", Toast.LENGTH_SHORT).show();
            return;
        }else if(subtotal == 0){
            Toast.makeText(this, "Your cart is empty.", Toast.LENGTH_SHORT).show();
            return;
        }else if (subtotal > 0 && pickup.isChecked()){
            Intent intent = new Intent(this, PickupOrder.class);
            startActivity(intent);

        }else{
            Intent intent = new Intent(this, DeliveryOrder.class);
            startActivity(intent);
            //Send delivery charge to Order Summary
        }

    }
}
