package com.lacerna.lab3;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText cm_01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cm_01 = findViewById(R.id.editText);
    }

    public void saveData(View v) {

        String data9 = cm_01.getText().toString() + " ";

        FileOutputStream writer1 = null;
        try {
            writer1 = openFileOutput("data1.txt", MODE_PRIVATE);

            writer1.write(data9.getBytes());


        } catch (FileNotFoundException e) {
            Log.d("error", "No Comment.");
        } catch (IOException e) {
            Log.d("error", "IO Error.");
        } finally {
            try {
                writer1.close();

            } catch (IOException e) {
                Log.d("error", "No Comment");
            }


        }
        Toast.makeText(this, "Data saved...", Toast.LENGTH_LONG).show();
    }

    public void NextPage(View v) {
        startActivity(new Intent(MainActivity.this, SecondActivity.class));
    }

}

