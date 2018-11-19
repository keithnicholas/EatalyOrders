package ca.ubco.cosc341.eatalyorders;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class OrderConfirm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_confirm);

        getSupportActionBar().setTitle("Order Confirmation");

        //TODO: Take in time order is placed & generate a random order number
    }

    public void done(View view){
        Intent intent = new Intent(this, MainActivity.class);
        finish();
    }
}
