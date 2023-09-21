package com.example.medilink;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BuyMedicineBookActivity extends AppCompatActivity {
    EditText edname,edcontact,edpincode,edaddress;
    Button btnbooking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine_book);
        edname=findViewById(R.id.editTextBMBFullName);
        edcontact=findViewById(R.id.editTextBMBContact);
        edpincode=findViewById(R.id.editTextBMBPinCode);
        edaddress=findViewById(R.id.editTextBMBAddress);
        btnbooking=findViewById(R.id.buttonBMBBook);

        Intent intent=getIntent();
        String[] price=intent.getStringExtra("price").split(":");
        String date=intent.getStringExtra("date");
        //String time=intent.getStringExtra("time");



        btnbooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedpreferences=getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username=sharedpreferences.getString("username","");

                Database db=new Database(getApplicationContext(),"MediLink",null,1);
                db.addOrder(username,edname.getText().toString(),edaddress.getText().toString(),edcontact.getText().toString(), Integer.parseInt(edpincode.getText().toString()),date.toString()," ",Float.parseFloat(price[1].toString()),"medicine");

                db.removeCart(username,"medicine");

                Toast.makeText(getApplicationContext(),"Your Booking is Done successfully",Toast.LENGTH_LONG).show();
                startActivity(new Intent(BuyMedicineBookActivity.this, HomeActivity.class));


            }
        });


    }
}