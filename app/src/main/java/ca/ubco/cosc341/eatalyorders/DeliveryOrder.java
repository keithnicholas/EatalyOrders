package ca.ubco.cosc341.eatalyorders;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;

public class DeliveryOrder extends AppCompatActivity {

    Spinner spinnerH, spinnerM, spinnerP;
    EditText editName, editPhone, editAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_order);

        getSupportActionBar().setTitle("Delivery");

        editName = findViewById(R.id.nameDEditText);
        editPhone = findViewById(R.id.pnDEditText);
        editAddress = findViewById(R.id.adDEditText);

        spinnerH = findViewById(R.id.hourDelivery);
        ArrayAdapter<CharSequence> adapterH = ArrayAdapter.createFromResource(this, R.array.hour, android.R.layout.simple_spinner_item);
        adapterH.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerH.setAdapter(adapterH);

        spinnerM = findViewById(R.id.minutesDelivery);
        ArrayAdapter<CharSequence> adapterM = ArrayAdapter.createFromResource(this, R.array.minutes, android.R.layout.simple_spinner_item);
        adapterM.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerM.setAdapter(adapterM);

        spinnerP = findViewById(R.id.payment);
        ArrayAdapter<CharSequence> adapterP = ArrayAdapter.createFromResource(this, R.array.payment, android.R.layout.simple_spinner_item);
        adapterP.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerP.setAdapter(adapterP);

    }

    public void continueButton(View view){

        if(editName.getText().toString().length() < 2){
            Toast.makeText(this, "Please enter a valid name", Toast.LENGTH_SHORT).show();
            return;
        }

        if(editPhone.getText().toString().length() != 10){
            Toast.makeText(this, "Invalid phone number", Toast.LENGTH_SHORT).show();
            return;
        }

        if(editAddress.getText().toString().length() < 5){
            Toast.makeText(this, "Please enter an address of at least 5 characters", Toast.LENGTH_SHORT).show();
            return;
        }

        //validation for pickup time
//        Calendar ca_now = Calendar.getInstance();
//        Calendar ca_user_select = Calendar.getInstance();
//        ca_user_select.set(Calendar.HOUR, Integer.parseInt(spinnerH.getSelectedItem().toString()));
//        ca_user_select.set(Calendar.MINUTE, Integer.parseInt(spinnerM.getSelectedItem().toString()));
//        if(ca_now.before(ca_user_select)) {
//            Toast.makeText(this, "Invalid Delivery Time.", Toast.LENGTH_SHORT).show();
//            return;
//        }

        Intent intent = new Intent(this, OrderSummary.class);
        //rewrote intent content by using Bundle
        Bundle new_bundle = getOrder();
        assert new_bundle != null;
        intent.putExtras(new_bundle);
        //reset spinner
        spinnerH.setSelection(0);
        spinnerM.setSelection(0);
        spinnerP.setSelection(0);

        startActivity(intent);
    }

    public void menuButton(View view){
        finish();
    }


    public Bundle getOrder() {
        Bundle oldBundle = getIntent().getExtras();
        //acquire customer info from PickupOrder
        oldBundle.putString("customer_name", editName.getText().toString());
        oldBundle.putString("phone_number", editPhone.getText().toString());
        oldBundle.putString("address", editAddress.getText().toString());
        oldBundle.putString("hour", spinnerH.getSelectedItem().toString());
        oldBundle.putString("minutes", spinnerM.getSelectedItem().toString());
        oldBundle.putString("payment", spinnerP.getSelectedItem().toString());
        //acquire Menu order
        if(oldBundle.containsKey("minestrone")) {
            oldBundle.putString("minestrone", oldBundle.getString("minestrone") );//passing ordered food name
            oldBundle.putDouble("price_minestrone", oldBundle.getDouble("price_minestrone"));//passing ordered food price
            oldBundle.putInt("q_minestrone", oldBundle.getInt("q_minestrone"));//passing ordered food quantity
        }
        if(oldBundle.containsKey("caesar")) {
            oldBundle.putString("caesar", oldBundle.getString("caesar") );//passing ordered food name
            oldBundle.putDouble("price_caesar", oldBundle.getDouble("price_caesar"));//passing ordered food price
            oldBundle.putInt("q_caesar", oldBundle.getInt("q_caesar"));//passing ordered food quantity
        }
        if(oldBundle.containsKey("spaghetti")) {
            oldBundle.putString("spaghetti", oldBundle.getString("spaghetti") );//passing ordered food name
            oldBundle.putDouble("price_spaghetti", oldBundle.getDouble("price_spaghetti"));//passing ordered food price
            oldBundle.putInt("q_spaghetti", oldBundle.getInt("q_spaghetti"));//passing ordered food quantity
        }
        if(oldBundle.containsKey("lasagna")) {
            oldBundle.putString("lasagna", oldBundle.getString("lasagna") );//passing ordered food name
            oldBundle.putDouble("price_lasagna", oldBundle.getDouble("price_lasagna"));//passing ordered food price
            oldBundle.putInt("q_lasagna", oldBundle.getInt("q_lasagna"));//passing ordered food quantity
        }
        if(oldBundle.containsKey("fettuccine")) {
            oldBundle.putString("fettuccine", oldBundle.getString("fettuccine") );//passing ordered food name
            oldBundle.putDouble("price_fettuccine", oldBundle.getDouble("price_fettuccine"));//passing ordered food price
            oldBundle.putInt("q_fettuccine", oldBundle.getInt("q_fettuccine"));//passing ordered food quantity
        }
        if(oldBundle.containsKey("coke")) {
            oldBundle.putString("coke", oldBundle.getString("coke") );//passing ordered food name
            oldBundle.putDouble("price_coke", oldBundle.getDouble("price_coke"));//passing ordered food price
            oldBundle.putInt("q_coke", oldBundle.getInt("q_coke"));//passing ordered food quantity
        }
        if(oldBundle.containsKey("icedtea")) {
            oldBundle.putString("icedtea", oldBundle.getString("icedtea") );//passing ordered food name
            oldBundle.putDouble("price_icedtea", oldBundle.getDouble("price_icedtea"));//passing ordered food price
            oldBundle.putInt("q_icedtea", oldBundle.getInt("q_icedtea"));//passing ordered food quantity
        }
        oldBundle.putDouble("subtotal", oldBundle.getDouble("subtotal"));
        return oldBundle;
    }
}
