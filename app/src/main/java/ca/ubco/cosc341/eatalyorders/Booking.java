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

//        getSupportActionBar().setTitle("Reservation Booking");
        setTitle("Reservation Booking");
        editName = findViewById(R.id.nResEditText);
        editPhone = findViewById(R.id.pnEditText);
        editPeople = findViewById(R.id.peopleEditText);



        displayDate = findViewById(R.id.datePicker);
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
        if( (editName.getText().toString().length() < 2) && (editPhone.getText().toString().length() != 14)&& (displayDate.getText().toString().matches("Click here to select a date"))  &&(editPeople.getText().toString().length() < 1 ||
                Integer.parseInt(editPeople.getText().toString()) < 1)){
            Toast.makeText(this, "Please enter your information", Toast.LENGTH_SHORT).show();
            return;
        }

        if(editName.getText().toString().length() < 2){
            Toast.makeText(this, "Invalid Name", Toast.LENGTH_SHORT).show();
            return;
        }

        if(editPhone.getText().toString().length() != 14){
            Toast.makeText(this, "Please enter a 10 digit phone number", Toast.LENGTH_SHORT).show();
            return;
        }
        if(displayDate.getText().toString().matches("Click here to select a date")) {
            Toast.makeText(this, "Please pick a date", Toast.LENGTH_SHORT).show();
            return;
        }
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        String[] arr_date = displayDate.getText().toString().split("/");//mm/dd/yyyy

        if(Integer.parseInt(arr_date[0]) < month || Integer.parseInt(arr_date[1]) < day
                || Integer.parseInt(arr_date[2]) < year) {
            Toast.makeText(this, "Please pick a date", Toast.LENGTH_SHORT).show();
            return;
        }
        if(editPeople.getText().toString().length() < 1 ||
                Integer.parseInt(editPeople.getText().toString()) < 1){
            Toast.makeText(this, "Invalid number of guests", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intentReserve = new Intent(this, ResConfirm.class);
        intentReserve.putExtra("name", editName.getText().toString());
        intentReserve.putExtra("phone", editPhone.getText().toString());
        intentReserve.putExtra("people", editPeople.getText().toString());
        intentReserve.putExtra("time", spinnerH.getSelectedItem().toString() + ":" +
                spinnerM.getSelectedItem().toString() + "pm");
        intentReserve.putExtra("date", displayDate.getText().toString());
        startActivity(intentReserve);
    }

    public void cancel(View view){
        finish();
    }
}
