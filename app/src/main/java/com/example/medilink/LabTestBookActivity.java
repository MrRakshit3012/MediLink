package com.example.medilink;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class LabTestBookActivity extends AppCompatActivity {

    EditText edname,edcontact,edpincode,edaddress;
    Button btnbooking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_book);



        edname=findViewById(R.id.editTextLTBFullName);
        edcontact=findViewById(R.id.editTextLTBContact);
        edpincode=findViewById(R.id.editTextLTBPinCode);
        edaddress=findViewById(R.id.editTextLTBAddress);
        btnbooking=findViewById(R.id.buttonLTBBook);



        Intent intent=getIntent();
        String[] price=intent.getStringExtra("price").split(":");
        String date=intent.getStringExtra("date");
        String time=intent.getStringExtra("time");



            btnbooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedpreferences=getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username=sharedpreferences.getString("username","");

                Database db=new Database(getApplicationContext(),"MediLink",null,1);
               db.addOrder(username,edname.getText().toString(),edaddress.getText().toString(),edcontact.getText().toString(), Integer.parseInt(edpincode.getText().toString()),date.toString(),time.toString(),Float.parseFloat(price[1].toString()),"lab");

                db.removeCart(username,"lab");

                Toast.makeText(getApplicationContext(),"Your Booking is Done successfully",Toast.LENGTH_LONG).show();
                startActivity(new Intent(LabTestBookActivity.this, HomeActivity.class));


            }
        });
    }
}