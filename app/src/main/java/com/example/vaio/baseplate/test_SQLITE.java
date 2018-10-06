package com.example.vaio.baseplate;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static java.lang.Boolean.TRUE;

public class test_SQLITE extends AppCompatActivity {
    DatabaseHelper jdb;
EditText e1;
    EditText e2;
    EditText e3;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test__sqlite);
        jdb=new DatabaseHelper(this);

        e1=(EditText)findViewById(R.id.editText2);
        e2=(EditText)findViewById(R.id.editText3);
        e3=(EditText)findViewById(R.id.editText4);
        b1=(Button)findViewById(R.id.button6);
        AddData();
    }
    public void AddData()
    {
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(getApplicationContext(),"SUcesssss",Toast.LENGTH_SHORT).show();
               boolean ans=jdb.insertData((e1.getText().toString()),e2.getText().toString(),e3.getText().toString());
                if(ans==true){

                    Toast.makeText(getApplicationContext(),"sicessss",Toast.LENGTH_SHORT).show();

                }
//                else
//                    Toast.makeText(getApplicationContext(),"fail",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
