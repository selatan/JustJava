package com.example.a3.justjava;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends ActionBarActivity {


    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayPrice(String price) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(price);
    }
    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
      /*  int quantity = 2; */
        CheckBox whippedcreamcheckbox = (CheckBox) findViewById(R.id.whipped_cream_view);
        boolean ischeckedcream = whippedcreamcheckbox.isChecked();

        CheckBox chocolatecheckbox = (CheckBox)findViewById(R.id.chocolate_view);
        boolean ischeckchocolate = chocolatecheckbox.isChecked();

        int price = 5;
        if(ischeckedcream){
            price = price+1;
        }
        if(ischeckchocolate){
            price = price +2;
        }

        EditText inputname = (EditText) findViewById(R.id.input_view);
        String name = inputname.getText().toString();
        String priceMessage ="Name:"+(name)+"\nAdd whipped cream ?"+(ischeckedcream)+"\nAdd Chocolate ?"
                +(ischeckchocolate)+"\nTotal $" +( quantity * price ) +"\nThank you!";



        displayPrice(priceMessage);

    }

    public void increment(View view) {
       /* int quantity = 2; */
        if(quantity>100){
            Toast.makeText(this, "不能超过100", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    public void decrement(View view){
       /* int quantity = 2; */
        if(quantity<1){
            Toast.makeText(this,"不能小于1",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity - 1;
        displayQuantity(quantity);
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

}