package com.example.vaio.baseplate;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;


public class complain extends AppCompatActivity {
    DatabaseHelper jdb;
    TextView ans;
    String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        jdb = new DatabaseHelper(this);
        setContentView(R.layout.activity_complain);
        ans = (TextView) findViewById(R.id.textView3);
        Bundle b1 = getIntent().getExtras();
        data = b1.getString("sakshi");
        Cursor res = jdb.getData();
        Toast.makeText(getApplicationContext(), data, Toast.LENGTH_SHORT).show();
        if (res.getCount() == 0) {
            return;
        }
        StringBuffer buf = new StringBuffer();
        while (res.moveToNext()) {
            buf.append("Sr no " + res.getString(0) + "\n");
            buf.append("Name " + res.getString(1) + "\n");
            buf.append("Complain " + res.getString(2) + "\n");
            buf.append("Location " + res.getString(3) + "\n\n");
            ans.setText(buf);

        }

    }
}

