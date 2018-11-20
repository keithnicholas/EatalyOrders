package ca.ubco.cosc341.eatalyorders;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class DeliveryOrder extends AppCompatActivity {

    Spinner spinnerH, spinnerM, spinnerP;
    EditText editName, editPhone, editAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_order);

        getSupportActionBar().setTitle("Delivery OrderRng");

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
        int pnLength = editPhone.getText().toString().length();
        if((pnLength < 10) || (pnLength > 10)){
            Toast.makeText(this, "Invalid phone number.", Toast.LENGTH_SHORT).show();
            return;
        }

        if(editName.getText().toString().length() < 2){
            Toast.makeText(this, "Please enter a valid name.", Toast.LENGTH_SHORT).show();
            return;
        }

        if(editAddress.getText().toString().length() < 5){
            Toast.makeText(this, "Please enter an address.", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(this, OrderSummary.class);
        //rewrote intent content by using Bundle
        Bundle new_bundle = new Bundle();
        new_bundle.putString("name_delivery", editName.getText().toString());
        new_bundle.putString("phone_number_delivery", editPhone.getText().toString());
        new_bundle.putString("hour", spinnerH.getSelectedItem().toString());
        new_bundle.putString("minutes", spinnerM.getSelectedItem().toString());
        new_bundle.putString("payment", spinnerP.getSelectedItem().toString());
        //receiving bundle from menu
        Double subtotal = getIntent().getExtras().getDouble("subtotal");
        new_bundle.putString("subtotal", subtotal.toString());
//        intent.putExtra("name_delivery", editName.getText().toString());
//        intent.putExtra("phone_number_delivery", editPhone.getText().toString());
//        intent.putExtra("hour_delivery", spinnerH.getSelectedItem().toString());
//        intent.putExtra("minutes_delivery", spinnerM.getSelectedItem().toString());
//        intent.putExtra("payment", spinnerP.getSelectedItem().toString());

        //intent.putExtras(getIntent().getExtras());
        intent.putExtras(new_bundle);

        spinnerH.setSelection(0);
        spinnerM.setSelection(0);
        spinnerP.setSelection(0);

        startActivity(intent);
    }

    public void menuButton(View view){
        finish();
    }
}
