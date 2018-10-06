package com.example.vaio.baseplate;

import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class clean extends AppCompatActivity {
  //  Login lg;
    TextView addr;
    Geocoder gc;
    List<Address> addresses;
    Double lat=19.0727373;
    Double longi=72.9002638;
    CheckBox c;
    CheckBox c2;
    Button submit;
    String complain="";
    String fulladd;
    DatabaseHelper jdb;
    String data;
//    private final LocationListener locationListener = new LocationListener() {
//        public void onLocationChanged(Location location) {
//            longi = location.getLongitude();
//            lat = location.getLatitude();
//        }
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clean);
        submit = (Button) findViewById(R.id.but5);

        jdb = new DatabaseHelper(this);
        Toast.makeText(getApplicationContext(), "as", Toast.LENGTH_SHORT).show();
        c = (CheckBox) findViewById(R.id.cb1);
        c2 = (CheckBox) findViewById(R.id.cb2);
        Bundle b1 = getIntent().getExtras();
        data = b1.getString("sakshi");


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

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(getApplicationContext(),"22222222",Toast.LENGTH_SHORT).show();
                if (c.isChecked()) {
                    //Toast.makeText(getApplicationContext(), "1111111111111111", Toast.LENGTH_SHORT).show();
                    complain += c.getText();
                }
                if (c2.isChecked()) {
                    //Toast.makeText(getApplicationContext(), "22222", Toast.LENGTH_SHORT).show();
                    complain += c2.getText();

                }
                AddData();
            }

        });



    }
    public void AddData()
    {
        boolean ans=jdb.insertData(data,complain,fulladd);
        if (ans==true)
        {
            Toast.makeText(getApplicationContext(),"SUcissssss",Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(getApplicationContext(),"Faillllll",Toast.LENGTH_SHORT).show();
    }
}
