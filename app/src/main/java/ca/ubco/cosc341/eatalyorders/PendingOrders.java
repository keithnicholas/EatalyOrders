package ca.ubco.cosc341.eatalyorders;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PendingOrders extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pending_orders);

        getSupportActionBar().setTitle("Pending Orders");
    }


    public void cButton(View view){
        //Continue to next page
    }

    public void homepage(View view){
        finish();
    }
}
