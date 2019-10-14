package com.lacerna.lab3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SecondActivity extends AppCompatActivity {

    TextView comms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        FileInputStream fin = null;
        comms = findViewById(R.id.textView2);

        try {
            fin = openFileInput("data1.txt");
            int token;
            String temp = "";
            while ((token = fin.read()) != -1){
                temp = temp + ((char)token);
            }
            fin.close();
            try {
                String[] list = temp.split("_");
                comms.setText(list[0]);

            } catch (Exception e) {
                Log.d("error", "empty strings");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }





    }

    public void PrevPage(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}