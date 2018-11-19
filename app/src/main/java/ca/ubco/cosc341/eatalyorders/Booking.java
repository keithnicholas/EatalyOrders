package ca.ubco.cosc341.eatalyorders;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class Booking extends AppCompatActivity {

    private static final String TAG = "Booking";
    TextView displayDate;
    DatePickerDialog.OnDateSetListener dateSetListener;
    EditText editName, editPhone, editPeople;
    Spinner spinnerH, spinnerM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        getSupportActionBar().setTitle("Reservation Booking");

        editName = findViewById(R.id.nResEditText);
        editPhone = findViewById(R.id.pnEditText);
        editPeople = findViewById(R.id.peopleEditText);



        displayDate = (TextView) findViewById(R.id.datePicker);
        displayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        Booking.this, android.R.style.Theme_Holo_Dialog_MinWidth, dateSetListener, year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                Log.d(TAG, "onDateSet: mm/dd/yyy: " + month + "/" + dayOfMonth + "/" + year);

                String date = month + "/" + dayOfMonth + "/" + year;
                displayDate.setText(date);
            }
        };

        spinnerH = findViewById(R.id.hour);
        ArrayAdapter<CharSequence> adapterH = ArrayAdapter.createFromResource(this, R.array.hour, android.R.layout.simple_spinner_item);
        adapterH.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerH.setAdapter(adapterH);

        spinnerM = findViewById(R.id.minutes);
        ArrayAdapter<CharSequence> adapterM = ArrayAdapter.createFromResource(this, R.array.minutes, android.R.layout.simple_spinner_item);
        adapterM.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerM.setAdapter(adapterM);

    }

    public void reserve(View view){
        if(editName.getText().toString().length() < 1){
            Toast.makeText(this, "Invalid Name", Toast.LENGTH_SHORT).show();
            return;
        }

        if(editPhone.getText().toString().length() < 1){
            Toast.makeText(this, "Invalid Phone Number", Toast.LENGTH_SHORT).show();
            return;
        }

        if(editPeople.getText().toString().length() < 1){
            Toast.makeText(this, "Invalid number of people", Toast.LENGTH_SHORT).show();
            return;
        }

        /*if(!displayDate.isSelected()){
            Toast.makeText(this, "Please select a date.", Toast.LENGTH_SHORT).show();

        }*/

        Intent intentReserve = new Intent(this, ResConfirm.class);
        intentReserve.putExtra("name", editName.getText().toString());
        intentReserve.putExtra("phone", editPhone.getText().toString());
        intentReserve.putExtra("people", editPeople.getText().toString());

        startActivity(intentReserve);
    }

    public void cancel(View view){
        finish();
    }
}
