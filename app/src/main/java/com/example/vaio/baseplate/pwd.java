package com.example.vaio.baseplate;

import android.location.Address;
import android.location.Geocoder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class pwd extends AppCompatActivity {
CheckBox cb;
CheckBox cbt;
Geocoder gc;
TextView addr;
String fulladd;
    List<Address> addresses;
    Double lat=19.0727373;
    Double longi=72.9002638;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pwd);

        b=(Button)findViewById(R.id.button7);
        gc=new Geocoder(this,Locale.getDefault());
        cb=(CheckBox)findViewById(R.id.checkBox);
        cbt=(CheckBox)findViewById(R.id.checkBox2);
        addr = (TextView) findViewById(R.id.textView2);
        gc = new Geocoder(this, Locale.getDefault());
        try {
            addresses = gc.getFromLocation(lat, longi, 1);
            String addres = addresses.get(0).getAddressLine(0);
            String area = addresses.get(0).getLocality();
            String city = addresses.get(0).getAdminArea();
            String country = addresses.get(0).getCountryName();
            String zip = addresses.get(0).getPostalCode();
            fulladd = "Somaiya Vidhyavihar " + " ," + area + " ," + city + " ," + zip + " ," + country + " ,";
            addr.setText(fulladd);

        } catch (IOException e) {
            e.printStackTrace();
        }

        addr.setText(fulladd);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s
            }
        });
    }
}
