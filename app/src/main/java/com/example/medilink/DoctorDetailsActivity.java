package com.example.medilink;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1=
            {
                    {"Doctor Name :Dr.Ajit Saste","Hospital Address:Pimpri","Exp=5yrs","Mobile Number:9898989898","600"},
                    {"Doctor Name :Dr.Prasad Pawar","Hospital Address:Nigdi","Exp=15yrs","Mobile Number:7878787878","900" },
                    {"Doctor Name :Dr.Swapnil Kale","Hospital Address:Pune","Exp=8yrs","Mobile Number:6868686868","300"},
                    {"Doctor Name :Dr.Deepak Deshmukh","Hospital Address:Chinchwad","Exp=6yrs","Mobile Number:989800000","500"},
                    {"Doctor Name :Dr.Ashok Panda","Hospital Address:Katraj","Exp=7yrs","Mobile Number:7098805021","800"}

            };
    private String[][] doctor_details2=
            {
                    {"Doctor Name :Dr.H V Srinivas","Hospital Address:Bengaluru","Exp=30yrs","Mobile Number:9898989898","800"},
                    {"Doctor Name :Dr. Srinivas V","Hospital Address:Mangalore","Exp=15yrs","Mobile Number:780087800","1000" },
                    {"Doctor Name :Dr.Anantha Padmanabh","Hospital Address:Hyderabad","Exp=10yrs","Mobile Number:6808606821","600"},
                    {"Doctor Name :Dr.Swathi","Hospital Address:Kalaburagi","Exp=6yrs","Mobile Number:9898002211","500"},
                    {"Doctor Name :Dr.Prakash","Hospital Address:Mysore","Exp=7yrs","Mobile Number:7093505021","700"}

            };
    private String[][] doctor_details3=
            {
                    {"Doctor Name :Dr.Anmol","Hospital Address:Ahmedabad","Exp=24yrs","Mobile Number:9800985210","1000"},
                    {"Doctor Name :Dr.Prasad","Hospital Address:Bhopal","Exp=16yrs","Mobile Number:7821568974","1500" },
                    {"Doctor Name :Dr.Suvarna","Hospital Address:Surat","Exp=10yrs","Mobile Number:6305238974","900"},
                    {"Doctor Name :Dr.Deepak Deshpande","Hospital Address:Chennai","Exp=9yrs","Mobile Number:9821568974","850"},
                    {"Doctor Name :Dr.Ashok Singh","Hospital Address:Lucknow","Exp=8yrs","Mobile Number:7098785241","1100"}

            };
    private String[][] doctor_details4=
            {
                    {"Doctor Name :Dr.Pankaj","Hospital Address:Indore","Exp=12yrs","Mobile Number:9898989898","600"},
                    {"Doctor Name :Dr.Seema Patil","Hospital Address:Mumbai","Exp=11yrs","Mobile Number:7878787878","900" },
                    {"Doctor Name :Dr.Manish Jain","Hospital Address:Ratnagiri","Exp=10yrs","Mobile Number:6868686868","700"},
                    {"Doctor Name :Dr.Swapnil Deshmukh","Hospital Address:Belagavi","Exp=9yrs","Mobile Number:989800000","500"},
                    {"Doctor Name :Dr.Shrikant Iyengar","Hospital Address:Bellary","Exp=8yrs","Mobile Number:7098805021","800"}

            };
    private String[][] doctor_details5=
            {
                    {"Doctor Name :Dr.Deepak","Hospital Address:Kolar","Exp=5yrs","Mobile Number:9898989898","1600"},
                    {"Doctor Name :Dr.Gayathri","Hospital Address:Ranchi","Exp=15yrs","Mobile Number:7878787878","1900" },
                    {"Doctor Name :Dr.Suresh","Hospital Address:Bengaluru","Exp=8yrs","Mobile Number:6868686868","1300"},
                    {"Doctor Name :Dr.Ashok Kumar","Hospital Address:Bidar","Exp=10yrs","Mobile Number:989800000","1500"},
                    {"Doctor Name :Dr.Tanija","Hospital Address:Vijayanagar","Exp=12yrs","Mobile Number:7098805021","1800"}

            };
    TextView tv;
    Button btn;
    String[][] doctor_details={};
    ArrayList list;
    HashMap<String,String> item;
    SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv=findViewById(R.id.textViewDDTitle);
        btn=findViewById((R.id.buttonDDBack));
        Intent it=getIntent();
        String title=it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physicians")==0)
            doctor_details=doctor_details1;
        else if(title.compareTo("Dietician")==0)
                doctor_details=doctor_details2;
        else if(title.compareTo("Dentist")==0)
                doctor_details=doctor_details3;
        else if(title.compareTo("Surgeon")==0)
            doctor_details=doctor_details4;
        else
            doctor_details=doctor_details5;

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
            }
        });

        list=new ArrayList();
        for(int i=0;i<doctor_details.length;i++){
            item=new HashMap<String,String>();
            item.put("line1",doctor_details[i][0]);
            item.put("line2",doctor_details[i][1]);
            item.put("line3",doctor_details[i][2]);
            item.put("line4",doctor_details[i][3]);
            item.put("line5","Cons Fees:"+doctor_details[i][4]+"/-");
            list.add(item);
        }
        sa=new SimpleAdapter(this,list,R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
                );
        ListView lst=findViewById(R.id.ListViewDD);
        lst.setAdapter(sa);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it=new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });
    }
}