package ca.ubco.cosc341.eatalyorders;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResConfirm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res_confirm);

//        getSupportActionBar().setTitle("Reservation Confirmation");
        setTitle("Reservation Confirmation");
//        Resources res = getResources();

        Bundle extras = getIntent().getExtras();
        assert extras != null;

        //datePicker & set time
        TextView resConfirm = findViewById(R.id.resConfirmTextView);
        String name = getIntent().getStringExtra("name");
        String temp = getIntent().getStringExtra("date");
        String str_time = getIntent().getStringExtra("time");
        resConfirm.setText("Thank you " + name + " for your reservation! We will see you on " + temp + " at "+ str_time);


        //datePicker
//        TextView date = findViewById(R.id.resDateConfirm);
////        String temp = res.getString(R.string.datetext);
//        String temp = getIntent().getStringExtra("date");
//        date.setText(temp);
//
//        //set time
//        String str_time = getIntent().getStringExtra("time");
//        TextView time = findViewById(R.id.resTimeConfirm);
//        time.setText(str_time);

    }

    public void finish(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
