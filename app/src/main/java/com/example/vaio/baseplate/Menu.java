package com.example.vaio.baseplate;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;

public class Menu extends AppCompatActivity {
    Button gar,pwd,jam,reports;
    TextView cs;

String data;
    DatabaseHelper jdb;

//     String value;
//    if ( extras != null) {
//        value = extras.getString("key");
//    }
   void dialContactPhone(final String phoneNumber) {
       startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phoneNumber, null)));
   }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        jdb=new DatabaseHelper(this);
       gar=(Button)findViewById(R.id.button2);
        pwd=(Button)findViewById(R.id.button3);
        jam=(Button)findViewById(R.id.button4);
        cs=(TextView)findViewById(R.id.editText);
        reports=(Button)findViewById(R.id.button5);
        Bundle b1=getIntent().getExtras();
        data=b1.getString("sakshi");


        Toast.makeText(getApplicationContext(),"Welcome "+data,Toast.LENGTH_SHORT).show();
        gar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent x=new Intent(getApplicationContext(),clean.class);
                Bundle b1=new Bundle();
                b1.putString("sakshi",data);
                x.putExtras(b1);
            startActivity(x);
            }
        });

        pwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent x1=new Intent(getApplicationContext(),test_SQLITE.class);
                Bundle b1=new Bundle();
                b1.putString("sakshi",data);
                x1.putExtras(b1);
                startActivity(x1);
            }
        });

        jam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        cs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialContactPhone("8879154024");
            }
        });

        reports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x=new Intent(getApplicationContext(),complain.class);
                Bundle b2=new Bundle();
                b2.putString("sakshi",data);
                x.putExtras(b2);
                startActivity(x);


            }
        });

        }
    }

