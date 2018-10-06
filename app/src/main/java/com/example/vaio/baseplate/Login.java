package com.example.vaio.baseplate;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vaio.baseplate.Menu;
import com.example.vaio.baseplate.R;

public class Login extends AppCompatActivity {
    EditText name;
    EditText pass;
    Button b;
    String n=null;
//    private SharedPreferences nn;
//    private SharedPreferences.Editor ed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        name=(EditText)findViewById(R.id.na_me);
        pass=(EditText)findViewById(R.id.pa_ss);
        b = (Button) findViewById(R.id.button);
        //nn= PreferenceManager.getDefaultSharedPreferences(this);
       // ed=nn.edit();

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 n=name.getText().toString();
                final String p=pass.getText().toString();
//
              //  Toast.makeText(getApplicationContext(),"Welcome "+n,Toast.LENGTH_SHORT).show();
                Intent x=new Intent(getApplicationContext(),Menu.class);
                Bundle b1=new Bundle();
                b1.putString("sakshi",n);
               x.putExtras(b1);
              startActivity(x);

            }
        });
    }
//    public String name(int i)
//    {
//        if(i==1)
//        {
//            return n;
//
//        }
//        else
//            return "sakshi";
//    }
}
