package com.example.medilink;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class BuyMedicineActivity extends AppCompatActivity {
    private String[][] packages={
            {"Uprise-03 1000IU Capsule","","","","50"},
            {"Healthvit Chromium Piconilate 200mcg Capsule","","","","305"},
            {"Crocin Advanced-650","","","","400"},
            {"Dolo-650","","","","30"},
            {"Amlong 5mg","","","","500"},
            {"Folvite-5mg","","","","50"},
            {"Strepsils For Sore Throat","","","","10"},
            {"Vitamin-B Complex Capsules","","","","540"}
    };
    private String[] package_details={
            "Building and keeping the bones and teeth strong\n"+
                    "Reducing Fatigue/Stress and muscular pains\n"+
                    "Boosting immunity and increasing resistance against infection\n",
            "Chromium is an essential trace mineral that plays an important role in helping insulin regulation",
            "Helps relieve a person from fever and high headaches\n"+
                    "Suitable for ages above 12+",
            "Helps a person relieve pain and fever by blocking the release of certain chemicals",
            "Amlong-5mg tablet is a medicine used for the treatment of high blood pressure",
            "Folvite is a Vitamin-C supplement that contains folic acid for the treatment of certain forms pf anaemia caused due to the deficiency of folic acid",
            "Strepsils relieves the symptoms of a bacterial throat infection and soothes the recovery process\n"+
                    "Provides a warm and comforting feeling during the sore throat",
            "Provides relief from Vitamin-B deficiencies\n"+
                    "Helps in the formation of red blood cells\n"+
                    "Maintains healthy nervous system"
    };

    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView lst;
    Button btnBack,btnGoToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);

        lst=findViewById(R.id.ListViewBM);
        btnBack=findViewById(R.id.buttonBMBack);
        btnGoToCart=findViewById(R.id.buttonBMGoToCart);

        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedicineActivity.this,CartBuyMedicineActivity.class));
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedicineActivity.this,HomeActivity.class));
            }
        });

        list=new ArrayList();
        for(int i=0;i<packages.length;i++){
            item=new HashMap<String,String>();
            item.put("line1",packages[i][0]);
            item.put("line2",packages[i][1]);
            item.put("line3",packages[i][2]);
            item.put("line4",packages[i][3]);
            item.put("line5","Total Cost:"+packages[i][4]+"/-");
            list.add(item);
        }

        sa=new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[] {"line1","line2","line3","line4","line5"},
                new int[] {R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it=new Intent(BuyMedicineActivity.this,BuyMedicineDetailsActivity.class);
                it.putExtra("text1",packages[i][0]);
                it.putExtra("text2",package_details[i]);
                it.putExtra("text3",packages[i][4]);
                startActivity(it);
            }
        });
    }
}