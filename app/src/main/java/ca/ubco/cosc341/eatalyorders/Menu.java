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
    double subtotal, mineTotal, caeTotal, spagTotal, lasTotal, fettTotal, cokeTotal, ITTotal;
    RadioGroup takeoutOption;
    RadioButton pickup, delivery;

    DecimalFormat decimal = new DecimalFormat("0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        getSupportActionBar().setTitle("Menu");

        Button addMine  =(Button) findViewById(R.id.addMine);
        addMine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView quantity = (TextView) findViewById(R.id.q1);
                minestrone = minestrone+1;
                quantity.setText(Integer.toString(minestrone));

                mineTotal = minestrone * minePrice;
                subtotal = mineTotal + caeTotal + spagTotal + lasTotal + fettTotal + cokeTotal + ITTotal;
                TextView subtotalTextView = (TextView) findViewById(R.id.subTotal);
                subtotalTextView.setText("$" + decimal.format(subtotal));

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
                    mineTotal = minestrone * minePrice;
                    subtotal = mineTotal + caeTotal + spagTotal + lasTotal + fettTotal + cokeTotal + ITTotal;

                    TextView subtotalTextView = (TextView) findViewById(R.id.subTotal);
                    subtotalTextView.setText("$" + decimal.format(subtotal));
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

                caeTotal = caesar * caesarPrice;
                subtotal = mineTotal + caeTotal + spagTotal + lasTotal + fettTotal + cokeTotal + ITTotal;
                TextView subtotalTextView = (TextView) findViewById(R.id.subTotal);
                subtotalTextView.setText("$" + decimal.format(subtotal));
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

                    caeTotal = caesar * caesarPrice;
                    subtotal = mineTotal + caeTotal + spagTotal + lasTotal + fettTotal + cokeTotal + ITTotal;
                    TextView subtotalTextView = (TextView) findViewById(R.id.subTotal);
                    subtotalTextView.setText("$" + decimal.format(subtotal));

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

                spagTotal = spaghetti * spagPrice;
                subtotal = mineTotal + caeTotal + spagTotal + lasTotal + fettTotal + cokeTotal + ITTotal;
                TextView subtotalTextView = (TextView) findViewById(R.id.subTotal);
                subtotalTextView.setText("$" + decimal.format(subtotal));

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

                    spagTotal = spaghetti * spagPrice;
                    subtotal = mineTotal + caeTotal + spagTotal + lasTotal + fettTotal + cokeTotal + ITTotal;
                    TextView subtotalTextView = (TextView) findViewById(R.id.subTotal);
                    subtotalTextView.setText("$" + decimal.format(subtotal));
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

                lasTotal = lasagna * lasPrice;
                subtotal = mineTotal + caeTotal + spagTotal + lasTotal + fettTotal + cokeTotal + ITTotal;
                TextView subtotalTextView = (TextView) findViewById(R.id.subTotal);
                subtotalTextView.setText("$" + decimal.format(subtotal));
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

                    lasTotal = lasagna * lasPrice;
                    subtotal = mineTotal + caeTotal + spagTotal + lasTotal + fettTotal + cokeTotal + ITTotal;
                    TextView subtotalTextView = (TextView) findViewById(R.id.subTotal);
                    subtotalTextView.setText("$" + decimal.format(subtotal));
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

                fettTotal = fettuccine * fettPrice;
                subtotal = mineTotal + caeTotal + spagTotal + lasTotal + fettTotal + cokeTotal + ITTotal;
                TextView subtotalTextView = (TextView) findViewById(R.id.subTotal);
                subtotalTextView.setText("$" + decimal.format(subtotal));
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

                    fettTotal = fettuccine * fettPrice;
                    subtotal = mineTotal + caeTotal + spagTotal + lasTotal + fettTotal + cokeTotal + ITTotal;
                    TextView subtotalTextView = (TextView) findViewById(R.id.subTotal);
                    subtotalTextView.setText("$" + decimal.format(subtotal));
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

                cokeTotal = coke * cokePrice;
                subtotal = mineTotal + caeTotal + spagTotal + lasTotal + fettTotal + cokeTotal + ITTotal;
                TextView subtotalTextView = (TextView) findViewById(R.id.subTotal);
                subtotalTextView.setText("$" + decimal.format(subtotal));
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

                    cokeTotal = coke * cokePrice;
                    subtotal = mineTotal + caeTotal + spagTotal + lasTotal + fettTotal + cokeTotal + ITTotal;
                    TextView subtotalTextView = (TextView) findViewById(R.id.subTotal);
                    subtotalTextView.setText("$" + decimal.format(subtotal));
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

                ITTotal = icedtea * ITPrice;
                subtotal = mineTotal + caeTotal + spagTotal + lasTotal + fettTotal + cokeTotal + ITTotal;
                TextView subtotalTextView = (TextView) findViewById(R.id.subTotal);
                subtotalTextView.setText("$" + decimal.format(subtotal));
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

                    ITTotal = icedtea * ITPrice;
                    subtotal = mineTotal + caeTotal + spagTotal + lasTotal + fettTotal + cokeTotal + ITTotal;
                    TextView subtotalTextView = (TextView) findViewById(R.id.subTotal);
                    subtotalTextView.setText("$" + decimal.format(subtotal));
                }
            }
        });

        takeoutOption = findViewById(R.id.radioGroup);
        pickup = findViewById(R.id.pickup);
        delivery = findViewById(R.id.delivery);
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
            Bundle bundle =  getOrder();
            assert bundle != null;
            intent.putExtras(bundle);
            startActivity(intent);
        }else{
            Intent intent = new Intent(this, DeliveryOrder.class);
            Bundle bundle =  getOrder();
            assert bundle != null;
            intent.putExtras(bundle);
            startActivity(intent);
        }

    }

    public Bundle getOrder() {
        Bundle bundle = new Bundle();
        if(minestrone > 0) {
            bundle.putString("minestrone", "minestrone" );//passing ordered food name
            bundle.putDouble("price_minestrone", minePrice);//passing ordered food price
            bundle.putInt("q_minestrone", minestrone);//passing ordered food quantity
        }
        if(caesar > 0) {
            bundle.putString("caesar", "caesar" );//passing ordered food name
            bundle.putDouble("price_caesar", caesarPrice);//passing ordered food price
            bundle.putInt("q_caesar", caesar);//passing ordered food quantity
        }
        if(spaghetti > 0) {
            bundle.putString("spaghetti", "spaghetti" );//passing ordered food name
            bundle.putDouble("price_spaghetti", spagPrice);//passing ordered food price
            bundle.putInt("q_spaghetti", spaghetti);//passing ordered food quantity
        }if(lasagna > 0) {
            bundle.putString("lasagna", "lasagna" );//passing ordered food name
            bundle.putDouble("price_lasagna", lasPrice);//passing ordered food price
            bundle.putInt("q_lasagna", lasagna);//passing ordered food quantity
        }
        if(fettuccine > 0) {
            bundle.putString("fettuccine", "fettuccine" );//passing ordered food name
            bundle.putDouble("price_fettuccine", fettPrice);//passing ordered food price
            bundle.putInt("q_fettuccine", fettuccine);//passing ordered food quantity
        }
        if(coke > 0) {
            bundle.putString("coke", "coke" );//passing ordered food name
            bundle.putDouble("price_coke", cokePrice);//passing ordered food price
            bundle.putInt("q_coke", coke);//passing ordered food quantity
        }
        if(icedtea > 0) {
            bundle.putString("icedtea", "icedtea" );//passing ordered food name
            bundle.putDouble("price_icedtea", ITPrice);//passing ordered food price
            bundle.putInt("q_icedtea", icedtea);//passing ordered food quantity
        }
        bundle.putDouble("subtotal", subtotal);
        return bundle;
    }
}
