package ca.ubco.cosc341.eatalyorders;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Eataly Orders");
    }

    public void menu(View view){
        Intent intentMenu = new Intent(this, Menu.class);
        startActivity(intentMenu);
    }

    public void reservations(View view){
        Intent intentRes = new Intent(this, Reservations.class);
        startActivity(intentRes);
    }

    public void pending(View view){
       /* Intent intentPending = new Intent(this, PendingOrders.class);
        startActivity(intentPending);
        */
    }
}
